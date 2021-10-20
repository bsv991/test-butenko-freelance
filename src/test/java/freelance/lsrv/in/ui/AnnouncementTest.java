package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.JobPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import static com.codeborne.selenide.Selenide.$;


public class AnnouncementTest extends BaseTest {
    @Test
    public void testAnnouncement() {
        openAppSelenide("login");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin("Username1");
        loginPage.setPassword("Password1");
        loginPage.clickLoginButton();
        MainPage mainPage = new MainPage();
        mainPage.findAndClickJob();
        Assert.assertTrue($("mat-card-subtitle:nth-child(1)").getText().contains("Posted by Sergey Butenko"), "Posted by Sergey Butenko");
        Assert.assertTrue($("div.mat-card-header-text > mat-card-title").getText().contains("Title200"), "Title200");
        Assert.assertTrue($("mat-card-subtitle.mat-card-subtitle.price").getText().contains("Price 2000"), "Price 2000");
        JobPage jobPage = new JobPage();
        jobPage.setComment("Comment Butenko");
        jobPage.clickCommentButton();
        Assert.assertTrue($("div > div.comments > div:nth-child(1) > mat-card > mat-card-content > p").getText().contains("Comment Butenko"), "Comment Butenko");
    }
}