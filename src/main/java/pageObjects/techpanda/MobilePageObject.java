package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.MobilePageUI;

public class MobilePageObject extends BasePage {
	WebDriver driver;

	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart(String page) {
		waitForElementClickable(driver, MobilePageUI.MOBILE_PAGE, page);
		clickToElement(driver, MobilePageUI.MOBILE_PAGE, page);
	}

}
