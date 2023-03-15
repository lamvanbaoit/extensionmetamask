package pageUIs.techpanda;

public class MobilePageUI {
	public static final String MOBILE_PAGE = "//a[normalize-space()='%s']//parent::h2[@class='product-name']//following-sibling::div//span[contains(text(),'Add to Cart')]";
	public static final String PRICE_PRODUCT = "//a[normalize-space()='%s']//ancestor::td[@class='product-cart-info']//following-sibling::td[@class='product-cart-price']/span/span";
}
