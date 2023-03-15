package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMenu() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_MENU);
		clickToElement(driver, HomePageUI.ACCOUNT_MENU);

		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_SUBMENU);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_SUBMENU);
	}

	public void clickToMoblie() {
		waitForElementClickable(driver, HomePageUI.MOBILE_NAVIGATION);
		clickToElement(driver, HomePageUI.MOBILE_NAVIGATION);
	}

}
