package ru.yandex.practicum.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.yandex.practicum.entity.User;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public RegisterPage registerClick(){
        $(byText("Зарегистрироваться")).click();
        return new RegisterPage();
    }

    @Step("Нажатие на 'Конструктор'")
    public HomePage constructorClick(){
        $(byText("Конструктор")).click();
        return new HomePage();
    }

    @Step("Нажатие на логотип")
    public HomePage logoClick(){
        $(byClassName("AppHeader_header__logo__2D0X2")).click();
        return new HomePage();
    }

    @Step("Получить надпись 'Вход'")
    public SelenideElement getSignInText(){
        return $x("//h2");
    }

    @Step("Получить кнопку 'Войти'")
    public SelenideElement getSignInButton(){
        return $(byText("Войти"));
    }


    @Step("Авторизация пользователя")
    public HomePage authorizedUser(User user){
        input("Email").setValue(user.getEmail());
        input("Пароль").setValue(user.getPassword());
        getSignInButton().click();
        return new HomePage();
    }

    @Step("Нажатие на 'Восстановить пароль'")
    public ForgotPasswordPage forgotPasswordClick(){
        $(byText("Восстановить пароль")).click();
        return new ForgotPasswordPage();
    }

    @Step("Нажатие на 'Выход'")
    public LoginPage logOutClick(){
        $(byText("Выход")).click();
        return this;
    }

    public SelenideElement input(String nameInput) {
        String inputName = String.format("//label[contains(.,'%s')]/following::input",nameInput);
        return $x(inputName);

    }


}
