package com.d11.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReactDatePicker extends BaseTest {
//public class ReactDatePicker{
	@Test()
	public void getD11PlayerStats() throws InterruptedException {
		//public static void main(String[] args) {
		String inputDate = "15th October'18";
		String[] dateParts = inputDate.split(" ");
		StringBuilder sb = new StringBuilder("");
		char[] inputDay = dateParts[0].toCharArray();
		
		for(int i = 0; i < inputDay.length; i++) {
			if(Character.isAlphabetic(inputDay[i]))
				break;
			sb.append(inputDay[i]);
		}
		String inputMonth = dateParts[1].split("'")[0];
		
		//Click Date Input
		WebElement datePickerInput = driver.findElement(By.xpath("(//div[@class='react-datepicker__input-container']/input)[2]"));
		datePickerInput.click();
		Thread.sleep(2000);
		
		//Get Text
		WebElement datePickerMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
		String currMon = datePickerMonth.getText().split(" ")[0];
		
		// Click Left Until Month Matches
		WebElement datePickerPrev = driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation react-datepicker__navigation--previous')]"));
		while(!inputMonth.equals(currMon)) {
			datePickerPrev.click();
			Thread.sleep(2000);
			currMon = datePickerMonth.getText().split(" ")[0];
		}
		
		// Select Day
		WebElement datePickerDay = driver.findElement(By.xpath("//div[text()='"+sb.toString()+"']"));
		datePickerDay.click();
		Thread.sleep(2000);
		System.out.println("Test Completed...");
	}
}
