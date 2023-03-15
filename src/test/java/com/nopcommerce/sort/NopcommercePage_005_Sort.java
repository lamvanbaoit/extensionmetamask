package com.nopcommerce.sort;

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
import pageObjects.nopcommerce.SortPageObject;

public class NopcommercePage_005_Sort extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SortPageObject sortPage;
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
	public void Nopcommerce_Sort_001_RegisterSuccess() {
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
	public void Nopcommerce_Sort_002_LoginSuccess() {
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

	@Test
	public void Nopcommerce_Sort_003() {
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
		homePage.clickToNameMenu("Computers");
		homePage.clickToNameSubMenu("Notebooks");

		sortPage = PageGeneratorManager.getPageGenerator().getSortPage(driver);
		sortPage.selectItemInSortDropdown("Name: A to Z");
		Assert.assertTrue(sortPage.LoadedSuccess());
		Assert.assertTrue(sortPage.isProductNameSortAscending());

		sortPage.selectItemInSortDropdown("Name: Z to A");
		Assert.assertTrue(sortPage.LoadedSuccess());
		Assert.assertTrue(sortPage.isProductNameSorDescending());

		sortPage.selectItemInSortDropdown("Price: High to Low");
		Assert.assertTrue(sortPage.LoadedSuccess());
		Assert.assertTrue(sortPage.isProductPriceSortDescending());

		sortPage.selectItemInSortDropdown("Price: Low to High");
		Assert.assertTrue(sortPage.LoadedSuccess());
		Assert.assertTrue(sortPage.isProductPriceSortAscending());
	}

	@Test
	public void Nopcommerce_Sort_004() {
		sortPage.selectItemInDisplayDropdown("3");
		Assert.assertTrue(sortPage.LoadedSuccess());

		Assert.assertTrue(sortPage.isDisplayedWith3Products());

		Assert.assertTrue(sortPage.isDisplayedNext());

		Assert.assertTrue(sortPage.isDisplayedPrevious());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
