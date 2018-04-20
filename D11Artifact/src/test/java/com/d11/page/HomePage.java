package com.d11.page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	@FindBy(xpath="//div[text()='My Contests']")
	WebElement myContests;

	@FindBy(xpath="//div[text()='Results']")
	WebElement results;

	@FindBy(xpath="//div[text()='1 Contest Joined']")
	List<WebElement> contestJoined;

	@FindBy(xpath="//div[contains(@class,'infobarContentLeft_')]")
	WebElement contestName;

	@FindBy(xpath="//i[text()='keyboard_arrow_right']")
	WebElement arrowRight;

	@FindBy(xpath="//i[text()='arrow_back']")
	WebElement arrowBack;

	@FindBy(xpath="//a[text()='Score']")
	WebElement score;

	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> rows;

	@FindBy(xpath="//table/thead/td")
	List<WebElement> headers;

	@FindBy(xpath="//div[text()='More']")
	WebElement more;

	@FindBy(xpath="//div[text()='Log Out']")
	WebElement logOut;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickMyContests() {
		this.click(myContests);
	}

	public void clickResults() {
		this.click(results);
	}

	public void clickArrowRight() {
		this.click(arrowRight);
	}

	public void clickArrowBack() {
		this.click(arrowBack);
	}

	public String getContestName() {
		return this.getText(contestName);
	}

	public void clickContestJoined(int index) {
		this.click(contestJoined.get(index));
	}
	
	public int getContestJoinedCount() {
		return contestJoined.size();
	}

	public int getContestJoined() {
		return contestJoined.size();
	}

	public void clickScore() {
		this.click(score);
	}

	public void clickMore() {
		this.click(more);
	}

	public void clickLogout() {
		this.click(logOut);
	}

	public String[][] getPlayersInfo() {
		String[][] tableData = new String[22][15];
		int rowSize = getRowsSize();
		for(int rowInd = 0; rowInd < rowSize; rowInd++) {
			List<WebElement> cols = rows.get(rowInd).findElements(By.xpath("./td"));
			for(int colInd = 0; colInd < cols.size(); colInd++) {
				tableData[rowInd][colInd] = cols.get(colInd).getText();
			}
		}
		return tableData;
	}

	public String[] getHeaders() {
		String[] headers = new String[15];
		for(int hIndex = 0; hIndex < headers.length; hIndex++) {
			headers[hIndex] = this.headers.get(hIndex).getText();
		}
		return headers;
	}

	public int getRowsSize() {
		return this.rows.size();
	}

}
