package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesPage {

    private SelenideElement
            categoriesTab = $(".header__menu"),
            category1stLevelBooks = $(byText("Книги")),
            category1stLevelSupplies = $(byText("Канцтовары")),
            category2ndLevelCases = $("a[href*='/shop/catalogue/10508/sort/a/page/1.html']"),
            categoryTitle = $("h1");

    public CategoriesPage openCategoriesTab() {
        categoriesTab.click();
        return this;
    }

    public CategoriesPage clickCategory1stLevel() {
        category1stLevelBooks.click();
        return this;
    }

    public CategoriesPage verifyCategoryTitle() {
        categoryTitle.shouldHave(text("Книги"));
        return this;
    }

    public CategoriesPage hover1stLevelCategory() {
        category1stLevelSupplies.hover();
        return this;
    }

    public CategoriesPage click2ndLevelCategory() {
        category2ndLevelCases.click();
        return this;
    }

    public CategoriesPage verify2ndLevelCategoryTitle() {
        categoryTitle.shouldHave(text("Пенал"));
        return this;
    }
}
