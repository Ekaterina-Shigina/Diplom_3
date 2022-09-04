package ru.yandex.practicum.page;

import io.qameta.allure.Step;
import ru.yandex.practicum.entity.User;


import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    @Step("Регистрация пользователя")
    public LoginPage registerUser(User user){
        input("Имя", user.getName());
        input("Email", user.getEmail());
        input("Пароль", user.getPassword());
        $(byText("Зарегистрироваться")).click();
        return new LoginPage();

    }

    @Step("Нажатие на 'Войти'")
    public LoginPage signInClick(){
        $(byText("Войти")).click();
        return new LoginPage();
    }

    @Step("Получить текст ошибки")
    public String getError(){
        return $(byClassName("input__error")).getText();
    }

    public void input(String nameInput, String parameters) {
        String inputName = String.format("//label[contains(.,'%s')]/following::input",nameInput);
        $x(inputName).setValue(parameters);

    }
}
