package ru.yandex.prakticum;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.entity.User;
import ru.yandex.practicum.helpers.ApiClient;
import ru.yandex.practicum.page.HomePage;
import ru.yandex.practicum.page.LoginPage;
import ru.yandex.practicum.page.RegisterPage;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RegisterUserTest extends BaseTest {

    Faker faker = new Faker();
    static Random random = new Random();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.name().firstName() + random.nextInt(100);

    User user = new User(name, email, password);

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registerValidUserTest(){

        //тест
       HomePage homePage = new HomePage();
       LoginPage loginPage = homePage.personalAccountClick()
               .registerClick()
               .registerUser(user);

        //проверка
       loginPage.input("Email").shouldBe(Condition.visible);
       loginPage.input("Пароль").shouldBe(Condition.visible);


       //очистка данных
        ApiClient client = new ApiClient();
        String accessToken = client.loginUser(user)
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");

        client .deleteUser(accessToken)
                .then()
                .statusCode(202);

    }

    @Test
    @DisplayName("Создание пользователя c паролем менее 6 цифр")
    public void registerUnValidUserTest(){
        user.setPassword("12345");
        HomePage homePage = new HomePage();
        homePage.personalAccountClick()
                .registerClick()
                .registerUser(user);
        RegisterPage registerPage = new RegisterPage();

        assertEquals(registerPage.getError(), "Некорректный пароль");


    }

}
