package com.hero_trading;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class HT_TC017 extends BaseTest {
    WebDriver driver;
    BasePageObject basePage;
    MetamaskPageObject metamaskPage;
    BuyPageObject buyPage;
    InventoryPageObject inventoryPage;
    @Parameters({ "browser", "url" })
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition: Open browser and navigate");
        driver = getBrowserDriver(browserName, appUrl);
        metamaskPage = PageGeneratorManager.getPageGenerator().getMetamaskPage(driver);
    }

    @Test
    public void TC_01_Login(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_BuyAHeroSuccesfully");
        log.info("Step : switchToMetamaskWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Switch To Metamask Web");
        metamaskPage.switchToMetamaskWeb();

        log.info("Step : clickToImportAntExistingWalletButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click To Import Ant Existing Wallet Button Web");
        metamaskPage.clickToImportAntExistingWalletButtonWeb();

        log.info("Step : clickIAgreeButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click I Agree Button Web");
        metamaskPage.clickIAgreeButtonWeb();

        log.info("Step : inputMetamaskTextWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Input Metamask Text Web");
        metamaskPage.inputMetamaskTextWeb();

        log.info("Step : clickConfirmSecretRecoveryPhraseButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Confirm Secret Recovery Phrase Button Web");
        metamaskPage.clickConfirmSecretRecoveryPhraseButtonWeb();

        log.info("Step : inputNewPasswordTextboxWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Input New Password Textbox Web");
        metamaskPage.inputNewPasswordTextboxWeb();

        log.info("Step : inputConfirmPasswordTextboxWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Input Confirm Password Textbox Web");
        metamaskPage.inputConfirmPasswordTextboxWeb();

        log.info("Step : clickTermsCheckboxWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Terms Checkbox Web");
        metamaskPage.clickTermsCheckboxWeb();

        log.info("Step : clickImportMyWalletButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Import My Wallet Button Web");
        metamaskPage.clickImportMyWalletButtonWeb();

        log.info("Step : clickGotItButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Got It Button Web");
        metamaskPage.clickGotItButtonWeb();

        log.info("Step : clickNextButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Next Button Web");
        metamaskPage.clickNextButtonWeb();

        log.info("Step : clickDoneButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click Done Button Web");
        metamaskPage.clickDoneButtonWeb();

        log.info("Step : switchToMarketplaceWeb");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Switch To Marketplace Web");
        metamaskPage.switchToMarketplaceWeb();

        log.info("Step : clickConnectWalletButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Connect Wallet Button Web");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickConnectWalletButtonWeb();

        log.info("Step : clickLoginWithMetaMaskButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Login With MetaMask Button Web");
        basePage.clickLoginWithMetaMaskButtonWeb();

        log.info("Step : switchPopupMetamask");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch Popup Metamask");
        metamaskPage = PageGeneratorManager.getPageGenerator().getMetamaskPage(driver);
        metamaskPage.switchPopupMetamask();

        log.info("Step : clickNextButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Next Button Popup");
        metamaskPage.clickNextButtonPopup();

        log.info("Step : clickConnectButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Connect Button Popup");
        metamaskPage.clickConnectButtonPopup();

        log.info("Step : clickApproveButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Approve Button Popup");
        metamaskPage.clickApproveButtonPopup();

        log.info("Step : clickSwitchNetworkButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Switch Network Button Popup");
        metamaskPage.clickSwitchNetworkButtonPopup();

        log.info("Step : switchToMarketplaceWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch To Marketplace Web");
        metamaskPage.switchToMarketplaceWeb();

        log.info("Step : clickAcceptAndSignButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Accept And Sign Button Web");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickAcceptAndSignButtonWeb();

        log.info("Step : switchPopupMetamask");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch Popup Metamask");
        metamaskPage = PageGeneratorManager.getPageGenerator().getMetamaskPage(driver);
        metamaskPage.switchPopupMetamask();

        log.info("Step : clickSignButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Sign Button Popup");
        metamaskPage.clickSignButtonPopup();

        log.info("Step : switchToMarketplaceWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch To Marketplace Web");
        metamaskPage.switchToMarketplaceWeb();

        log.info("Step : clickCloseIcon");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Close Icon");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickCloseIcon();

        log.info("Step : clickCloseIcon");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Close Icon");
        basePage.clickCloseIcon();

        log.info("Step : switchToMetamaskWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch To Metamask Web");
        metamaskPage = PageGeneratorManager.getPageGenerator().getMetamaskPage(driver);
        metamaskPage.switchToMetamaskWeb();

        log.info("Step : clickImportTokensLinkWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Link Web");
        metamaskPage.clickImportTokensLinkWeb();

        log.info("Step : inputTokenContractAddressTextboxWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Input Token Contract Address Textbox Web");
        metamaskPage.inputTokenContractAddressTextboxWeb("0x21f9b2137d4e1b83d09ea373be773a986c0e3f90");

        log.info("Step : clickToAddCustomTokenButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Add Custom Token Button Web");
        metamaskPage.clickToAddCustomTokenButtonWeb();

        log.info("Step : clickImportTokensButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Button Web");
        metamaskPage.clickImportTokensButtonWeb();

        log.info("Step : clickBackIconButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Back Icon Button Web");
        metamaskPage.clickBackIconButtonWeb();

        log.info("Step : clickToAssetsButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Assets Button Web");
        metamaskPage.clickToAssetsButtonWeb();

        log.info("Step : clickImportTokensLinkWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Link Web");
        metamaskPage.clickImportTokensLinkWeb();

        log.info("Step : inputTokenContractAddressTextboxWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Input Token Contract Address Textbox Web");
        metamaskPage.inputTokenContractAddressTextboxWeb("0x948deddc3d3cf03017fd4e42cc9ac874402d0bb9");

        log.info("Step : clickToAddCustomTokenButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Add Custom Token Button Web");
        metamaskPage.clickToAddCustomTokenButtonWeb();

        log.info("Step : clickImportTokensButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Button Web");
        metamaskPage.clickImportTokensButtonWeb();

        log.info("Step : clickBackIconButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Back Icon Button Web");
        metamaskPage.clickBackIconButtonWeb();

        log.info("Step : clickToAssetsButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Assets Button Web");
        metamaskPage.clickToAssetsButtonWeb();

        log.info("Step : clickImportTokensLinkWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Link Web");
        metamaskPage.clickImportTokensLinkWeb();

        log.info("Step : inputTokenContractAddressTextboxWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Input Token Contract Address Textbox Web");
        metamaskPage.inputTokenContractAddressTextboxWeb("0x15c9e651b5971feb66e19fe9e897be6bdc3e841a");

        log.info("Step : clickToAddCustomTokenButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Add Custom Token Button Web");
        metamaskPage.clickToAddCustomTokenButtonWeb();

        log.info("Step : clickImportTokensButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Import Tokens Button Web");
        metamaskPage.clickImportTokensButtonWeb();

        log.info("Step : clickBackIconButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click Back Icon Butto nWeb");
        metamaskPage.clickBackIconButtonWeb();

        log.info("Step : clickToAssetsButtonWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Click To Assets Button Web");
        metamaskPage.clickToAssetsButtonWeb();

        log.info("Step : switchToMarketplaceWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : Switch To Marketplace Web");
        metamaskPage.switchToMarketplaceWeb();
    }

    @Test
    public  void TC_02_BuyAHeroSuccesfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_02_BuyAHeroSuccesfully");

        log.info("Step : clickToBuyMenu");
        ExtentTestManager.getTest().log(Status.INFO, "Step : Click To Buy Menu");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickToBuyMenu("Buy");

        log.info("Step : clickToCloseIcon");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToCloseIcon");
        basePage.clickToCloseIcon();

        log.info("Step : clickToCheapestItemDropList");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToCheapestItemDropList");
        buyPage = PageGeneratorManager.getPageGenerator().getBuyPage(driver);
        buyPage.clickToSortDropList();

        log.info("Step : getTextClickToFirstHeroItem");
        ExtentTestManager.getTest().log(Status.INFO,"Step : getTextClickToFirstHeroItem");
        String textHeroBuy = buyPage.getTextClickToFirstHeroItem();

        log.info("Step : clickToFirstHeroItem");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToFirstHeroItem");
        buyPage.clickToFirstHeroItem("3");

        log.info("Step : clickToBuyButton");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToBuyButton");
        buyPage.clickToBuyButton();

        log.info("Step : clickToCheckoutButton");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToCheckoutButton");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickToCheckoutButton();

        log.info("Step : switchPopupMetamask");
        ExtentTestManager.getTest().log(Status.INFO,"Step : switchPopupMetamask");
        metamaskPage = PageGeneratorManager.getPageGenerator().getMetamaskPage(driver);
        metamaskPage.switchPopupMetamask();

        log.info("Step : clickConfirmButtonPopup");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickConfirmButtonPopup");
        metamaskPage.clickConfirmButtonPopup();

        log.info("Step : switchToMarketplaceWeb");
        ExtentTestManager.getTest().log(Status.INFO,"Step : switchToMarketplaceWeb");
        metamaskPage.switchToMarketplaceWeb();

        log.info("Step : clickToCloseButton");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToCloseButton");
        basePage = PageGeneratorManager.getPageGenerator().getBasePage(driver);
        basePage.clickToCloseButton();

        log.info("Step : clickToAvatarProfile");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToAvatarProfile");
        basePage.clickToAvatarProfile();

        log.info("Step : clickToProfileInventory");
        ExtentTestManager.getTest().log(Status.INFO,"Step : clickToProfileInventory");
        basePage.clickToProfileInventory();

        log.info("Step : getTexToFirstHeroItemProfile");
        ExtentTestManager.getTest().log(Status.INFO,"Step : getTexToFirstHeroItemProfile");
        inventoryPage =  PageGeneratorManager.getPageGenerator().getInventoryPage(driver);
        String textHeroInventory = inventoryPage.getTexToFirstHeroItemProfile();

        Assert.assertEquals(textHeroBuy, textHeroInventory);


    }

//    @AfterClass(alwaysRun = true)
//    public void afterClass() {
//        log.info("Post-Condition: Close browser");
//        closeBrowserAndDriver();
//    }
}
