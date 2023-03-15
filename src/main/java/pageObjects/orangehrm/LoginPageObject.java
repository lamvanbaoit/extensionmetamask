package pageObjects.orangehrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToUserIDTextboxAndPressTAB() {
		waitForElementClickable(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public void clickToPasswordTextboxAndPressTAB() {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, Keys.chord(Keys.TAB));
	}

	public String isLoginUserIDDislayed() {
		waitForElementVisible(driver, LoginPageUI.MASSAGE_USER_ID);
		return getElementText(driver, LoginPageUI.MASSAGE_USER_ID);
	}

	public String isLoginPasswordDislayed() {
		waitForElementVisible(driver, LoginPageUI.MASSAGE_PASSWORD);
		return getElementText(driver, LoginPageUI.MASSAGE_PASSWORD);
	}

	public void inputValueUserIDTextbox(String userid) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userid);

	}

	public void inputValuePasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToResetButton() {
		waitForElementClickable(driver, LoginPageUI.RESET_BUTTON);
		clickToElement(driver, LoginPageUI.RESET_BUTTON);
	}

	public String isUserIDBlankDisplayed() {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		return getElementText(driver, LoginPageUI.USER_ID_TEXTBOX);
	}

	public String isPasswordBlankDisplayed() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		return getElementText(driver, LoginPageUI.PASSWORD_TEXTBOX);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public void clickToHere() {
		waitForElementClickable(driver, LoginPageUI.LINK_HERE);
		clickToElement(driver, LoginPageUI.LINK_HERE);

	}

}
