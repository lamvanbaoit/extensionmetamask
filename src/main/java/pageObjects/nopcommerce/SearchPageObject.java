package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToSearchStore(String store) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_STORE_TEXTBOX);
		sendKeyToElement(driver, SearchPageUI.SEARCH_STORE_TEXTBOX, store);
	}

	public void clickToSearchStoreButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_STORE_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_STORE_BUTTON);
	}

	public void clearToSearchKeyword() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		clearElementText(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
	}

	public void clickToSearchKeywordButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_KEYWORD_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_KEYWORD_BUTTON);
	}

	public String isMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.NOT_FOUND_MESSAGE);
		return getElementText(driver, SearchPageUI.NOT_FOUND_MESSAGE);
	}

	public void inputToSearchKeyword(String key) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendKeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, key);
	}

	public String isNotFoundProductMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.NOT_FOUND_PRODUCT_MESSAGE);
		return getElementText(driver, SearchPageUI.NOT_FOUND_PRODUCT_MESSAGE);
	}

	public void isProductTitleDisplayed(String name) {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_TITLE);
		findNameProduct(driver, SearchPageUI.PRODUCT_TITLE, name);
	}

	public void clickAdvancedCheckBox() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryDropdown(String text) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_SELECT);
		selectItemInDefaultDropdownVisibleText(driver, SearchPageUI.CATEGORY_SELECT, text);
	}

	public void clickAutomaticallySearchSubCategories() {
		waitForElementClickable(driver, SearchPageUI.CATEGORY_CHECKBOX);
		clickToElement(driver, SearchPageUI.CATEGORY_CHECKBOX);

	}

	public void selectManufacturerDropdown(String text) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTURER_SELECT);
		selectItemInDefaultDropdownVisibleText(driver, SearchPageUI.MANUFACTURER_SELECT, text);
	}

}
