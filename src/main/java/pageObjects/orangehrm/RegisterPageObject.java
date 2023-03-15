package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailID(String emailid) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID, emailid);

	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserID() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_LABEL);
		return getElementText(driver, RegisterPageUI.USER_ID_LABEL);
	}

	public String getPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ID_LABEL);
		return getElementText(driver, RegisterPageUI.PASSWORD_ID_LABEL);
	}

	public void openLoginPage() {
		openPageUrl(driver, "https://demo.guru99.com/v4/index.php");
	}
}
