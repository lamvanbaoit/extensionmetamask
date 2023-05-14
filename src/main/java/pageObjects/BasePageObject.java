package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;

public class BasePageObject extends BasePage {
    WebDriver driver;
    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConnectWalletButtonWeb() {
        waitForElementClickable(driver, BasePageUI.connectWalletButton);
        clickToElement(driver, BasePageUI.connectWalletButton);
    }

    public void clickLoginWithMetaMaskButtonWeb() {
        waitForElementClickable(driver, BasePageUI.loginWithMetaMaskButton);
        clickToElement(driver, BasePageUI.loginWithMetaMaskButton);
    }

    public void clickAcceptAndSignButtonWeb() {
        waitForElementClickable(driver, BasePageUI.acceptAndSignButton);
        clickToElement(driver, BasePageUI.acceptAndSignButton);
    }

    public void clickCloseIcon() {
        waitForElementClickable(driver, BasePageUI.closeButton);
        clickToElement(driver, BasePageUI.closeButton);
    }

    public void clickToBuyMenu(String buy) {
        waitForElementClickable(driver, BasePageUI.menuGeneral, buy);
        clickToElement(driver, BasePageUI.menuGeneral, buy);
    }

    public void clickToCheckoutButton() {
        waitForElementClickable(driver, BasePageUI.checkoutButton);
        clickToElement(driver, BasePageUI.checkoutButton);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, BasePageUI.closeIcon);
        clickToElement(driver, BasePageUI.closeIcon);
    }

    public void clickToCloseButton() {
        waitForElementClickable(driver, BasePageUI.closePopupButton);
        clickToElement(driver, BasePageUI.closePopupButton);
    }


    public void clickToAvatarProfile() {
        waitForElementClickable(driver, BasePageUI.avatarIcon);
        clickToElement(driver, BasePageUI.avatarIcon);
    }

    public void clickToProfileInventory() {
        waitForElementClickable(driver, BasePageUI.inventoryButton);
        clickToElement(driver, BasePageUI.inventoryButton);
    }


}
