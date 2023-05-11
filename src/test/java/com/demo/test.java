package com.demo;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class test extends BasePage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addExtensions(new File("extension/nkbihfbeogaeaoehlefnkodbefgpgknn.crx"));
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://marketplace.uat.thetanarena.com/");
    }

//    @Test
//    public void TC_01_Radio_Customer() {
//        WebElement connectButton = driver.findElement(By.xpath("//button[@class='button btn--rounded btn-secondary']"));
//        connectButton.click();
//    }

    @Test
    public void TC_01_getData( ) throws InterruptedException {

//        waitForElementClickable(driver,"(//span[text()='Connect Wallet'])[2]");
//        clickToElement(driver, "(//span[text()='Connect Wallet'])[2]");

//        waitForElementClickable(driver, "//span[text()='Login with MetaMask']");
//        clickToElement(driver, "//span[text()='Login with MetaMask']");

        // popup page
//        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");
//        Thread.sleep(20);

        switchToWindowByTitle(driver, "MetaMask");

        waitForElementClickable(driver,"//button[@class='button btn--rounded btn-secondary']");
        clickToElement(driver, "//button[@class='button btn--rounded btn-secondary']");

        waitForElementClickable(driver,"//button[@class='button btn--rounded btn-primary btn--large']");
        clickToElement(driver, "//button[@class='button btn--rounded btn-primary btn--large']");

        sendKeyToElement(driver, "(//input[@type=\"password\"])[1]", "job");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[2]", "lend");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[3]", "math");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[4]", "draft");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[5]", "salon");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[6]", "devote");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[7]", "ribbon");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[8]", "hood");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[9]", "goat");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[10]", "subway");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[11]", "problem");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[12]", "roof");

        waitForElementClickable(driver,"//button[@data-testid=\"import-srp-confirm\"]");
        clickToElement(driver, "//button[@data-testid=\"import-srp-confirm\"]");

        waitForElementClickable(driver,"//input[@data-testid=\"create-password-new\"]");
        sendKeyToElement(driver, "//input[@data-testid=\"create-password-new\"]", "0913012320Bao@");

        waitForElementClickable(driver,"//input[@data-testid=\"create-password-confirm\"]");
        sendKeyToElement(driver, "//input[@data-testid=\"create-password-confirm\"]", "0913012320Bao@");

        waitForElementClickable(driver,"//input[@data-testid=\"create-password-terms\"]");
        clickToElement(driver, "//input[@data-testid=\"create-password-terms\"]");

        waitForElementClickable(driver,"//button[@data-testid=\"create-password-import\"]");
        clickToElement(driver, "//button[@data-testid=\"create-password-import\"]");

        waitForElementClickable(driver,"//button[@data-testid=\"onboarding-complete-done\"]");
        clickToElement(driver, "//button[@data-testid=\"onboarding-complete-done\"]");

        waitForElementClickable(driver,"//button[@data-testid=\"pin-extension-next\"]");
        clickToElement(driver, "//button[@data-testid=\"pin-extension-next\"]");

        waitForElementClickable(driver,"//button[@data-testid=\"pin-extension-done\"]");
        clickToElement(driver, "//button[@data-testid=\"pin-extension-done\"]");

        switchToWindowByTitle(driver, "The Official Marketplace of Thetan Arena");

        waitForElementClickable(driver,"(//span[text()='Connect Wallet'])[2]");
        clickToElement(driver, "(//span[text()='Connect Wallet'])[2]");

        waitForElementClickable(driver, "//span[text()='Login with MetaMask']");
        clickToElement(driver, "//span[text()='Login with MetaMask']");

        waitNumberOfwindow(driver, 3);
        switchToWindowByTitle(driver, "MetaMask Notification");
        System.out.println("lamvanbao");

        waitForElementClickable(driver, "//div[@class='permissions-connect-header__title']");
        String text = geElementText(driver, "//div[@class='permissions-connect-header__title']");
        System.out.println(text);

        clickToElementByJS(driver, "//button[text()='Next']");
        clickToElementByJS(driver, "//button[text()='Connect']");
        scrollToBottomPage(driver);
        clickToElementByJS(driver, "//button[text()='Approve']");
        clickToElementByJS(driver, "//button[text()='Switch network']");

        switchToWindowByTitle(driver, "The Official Marketplace of Thetan Arena");

        waitForElementClickable(driver, "//button[@data-test-id='login.connect.accept-and-sign']");
        clickToElement(driver, "//button[@data-test-id='login.connect.accept-and-sign']");

        waitNumberOfwindow(driver, 3);
        switchToWindowByTitle(driver, "MetaMask Notification");

        clickToElementByJS(driver, "//button[text()='Sign']");

        switchToWindowByTitle(driver, "The Official Marketplace of Thetan Arena");

        waitForElementClickable(driver, "(//button//img)[5]");
        clickToElement(driver, "(//button//img)[5]");

        waitForElementClickable(driver, "(//button//img)[5]");
        clickToElement(driver, "(//button//img)[5]");

        waitForElementClickable(driver, "//div[@id='app']//div[@data-test-id=\"header.container\"]//div//span[text()='Buy']");
        clickToElement(driver, "//div[@id='app']//div[@data-test-id=\"header.container\"]//div//span[text()='Buy']");

        waitForElementClickable(driver, "(//div[@id='app']/div/div)[4]");
        clickToElement(driver, "(//div[@id='app']/div/div)[4]");

        switchToWindowByTitle(driver, "MetaMask");

        waitForElementClickable(driver, "//a[text()='Import tokens']");
        clickToElement(driver, "//a[text()='Import tokens']");

        waitForElementVisible(driver, "//input[@id='custom-address']");
        sendKeyToElement(driver, "//input[@id='custom-address']", "0x21f9b2137d4e1b83d09ea373be773a986c0e3f90");

//        waitForElementVisible(driver, "//input[@id='custom-symbol']");
//        String textTHC = getElementAttribute(driver, "//input[@id='custom-symbol']", "value");
//        System.out.println(textTHC);
//        Assert.assertEquals("THC", textTHC);
//
//        waitForElementVisible(driver, "//input[@id='custom-decimals']");
//        String text18 = getElementCssValue(driver, "//input[@id='custom-decimals']", "value");
//        Assert.assertEquals("THC", text18);

        Thread.sleep(5 * 1000);

        waitForElementClickable(driver, "//button[@data-testid='page-container-footer-next']");
        clickToElement(driver, "//button[@data-testid='page-container-footer-next']");

        waitForElementClickable(driver, "//button[text()='Import tokens']");
        clickToElement(driver, "//button[text()='Import tokens']");

        waitForElementClickable(driver, "//button[@class='asset-breadcrumb']");
        clickToElement(driver, "//button[@class='asset-breadcrumb']");

        waitForElementClickable(driver, "//li[@data-testid='home__asset-tab']//button");
        clickToElement(driver, "//li[@data-testid='home__asset-tab']//button");

        waitForElementClickable(driver, "//a[text()='Import tokens']");
        clickToElement(driver, "//a[text()='Import tokens']");

        waitForElementVisible(driver, "//input[@id='custom-address']");
        sendKeyToElement(driver, "//input[@id='custom-address']", "0x948deddc3d3cf03017fd4e42cc9ac874402d0bb9");
        Thread.sleep(5 * 1000);

        waitForElementClickable(driver, "//button[@data-testid='page-container-footer-next']");
        clickToElement(driver, "//button[@data-testid='page-container-footer-next']");

        waitForElementClickable(driver, "//button[text()='Import tokens']");
        clickToElement(driver, "//button[text()='Import tokens']");

        waitForElementClickable(driver, "//button[@class='asset-breadcrumb']");
        clickToElement(driver, "//button[@class='asset-breadcrumb']");

        waitForElementClickable(driver, "//a[text()='Import tokens']");
        clickToElement(driver, "//a[text()='Import tokens']");

        waitForElementVisible(driver, "//input[@id='custom-address']");
        sendKeyToElement(driver, "//input[@id='custom-address']", "0x15c9e651b5971feb66e19fe9e897be6bdc3e841a");
        Thread.sleep(5 * 1000);

        waitForElementClickable(driver, "//button[@data-testid='page-container-footer-next']");
        clickToElement(driver, "//button[@data-testid='page-container-footer-next']");

        waitForElementClickable(driver, "//button[text()='Import tokens']");
        clickToElement(driver, "//button[text()='Import tokens']");

        waitForElementClickable(driver, "//button[@class='asset-breadcrumb']");
        clickToElement(driver, "//button[@class='asset-breadcrumb']");

        switchToWindowByTitle(driver, "The Official Marketplace of Thetan Arena");

        waitForElementClickable(driver, "//div[@id='app']//div[@data-test-id=\"header.container\"]//div//span[text()='Buy']");
        clickToElement(driver, "//div[@id='app']//div[@data-test-id=\"header.container\"]//div//span[text()='Buy']");

        waitForElementClickable(driver, "//div[@data-test-id='buy.hero-items'][1]");
        clickToElement(driver, "//div[@data-test-id='buy.hero-items'][1]");

        waitForElementClickable(driver, "//button[@data-test-id='hero-detail.buy-button']");
        clickToElement(driver, "//button[@data-test-id='hero-detail.buy-button']");

        waitForElementClickable(driver, "//span[text()='Checkout']/parent::button");
        clickToElement(driver, "//span[text()='Checkout']/parent::button");

        waitNumberOfwindow(driver, 3);
        switchToWindowByTitle(driver, "MetaMask Notification");

        clickToElementByJS(driver, "//button[text()='Confirm']");

        switchToWindowByTitle(driver, "The Official Marketplace of Thetan Arena");

        waitForElementClickable(driver, "//span[text()='Close']/parent::button");
        clickToElement(driver, "//span[text()='Close']/parent::button");
    }

}
