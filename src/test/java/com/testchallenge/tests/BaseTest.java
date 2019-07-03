package com.testchallenge.tests;

import com.testchallenge.Base;
import com.testchallenge.pages.home.Home;
import com.testchallenge.signin.SignIn;
import com.testchallenge.pages.welcome.Welcome;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Base {
    public static Welcome WelcomePage;
    public static SignIn SignInPage;
    public static Home HomePage;

    @BeforeClass
    public static void setUp() throws Exception {
        Base.setUp();
    }
}
