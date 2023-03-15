package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String isFirstNameDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_MESSAGE);
	}

	public String isLastNameDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_MESSAGE);
	}

	public String isEmailDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_MESSAGE);
	}

	public String isPasswordDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_MESSAGE);
	}

	public String isConfirmPasswordDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void inputToEmailTextbox(String emailAdrress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdrress);
	}

	public void inputToFasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmFasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
	}

	public String isInvalidEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE);
	}

	public String isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public String isExistingEmailMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_MESSAGE);
	}

	public String isLessThan6CharsMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_MESSAGE);
	}

	public String isInvalidConfirmPasswordMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_MESSAGE);
	}

	public void inputToDayDropdown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, RegisterPageUI.DAY_DROPDOWN, day);
	}

	public void inputToMonthDropdown(String month) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void inputToYearDropdown(String year) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, RegisterPageUI.YEAR_DROPDOWN, year);
	}

}
