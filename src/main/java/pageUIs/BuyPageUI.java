package pageUIs;

public class BuyPageUI {
    public static final String parentSortDropList = "(//div[@data-test-id='buy.dropdown-list']//div)[1]";
    public static final String childSortDropList = "//div[@data-test-id='buy.dropdown-list']//div//span";
    public static final String firstHeroItem = "//div[@data-test-id='buy.hero-items'][%s]";
    public static final String firstHeroItemText = "(//span[@data-test-id='buy.hero-name'])[1]";
    public static final String buyButton = "//button[@data-test-id='hero-detail.buy-button']";
}

