package com.techpanda.createaccount;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import pageObjects.techpanda.HomePageObject;
import pageObjects.techpanda.LoginOrCreateAnAccountObject;
import pageObjects.techpanda.PageGeneratorManager;
import pageUIs.techpanda.LoginOrCreateAnAccountUI;
import reportConfig.ExtentTestManager;

public class TC_02_CheckValidationMessage extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginOrCreateAnAccountObject loginOrCreateAnAccount;

	String email = "222222";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);

	}

	@Test
	public void TC_01_CheckValidMessage(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_01_CheckValidMessage");

		log.info("Step 1: Click on [My Account] link");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on [My Account] link");
		homePage.clickToMenu();
		loginOrCreateAnAccount = PageGeneratorManager.getPageGenerator().getLoginOrCreateAnAccount(driver);

		log.info("Step 2: Click on [CREATE AN ACCOUNT] button");
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Click on [CREATE AN ACCOUNT] button");
		loginOrCreateAnAccount.createToAccount();

		log.info("Step 3: Input value [222222] to [Email Address] textbox");
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input value [222222] to [Email Address] textbox");
		loginOrCreateAnAccount.inputToEmailAddress(email);

		log.info("Step 4: Click [REGISTER] button");
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Click [REGISTER] button");
		loginOrCreateAnAccount.clickToRegister();

		log.info("Step 5: A error: message Please include an '@' in the email address. '222222' is missing an '@'.");
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Step 5: A error: message Please include an '@' in the email address. '222222' is missing an '@'.");
		verifyEquals(loginOrCreateAnAccount.getHTML5Message(driver, LoginOrCreateAnAccountUI.HTML5_MESSAGE),
				"Please include an '@' in the email address. '" + email + "' is missing an '@111'.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
