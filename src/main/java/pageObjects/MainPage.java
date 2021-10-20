package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement getSubtitle = $$("mat-card-header > div > mat-card-subtitle").findBy(text("Posted by Sergey Butenko"));
    private final SelenideElement viewInfoButton = $(By.xpath("//mat-card[1]/mat-card-actions/button"));

    @Step("Find and Click Job")
    public void findAndClickJob() {
        getSubtitle.should(Condition.appear).shouldBe(Condition.visible);
        viewInfoButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }
}
