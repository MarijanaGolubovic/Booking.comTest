package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browser.Chrome;
import utilities.Constants;

public class BaseTest {
	
	public static WebDriver driver = Chrome.getBrowser();
		
	@BeforeClass
	public static void setUp() {	
		
		driver.get(Constants.HOME_URL);
		driver.manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

}
