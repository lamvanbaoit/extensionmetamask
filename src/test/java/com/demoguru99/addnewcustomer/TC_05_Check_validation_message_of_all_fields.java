package com.demoguru99.addnewcustomer;

//mngr461777
//EnYsEjE

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

public class TC_05_Check_validation_message_of_all_fields extends BaseTest {
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
	public void TC_05_CheckValidationMessage() {
		log.info("Step 1: Open New Customer Page");
		managerHomePage.menuPageByName(driver, "New Customer");
		addCustomerPage = PageGeneratorManager.getPageGenerator().getAddCustomerPage(driver);

		log.info("Step 2: Click to [Customer Name] textbox and press TAB");
		addCustomerPage.clickToCustomerName();

		log.info("Step 3: Click to [Date of Birth] control and and press TAB");
		addCustomerPage.clickToDateOfBirth();

		log.info("Step 4: Click to [Address] textbox and press TAB");
		addCustomerPage.clickToAddress();

		log.info("Step 5: Click to [City] textbox and press TAB");
		addCustomerPage.clickToCity();

		log.info("Step 6: Click to [State] textbox and press TAB");
		addCustomerPage.clickToState();

		log.info("Step 7: Click to [PIN] textbox and press TAB");
		addCustomerPage.clickToPIN();

		log.info("Step 8: Click to [Mobile Number] textbox and press TAB");
		addCustomerPage.clickToMobileNumber();

		log.info("Step 9: Click to [E-mail] textbox and press TAB");
		addCustomerPage.clickToEmail();

		log.info("Step 10: Click to [Password] textbox and press TAB");
		addCustomerPage.clickToPassword();

		log.info("Step 11: An error message: 'Customer name must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.CUSTOMER_NAME_MESSAGE),
				"Customer name must not be blank");

		log.info("Step 12: An error message: 'Date Field must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.DATE_OF_MESSAGE),
				"Date Field must not be blank");

		log.info("Step 13: An error message: 'Address Field must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.ADDRESS_MESSAGE),
				"Address Field must not be blank");

		log.info("Step 14: An error message: 'city Field must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.CITY_MESSAGE),
				"City Field must not be blank");

		log.info("Step 15: An error message: 'state must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.STATE_MESSAGE), "State must not be blank");

		log.info("Step 16: An error message: 'PIN Code must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.PIN_MESSAGE),
				"PIN Code must not be blank");

		log.info("Step 17: An error message: 'Mobile no must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.MOBILE_NUMBER_MESSAGE),
				"Mobile no must not be blank");

		log.info("Step 18: An error message: 'Emall-ID must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.EMAIL_MESSAGE),
				"Email-ID must not be blank");

		log.info("Step 19: An error message: 'Password must not be blank'");
		verifyEquals(addCustomerPage.geElementText(driver, AddCustomerPageUI.PASSWORD_MESSAGE),
				"Password must not be blank");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}

}
