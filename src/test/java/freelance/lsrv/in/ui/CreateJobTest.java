package freelance.lsrv.in.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class CreateJobTest extends HomeTest {

    @Test
    public void testJobCreate() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        loginPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickAddJobButton();
        profilePage.setTitle("Title200");
        profilePage.setDescription("Description200");
        profilePage.setPrice("2000");
        profilePage.clickCreateJobButton();
        Assert.assertTrue($("div > mat-card-title").getText().contains("Title200"), "Title200");
        Assert.assertTrue($("mat-card-subtitle.price").getText().contains("Price 2000"), "Price 2000");
    }
}