package freelance.lsrv.in;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://freelance.lsrv.in.ua/";
        Configuration.downloadsFolder = Paths.get("target").toFile().getAbsolutePath();
        Configuration.startMaximized = true;
    }

    public void openAppSelenide(String url) {
        open(url);
    }
}