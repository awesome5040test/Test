package utils;


public class Properties {
    private static String browser = System.getProperty("browser");
    private static String baseUrl = System.getProperty("webdriver.base.url");
    private static int  pageLoadTimeOut = Integer.parseInt(System.getProperty("pageloadtimeout"));

    public static int getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

}
