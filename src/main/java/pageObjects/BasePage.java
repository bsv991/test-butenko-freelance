package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class BasePage {

    @Step("Get text")
    protected static String getText(SelenideElement element) {
        return element.getText();
    }
}