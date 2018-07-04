package com.d11.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathOneShot {

	public static void main(String[] args) throws InterruptedException {
		String os = System.getProperty("os.name");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver-"+os);
		WebDriver driver  = new ChromeDriver();
		driver.get("file:///home/rajasekharr/Desktop/Help.html");
		String input = "PROD";
		List<WebElement> chkboxes = driver.findElements(By.xpath("//td[text()='"+input+"']/preceding-sibling::td[2]/input"));
		if(chkboxes.size() > 0) {
			chkboxes.get(0).click();
		}
		Thread.sleep(3000);
	}

}
