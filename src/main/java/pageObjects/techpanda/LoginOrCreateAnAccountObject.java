package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.LoginOrCreateAnAccountUI;

public class LoginOrCreateAnAccountObject extends BasePage {
	WebDriver driver;

	public LoginOrCreateAnAccountObject(WebDriver driver) {
		this.driver = driver;
	}

	public void createToAccount() {
		waitForElementClickable(driver, LoginOrCreateAnAccountUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginOrCreateAnAccountUI.CREATE_AN_ACCOUNT_BUTTON);

	}

	public void inputToEmailAddress(String value) {
		waitForElementVisible(driver, LoginOrCreateAnAccountUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, LoginOrCreateAnAccountUI.EMAIL_ADDRESS_TEXTBOX, value);
	}

	public void clickToRegister() {
		waitForElementClickable(driver, LoginOrCreateAnAccountUI.REGISTER_BUTTON);
		clickToElement(driver, LoginOrCreateAnAccountUI.REGISTER_BUTTON);

	}

}
