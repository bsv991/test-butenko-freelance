package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class ProfileTest extends BaseTest {

    @Test
    public void testProfile() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        loginPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEditInfoButton();
        profilePage.setName();
        profilePage.setLastName();
        profilePage.clickUpdateButton();
        Assert.assertTrue($("mat-toolbar > h3").getText().contains("Sergey Butenko"), "Sergey Butenko");
    }

    @Test
    public void testAddImageProfile() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        loginPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickAddImageButton();
    }
}