package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobPage extends BasePage {
    private final SelenideElement inputComment = $(By.id("mat-input-2"));
    private final SelenideElement leaveCommentButton = $$("button > span.mat-button-wrapper").findBy(text(" Leave comment "));
    private final SelenideElement closeJobButton = $$("button > span.mat-button-wrapper").findBy(text(" Close job details "));
    private static final SelenideElement contentComments = $("div > div.comments > div:nth-child(1) > mat-card > mat-card-content > p");

    @Step("Set Comment")
    public void setComment(String comment) {
        inputComment.should(Condition.appear).shouldBe(Condition.visible).setValue(comment);
    }

    @Step("Click Comment Button")
    public void clickCommentButton() {
        leaveCommentButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Close Job Button")
    public void clickCloseJob() {
        closeJobButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Get Content")
    public static Boolean getContent(String name) {
        return getText(contentComments).contains(name);
    }
}