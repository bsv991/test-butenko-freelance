package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private final SelenideElement registerLink = $(By.linkText("Create account"));
    private final SelenideElement loginLink = $(By.linkText("Log in"));
    private static final SelenideElement toolbar = $("div > h2");

    @Step("Click Register")
    public void clickRegister() {
        registerLink.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Click Login")
    public void clickLogin() {
        loginLink.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Get toolbarName")
    public static Boolean getToolbarName(String name) {
        return getText(toolbar).contains(name);
    }
}