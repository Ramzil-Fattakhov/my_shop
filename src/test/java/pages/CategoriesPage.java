package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;
import java.util.Random;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoriesPage {

    private SelenideElement
            categoriesTab = $(".header__menu"),
            categoryTitle = $("h1");

    private final Random random = new Random();
    ElementsCollection categories = $$(".md-left a");
    ElementsCollection categories2ndLevel = $$(".menu__sections a.menu__list__link.title");
    private String expectedCategoryName;
    private String expected2ndLevelCategoryName;

    private final Map<String, String> categoryTitles = Map.of(
            "Книги", "Книги",
            "Образование", "Учебники, учебная литература",
            "Канцтовары", "Канцтовары",
            "Книги на иностранных языках", "Литература на иностранных языках",
            "Игрушки", "Игры и игрушки",
            "Хобби", "Всё для хобби",
            "Сувениры", "Сувениры",
            "Видео, музыка, софт", "Видео, аудио и программное обеспечение"
    );

    public CategoriesPage openCategoriesTab() {
        categoriesTab.click();
        return this;
    }

    public CategoriesPage clickRandomCategory() {
        int index = random.nextInt(categories.size());
        SelenideElement chosen = categories.get(index);
        String menuCategoryName = chosen.getText().trim();
        this.expectedCategoryName = categoryTitles.get(menuCategoryName);
        chosen.click();
        return this;
    }

    public CategoriesPage verifyCategoryTitle() {
        if (expectedCategoryName == null || expectedCategoryName.isBlank()) {
            categoryTitle.shouldBe(empty);
        } else {
            categoryTitle.shouldHave(text(expectedCategoryName));
        }
        return this;
    }

    public CategoriesPage hoverRandom2ndLevelCategory() {
        int index = random.nextInt(categories.size());
        SelenideElement chosen = categories.get(index);
        chosen.hover();
        return this;
    }

    public CategoriesPage clickRandom2ndLevelCategory() {
        int index = random.nextInt(categories2ndLevel.size());
        SelenideElement chosen = categories2ndLevel.get(index);
        this.expected2ndLevelCategoryName = chosen.getText().trim();
        chosen.click();
        return this;
    }

    public CategoriesPage verify2ndLevelCategoryTitle() {
        if (expected2ndLevelCategoryName == null || expected2ndLevelCategoryName.isBlank()) {
            categoryTitle.shouldBe(empty);
        } else {
            categoryTitle.shouldHave(text(expected2ndLevelCategoryName));
        }
        return this;
    }
}
