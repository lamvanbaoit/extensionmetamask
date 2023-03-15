package commons;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageUIs.orangehrm.BasePageUI;

// Common class
public class BasePage {

	// Cách 2
	// lấy 1 object
	// BasePage là kiểu object
	// static để khỏi new 1 đối tượng (object)
	public static BasePage getBasePageObject() {
		// new 1 object
		return new BasePage();
	}

	// log4j
	// init log
	protected final Log log;

	// log4j
	// constructor
	protected BasePage() {
		log = LogFactory.getLog(getClass());
	}

	// Common function
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookies : allCookies) {
			driver.manage().addCookie(cookies);
		}
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public WebElement getElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}

	public List<WebElement> getElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public By getLocatorBy(String locator) {
		By by = null;
		if (locator.startsWith("xpath=")) {
			locator = locator.replace("xpath=", "");
			by = By.xpath(locator);
		} else if (locator.startsWith("xpath=")) {
			locator = locator.replace("css=", "");
			by = By.xpath(locator);
		}
		return by;
	}

	public String getDynamicLocator(String xpathLocator, String... parameters) {
		return String.format(xpathLocator, (Object[]) parameters);
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getElement(driver, xpathLocator).click();
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... parameters) {
		getElement(driver, getDynamicLocator(xpathLocator, parameters)).click();
	}

	public void clearElementText(WebDriver driver, String xpathLocator) {
		getElement(driver, xpathLocator).clear();
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... parameters) {
		WebElement element = getElement(driver, getDynamicLocator(xpathLocator, parameters));
		element.clear();
		element.sendKeys(textValue);
	}

	public String geElementText(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).getText();
	}

	public String geElementText(WebDriver driver, String xpathLocator, String... parameters) {
		return getElement(driver, getDynamicLocator(xpathLocator, parameters)).getText();
	}

	public void selectItemInDefaultDropdownVisibleText(WebDriver driver, String xpathLocator, String textItem) {
		select = new Select(getElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdownValue(WebDriver driver, String xpathLocator, String textItem) {
		select = new Select(getElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropdownIndex(WebDriver driver, String xpathLocator, int index) {
		select = new Select(getElement(driver, xpathLocator));
		select.selectByIndex(index);
	}

	public String getSelectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public int getSelectItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		select = new Select(getElement(driver, xpathLocator));
		return select.getOptions().size();
	}

	public boolean istDropdownMultiple(WebDriver driver, String xpathLocator) {
		select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();
	}

	// click rồi => click chọn 1
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		// Chờ cho element này được phép click
		// Click vào 1 element cho nó xổ ra tất cả item trong dropdown ra
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		// Wait cho tất cả element được load ra (có trong HTML/ DOM)
		// presence
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		// Lấy tất cả các item trong dropdown bằng bao nhiêu
//		System.out.println("Item size: " + allItems.size());

		for (WebElement item : allItems) {
			// Mỗi lần duyệt kiểm tra xem text của item đó có bằng với item mình cần click
			// hay ko
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item)).click();
				sleepInSecond(1);
				break;
			}
		}
	}

	// nhập rồi => click chọn 1
	public void selectItemInputInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		// Chờ cho element này được phép click
		// input vào 1 element cho nó xổ ra tất cả item trong dropdown ra
		getElement(driver, parentLocator).sendKeys(expectedItem);
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, longTimeout);
		// Wait cho tất cả element được load ra (có trong HTML/ DOM)
		// presence
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		// Lấy tất cả các item trong dropdown bằng bao nhiêu
//			System.out.println("Item size: " + allItems.size());

		for (WebElement item : allItems) {
			// Mỗi lần duyệt kiểm tra xem text của item đó có bằng với item mình cần click
			// hay ko
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				explicitWait.until(ExpectedConditions.elementToBeClickable(item)).click();
				sleepInSecond(1);
				break;
			}
		}
	}

	// chọn nhiều
	public void selectMultileItemInEditDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String childItemLocatorInput, String[] expectedItem) {
		// Chờ cho element này được phép click
		// Click vào 1 element cho nó xổ ra tất cả item trong dropdown ra
		getElement(driver, parentLocator).click();
		;

		// Wait cho tất cả element được load ra (có trong HTML/ DOM)
		// presence
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		// Lấy tất cả các item trong dropdown bằng bao nhiêu
//		System.out.println("Item size: " + allItems.size());

		for (WebElement childElement : allItems) {
			for (String item : expectedItem) {
				String actualItem = childElement.getText();
				if (actualItem.equals(item)) {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSecond(1);
					explicitWait.until(ExpectedConditions.elementToBeClickable(childElement)).click();
					sleepInSecond(1);

					List<WebElement> itemSlected = getElements(driver, childItemLocatorInput);
					System.out.println("Item selected: " + itemSlected.size());
					if (expectedItem.length == itemSlected.size()) {
						break;
					}
				}
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).getText();
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getElements(driver, xpathLocator).size();
	}

	public int getElementSize(WebDriver driver, String xpathLocator, String... parameters) {
		return getElements(driver, getDynamicLocator(xpathLocator, parameters)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		try {
			// Displayed: Visible on UI + Exist in DOM
			// Undisplayed: Invisible on UI + Exist in DOM
			return getElement(driver, xpathLocator).isDisplayed();
		} catch (Exception e) {
//			e.printStackTrace();
			// Undisplayed: Invisible on UI + Not in DOM
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time = " + new Date().toString());
		overrideGlobalTimeout(driver, shortTimeout);
		// lúc đầu implicitlyWait thiết lặp là 5s findElement
		List<WebElement> elements = getElements(driver, locator);
		// lúc sau implicitlyWait thiết lặp là 30s findElement
		overrideGlobalTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible on UI");
			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible on UI");
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... parameters) {
		return getElement(driver, getDynamicLocator(xpathLocator, parameters)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementSelectedd(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// action
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, xpathLocator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator, String... parameters) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(xpathLocator, parameters))).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... parameters) {
		action = new Actions(driver);
		locator = getDynamicLocator(locator, parameters);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	// javascript
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
	}

	public String getHiddenText(String cssLocator) {
		return (String) jsExecutor.executeScript("return document.querySelect(\"" + cssLocator + "\").value;");
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "')", getElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isJQueryAjaxJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Boolean) jsExecutor
							.executeScript("return window.jQuery != null && (jQuery.active === 0);"));
				} catch (Exception e) {
					return true;
				}
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public boolean isJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return window.jQuery != null && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... parameters) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, parameters))));
	}

	public void waitForElementAllVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... parameters) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, parameters))));
	}

	public void waitForElementAllInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... parameters) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, parameters))));
	}

//	public SearchPageObject openSearchPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.SEARCH_PAGE_FOOTER);
//		clickToElement(driver, BasePageUI.SEARCH_PAGE_FOOTER);
//		return PageGeneratorManager.getSearchPage(driver);
//	}
//
//	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
//		clickToElement(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
//		return PageGeneratorManager.getMyAccountPage(driver);
//	}
//
//	public OrderPageObject openOrderPage(WebDriver driver) {
//		waitForElementClickable(driver, BasePageUI.ORDER_PAGE_FOOTER);
//		clickToElement(driver, BasePageUI.ORDER_PAGE_FOOTER);
//		return PageGeneratorManager.getOrderPage(driver);
//	}

	// cách 1 Dynamic Locator and Rest Parameter
//	public BasePage getFooterPageByName(WebDriver driver, String pageName) {
//		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
//		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
//		if (pageName.equals("Search")) {
//			return PageGeneratorManager.getSearchPage(driver);
//		} else if (pageName.equals("My account")) {
//			return PageGeneratorManager.getMyAccountPage(driver);
//		} else if (pageName.equals("Orders")) {
//			return PageGeneratorManager.getOrderPage(driver);
//		} else {
//			return PageGeneratorManager.getHomePage(driver);
//		}
//	}

	// upload file
//	public void uploadMultipleFile(WebDriver driver, String... fileNames) {
//		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
//		String fullFileName = "";
//
//		for (String file : fileNames) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//
//		fullFileName = fullFileName.trim();
//
//		getElement(driver, HomePageUI.UPLOAD_FILE_BY_CARD_NAME).sendKeys(fullFileName);
//	}

	// sort A - Z
	public boolean isDataStringSortAscending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<String> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (String name : arrayList) {
			System.out.println(" ---Dữ liệu trên UI--- " + name);
		}
		System.out.println("---------------------------------");

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (String name : sortedList) {
//			System.out.print(" " + name);
		}

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	// sort Z - A
	public boolean isDataStringSortDescending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<String> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (String name : arrayList) {
			System.out.println(" ---Dữ liệu trên UI--- " + name);
		}
		System.out.println("---------------------------------");

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (String name : sortedList) {
//			System.out.print(" " + name);
		}

		// Thực hiện sort Z-A
		Collections.reverse(sortedList);

		// System.out.println("---Dữ liệu đã SORT DESC trong code---");
		for (String name : sortedList) {
//			System.out.print(" " + name);
		}

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	// sort số lớn -> nhỏ
	public boolean isDataFloatSortAscending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<Float> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (Float name : arrayList) {
			System.out.println(" ---Dữ liệu trên UI--- " + name);
		}
		System.out.println("---------------------------------");

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (Float name : sortedList) {
			System.out.println(" ---Dữ liệu đã SORT ASC trong code--- " + name);
		}
		System.out.println("---------------------------------");

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	// sort số nhỏ -> lớn
	public boolean isDataFloatSortDescending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<Float> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (Float name : arrayList) {
			System.out.println(" ---Dữ liệu trên UI--- " + name);
		}
		System.out.println("---------------------------------");

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (Float name : sortedList) {
//				System.out.print(" " + name);
		}

		// Thực hiện sort Z-A
		Collections.reverse(sortedList);

		// System.out.println("---Dữ liệu đã SORT DESC trong code---");
		for (Float name : sortedList) {
			System.out.println(" ---Dữ liệu đã SORT DESC trong code--- " + name);
		}
		System.out.println("---------------------------------");

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	// sort date mới -> cũ
	public boolean isDataDateSortAscending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<Date> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (Date name : arrayList) {
			// System.out.print(" " + name);
		}

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (Date name : sortedList) {
			// System.out.print(" " + name);
		}

		// Thực hiện sort Z-A
		Collections.reverse(sortedList);

		// System.out.println("---Dữ liệu đã SORT DESC trong code---");
		for (Date name : sortedList) {
			// System.out.print(" " + name);
		}

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	// sort date cũ -> mới
	public boolean isDataDateSortDescending(WebDriver driver, String xpathLocator) {
		// Khai báo 1 ArrayList
		ArrayList<Date> arrayList = new ArrayList<>();

		// Tìm tất cả element matching vs điều kiện (Name/Price/..)
		List<WebElement> elementList = getElements(driver, xpathLocator);

		// Lấy text của từng element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}

		// System.out.println("---Dữ liệu trên UI---");
		for (Date name : arrayList) {
//					System.out.print(" " + name);
		}

		// Copy qua 1 arrayList mới để SORT trong Code
		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}

		// Thực hiện SORT ASC
		Collections.sort(sortedList);

		// System.out.println("---Dữ liệu đã SORT ASC trong code---");
		for (Date name : sortedList) {
//					System.out.print(" " + name);
		}

		// Verify 2 array bằng nhau - nếu dữ kiệu sort trên UI ko chính xác thì kết quả
		// về sai
		return sortedList.equals(arrayList);
	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	// demo.guru99
	public void menuPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_MENU, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_MENU, pageName);
	}

	// techpanda
	public String getHTML5Message(WebDriver driver, String xpathLocator) {
		jsExecutor = (JavascriptExecutor) driver;
//		WebElement field = driver.findElement(By.xpath("//input[@id='email_address']"));
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getElement(driver, xpathLocator));
	}

	public String calculateGrandTotal(String firstPrice, String secondPrice) {
		firstPrice = firstPrice.replace("$", "");
		secondPrice = secondPrice.replace("$", "");
		BigDecimal newFirstPrice = new BigDecimal(firstPrice);
		BigDecimal newSecondPrice = new BigDecimal(secondPrice);
		double totalPrice = newFirstPrice.doubleValue() + newSecondPrice.doubleValue();
		return "$" + totalPrice;
	}

	// orangehrmlive
	/**
	 * Get column header
	 * 
	 * @param TestObject
	 * @return
	 */
//	public List<String> getColumnHeader(TestObject object){
//		List<String> result = [];
//		List<WebElement> lstElementHeaders = WebUiCommonHelper.findWebElements(object, 2);
//		for(int i = 0; i < lstElementHeaders.size(); i++) {
//			WebElement element = lstElementHeaders[i];
//			String strHeader = element.getText();
//			result.add(strHeader);
//		}
//		//		for(WebElement element in lstElementHeaders){
//		//			String strHeader = element.getText()
//		//			result.add(strHeader)
//		//		}
//		return result;
//	}

//	/**
//	 * Get All Data Table
//	 * 
//	 * @param lstColumnHeaders
//	 * @param totalRow
//	 * @return List
//	 */
//	public static List getAllDataTable(List<String> lstColumnHeaders, int totalRow){
//		List<Map> result = []
//		for(int i = 0; i < totalRow; i++){
//			Map<String, String> temp = [:]
//			TestObject rowObject = findTestObject('Object Repository/Test_Case_5/tbl_TotalCells', [('index') : i + 1]) //table[@id='resultTable']/tbody/tr[${index}]/td
//			List<WebElement> lstElementRows = WebUiCommonHelper.findWebElements(rowObject, 2)
//			//			for(int j = 0; j < lstElementRows.size(); j++){
//			//				WebElement element = lstElementRows[j]
//			//				String cell = element.getText()
//			//				temp.put(lstColumnHeaders[j], cell)
//			//			}
//			for(int j = 0; j < lstElementRows.size(); j++){
//				WebElement element = lstElementRows[j]
//				String cell = element.getText()
//				temp.put(lstColumnHeaders[j], cell)
//			}
//			result.add(temp)
//		}
//		return result
//	}
//	/**
//	 * Get column header by header name
//	 * @param TestObject
//	 * @param column header
//	 * @return
//	 */
//	public static int getColumnIndexByHeader(TestObject object, String header){
//		boolean flag = false
//		int index = 1
//		List<WebElement> lstElementHeaders = WebUiCommonHelper.findWebElements(object, 2)
//		for(WebElement element in lstElementHeaders){
//			String temp = element.getText()
//			if(temp.equalsIgnoreCase(header)){
//				flag = true
//				break
//			}
//			index = index + 1
//		}
//		if(!flag){
//			throw new Exception("Can not find column header: $header")
//		}
//		return index
//	}
//	/**
//	 * Get data column by index
//	 * @param object
//	 * @return
//	 */
//	public static List<String> getDataColumnByIndex(TestObject object){
//		List<String> result = []
//		List<WebElement> lstElementRows = WebUiCommonHelper.findWebElements(object, 2)
//		for(WebElement element in lstElementRows){
//			String row = element.getText()
//			result.add(row)
//		}
//		return result
//	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void findNameProduct(WebDriver driver, String xpathLocator, String name) {
		List<WebElement> courseName = getElements(driver, xpathLocator);
		for (WebElement course : courseName) {
			System.out.println(course.getText());
			Assert.assertTrue(course.getText().contains(name));
		}
	}

	public boolean findNameProducts(WebDriver driver, String xpathLocator) {
		List<WebElement> products = getElements(driver, xpathLocator);
		int numOfProducts = products.size();
		System.out.println(numOfProducts);
		if (numOfProducts <= 3) {
			return true;
		}
		return false;
	}

	private Alert alert;
	private Select select;
	private Actions action;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
