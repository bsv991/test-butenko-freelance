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
        Assert.assertTrue(MainPage.getSubtitle("Posted by Sergey Butenko"), "Posted by Sergey Butenko");
        Assert.assertTrue(MainPage.getTitle("Title200"), "Title200");
        Assert.assertTrue(MainPage.getPrice("Price 2000"), "Price 2000");
        JobPage jobPage = new JobPage();
        jobPage.setComment("Comment Butenko");
        jobPage.clickCommentButton();
        Assert.assertTrue(JobPage.getContent("Comment Butenko"), "Comment Butenko");
    }
}