package com.testchallenge.pages.constructors;

import com.testchallenge.pages.BasePage;
import com.testchallenge.pages.home.Home;
import com.testchallenge.signin.SignIn;
import com.testchallenge.pages.welcome.Welcome;
import com.testchallenge.tests.BaseTest;

public class PageConstructor {
    public static void initializePageObject(String page) throws Exception {

        if ("Home".equals(page)) {
            BasePage.HomePage = new Home();
            BaseTest.HomePage = new Home();
        } else if ("SignIn".equals(page)) {
            BasePage.SignInPage = new SignIn();
            BaseTest.SignInPage = new SignIn();
        } else if ("Welcome".equals(page)) {
            BasePage.WelcomePage = new Welcome();
            BaseTest.WelcomePage = new Welcome();
        } else {
            System.out.println(page + "screen not found or defined");
        }
    }

}
