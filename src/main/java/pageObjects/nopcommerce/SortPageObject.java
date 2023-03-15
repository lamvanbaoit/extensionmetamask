package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.SortPageUI;

public class SortPageObject extends BasePage {
	WebDriver driver;

	public SortPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Sort
	public void selectItemInSortDropdown(String itemText) {
		waitForElementClickable(driver, SortPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, SortPageUI.SORT_DROPDOWN, itemText);

	}

	public boolean LoadedSuccess() {
		return isPageLoadedSuccess(driver);
	}

	public boolean isProductNameSortAscending() {
		waitForElementVisible(driver, SortPageUI.PRODUCT_NAME_TEXT);
		return isDataStringSortAscending(driver, SortPageUI.PRODUCT_NAME_TEXT);

	}

	public boolean isProductNameSorDescending() {
		waitForElementVisible(driver, SortPageUI.PRODUCT_NAME_TEXT);
		return isDataStringSortDescending(driver, SortPageUI.PRODUCT_NAME_TEXT);

	}

	public boolean isProductPriceSortAscending() {
		waitForElementVisible(driver, SortPageUI.PRODUCT_PRICE_TEXT);
		return isDataFloatSortAscending(driver, SortPageUI.PRODUCT_PRICE_TEXT);

	}

	public boolean isProductPriceSortDescending() {
		waitForElementVisible(driver, SortPageUI.PRODUCT_PRICE_TEXT);
		return isDataFloatSortDescending(driver, SortPageUI.PRODUCT_PRICE_TEXT);

	}

	// Displayed
	public void selectItemInDisplayDropdown(String itemText) {
		waitForElementClickable(driver, SortPageUI.DISPLAYED_DROPDOWN);
		selectItemInDefaultDropdownVisibleText(driver, SortPageUI.DISPLAYED_DROPDOWN, itemText);

	}

	public boolean isDisplayedWith3Products() {
		waitForElementVisible(driver, SortPageUI.ITEM_NAME_TEXT);
		return findNameProducts(driver, SortPageUI.ITEM_NAME_TEXT);
	}

	public boolean isDisplayedNext() {
		waitForElementVisible(driver, SortPageUI.NEXT);
		return isElementDisplayed(driver, SortPageUI.NEXT);
	}

	public boolean isDisplayedPrevious() {
		clickToElement(driver, SortPageUI.NEXT);
		waitForElementVisible(driver, SortPageUI.PREVIOUS);
		return isElementDisplayed(driver, SortPageUI.PREVIOUS);
	}

}
