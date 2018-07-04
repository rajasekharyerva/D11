package com.d11.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SDET {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	public static void main(String[] args) {
		//Array
		List<String> strList  = new ArrayList<String>();
		String input ="CatMat";
		String[] srtArray = new String[]{"Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"};
		strList = Arrays.asList(srtArray);
		//Substring 1,2,3..6
		for(int i=1; i<=input.length(); i++) {
			//Substring
			for(int j=0;j<input.length();j++) {
				//endIndex <= length of input
				if(j+i <= input.length()) {
					String subStr = input.substring(j, j+i);
					if(strList.contains(subStr))
						System.out.println("List " + strList.toArray() + " contains " + subStr);
					else
						System.out.println("List " + strList.toArray() + " not contains " + subStr);
				}
			}
		}
	}

	@BeforeTest
	public void startReport(){
		System.setProperty("webdriver.chrome.driver", "/home/rajasekharr/EclipseWS/D11Artifact/drivers/chromedriver-Linux");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Raj");

		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("Name of the Report Comes here");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Test
	public void passTest(){
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		//logger.log();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
	}

	@Test
	public void failTest(){
		logger = extent.createTest("failTest");
		Assert.assertTrue(false);
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
	}

	@Test
	public void skipTest(){
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			try {
				String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+result.getMethod().getMethodName()+"_"+dateName+".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(src, finalDestination);
				//FileUtils.copyFile(src, new File(result.getMethod().getMethodName() + ".png"));
				logger.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/"+result.getMethod().getMethodName() + ".png").build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		}
	}
	@AfterTest
	public void endReport(){
		extent.flush();
	}

	//@Test
	public void searchResults() {
		System.setProperty("webdriver.chrome.driver", "/home/rajasekharr/EclipseWS/D11Artifact/drivers/chromedriver-Linux");
		WebDriver driver =  new ChromeDriver();
		try {
			driver.get("https://www.google.com/");
			WebElement el = driver.findElement(By.xpath("//input[@id='lst-ib']"));
			el.sendKeys("HCL Technologies");
			el.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			List<WebElement> els = driver.findElements(By.xpath("//*[@id='rso']//div[@class='g']//h3/a"));
			for(WebElement we: els) {
				System.out.println(we.getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
