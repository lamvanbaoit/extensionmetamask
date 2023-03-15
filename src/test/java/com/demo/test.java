package com.demo;

import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        options.addExtensions(new File("C:\\Users\\lamva\\Downloads\\nkbihfbeogaeaoehlefnkodbefgpgknn.crx"));
//        options.setAcceptInsecureCerts(true);
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

        sendKeyToElement(driver, "(//input[@type=\"password\"])[1]", "senior");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[2]", "drift");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[3]", "laundry");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[4]", "goose");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[5]", "bonus");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[6]", "grant");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[7]", "few");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[8]", "ecology");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[9]", "super");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[10]", "year");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[11]", "then");
        sendKeyToElement(driver, "(//input[@type=\"password\"])[12]", "title");

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

        switchToWindowByTitle(driver, "MetaMask Notification");
        System.out.println("lamvanbao");

//        driver.get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#onboarding/welcome");

        waitForElementClickable(driver, "//button[@class=\"button btn--rounded btn-secondary\"]");
        clickToElement(driver, "//button[@class=\"button btn--rounded btn-secondary\"]");

//        waitForElementClickable(driver, "data-testid=\"page-container-footer-next");
//        clickToElement(driver, "data-testid=\"page-container-footer-next");
//
//        waitForElementClickable(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
//        clickToElement(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
//
//        waitForElementClickable(driver, "//button[@class=\"button btn--rounded btn-primary\"]");
//        clickToElement(driver, "//button[@class=\"button btn--rounded btn-primary\"]");


    }

}
