package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends  BasePage {
    private final SelenideElement catalogLink = $x("//span[@class = 'b-main-navigation__text' and text() = 'Каталог']");

    public OnlinerCatalogPage clickOnCatalog() {
        catalogLink.click();
        return new OnlinerCatalogPage();
    }

}
