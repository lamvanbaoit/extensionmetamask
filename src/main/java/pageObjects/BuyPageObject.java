package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BuyPageUI;

public class BuyPageObject extends BasePage {
    WebDriver driver;
    public BuyPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSortDropList() {
        selectItemInCustomDropdown(driver, BuyPageUI.parentSortDropList, BuyPageUI.childSortDropList, "Latest");
    }

    public void clickToFirstHeroItem(String index) {
        waitForElementClickable(driver, BuyPageUI.firstHeroItem, index);
        clickToElement(driver, BuyPageUI.firstHeroItem, index);
    }

    public String getTextClickToFirstHeroItem() {
        waitForElementAllVisible(driver, BuyPageUI.firstHeroItemText);
        return getElementText(driver, BuyPageUI.firstHeroItemText);
    }

    public void clickToBuyButton() {
        waitForElementClickable(driver, BuyPageUI.buyButton);
        clickToElement(driver, BuyPageUI.buyButton);
    }
}
