package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class CategoriesPage {

    private SelenideElement
            categoriesTab = $(".header__menu"),
            category1stLevelBooks = $(byText("Книги")),
            category1stLevelSupplies = $(byText("Канцтовары")),
            category2ndLevelCases = $("a[href*='/shop/catalogue/10508/sort/a/page/1.html']"),
            categoryTitle = $("h1");

    public CategoriesPage openCategoriesTab() {
        categoriesTab.click();
        sleep(500);
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

        category1stLevelSupplies
                .shouldBe(visible)
                .shouldBe(interactable);

        int elementWidth = category1stLevelSupplies.getSize().getWidth();
        int xOffset = elementWidth / 2;

        new Actions(getWebDriver())
                .moveToElement(category1stLevelSupplies)
                .pause(300)
                .moveByOffset(xOffset, 0)
                .pause(300)
                .perform();
        return this;
    }

    public CategoriesPage click2ndLevelCategory() {
        category2ndLevelCases.shouldBe(interactable).click();
        return this;
    }

    public CategoriesPage verify2ndLevelCategoryTitle() {
        categoryTitle.shouldHave(text("Пенал"));
        return this;
    }
}
