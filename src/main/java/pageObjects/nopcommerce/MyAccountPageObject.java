package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, MyAccountPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, MyAccountPageUI.GENDER_FEMALE_RADIO);
	}

	public void inputToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void inputToEmailTextbox(String emailAdrress) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emailAdrress);
	}

	public void inputToDayDropdown(String day) {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, MyAccountPageUI.DAY_DROPDOWN, day);
	}

	public void inputToMonthDropdown(String month) {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, MyAccountPageUI.MONTH_DROPDOWN, month);
	}

	public void inputToYearDropdown(String year) {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, MyAccountPageUI.YEAR_DROPDOWN, year);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isFeMaleDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.GENDER_FEMALE_RADIO);
		return isElementDisplayed(driver, MyAccountPageUI.GENDER_FEMALE_RADIO);
	}

	public String isFirstNameDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String isLastNameDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String isDayDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.DAY_DROPDOWN, "value");
	}

	public String isMonthDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.MONTH_DROPDOWN, "value");
	}

	public String isYearDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getElementAttribute(driver, MyAccountPageUI.YEAR_DROPDOWN, "value");
	}

	public String isEmailDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
	}

	public void inputToAddressFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToAddressLastnameTextbox(String lastname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX, lastname);
	}

	public void inputToAddressEmailTextbox(String email) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void inputToAddressCompanyTextbox(String address) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX, address);
	}

	public void inputToAddressCountryDropdown(String country) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COUNTRY_TEXTBOX);
		selectItemInDefaultDropdownVisibleText(driver, MyAccountPageUI.ADDRESS_COUNTRY_TEXTBOX, country);
	}

	public void inputToAddressStateDropdown(String state) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_STATE_TEXTBOX);
		selectItemInDefaultDropdownVisibleText(driver, MyAccountPageUI.ADDRESS_STATE_TEXTBOX, state);
	}

	public void inputToAddressCityTextBox(String city) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ADDRESS_1_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS_1_TEXTBOX, address1);

	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ADDRESS_2_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS_2_TEXTBOX, address2);

	}

	public void inputToAddressZipTextbox(String zip) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ZIP_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_ZIP_TEXTBOX, zip);

	}

	public void inputToAddressPhoneNumberTextbox(String phonenumber) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, phonenumber);

	}

	public void inputToAddressFaxNumberTextbox(String faxnumber) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.ADDRESS_FAX_NUMBER_TEXTBOX, faxnumber);

	}

	public void clickToAddressSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
	}

	public void clickAddressAddNewButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);

	}

	public String isAddressEmailDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_MESSAGE);
		return getElementText(driver, MyAccountPageUI.EMAIL_MESSAGE);
	}

	public String isAddressPhoneDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.PHONE_NUMBER_MESSAGE);
		return getElementText(driver, MyAccountPageUI.PHONE_NUMBER_MESSAGE);
	}

	public String isAddressFaxDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.PAX_NUMBER_MESSAGE);
		return getElementText(driver, MyAccountPageUI.PAX_NUMBER_MESSAGE);
	}

	public String isAddressCompanyDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_MESSAGE);
		return getElementText(driver, MyAccountPageUI.COMPANY_MESSAGE);
	}

	public String isAddressAddress1Displayed() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_1_MESSAGE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_1_MESSAGE);
	}

	public String isAddressAddress2Displayed() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_2_MESSAGE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_2_MESSAGE);
	}

	public String isAddressCityStateZipDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.CITY_STATE_ZIP_MESSAGE);
		return getElementText(driver, MyAccountPageUI.CITY_STATE_ZIP_MESSAGE);
	}

	public String isAddressCountryDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.COUNTRY_MESSAGE);
		return getElementText(driver, MyAccountPageUI.COUNTRY_MESSAGE);
	}

	public void inputToOldPasswordTextbox(String oldpassowrd) {
		waitForElementVisible(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, oldpassowrd);
	}

	public void inputToNewPasswordTextbox(String newpassowrd) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newpassowrd);
	}

	public void inputToConfirmPasswordTextbox(String confirmpassowrd) {
		waitForElementVisible(driver, MyAccountPageUI.CONIFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.CONIFIRM_PASSWORD_TEXTBOX, confirmpassowrd);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public void clickToAddToCartButton(String nameProduct) {
		waitForElementClickable(driver, MyAccountPageUI.ADD_TO_CART, nameProduct);
		clickToElement(driver, MyAccountPageUI.ADD_TO_CART, nameProduct);
	}

	public void clickToAddYourReviewLink() {
		waitForElementClickable(driver, MyAccountPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, MyAccountPageUI.ADD_YOUR_REVIEW_LINK);

	}

	public void inputReviewTitleTextBox(String reviewTitle) {
		waitForElementVisible(driver, MyAccountPageUI.REVIEW_TITTLE_TEXTBOX);
		sendKeyToElement(driver, MyAccountPageUI.REVIEW_TITTLE_TEXTBOX, reviewTitle);
	}

	public void inputReviewTextTextArea(String reviewContent) {
		waitForElementVisible(driver, MyAccountPageUI.REVIEW_TEXT_TEXTAREA);
		sendKeyToElement(driver, MyAccountPageUI.REVIEW_TEXT_TEXTAREA, reviewContent);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, MyAccountPageUI.SUBMIT_REVIEW);
		clickToElement(driver, MyAccountPageUI.SUBMIT_REVIEW);

	}

	public void clickToClosedIcon() {
		waitForElementClickable(driver, MyAccountPageUI.CLOSE_ICON);
		clickToElement(driver, MyAccountPageUI.CLOSE_ICON);
	}

}
