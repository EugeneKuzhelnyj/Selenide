package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class OnlinerCatalogPage extends  BasePage {

    private final ElementsCollection sectionCollection = $$x("//span[@class = 'catalog-navigation-classifier__item-title-wrapper']");
    private final SelenideElement computerAndNetworks = $x("//li[@class = 'catalog-navigation-classifier__item ' and @data-id ='2']");

    public void isAllCatalogSectionsExistAndDisplayed(List<String> sections){
        sectionCollection.filter(visible).shouldBe(size(sectionCollection.size()),ofSeconds(15));
        sectionCollection.shouldHave(containExactTextsCaseSensitive(sections),ofSeconds(15));
    }

    public ComputersAndNetworksPage clickOnComputerAndNetworks() {
        computerAndNetworks.click();
        return new ComputersAndNetworksPage();
    }

}
