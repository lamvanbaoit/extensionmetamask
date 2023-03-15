package pageObjects.orangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddAccountPageUI;

public class AddAccountPageObject extends BasePage {
	WebDriver driver;

	public AddAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerID() {
		waitForElementClickable(driver, AddAccountPageUI.CUSTOMER_ID);
		sendKeyToElement(driver, AddAccountPageUI.CUSTOMER_ID, Keys.chord(Keys.TAB));
	}

	public void clickInitialDeposit() {
		waitForElementClickable(driver, AddAccountPageUI.INITIAL_DEPOSIT);
		sendKeyToElement(driver, AddAccountPageUI.INITIAL_DEPOSIT, Keys.chord(Keys.TAB));
	}

	public void inputToCustomerID(String customerId) {
		waitForElementVisible(driver, AddAccountPageUI.CUSTOMER_ID);
		sendKeyToElement(driver, AddAccountPageUI.CUSTOMER_ID, customerId);

	}

	public void inputAccountType(String value) {
		waitForElementVisible(driver, AddAccountPageUI.ACCOUNT_TYPE);
		selectItemInDefaultDropdownVisibleText(driver, AddAccountPageUI.ACCOUNT_TYPE, value);
	}

	public void inputInitialDeposit(String deposit) {
		waitForElementVisible(driver, AddAccountPageUI.INITIAL_DEPOSIT);
		sendKeyToElement(driver, AddAccountPageUI.INITIAL_DEPOSIT, deposit);

	}

	public void clickToSubmit() {
		waitForElementClickable(driver, AddAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AddAccountPageUI.SUBMIT_BUTTON);

	}
}
