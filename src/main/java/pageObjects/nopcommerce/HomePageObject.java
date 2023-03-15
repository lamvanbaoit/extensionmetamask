package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToHeardNameMenu(String nameMenu) {
		waitForElementClickable(driver, HomePageUI.HEADER_NAME_MENU, nameMenu);
		clickToElement(driver, HomePageUI.HEADER_NAME_MENU, nameMenu);
	}

	public void clickToHeardNameSubMenu(String subMenu) {
		waitForElementClickable(driver, HomePageUI.HEADER_SUB_MENU, subMenu);
		clickToElement(driver, HomePageUI.HEADER_SUB_MENU, subMenu);
	}

	public void clickToNameMenu(String nameMenu) {
		waitForElementClickable(driver, HomePageUI.NAME_MENU, nameMenu);
		hoverMouseToElement(driver, HomePageUI.NAME_MENU, nameMenu);
	}

	public void clickToNameSubMenu(String subMenu) {
		waitForElementClickable(driver, HomePageUI.SUB_MENU, subMenu);
		clickToElement(driver, HomePageUI.SUB_MENU, subMenu);
	}

}
