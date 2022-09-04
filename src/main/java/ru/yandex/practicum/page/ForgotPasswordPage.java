package ru.yandex.practicum.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    @Step("Нажатие на 'Войти'")
    public LoginPage signInClick(){
        $(byText("Войти")).click();
        return new LoginPage();
    }
}
