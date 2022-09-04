package ru.yandex.prakticum;


import com.codeborne.selenide.Condition;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.page.HomePage;

import static com.codeborne.selenide.Configuration.timeout;

public class ConstructorTest extends BaseTest{

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void getBunTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.sauceClick();
        Thread.sleep(2000);
        homePage.bunClick();

        homePage.visibleTextBurgerOnPage("Мясо").shouldNotBe(Condition.visible);
        homePage.visibleCssClassBurgerOnPage("Булки").shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));

        //tab_tab_type_current__2BEPc появляется только, если на пункт меню был клик

    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void getSauceTest(){
        HomePage homePage = new HomePage();
        homePage.sauceClick();
        homePage.visibleTextBurgerOnPage("булка").shouldNotBe(Condition.visible);
        homePage.visibleCssClassBurgerOnPage("Соусы").shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));

    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void getIngredientTest(){
        HomePage homePage = new HomePage();
        homePage.ingredientClick();

        homePage.visibleTextBurgerOnPage("соус").shouldNotBe(Condition.visible);
        homePage.visibleCssClassBurgerOnPage("Начинки").shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));

    }
}
