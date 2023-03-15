package pageObjects.orangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddCustomerPageUI;

public class AddCustomerPageObject extends BasePage {
	WebDriver driver;

	public AddCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerName() {
		waitForElementClickable(driver, AddCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToDateOfBirth() {
		waitForElementClickable(driver, AddCustomerPageUI.DATE_OF_BIRTH);
		sendKeyToElement(driver, AddCustomerPageUI.DATE_OF_BIRTH, Keys.chord(Keys.TAB));
	}

	public void clickToAddress() {
		waitForElementClickable(driver, AddCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.ADDRESS_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToCity() {
		waitForElementClickable(driver, AddCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.CITY_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToState() {
		waitForElementClickable(driver, AddCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.STATE_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToPIN() {
		waitForElementClickable(driver, AddCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.PIN_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToMobileNumber() {
		waitForElementClickable(driver, AddCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToEmail() {
		waitForElementClickable(driver, AddCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.EMAIL_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToPassword() {
		waitForElementClickable(driver, AddCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.PASSWORD_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void inputToCustomerName(String custorname) {
		waitForElementVisible(driver, AddCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.CUSTOMER_NAME_TEXTBOX, custorname);
	}

	public void inputToGender(String gender) {
		waitForElementVisible(driver, AddCustomerPageUI.GENDER_RADIDO, gender);
		clickToElement(driver, AddCustomerPageUI.GENDER_RADIDO, gender);
	}

	public void inputToDateOfBirth(String date) {
		waitForElementVisible(driver, AddCustomerPageUI.DATE_OF_BIRTH);
		removeAttributeInDOM(driver, AddCustomerPageUI.DATE_OF_BIRTH, "type");
		sendKeyToElement(driver, AddCustomerPageUI.DATE_OF_BIRTH, date);
	}

	public void inputToAddress(String address) {
		waitForElementVisible(driver, AddCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.ADDRESS_TEXTBOX, address);

	}

	public void inputToCity(String city) {
		waitForElementVisible(driver, AddCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void inputToState(String state) {
		waitForElementVisible(driver, AddCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.STATE_TEXTBOX, state);
	}

	public void inputToPIN(String pin) {
		waitForElementVisible(driver, AddCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public void inputToMobileNumber(String mobile) {
		waitForElementVisible(driver, AddCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobile);
	}

	public void inputToEmail(String pin) {
		waitForElementVisible(driver, AddCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.EMAIL_TEXTBOX, pin);
	}

	public void inputToPassword(String password) {
		waitForElementVisible(driver, AddCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, AddCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToSubmit() {
		waitForElementVisible(driver, AddCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AddCustomerPageUI.SUBMIT_BUTTON);
	}
}
