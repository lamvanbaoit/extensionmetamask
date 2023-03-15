package com.demoguru99.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;

public class TC_02_Check_reset_button extends BaseTest {
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
	public void TC_02_CheckReset() {
		log.info("Step 1: Input value 'abc' to [UserID] text box");
		loginPage.inputValueUserIDTextbox("abc");

		log.info("Step 2: Input value 'test' to [Password] text box");
		loginPage.inputValuePasswordTextbox("test");

		log.info("Step 3: Click to Reset button");
		loginPage.clickToResetButton();

		log.info("Step 4: [UserID] and [Password] text box will be reset (displayed blank)");
		verifyEquals(loginPage.isUserIDBlankDisplayed(), "");
		verifyEquals(loginPage.isPasswordBlankDisplayed(), "");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
