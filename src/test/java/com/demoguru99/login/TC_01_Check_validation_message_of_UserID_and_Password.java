package com.demoguru99.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;

public class TC_01_Check_validation_message_of_UserID_and_Password extends BaseTest {
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
	public void TC_01_CheckValidMessage() {
		log.info("Step 1: Click to [UserID] textbox and press TAB");
		loginPage.clickToUserIDTextboxAndPressTAB();

		log.info("Step 2: Click to [Password] textbox and press TAB");
		loginPage.clickToPasswordTextboxAndPressTAB();

		log.info("Step 3: An error message: 'User-ID must not be blank' ");
		verifyEquals(loginPage.isLoginUserIDDislayed(), "User-ID must not be blank");

		log.info("Step 4: An error message: 'Password must not be blank' ");
		verifyEquals(loginPage.isLoginPasswordDislayed(), "Password must not be blank");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
