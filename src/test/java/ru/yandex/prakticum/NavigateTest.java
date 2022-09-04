package ru.yandex.prakticum;

import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.entity.User;
import ru.yandex.practicum.page.HomePage;
import ru.yandex.practicum.page.LoginPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.handlers.GetProperties.getProperties;

public class NavigateTest extends BaseTest {

    User user = new User(null, getProperties("email"), getProperties("password"));
    final String urlBurger = "https://stellarburgers.nomoreparties.site/";

    @Test
    @DisplayName("Переход по клику 'Личный кабинет'")
    public void navigatePersonalAccountTest(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.personalAccountClick();

        loginPage.input("Email").shouldBe(Condition.visible);
        loginPage.input("Пароль").shouldBe(Condition.visible);
        loginPage.getSignInButton().shouldBe(Condition.visible);

        assertEquals(loginPage.getSignInText().getText(), "Вход");

    }

    @Test
    @DisplayName("Переход из личного кабинета по клику  на 'Конструктор'")
    public void navigateConstructorTest(){

        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .constructorClick();

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));

    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип")
    public void navigateLogoTest(){
        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .logoClick();

        assertEquals(homePage.visibleTextHomePage().getText(), "Соберите бургер");
        webdriver().shouldHave(url(urlBurger));

    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void navigateLogOutTest(){

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.personalAccountClick()
                .registerClick()
                .signInClick()
                .authorizedUser(user)
                .personalAccountClick()
                .logOutClick();

        loginPage.input("Email").shouldBe(Condition.visible);
        loginPage.input("Пароль").shouldBe(Condition.visible);
        loginPage.getSignInButton().shouldBe(Condition.visible);

        assertEquals(loginPage.getSignInText().getText(), "Вход");

    }
}
