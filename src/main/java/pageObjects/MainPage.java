package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    private final SelenideElement getSubtitle = $$("mat-card-header > div > mat-card-subtitle").findBy(text("Posted by Sergey Butenko"));
    private final SelenideElement viewInfoButton = $(By.xpath("//mat-card[1]/mat-card-actions/button"));
    private static final SelenideElement subtitle = $("mat-card-subtitle:nth-child(1)");
    private static final SelenideElement title = $("div.mat-card-header-text > mat-card-title");
    private static final SelenideElement price = $("mat-card-subtitle.mat-card-subtitle.price");

    @Step("Find and Click Job")
    public void findAndClickJob() {
        getSubtitle.should(Condition.appear).shouldBe(Condition.visible);
        viewInfoButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Get subtitle")
    public static Boolean getSubtitle(String name) {
        return getText(subtitle).contains(name);
    }

    @Step("Get Title")
    public static Boolean getTitle(String name) {
        return getText(title).contains(name);
    }

    @Step("Get Price")
    public static Boolean getPrice(String name) {
        return getText(price).contains(name);
    }
}
