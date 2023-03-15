package pageObjects.techpanda;

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

	public HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public LoginOrCreateAnAccountObject getLoginOrCreateAnAccount(WebDriver driver) {
		return new LoginOrCreateAnAccountObject(driver);
	}

	public MobilePageObject getMobilePage(WebDriver driver) {
		return new MobilePageObject(driver);
	}
}
