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

@DisplayName("Тесты каталога")
@Tag("categoriesPage-tests")
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
        step("Клик по категории 1 уровня 'Книги'", () -> {
            categoriesPage.clickCategory1stLevel();
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
        step("Наведение мыши на категорию 1 уровня", () -> {
            categoriesPage.hover1stLevelCategory();
        });

        step("Клик по категории 2 уровня", () -> {
            categoriesPage.click2ndLevelCategory();
        });
        step("Проверка открытия листинга категории 2 уровня", () -> {
            categoriesPage.verify2ndLevelCategoryTitle();
        });
    }
}
