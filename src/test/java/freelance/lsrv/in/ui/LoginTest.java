package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        Assert.assertTrue($("mat-toolbar > h3").getText().contains("Name1 Last Name1"), "Name1 LastName1");
    }
}