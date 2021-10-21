package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void testMoveToRegister() {
        openAppSelenide("home");
        HomePage homePage = new HomePage();
        homePage.clickRegister();
        Assert.assertTrue(HomePage.getToolbarName("Register"), "Register");
    }

    @Test
    public void testMoveToLogin() {
        openAppSelenide("home");
        HomePage homePage = new HomePage();
        homePage.clickLogin();
        Assert.assertTrue(HomePage.getToolbarName("Login"), "Login");
    }
}