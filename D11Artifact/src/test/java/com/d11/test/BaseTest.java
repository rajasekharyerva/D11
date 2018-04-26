package com.d11.test;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.d11.page.HomePage;
import com.d11.page.LoginPage;

public class BaseTest {
	public static Properties prop = null;
	String configPropPath = "properties/config.properties";
	LoginPage loginPage;
	HomePage homePage;
	WebDriver driver;

	public void readPropertiesFile(String filePath) {
		prop = new Properties();
		InputStream input = null;

		try {
			input = BaseTest.class.getClassLoader().getResourceAsStream(filePath);
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Sorry, unable to find " + filePath);
		}
	}

	@BeforeClass(alwaysRun=true)
	public void readProperties() {
		readPropertiesFile(configPropPath);
		setUpDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.get(prop.getProperty("url"));
		signIn();
	}

	private void setUpDriver() {
		String os = System.getProperty("os.name");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver-"+os);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@BeforeMethod
	public void signIn() {
		
		if(!"https://www.iplt20.com/stats/2018".equals(driver.getCurrentUrl())) {
			loginPage.clickSignIn();
			loginPage.clickSignIn();
			loginPage.setEmail(prop.getProperty("email"));
			loginPage.setPassword(prop.getProperty("password"));
			loginPage.clickLogin();
		}
	}

	@AfterMethod
	public void signOut() {
		//homePage.clickMore();
		//homePage.clickLogout();
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}