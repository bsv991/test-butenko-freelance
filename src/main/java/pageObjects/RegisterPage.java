package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {
    private final SelenideElement inputUsername = $(By.id("mat-input-0"));
    private final SelenideElement inputName = $(By.id("mat-input-1"));
    private final SelenideElement inputLastName = $(By.id("mat-input-2"));
    private final SelenideElement inputPassword = $(By.id("mat-input-3"));
    private final SelenideElement inputConfirmPassword = $(By.id("mat-input-4"));
    private final SelenideElement registerButton = $("#controls > button");

    @Step("Set Username")
    public void setUsername(String username) {
        inputUsername.should(Condition.enabled).setValue(username);
    }

    @Step("Set Name")
    public void setName(String name) {
        inputName.should(Condition.enabled).setValue(name);
    }

    @Step("Set Lastname")
    public void setLastName(String lastName) {
        inputLastName.should(Condition.enabled).setValue(lastName);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        inputPassword.should(Condition.enabled).setValue(password);
    }

    @Step("Set Confirm Password")
    public void setConfirmPassword(String confirmPassword) {
        inputConfirmPassword.should(Condition.enabled).setValue(confirmPassword);
    }

    @Step("Click Register Button")
    public void clickRegisterButton() {
        registerButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }
}