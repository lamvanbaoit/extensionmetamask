package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class NopcommercePage_003_MyAccount extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	String email = "ad" + randomestring() + "@ad.ad";
	String emailUpdate = "ad" + randomestring() + "@ad.ad";
	String password = "123123";
	String newPassword = "123456";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_MyAccount_001_RegisterSuccess() {
		log.info("Step 01: Click to register menu");
		homePage.clickToHeardNameMenu("Register");
		registerPage = PageGeneratorManager.getPageGenerator().getRegisterPage(driver);

		log.info("Step 02: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Step 03: select to day dropdownlist");
		registerPage.inputToDayDropdown("3");

		log.info("Step 04: select to month dropdownlist");
		registerPage.inputToMonthDropdown("July");

		log.info("Step 05: select to year dropdownlist");
		registerPage.inputToYearDropdown("1997");

		log.info("Step 06: Input To Firstname Textbox");
		registerPage.inputToFirstnameTextbox("Bao");

		log.info("Step 07: Input To Lastname Textbox");
		registerPage.inputToLastnameTextbox("Lam");

		log.info("Step 08: Input To Email Textbox");
		registerPage.inputToEmailTextbox(email);
		System.out.println(email);
//		registerPage.inputToEmailTextbox("ad@ad.ad");

		log.info("Step 09: Input To Fassword Textbox");
		registerPage.inputToFasswordTextbox(password);

		log.info("Step 10: Input to Confirm Fassword Textbox");
		registerPage.inputToConfirmFasswordTextbox(password);

		log.info("Step 11: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Step 12: Verify success message displayed");
		Assert.assertEquals(registerPage.isSuccessMessageDisplayed(), "Your registration completed");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_MyAccount_002_LoginSuccess() {
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
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);

	}

	@Test
	public void Nopcommerce_MyAccount_003_CustomerInfo() {
		log.info("Step 01: Click to my account menu");
		homePage.clickToHeardNameMenu("My account");
		myAccountPage = PageGeneratorManager.getPageGenerator().getMyAccountPage(driver);

		log.info("Step 02: Click to Male radio button");
		myAccountPage.clickToGenderMaleRadioButton();

		log.info("Step 03: select to day dropdownlist");
		myAccountPage.inputToDayDropdown("10");

		log.info("Step 04: select to month dropdownlist");
		myAccountPage.inputToMonthDropdown("March");

		log.info("Step 05: select to year dropdownlist");
		myAccountPage.inputToYearDropdown("2000");

		log.info("Step 06: Input to Firstname Textbox");
		myAccountPage.inputToFirstnameTextbox("Lam");

		log.info("Step 07: Input to Lastname Textbox");
		myAccountPage.inputToLastnameTextbox("Bao");

		log.info("Step 08: Input to Email Textbox");
		myAccountPage.inputToEmailTextbox(email);

		log.info("Step 09: Click to Save Button");
		myAccountPage.clickToSaveButton();

		log.info("Step 10: Verify success message FeMale displayed");
		Assert.assertTrue(myAccountPage.isFeMaleDisplayed());

		log.info("Step 11: Verify success message First Name displayed");
		Assert.assertEquals(myAccountPage.isFirstNameDisplayed(), "Lam");

		log.info("Step 12: Verify success message Last Name displayed");
		Assert.assertEquals(myAccountPage.isLastNameDisplayed(), "Bao");

		log.info("Step 13: Verify success message Day displayed");
		Assert.assertEquals(myAccountPage.isDayDisplayed(), "10");

		log.info("Step 14: Verify success message Month displayed");
		Assert.assertEquals(myAccountPage.isMonthDisplayed(), "3");

		log.info("Step 15: Verify success message Year displayed");
		Assert.assertEquals(myAccountPage.isYearDisplayed(), "2000");

		log.info("Step 16: Verify success message Email displayed");
		Assert.assertEquals(myAccountPage.isEmailDisplayed(), email);
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);

	}

	@Test
	public void Nopcommerce_MyAccount_004_Addresses() {
		log.info("Step 01: Click to my account menu");
		homePage.clickToHeardNameSubMenu("Addresses");
		myAccountPage = PageGeneratorManager.getPageGenerator().getMyAccountPage(driver);

		log.info("Step 02: Click to address add new button");
		myAccountPage.clickAddressAddNewButton();

		log.info("Step 03: Input to address first name textbox");
		myAccountPage.inputToAddressFirstnameTextbox("Ngự");

		log.info("Step 04: Input to address last name textbox");
		myAccountPage.inputToAddressLastnameTextbox("Bình");

		log.info("Step 05: Input to address email textbox");
		myAccountPage.inputToAddressEmailTextbox("ngubinh@gmail.com");

		log.info("Step 06: Input to address company textbox");
		myAccountPage.inputToAddressCompanyTextbox("company qa");

		log.info("Step 07: Input to address country dropdownlist");
		myAccountPage.inputToAddressCountryDropdown("Viet Nam");

		log.info("Step 08: Input to address state dropdownlist");
		myAccountPage.inputToAddressStateDropdown("Other");

		log.info("Step 09: Input to address city textbox");
		myAccountPage.inputToAddressCityTextBox("HCM");

		log.info("Step 10: Input to address address 1 textbox");
		myAccountPage.inputToAddress1Textbox("Q7");

		log.info("Step 11: Input to address address 2 textbox");
		myAccountPage.inputToAddress2Textbox("Q1");

		log.info("Step 12: Input to address zip textbox");
		myAccountPage.inputToAddressZipTextbox("550000");

		log.info("Step 13: Input to address phone number textbox");
		myAccountPage.inputToAddressPhoneNumberTextbox("0855556393");

		log.info("Step 14: Input to address fax number textbox");
		myAccountPage.inputToAddressFaxNumberTextbox("0812345678");

		log.info("Step 15: Click to address save button");
		myAccountPage.clickToAddressSaveButton();

		log.info("Step 16: Verify success message Email displayed");
		Assert.assertEquals(myAccountPage.isAddressEmailDisplayed(), "Email: ngubinh@gmail.com");

		log.info("Step 17: Verify success message Phone displayed");
		Assert.assertEquals(myAccountPage.isAddressPhoneDisplayed(), "Phone number: 0855556393");

		log.info("Step 18: Verify success message Fax displayed");
		Assert.assertEquals(myAccountPage.isAddressFaxDisplayed(), "Fax number: 0812345678");

		log.info("Step 19: Verify success message Company displayed");
		Assert.assertEquals(myAccountPage.isAddressCompanyDisplayed(), "company qa");

		log.info("Step 20: Verify success message Address 1 displayed");
		Assert.assertEquals(myAccountPage.isAddressAddress1Displayed(), "Q7");

		log.info("Step 21: Verify success message Address 2 displayed");
		Assert.assertEquals(myAccountPage.isAddressAddress2Displayed(), "Q1");

		log.info("Step 22: Verify success message State City Zip displayed");
		Assert.assertEquals(myAccountPage.isAddressCityStateZipDisplayed(), "HCM, 550000");

		log.info("Step 23: Verify success message Country displayed");
		Assert.assertEquals(myAccountPage.isAddressCountryDisplayed(), "Viet Nam");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void Nopcommerce_MyAccount_005_ChangePassword() {
		log.info("Step 01: Click to change password menu");
		homePage.clickToHeardNameSubMenu("Change password");
		myAccountPage = PageGeneratorManager.getPageGenerator().getMyAccountPage(driver);

		log.info("Step 02: Input to password menu");
		myAccountPage.inputToOldPasswordTextbox(password);

		log.info("Step 03: Input to new password menu");
		myAccountPage.inputToNewPasswordTextbox(newPassword);

		log.info("Step 04: Input to confirm password menu");
		myAccountPage.inputToConfirmPasswordTextbox(newPassword);

		log.info("Step 05: Click to change password button");
		myAccountPage.clickToChangePasswordButton();

		log.info("Step 06: Click to close Icon");
		myAccountPage.clickToClosedIcon();
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);

		log.info("Step 07: Click to log out menu");
		homePage.clickToHeardNameMenu("Log out");

		log.info("Step 08: Click to login button");
		homePage.clickToHeardNameMenu("Log in");

		log.info("Step 09: Input to email textbox");
		loginPage.inputToEmailTextBox(email);

		log.info("Step 20: Input to password textbox");
		loginPage.inputToPasswordTextBox(password);

		log.info("Step 12: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("Step 13: Input to password textbox");
		loginPage.inputToPasswordTextBox(newPassword);

		log.info("Step 14: Click to Login button");
		loginPage.clickToLoginButton();
		myAccountPage = PageGeneratorManager.getPageGenerator().getMyAccountPage(driver);
	}

	@Test
	public void Nopcommerce_MyAccount_006_MyProductReviews() {
		myAccountPage.clickToAddToCartButton("Build your own computer");
		myAccountPage.clickToAddYourReviewLink();
		myAccountPage.inputReviewTitleTextBox("abc");
		myAccountPage.inputReviewTextTextArea("abc\ndef");
		myAccountPage.clickToSubmitReviewButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
//		closeBrowserAndDriver();
	}
}
