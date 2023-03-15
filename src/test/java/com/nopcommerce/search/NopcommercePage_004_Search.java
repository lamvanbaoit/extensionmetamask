package com.nopcommerce.search;

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
import pageObjects.nopcommerce.SearchPageObject;

public class NopcommercePage_004_Search extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
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
	public void Nopcommerce_Search_001_RegisterSuccess() {
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
	public void Nopcommerce_Search_002_LoginSuccess() {
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
		searchPage = PageGeneratorManager.getPageGenerator().getSearchPage(driver);

	}

	@Test
	public void Nopcommerce_Search_003_EmptyData() {
		searchPage.inputToSearchStore("a");
		searchPage.clickToSearchStoreButton();
		searchPage.clearToSearchKeyword();
		searchPage.clickToSearchKeywordButton();
		Assert.assertEquals(searchPage.isMessageDisplayed(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Nopcommerce_Search_004_DataNotExist() {
		searchPage.inputToSearchKeyword("Macbook Pro 2050");
		searchPage.clickToSearchKeywordButton();
		Assert.assertEquals(searchPage.isNotFoundProductMessageDisplayed(),
				"No products were found that matched your criteria.");
	}

	@Test
	public void Nopcommerce_Search_005_RelativeData() {
		searchPage.inputToSearchKeyword("Lenovo");
		searchPage.clickToSearchKeywordButton();
		searchPage.isProductTitleDisplayed("Lenovo");
	}

	@Test
	public void Nopcommerce_Search_006_AbsoluteData() {
		searchPage.inputToSearchKeyword("Thinkpad X1 Carbon");
		searchPage.clickToSearchKeywordButton();
		searchPage.isProductTitleDisplayed("Lenovo Thinkpad X1 Carbon");
	}

	@Test
	public void Nopcommerce_Search_008_AdvancedData() {
		searchPage.inputToSearchKeyword("App MacBoox Pro");
		searchPage.clickAdvancedCheckBox();
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickAutomaticallySearchSubCategories();
		searchPage.selectManufacturerDropdown("HP");
		searchPage.clickToSearchKeywordButton();
		Assert.assertEquals(searchPage.isNotFoundProductMessageDisplayed(),
				"No products were found that matched your criteria.");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
