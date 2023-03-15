package com.techpanda.createaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.techpanda.HomePageObject;
import pageObjects.techpanda.LoginOrCreateAnAccountObject;
import pageObjects.techpanda.MobilePageObject;
import pageObjects.techpanda.PageGeneratorManager;
import pageUIs.techpanda.MobilePageUI;

public class TC_08_CheckAddMultiItem extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginOrCreateAnAccountObject loginOrCreateAnAccount;
	MobilePageObject mobilePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser and navigate");
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);
	}

	@Test
	public void TC_01_CheckValidMessage() {
		log.info("Step: 1. Select [MOBILE] menu");
		homePage.clickToMoblie();
		mobilePage = PageGeneratorManager.getPageGenerator().getMobilePage(driver);

		log.info("Step: 2. In the list mobile, select Samsung Galaxy and click [ADD TO CARD] button");
		mobilePage.addToCart("Samsung Galaxy");
		homePage = PageGeneratorManager.getPageGenerator().getHomePage(driver);

		log.info("Step: 3. Select [MOBILE] menu");
		homePage.clickToMoblie();
		mobilePage = PageGeneratorManager.getPageGenerator().getMobilePage(driver);

		log.info("Step: 4. In the list mobile, select Samsung Galaxy and click [ADD TO CARD] button");
		mobilePage.addToCart("Sony Xperia");

		String samsung = mobilePage.geElementText(driver, MobilePageUI.PRICE_PRODUCT, "Samsung Galaxy");
		String sony = mobilePage.geElementText(driver, MobilePageUI.PRICE_PRODUCT, "Sony Xperia");

		log.info("Step: 6. Grand total = Iphone Cost + SamSung Galaxy Cost");
		String total = mobilePage.calculateGrandTotal(samsung, sony);
		System.out.print(total);
		verifyEquals(total, "$230.0");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
}
