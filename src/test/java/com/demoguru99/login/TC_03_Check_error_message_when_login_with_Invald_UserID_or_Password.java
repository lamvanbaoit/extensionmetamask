package com.demoguru99.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;

public class TC_03_Check_error_message_when_login_with_Invald_UserID_or_Password extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

	}

	@Test
	public void TC_03_CheckErrorMessage() {
		log.info("Step 1: Input value 'abc' to [UserID] text box");
		loginPage.inputValueUserIDTextbox("abc");

		log.info("Step 2: Input value 'test' to [Password] text box");
		loginPage.inputValuePasswordTextbox("test");

		log.info("Step 3: Click to [Login] button");
		loginPage.clickToLoginButton();

		log.info("Step 4: An error message 'User or Password is not valid' ");
		verifyEquals(loginPage.getAlertText(driver), "User or Password is not valid");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
