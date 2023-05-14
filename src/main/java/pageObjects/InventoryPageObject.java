package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.InventoryPageUI;

public class InventoryPageObject extends BasePage {
    WebDriver driver;
    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTexToFirstHeroItemProfile() {
        waitForElementClickable(driver, InventoryPageUI.firstHeroItemProfileText);
        return  getElementText(driver, InventoryPageUI.firstHeroItemProfileText);
    }
}
