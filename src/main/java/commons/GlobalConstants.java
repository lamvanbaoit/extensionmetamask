package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_APP_URL = "https://demo.nopcommerce.com/";
	public static final String TESTING_APP_URL = "https://demo.nopcommerce.com/";
	public static final String STAGING_APP_URL = "https://demo.nopcommerce.com/";

	public static final long SHORT_TIMEOUT = 10;
	public static final long LONG_TIMEOUT = 30;

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String OS_NAME = System.getProperty("os.name");

	public static final String DEV_DB_URL = "";
	public static final String DEV_DB_USER = "";
	public static final String DEV_DB_PASS = "";

	public static final String TEST_DB_URL = "";
	public static final String TEST_DB_USER = "";
	public static final String TEST_DB_PASS = "";
	public static final String JAVA_VERSION = System.getProperty("java.version");;
}

// cách hoạt động của nó
// nó có cấu trúc gì 
// nó làm việc như thế nào
// các tầng liên kế với nhau ra sao