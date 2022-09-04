package ru.yandex.prakticum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.entity.User;
import ru.yandex.practicum.page.HomePage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.handlers.GetProperties.getProperties;


public class LoginUserTest extends BaseTest{

    User user = new User(null, getProperties("email"), getProperties("password"));
    final String urlBurger = "https://stellarburgers.nomoreparties.site/";

    @Test
    @DisplayName("Вход в систему через 'Войти в аккаунт'")
    public void signInUserTest(){
        HomePage homePage = new HomePage();
        homePage.logInAccountClick()
                .authorizedUser(user);

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));


    }

    @Test
    @DisplayName("Вход в систему через 'Личный кабинет'")
    public void signInAccountUserTest(){
        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .authorizedUser(user);

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));

    }

    @Test
    @DisplayName("Вход в систему по ссылке через форму регистрации")
    public void signInRegistredUserTest(){
        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .registerClick()
                .signInClick()
                .authorizedUser(user);

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));

    }

    @Test
    @DisplayName("Вход в систему по ссылке через форму регистрации")
    public void signInForgotUserTest(){
        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .forgotPasswordClick()
                .signInClick()
                .authorizedUser(user);

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));

    }
}
