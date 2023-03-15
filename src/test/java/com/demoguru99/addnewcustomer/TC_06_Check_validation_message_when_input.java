package com.demoguru99.addnewcustomer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.AddCustomerPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.ManagerHomePageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.RegisterPageObject;
import pageUIs.orangehrm.AddCustomerPageUI;

public class TC_06_Check_validation_message_when_input extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	ManagerHomePageObject managerHomePage;
	AddCustomerPageObject addCustomerPage;

	String username, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

//		log.info("Input value 'abc' to [UserID] text box");
//		loginPage.inputValueUserIDTextbox("mngr461777");
//
//		log.info("Input value 'test' to [Password] text box");
//		loginPage.inputValuePasswordTextbox("EnYsEjE");
//
//		log.info("Click to [Login] button");
//		loginPage.clickToLoginButton();
//		managerHomePage = PageGeneratorManager.getPageGenerator().getManagerHomePage(driver);

	}

	@Test
	public void TC_04_CheckLoginSuccess() {
		log.info("Step 1: Click [here]");
		loginPage.clickToHere();
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		log.info("Step 2: Input [Email ID]");
		registerPage.inputToEmailID("ad@ad.ad");

		log.info("Step 3: Click [Submit] button");
		registerPage.clickToSubmitButton();

		log.info("Step 4: Get [UserID]");
		username = registerPage.getUserID();

		log.info("Step 5: Get [Password]");
		password = registerPage.getPassword();

		log.info("Step 6: Back to login page");
		registerPage.openLoginPage();
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 7: Input value 'abc' to [UserID] text box");
		loginPage.inputValueUserIDTextbox(username);

		log.info("Step 8: Input value 'test' to [Password] text box");
		loginPage.inputValuePasswordTextbox(password);

		log.info("Step 9: Click to [Login] button");
		loginPage.clickToLoginButton();
		managerHomePage = PageGeneratorManager.getPageGenerator().getManagerHomePage(driver);

	}

	@Test
	public void TC_06_CheckValidationMessage() {
		log.info("Step 1: Open New Customer Page");
		managerHomePage.menuPageByName(driver, "New Customer");
		addCustomerPage = PageGeneratorManager.getPageGenerator().getAddCustomerPage(driver);

		log.info("Step 2: Input '1234' to [Customer Name] textbox");
		addCustomerPage.inputToCustomerName("123");

		log.info("Step 3: An error message: 'Numbers are not allowed'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.CUSTOMER_NAME_MESSAGE),
				"Numbers are not allowed");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
