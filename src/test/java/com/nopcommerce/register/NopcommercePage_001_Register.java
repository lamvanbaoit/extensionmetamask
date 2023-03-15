package com.nopcommerce.register;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class NopcommercePage_001_Register extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String email = "ad" + randomestring() + "@ad.ad";
	String password = "123123";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_001_EmptyData(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_001_EmptyData");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to register button");
		log.info("Step 02: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify error message first name displayed");
		log.info("Step 03: Verify error message first name displayed");
		Assert.assertEquals(registerPage.isFirstNameDisplayed(), "First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify error message last name displayed");
		log.info("Step 04: Verify error message last name displayed");
		Assert.assertEquals(registerPage.isLastNameDisplayed(), "Last name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify error message email displayed");
		log.info("Step 05: Verify error message email displayed");
		Assert.assertEquals(registerPage.isEmailDisplayed(), "Email is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify error message password displayed");
		log.info("Step 06: Verify error message password displayed");
		Assert.assertEquals(registerPage.isPasswordDisplayed(), "Password is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify error message confirm password displayed");
		log.info("Step 07: Verify error message confirm password displayed");
		Assert.assertEquals(registerPage.isConfirmPasswordDisplayed(), "Password is required.");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_002_InvalidEmail(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_002_InvalidEmail");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Male radio button");
		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input To Firstname Textbox");
		log.info("Step 03: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input To Lastname Textbox");
		log.info("Step 04: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input To Email Textbox");
		log.info("Step 05: Input To Email Textbox");
		registerPage.inputToEmailTextbox("ad");

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input To Fassword Textbox");
		log.info("Step 06: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Confirm Fassword Textbox");
		log.info("Step 07: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to register button");
		log.info("Step 08: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify error message invalid email displayed");
		log.info("Step 09: Verify error message invalid email displayed");
		Assert.assertEquals(registerPage.isInvalidEmailErrorMessageDisplayed(), "Wrong email");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_003_RegisterSuccess(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_003_RegisterSuccess");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Male radio button");
		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input To Firstname Textbox");
		log.info("Step 03: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input To Lastname Textbox");
		log.info("Step 04: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input To Email Textbox");
		log.info("Step 05: Input To Email Textbox");
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input To Fassword Textbox");
		log.info("Step 06: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Confirm Fassword Textbox");
		log.info("Step 07: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to register button");
		log.info("Step 08: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify success message displayed");
		log.info("Step 09: Verify success message displayed");
		Assert.assertEquals(registerPage.isSuccessMessageDisplayed(), "Your registration completed");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_004_ExistingEmail(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_004_ExistingEmail");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Male radio button");
		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input To Firstname Textbox");
		log.info("Step 03: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input To Lastname Textbox");
		log.info("Step 04: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input To Email Textbox");
		log.info("Step 05: Input To Email Textbox");
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input To Fassword Textbox");
		log.info("Step 06: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Confirm Fassword Textbox");
		log.info("Step 07: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to register button");
		log.info("Step 08: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify error message existing email displayed");
		log.info("Step 09: Verify error message existing email displayed");
		Assert.assertEquals(registerPage.isExistingEmailMessageDisplayed(), "The specified email already exists");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_005_LessThan6Chars(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_005_LessThan6Chars");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Male radio button");
		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input To Firstname Textbox");
		log.info("Step 03: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input To Lastname Textbox");
		log.info("Step 04: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input To Email Textbox");
		log.info("Step 05: Input To Email Textbox");
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input To Fassword Textbox");
		log.info("Step 06: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox("12345");

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Confirm Fassword Textbox");
		log.info("Step 07: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox("12345");

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to register button");
		log.info("Step 08: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify error message less than 6 chars displayed");
		log.info("Step 09: Verify error message less than 6 chars displayed");
		Assert.assertEquals(registerPage.isLessThan6CharsMessageDisplayed(),
				"Password must meet the following rules:\nmust have at least 6 characters");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Register_006_InvalidConfirmPassword(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_006_InvalidConfirmPassword");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register menu");
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Male radio button");
		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input To Firstname Textbox");
		log.info("Step 03: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input To Lastname Textbox");
		log.info("Step 04: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input To Email Textbox");
		log.info("Step 05: Input To Email Textbox");
		registerPage.inputToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input To Fassword Textbox");
		log.info("Step 06: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox("123456");

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Confirm Fassword Textbox");
		log.info("Step 07: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox("654321");

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click to register button");
		log.info("Step 08: Click to register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify error message invalid confirm password displayed");
		log.info("Step 09: Verify error message invalid confirm password displayed");
		Assert.assertEquals(registerPage.isInvalidConfirmPasswordMessageDisplayed(),
				"The password and confirmation password do not match.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
