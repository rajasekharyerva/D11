package com.d11.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.d11.test.BaseTest;

public class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click(WebElement we) {
		Actions action = new Actions(this.driver);
		action.moveToElement(we).perform();
		action.click(we).build().perform();
		waitFor(3);
	}

	public void sendKeys(WebElement we, String input) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.click();
		actions.sendKeys(input);
		actions.build().perform();
		waitFor(1);
	}

	public String getText(WebElement we) {
		return we.getText();
	}

	public boolean waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, Long.parseLong(BaseTest.prop.getProperty("implicitwait")));

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public void waitFor(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}
}
