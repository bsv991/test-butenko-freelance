package freelance.lsrv.in;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://freelance.lsrv.in.ua/";
        Configuration.downloadsFolder = Paths.get("target").toFile().getAbsolutePath();
        Configuration.reportsFolder = Paths.get("target").toFile().getAbsolutePath();
        Configuration.startMaximized = true;
    }

    public void openAppSelenide(String url) {
        open(url);
    }
}