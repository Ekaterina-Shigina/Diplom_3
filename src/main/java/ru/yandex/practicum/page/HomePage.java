package ru.yandex.practicum.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {


    @Step("Переход в личный кабинет")
    public LoginPage personalAccountClick(){
        $x("//p[text()='Личный Кабинет']").shouldBe(Condition.visible).click();
        return new LoginPage();
    }

    @Step("Нажатие 'Войти в аккаунт'")
    public LoginPage logInAccountClick(){
        $x("//button[text()='Войти в аккаунт']").click();
        return new LoginPage();
    }

    @Step("Нажатие на ссылку 'Булки'")
    public HomePage bunClick(){
        $x("//span[text()='Булки']").click();
        return this;
    }

    @Step("Нажатие на ссылку 'Соус'")
    public HomePage sauceClick(){
        $x("//span[text()='Соусы']").shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Нажатие на ссылку 'Начинки'")
    public HomePage ingredientClick(){
        $x("//span[text()='Начинки']").shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Получение текста 'Соберите бургер'")
    public SelenideElement visibleTextHomePage(){
        return  $x("//h1");
    }

    @Step("Получение текста бургеров и ингридиентов")
    public SelenideElement visibleTextBurgerOnPage(String nameIngredients){
        return  $(byText("contains(text(),'"+nameIngredients+"'"));
    }

    @Step("Получение класса бургеров и ингридиентов")
    public SelenideElement visibleCssClassBurgerOnPage(String nameIngredients){
        return  $x("//span[text()='"+nameIngredients+"']/parent::div");
    }
}
