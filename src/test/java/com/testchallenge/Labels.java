package com.testchallenge;

public class Labels extends Base {
    protected static final String APPIUM_PORT_NUMBER_DEFAULT = "4723";
    //////  APPIUM  android app capabilities//////
    public static final String ANDROID_CAPABILITIES_DEVICE_NAME = "ZY22284PGD";
    public static final String ANDROID_CAPABILITIES_PLATFORM_VERSION = "6.0.1";
    protected static final String APPIUM_PORT_NUMBER = System.getProperty("port", APPIUM_PORT_NUMBER_DEFAULT);
    public static final String ANDROID_CAPABILITIES_URL = "http://127.0.0.1:" + APPIUM_PORT_NUMBER + "/wd/hub";
    public static final String ANDROID_CAPABILITIES_APP_WAIT_ACTIVITY = "com.atimi.fugu.SplashActivity";
    public static final String ANDROID_CAPABILITIES_PACKAGE_NAME = "com.trello";
    public static final String APP_ACTIVITY = "com.trello.feature.home.HomeActivity";
    public static final String ANDROID_CAPABILITIES_BROWSER_NAME = "Android";
    public static final String ANDROID_CAPABILITIES_APP_PATH = "../app-release_signed.apk";
    public static final String DEVICE_TYPE_DEFAULT = "phone";
    public static final int DEFAULT_WAITING_TIME = 15;
    public static final int MIN_ATTEMPTS = 3;
    public static final int WAIT_TIME_DEFAULT = 5000;
    public static final int WAIT_TIME_MIN = 3000;


    public static final String WELCOME_LOGIN_BUTTON = "com.trello:id/log_in_button";
    public static final String WEB_WELCOME_LOGIN_BUTTON = "btn btn-sm btn-link text-white";
    public static final String WEB_WELCOME_USE_PASSWORD_BUTTON = "use-password";
    public static final String SIGNIN_USER = "com.trello:id/user";
    public static final String SIGNIN_WEB_USER = "user";
    public static final String SIGNIN_PASSWORD = "com.trello:id/password";
    public static final String SIGNIN_WEB_PASSWORD = "password";
    public static final String SIGNIN_LOGIN_BUTTON = "com.trello:id/authenticate";
    public static final String SIGNIN_WEB_LOGIN_BUTTON = "login";
    public static final String HOME_PAGE = "com.trello:id/organization_name_text_view";
    public static final String WEB_HOME_PAGE = "home-sticky-container";
    public static final String CARD_NAME = "test-card";
    public static final String EDIT_LABEL_NAME = "com.trello:id/icon";
    public static final String LABEL_NAME = "com.trello:id/label_container";

}
