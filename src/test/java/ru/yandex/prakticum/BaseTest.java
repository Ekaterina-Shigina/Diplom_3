package ru.yandex.prakticum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import ru.yandex.practicum.page.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    static String urlBurger = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void openHome(){
        Configuration.browserSize = "1920x1080";
        //Configuration.browser = "firefox"; оставила, если захочется проверить еще в одном браузере
        open(urlBurger);
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
