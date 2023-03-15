package com.demoguru99.addnewcustomer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.orangehrm.AddCustomerPageObject;
import pageObjects.orangehrm.CustomerRegMsgPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.ManagerHomePageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.RegisterPageObject;
import pageUIs.orangehrm.CustomerRegMsgPageUI;

public class TC_08_Check_created_new_customer_successfully extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	ManagerHomePageObject managerHomePage;
	AddCustomerPageObject addCustomerPage;
	CustomerRegMsgPageObject customerRegMsgPage;

	String username, password;
	String email = "baolam" + randomestring() + "@gmail.com";

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
	public void TC_08_CreateNewCustomer() {
		log.info("Step 1: Open New Customer Page");
		managerHomePage.menuPageByName(driver, "New Customer");
		addCustomerPage = PageGeneratorManager.getPageGenerator().getAddCustomerPage(driver);

		log.info("Step 2: input to [Customer Name] textbox ");
		addCustomerPage.inputToCustomerName("Selenium Java");

		log.info("Step 3: input to [Gender] textbox ");
		addCustomerPage.inputToGender("f");

		log.info("Step 4: input to [Date of Birth] control ");
		addCustomerPage.inputToDateOfBirth("11/12/2022");

		log.info("Step 5: input to [Address] textbox ");
		addCustomerPage.inputToAddress("19 duong nguyen\n huu tho");

		log.info("Step 6: input to [City] textbox");
		addCustomerPage.inputToCity("sai gon");

		log.info("Step 7: input to [State] textbox");
		addCustomerPage.inputToState("quan");

		log.info("Step 8: input to [PIN] textbox");
		addCustomerPage.inputToPIN("123456");

		log.info("Step 9: input to [Mobile Number] textbox");
		addCustomerPage.inputToMobileNumber("123456789");

		log.info("Step 10: input to [E-mail] textbox");
		addCustomerPage.inputToEmail(email);

		log.info("Step 11: input to [Password] textbox");
		addCustomerPage.inputToPassword("123456789");

		log.info("Step 12: An error message: 'Click Submit button'");
		addCustomerPage.clickToSubmit();
		customerRegMsgPage = PageGeneratorManager.getPageGenerator().getCustomerRegMsgPage(driver);

		log.info("Step 13: A message: 'Customer Registered Successfully!!!'");
		verifyEquals(customerRegMsgPage.geElementText(driver, CustomerRegMsgPageUI.SUCCESS_MESSAGE),
				"Customer Registered Successfully!!!");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}

}
