package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement inputLogin = $(By.id("mat-input-0"));
    private final SelenideElement inputPassword = $(By.id("mat-input-1"));
    private final SelenideElement loginButton = $("#controls > button");
    private final SelenideElement menuProfile = $("span.mat-button-wrapper > mat-icon");
    private final SelenideElement profileButton = $("#mat-menu-panel-0 > div > button:nth-child(1)");

    @Step("Set Login")
    public void setLogin(String login) {
        inputLogin.should(Condition.enabled).setValue(login);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        inputPassword.should(Condition.enabled).setValue(password);
    }

    @Step("Click Login Button")
    public void clickLoginButton() {
        loginButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Click Profile Button")
    public void clickProfileButton () {
        menuProfile.should(Condition.appear).shouldBe(Condition.visible).click();
        profileButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }
}