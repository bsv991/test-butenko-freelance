package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class DeleteJobTest extends BaseTest {
    @Test
    public void deleteJobTest() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        loginPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickAddJobButton();
        profilePage.setTitle("Title400");
        profilePage.setDescription("Description400");
        profilePage.setPrice("4000");
        profilePage.clickCreateJobButton();
        Assert.assertTrue(ProfilePage.getTitle("Title400"), "Title400");
        Assert.assertTrue(ProfilePage.getPrice("Price 4000"), "Price 4000");
        Assert.assertTrue($("mat-card:nth-child(3) > mat-card-subtitle > mat-card-subtitle:nth-child(1)").getText().contains("Comments: 0"), "Comments: 0");

        profilePage.clickRemoveJob();
    }
}