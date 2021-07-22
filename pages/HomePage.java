package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	private static WebElement element;

	private static final String SEARCH_FIELD = "ss";
	private static final String CHECKIN_CHECKOUT = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[3]/div/div/div/div/span";
	private static final String NEXT_BTN = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]";
	private static final String CHECK_IN_DATE = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[4]/td[2]";
	private static final String CHECK_OUT_DATE = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/table/tbody/tr[5]/td[1]";
	private static final String TOGGLE_GUESTS = "xp__guests__toggle";
	private static final String DECREASE_BUTTON = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[1]";
	private static final String INCREASE_BUTTON = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]";
	private static final String AGE_LIST = "age";
	private static final String SEARCH_BUTTON = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button";
	public static final String HOTEL_LINK = "//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[1]/div[1]/div[1]/h3/a/span[1]";

	public static void inputSearchKeyword(WebDriver driver, String input) {
		element = driver.findElement(By.id(SEARCH_FIELD));
		element.clear();
		element.sendKeys(input);
	}

	public static WebElement findCheckInCheckOutBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(CHECKIN_CHECKOUT));
		return element;
	}

	public static void clickNext(WebDriver driver) {
		driver.findElement(By.xpath(NEXT_BTN)).click();
	}

	public static void selectCheckInDate(WebDriver driver) {
		driver.findElement(By.xpath(CHECK_IN_DATE)).click();
	}

	public static void selectCheckOutDate(WebDriver driver) {
		driver.findElement(By.xpath(CHECK_OUT_DATE)).click();
	}

	public static void chooseCheckinCheckoutDate(WebDriver driver) {
		findCheckInCheckOutBtn(driver).click();
		clickNext(driver);
		clickNext(driver);
		selectCheckInDate(driver);
		selectCheckOutDate(driver);
	}

	public static void clickToggleGuests(WebDriver driver) {
		driver.findElement(By.id(TOGGLE_GUESTS)).click();
	}

	public static void clickIncreaseChildrenNum(WebDriver driver) {
		driver.findElement(By.xpath(INCREASE_BUTTON)).click();
	}

	public static void clickDecreaseChildrenNum(WebDriver driver) {
		driver.findElement(By.xpath(DECREASE_BUTTON)).click();
	}

	public static WebElement findAgeList(WebDriver driver) {
		element = driver.findElement(By.name(AGE_LIST));
		return element;
	}

	public static void chooseAge(WebDriver driver, String option) {
		Select se = new Select(findAgeList(driver));
		se.selectByVisibleText(option);
	}

	public static void clickSearchButton(WebDriver driver) {
		driver.findElement(By.xpath(SEARCH_BUTTON)).click();
	}

	public static void selectHotel(WebDriver driver) {
		driver.findElement(By.xpath(HOTEL_LINK)).click();
	}
}
