package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String isEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_MESSAGE);
	}

	public String isErrorMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String username) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, username);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

}
