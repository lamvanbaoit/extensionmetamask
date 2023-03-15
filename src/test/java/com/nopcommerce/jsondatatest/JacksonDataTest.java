package com.nopcommerce.jsondatatest;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import commons.BaseTest;
import testdata.PersonData;

//docs: http://dius.github.io/java-faker/apidocs/index.html
public class JacksonDataTest extends BaseTest {
    WebDriver driver;
    // B1
    PersonData personData;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // B2
        personData = PersonData.getData();

    }

    @Test
    public void TC_01_JacksonData() {
        // B3
        System.out.println(personData.getFirstname());
        System.out.println(personData.getLastname());
        System.out.println(personData.getFullname());
        System.out.println(personData.getEditFirstName());
        System.out.println(personData.getEditLastName());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
