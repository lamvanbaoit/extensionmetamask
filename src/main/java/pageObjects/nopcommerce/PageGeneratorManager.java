package pageObjects.nopcommerce;

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

	public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}

	public SortPageObject getSortPage(WebDriver driver) {
		return new SortPageObject(driver);
	}

}
