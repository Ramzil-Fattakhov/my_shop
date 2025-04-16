package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            searchInput = $("[placeholder='Поиск на Майшоп']"),
            headerSearch = $("#header-search-input"),
            searchHeaderWithCategory = $("div.head"),
            headerSearchButton = $("button"),
            productListWrapHeader = $("h1"),
            sliderRegularCard = $(".product-card"),
            deliveryBlock = $(".icon__block.delivery"),
            addressList = $(".autocomplete__list");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage setSearchValue(String value) {
        searchInput.setValue(value);
        return this;
    }

    public MainPage clickSearchButton() {
        headerSearchButton.shouldHave(text("Искать")).click();
        return this;
    }

    public MainPage verifySearchResult(String value) {
        productListWrapHeader.shouldHave(text(value));
        return this;
    }

    public MainPage addToCard() {
        sliderRegularCard.$("button").shouldHave(text("В корзину")).click();
        return this;
    }

    public MainPage verifyAddToCardResult() {
        sliderRegularCard.shouldHave(text("1"));
        return this;
    }

    public MainPage openAddressChoiceModal() {
        deliveryBlock.click();
        return this;
    }

    public MainPage chooseDeliveryCity(String value) {
        addressList.$(byText(value)).click();
        return this;
    }

    public MainPage verifyChosenCity(String value) {
        deliveryBlock.shouldHave(text(value));
        return this;
    }
}
