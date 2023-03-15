package com.nopcommerce.login;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class NopcommercePage_002_Login extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
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
	public void Nopcommerce_Login_001_RegisterSuccess(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_001_RegisterSuccess");

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to login menu");
		log.info("Step 01: Click to login menu");
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
//		registerPage.inputToEmailTextbox("ad@ad.ad");

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
	public void Nopcommerce_Login_002_EmptyData() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Verify error message email displayed");
		Assert.assertEquals(loginPage.isEmailErrorMessageDisplayed(), "Please enter your email");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Login_003_InvalidEmail() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Input to email textbox");
		loginPage.inputToEmailTextBox("ad");

		log.info("Step 04: Input to password textbox");
		loginPage.inputToPasswordTextBox("123123");

		log.info("Step 05: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("Step 06: Verify error message email displayed");
		Assert.assertEquals(loginPage.isEmailErrorMessageDisplayed(), "Wrong email");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Login_004_UnregisteredEmail() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Input to email textbox");
		loginPage.inputToEmailTextBox("ad@ad.com");

		log.info("Step 04: Input to password textbox");
		loginPage.inputToPasswordTextBox("123123");

		log.info("Step 05: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("Step 06: Verify error message email displayed");
		Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Login_005_EmptyPassword() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Input to email textbox");
		loginPage.inputToEmailTextBox(email);

		log.info("Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("Step 05: Verify error message email displayed");
		Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Login_006_InvalidPassword() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Input to email textbox");
		loginPage.inputToEmailTextBox(email);

		log.info("Step 04: Input to password textbox");
		loginPage.inputToPasswordTextBox("123456");

		log.info("Step 05: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("Step 06: Verify error message email displayed");
		Assert.assertEquals(loginPage.isErrorMessageDisplayed(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_Login_007_LoginSuccess() {
		log.info("Step 01: Click to login menu");
		homePage.clickToHeardNameMenu("Log in");
		loginPage = PageGeneratorManager.getPageGenerator().getLoginPage(driver);

		log.info("Step 02: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Step 03: Input to email textbox");
		loginPage.inputToEmailTextBox(email);

		log.info("Step 04: Input to password textbox");
		loginPage.inputToPasswordTextBox(password);

		log.info("Step 05: Click to Login button");
		loginPage.clickToLoginButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
