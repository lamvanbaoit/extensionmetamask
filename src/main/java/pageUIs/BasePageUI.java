package pageUIs;

public class BasePageUI {
    public static final String avatarIcon = "//div[@data-test-id='header.user-avatar']";
    public static final String inventoryButton = "(//div[@data-test-id='header.user-menu']//div)[3]//span[text()='Inventory']";
    public static final String connectWalletButton = "(//span[text()='Connect Wallet'])[2]";
    public static final String loginWithMetaMaskButton = "//span[text()='Login with MetaMask']";
    public static final String acceptAndSignButton = "//button[@data-test-id='login.connect.accept-and-sign']";
    public static final String closeButton = "(//button//img)[5]";
    public static final String menuGeneral = "//div[@data-test-id='header.container']//div[1]//span[text()='%s']";
    public static final String checkoutButton = "//span[text()='Checkout']/parent::button";
    public static final String closeIcon = "//div[@id='app']/div[4]/div/img";
    public static final String closePopupButton = "//span[text()='Close']/parent::button";
}
