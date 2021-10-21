package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage {
    private final SelenideElement editInfoButton = $$("span.mat-button-wrapper").findBy(text("Edit Info"));
    private final SelenideElement updateButton = $$("span.mat-button-wrapper").findBy(text(" Update "));
    private final SelenideElement addJobButton = $$("span.mat-button-wrapper").findBy(text("Add job"));
    private final SelenideElement createJobButton = $$("span.mat-button-wrapper").findBy(text(" Create job "));
    private final SelenideElement deleteJobButton = $$("span.mat-button-wrapper").findBy(text("delete"));
    private final SelenideElement addImageButton = $$("span.mat-button-wrapper").findBy(text("Pick File"));
    private final SelenideElement uploadImageButton = $("div:nth-child(1) > input[type=file]");
    private final SelenideElement inputName = $(By.xpath("//*[@id=\"mat-input-2\"]"));
    private final SelenideElement inputLastName = $(By.xpath("//*[@id=\"mat-input-3\"]"));
    private final SelenideElement inputTitle = $(By.id("mat-input-2"));
    private final SelenideElement inputDescription = $(By.id("mat-input-3"));
    private final SelenideElement inputPrice = $(By.id("mat-input-4"));
    private static final SelenideElement toolbar = $("mat-toolbar > h3");
    private static final SelenideElement title = $("div > mat-card-title");
    private static final SelenideElement price = $("mat-card-subtitle.price");

    @Step("Click Edit Info Button")
    public void clickEditInfoButton() {
        editInfoButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Set Name")
    public void setName() {
       inputName.should(Condition.enabled).clear();
       inputName.should(Condition.enabled).setValue("Sergey");
    }

    @Step("Set Last Name")
    public void setLastName() {
        inputLastName.should(Condition.enabled).clear();
        inputLastName.should(Condition.enabled).setValue("Butenko");
    }

    @Step("Click Update Button")
    public void clickUpdateButton() {
        updateButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Click Add Job Button")
    public void clickAddJobButton() {
        addJobButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }
    @Step("Click Add Image Button")
    public void clickAddImageButton() {
        addImageButton.should(Condition.appear).shouldBe(Condition.visible).uploadFile(new File("src/test/resources/image.png"));
        uploadImageButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Set Title")
    public void setTitle(String title) {
        inputTitle.should(Condition.enabled).clear();
        inputTitle.should(Condition.enabled).setValue(title);
    }

    @Step("Set Description")
    public void setDescription(String description) {
        inputDescription.should(Condition.enabled).clear();
        inputDescription.should(Condition.enabled).setValue(description);
    }

    @Step("Set Price")
    public void setPrice(String price) {
        inputPrice.should(Condition.enabled).clear();
        inputPrice.should(Condition.enabled).setValue(price);
    }

    @Step("Click Create Job Button")
    public void clickCreateJobButton() {
        createJobButton.should(Condition.appear).shouldBe(Condition.visible).click();
    }

    @Step("Click Remove Job Button")
    public void clickRemoveJob() {
        deleteJobButton.should(Condition.appear).shouldBe(Condition.visible).click();
        Selenide.confirm();
    }

    @Step("Get toolbarName")
    public static Boolean getToolbarName(String name) {
        return getText(toolbar).contains(name);
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