package test;

import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.Constants;

public class HomePageTest extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement result;

	// Test search form by filling it out and then select a hotel
	@Test(priority = 1)

	public void chooseHotelTest() {

		HomePage.inputSearchKeyword(driver, Constants.KEYWORD);
		HomePage.chooseCheckinCheckoutDate(driver);
		HomePage.clickToggleGuests(driver);
		HomePage.clickIncreaseChildrenNum(driver);
		HomePage.chooseAge(driver, Constants.CHILD_AGE);
		HomePage.clickSearchButton(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePage.HOTEL_LINK)));
		HomePage.selectHotel(driver);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.HOTEL_TITLE)));
		String expectedResult = Constants.HOTEL_NAME;
		Assert.assertEquals(result.getText(), expectedResult);
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	// Test search form by skipping to choose the age of the child
	@Test(priority = 2)

	public void searchWithoutEnteringAgeTest() {

		driver.get(Constants.HOME_URL);
		HomePage.inputSearchKeyword(driver, Constants.KEYWORD);
		HomePage.clickToggleGuests(driver);
		HomePage.clickDecreaseChildrenNum(driver);
		HomePage.clickIncreaseChildrenNum(driver);
		HomePage.clickSearchButton(driver);

		String expectedTitle = Constants.HOMEPAGE_TITLE;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	// Test search form by not entering any search keyword
	@Test(priority = 3)

	public void searchWithoutEnteringKeywordTest() {

		driver.navigate().to(Constants.HOME_URL);
		HomePage.clickSearchButton(driver);

		result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.ERROR_MSSG_XPATH)));
		String expectedResult = Constants.ERROR_MSSG_TXT;
		Assert.assertEquals(result.getText().contains(expectedResult), true);
	}

	// Test search form by entering some special characters for search keyword
	@Test(priority = 4)

	public void searchByEnteringSpecCharsTest() {

		driver.navigate().to(Constants.HOME_URL);
		HomePage.inputSearchKeyword(driver, Constants.SPEC_CHARS_KEYWORD);
		HomePage.clickSearchButton(driver);

		String expectedTitle = Constants.HOMEPAGE_TITLE;
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
