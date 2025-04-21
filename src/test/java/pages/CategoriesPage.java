package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Map;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoriesPage {

    private SelenideElement
            categoriesTab = $(".header__menu"),
            categoryTitle = $("h1"),
            a = $("a");

    private final Random random = new Random();
    ElementsCollection categories = $$(".md-left a");
    private String expectedCategoryName;

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
        String menuCategoryName = chosen.getText();
        this.expectedCategoryName = categoryTitles.get(menuCategoryName);
        chosen.click();
        return this;
    }

    public CategoriesPage verifyCategoryTitle() {
        categoryTitle.shouldHave(text(expectedCategoryName));
        return this;
    }
}
