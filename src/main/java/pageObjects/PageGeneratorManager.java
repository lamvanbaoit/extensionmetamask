package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	// Cách 2
	// lấy 1 object
	// BasePage là kiểu object
	// static để khỏi new 1 đối tượng (object)
	public static PageGeneratorManager getPageGenerator() {
		// new 1 object
		return new PageGeneratorManager();
	}

	public MetamaskPageObject getMetamaskPage(WebDriver driver) {
		return new MetamaskPageObject(driver);
	}

	public DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}

	public BuyPageObject getBuyPage(WebDriver driver) {
		return new BuyPageObject(driver);
	}

	public RentPageObject getRentPage(WebDriver driver) {
		return new RentPageObject(driver);
	}

	public ThetanBoxPageObject getThetanBoxPage(WebDriver driver) {
		return new ThetanBoxPageObject(driver);
	}

	public BasePageObject getBasePage(WebDriver driver) {
		return new BasePageObject(driver);
	}

	public InventoryPageObject getInventoryPage(WebDriver driver) {
		return new InventoryPageObject(driver);
	}

}
