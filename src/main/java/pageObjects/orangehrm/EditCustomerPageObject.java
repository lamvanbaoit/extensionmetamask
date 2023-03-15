package pageObjects.orangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerID() {
		waitForElementClickable(driver, EditCustomerPageUI.CUSTOMER_ID);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID, Keys.chord(Keys.TAB));

	}

	public void inputToCustomerID(String customerId) {
		waitForElementClickable(driver, EditCustomerPageUI.CUSTOMER_ID);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID, customerId);
	}

	public void clickToSubmit() {
		waitForElementClickable(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}

	public void inputToAddress(String address) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_MESSAGE);
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_MESSAGE, address);

	}

	public void inputToCity(String city) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_MESSAGE);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_MESSAGE, city);

	}

	public void clickToEditSubmit() {
		waitForElementClickable(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
		acceptAlert(driver);
	}

}
