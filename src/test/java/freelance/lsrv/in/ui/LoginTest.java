package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.getToolbarName("Sergey Butenko"), "Sergey Butenko");
    }
}