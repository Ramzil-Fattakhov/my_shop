package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductCardDetail {

    private SelenideElement
            favoriteButton = $(".form-control").$("[title='Добавить в избранное']"),
            favoriteTabButton = $(".badge.bg-Myshop-Purple"),
            addToCardButton = $(byText("В корзину")).parent(),
            addToCardTabButton = $(".tabs-button.orange"),
            questionFormButton = $("[to='#reviews']"),
            userNameInput = $("input#name"),
            questionTextInput = $("#inputTextarea"),
            sendQuestionButton = $(byText("Отправить")),
            modalDialogHeader = $(byText("Спасибо за вопрос!"));

    public ProductCardDetail openProductDetailPage() {
        open("https://my-shop.ru/shop/product/5048985.html");
        return this;
    }

    public ProductCardDetail pressFavoriteButton() {
        favoriteButton.click();
        return this;
    }

    public ProductCardDetail verifyAddToFavorite(String value) {
        favoriteTabButton.shouldHave(text(value));
        return this;
    }

    public ProductCardDetail addToCard() {
        addToCardButton.click();
        return this;
    }

    public ProductCardDetail verifyAddToCard(String value) {
        addToCardTabButton.shouldHave(text(value));
        return this;
    }

    public ProductCardDetail openQuestionForm() {
        questionFormButton.click();
        return this;
    }

    public ProductCardDetail setUserName(String name, String question) {
        userNameInput.setValue(name);
        questionTextInput.setValue(question);
        return this;
    }

    public ProductCardDetail sendQuestion() {
        sendQuestionButton.click();
        return this;
    }

    public ProductCardDetail verifyQuestionIsSend() {
        modalDialogHeader.shouldBe(visible);
        return this;
    }
}
