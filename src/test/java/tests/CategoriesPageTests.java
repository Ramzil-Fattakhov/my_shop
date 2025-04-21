package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.CategoriesPage;

import static io.qameta.allure.Allure.step;

public class CategoriesPageTests extends TestBase{

    MainPage mainPage = new MainPage();
    CategoriesPage categoriesPage = new CategoriesPage();

    @Test
    @Tag("smoke")
    @Feature("Каталог")
    @Story("Главная страница")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Открытие каталога товаров и переход в категорию 1 уровня")
    void openRandomCategories() {
        step("Открытие главной страницы Майшоп", () -> {
            mainPage.openPage();
        });

        step("Открытие каталога товаров", () -> {
            categoriesPage.openCategoriesTab();
        });

        step("Клик по случайной категории", () -> {
            categoriesPage.clickRandomCategory();
        });

        step("Проверка открытия листинга категории 1 уровня", () -> {
            categoriesPage.verifyCategoryTitle();
        });
    }

    @Test
    @Tag("smoke")
    @Feature("Каталог")
    @Story("Главная страница")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Открытие каталога товаров и переход в категорию 2 уровня")
    void openRandomCategories2ndLevel() {
        step("Открытие главной страницы Майшоп", () -> {
            mainPage.openPage();
        });

        step("Открытие каталога товаров", () -> {
            categoriesPage.openCategoriesTab();
        });

        step("Наведение мыши на случайную категорию 2 уровня", () -> {
            categoriesPage.hoverRandom2ndLevelCategory();
        });

        step("Клик по случайной категории 2 уровня", () -> {
            categoriesPage.clickRandom2ndLevelCategory();
        });


        step("Проверка открытия листинга категории 2 уровня", () -> {
            categoriesPage.verify2ndLevelCategoryTitle();
        });
    }
}
