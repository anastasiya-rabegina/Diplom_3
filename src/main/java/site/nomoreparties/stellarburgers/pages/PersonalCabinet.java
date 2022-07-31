package site.nomoreparties.stellarburgers.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PersonalCabinet extends Header {

    //локаторя для поля ввода Имя
    @FindBy(how = How.XPATH, using = "//input[@class='text input__textfield text_type_main-default input__textfield-disabled']")
    private ElementsCollection inputFields;

    //локаторя для кнопки Выход
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement btnLogOut;

    //локаторя для текста с описанием
    @FindBy(how = How.XPATH, using = "//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    private SelenideElement textYouCanEditData;

    @Step("Get name of logged in user")
    public String checkUserName() {
        return inputFields.get(0).getValue();
    }

    @Step("Clock on Logout button to go to Login Page")
    public LoginPage clickLogOut() {
        btnLogOut.click();
        return page(LoginPage.class);
    }

    @Step("Check if Personal Cabinet page is displayed")
    public boolean isPersonalCabinetDisplayed() {
        textYouCanEditData.shouldBe(Condition.visible);
        return textYouCanEditData.isDisplayed();
    }
}