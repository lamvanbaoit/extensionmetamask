package pageObjects.orangehrm;

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

	public LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public ManagerHomePageObject getManagerHomePage(WebDriver driver) {
		return new ManagerHomePageObject(driver);
	}

	public AddCustomerPageObject getAddCustomerPage(WebDriver driver) {
		return new AddCustomerPageObject(driver);
	}

	public EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public CustomerRegMsgPageObject getCustomerRegMsgPage(WebDriver driver) {
		return new CustomerRegMsgPageObject(driver);
	}

	public AddAccountPageObject getAddAccountPage(WebDriver driver) {
		return new AddAccountPageObject(driver);
	}
}
