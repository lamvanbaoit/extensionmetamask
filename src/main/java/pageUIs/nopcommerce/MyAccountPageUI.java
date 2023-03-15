package pageUIs.nopcommerce;

public class MyAccountPageUI {
	// Customer info
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String GENDER_FEMALE_RADIO = "//input[@id='gender-female']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";

	// Addresses
	public static final String ADDRESS_ADD_NEW_BUTTON = "//div[@class='add-button']//button";
	public static final String ADDRESS_FIRSTNAME_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String ADDRESS_LASTNAME_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String ADDRESS_EMAIL_TEXTBOX = "//input[@id='Address_Email']";
	public static final String ADDRESS_COMPANY_TEXTBOX = "//input[@id='Address_Company']";
	public static final String ADDRESS_COUNTRY_TEXTBOX = "//select[@id='Address_CountryId']";
	public static final String ADDRESS_STATE_TEXTBOX = "//select[@id='Address_StateProvinceId']";
	public static final String ADDRESS_CITY_TEXTBOX = "//input[@id='Address_City']";
	public static final String ADDRESS_ADDRESS_1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ADDRESS_ADDRESS_2_TEXTBOX = "//input[@id='Address_Address2']";
	public static final String ADDRESS_ZIP_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String ADDRESS_PHONE_NUMBER_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	public static final String ADDRESS_FAX_NUMBER_TEXTBOX = "//input[@id='Address_FaxNumber']";
	public static final String ADDRESS_SAVE_BUTTON = "//div[@class='buttons']//button";
	public static final String EMAIL_MESSAGE = "//li[@class='email']";
	public static final String PHONE_NUMBER_MESSAGE = "//li[@class='phone']";
	public static final String PAX_NUMBER_MESSAGE = "//li[@class='fax']";
	public static final String COMPANY_MESSAGE = "//li[@class='company']";
	public static final String ADDRESS_1_MESSAGE = "//li[@class='address1']";
	public static final String ADDRESS_2_MESSAGE = "//li[@class='address2']";
	public static final String CITY_STATE_ZIP_MESSAGE = "//li[@class='city-state-zip']";
	public static final String COUNTRY_MESSAGE = "//li[@class='country']";

	// Change Password
	public static final String OLD_PASSWORD_TEXTBOX = "//input[@id='OldPassword']";
	public static final String NEW_PASSWORD_TEXTBOX = "//input[@id='NewPassword']";
	public static final String CONIFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	public static final String CHANGE_PASSWORD_BUTTON = "//button[@class='button-1 change-password-button']";

	// My Product Reviews
	public static final String ADD_TO_CART = "//a[text()='%s']//ancestor::div[@class='details']//div[@class='add-info']//div[@class='buttons']//button[text()='Add to cart']";
	public static final String ADD_YOUR_REVIEW_LINK = "//div[@class='product-review-links']//a[text()='Add your review']";
	public static final String REVIEW_TITTLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTAREA = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String SUBMIT_REVIEW = "//button[@name='add-review']";
	public static final String CLOSE_ICON = "//span[@title='Close']";
}
