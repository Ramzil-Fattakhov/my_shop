package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProductCardDetail;

import static io.qameta.allure.Allure.step;

public class ProductCardDetailTests extends BaseTest{

    ProductCardDetail productCardDetail = new ProductCardDetail();

    @Test
    @Tag("regression")
    @Feature("Избранное")
    @Story("Детальная страница товара")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Добавление товара в избранное")
    void pressFavoriteButton() {

        step("Открываем деталку товара", () -> {
            productCardDetail.openProductDetailPage();
        });

        step("Клик/добавить товар в избранное", () -> {
            productCardDetail.pressFavoriteButton();
        });
        step("Проверка появления численного лейбла на кнопке избранного в хэдере", () -> {
            productCardDetail.verifyAddToFavorite("1");
        });
    }

    @Test
    @Tag("regression")
    @Feature("Добавление в корзину")
    @Story("Детальная страница товара")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Добавление товара в корзину")
    void addToCard() {

        step("Открываем деталку товара", () -> {
            productCardDetail.openProductDetailPage();
        });

        step("Добавить товар в корзину", () -> {
            productCardDetail.addToCard();
        });
        step("Проверка появления численного лейбла на кнопке корзины в хэдере", () -> {
            productCardDetail.verifyAddToCard("1");
        });
    }

    @Test
    @Tag("regression")
    @Feature("Оставление вопроса")
    @Story("Детальная страница товара")
    @Owner("Fattakhov Ramzil")
    @DisplayName("Отправка вопроса через форму")
    void askQuestion() {

        step("Открываем деталку товара", () -> {
            productCardDetail.openProductDetailPage();
        });

        step("Открытие формы 'Задать вопрос'", () -> {
            productCardDetail.openQuestionForm();
        });

        step("Заполнение формы", () -> {
            productCardDetail.setUserName("Иван", "Есть ли в наличии в твердом переплете?");
        });

        step("Клик по кнопке 'Отправить'", () -> {
            productCardDetail.sendQuestion();
        });

        step("Проверка появления модалки с текстом 'Спасибо за вопрос!'", () -> {
            productCardDetail.verifyQuestionIsSend();
        });
    }
}
