package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import java.time.Duration;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты главной страницы")
@Tag("mainPage-tests")
public class MainPageTests extends TestBase{

    MainPage mainPage = new MainPage();

    @Test
    @Tag("smoke")
    @Feature("Поиск")
    @Story("Главная страница")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Поиск товара с главной страницы")
    void searchFromMainPage() {

        step("Открытие главной страницы Майшоп", () -> {
            mainPage.openPage();
        });
        step("Ввод запроса в поисковую строку", () -> {
            mainPage.setSearchValue("книга");
        });
        step("Клик по кнопке 'Искать'", () -> {
            mainPage.clickSearchButton();
        });
        step("Проверка наличия запроса в хедере", () -> {
            mainPage.verifySearchResult("книга");
        });
    }

    @Test
    @Tag("smoke")
    @Feature("Поиск")
    @Story("Главная страница")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Добавление товара в корзину с главной страницы")
    void addToCartFromMainPage() {

        step("Открытие главной страницы Майшоп", () -> {
            mainPage.openPage();
        });
        step("Клик по кнопке 'В корзину'", () -> {
            mainPage.addToCard();
        });
        step("Проверка батарейки на карточке товара", () -> {
            mainPage.verifyAddToCardResult();
        });
    }

    @Test
    @Tag("smoke")
    @Feature("Поиск")
    @Story("Главная страница")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Смена адреса магазина на Санкт-Петербург")
    void changeDeliveryAddress() {

        step("Открытие главной страницы Майшоп", () -> {
            mainPage.openPage();
        });
        step("Открытие модалки выбора адреса", () -> {
            WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            mainPage.openAddressChoiceModal();
        });
        step("Выбор населенного пункта", () -> {
            mainPage.chooseDeliveryCity("г. Санкт-Петербург");
        });
        step("Проверка выбранного населенного пункта", () -> {
            mainPage.verifyChosenCity("г. Санкт-Петербург");
        });
    }
}
