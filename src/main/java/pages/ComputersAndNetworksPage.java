package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ComputersAndNetworksPage extends  BasePage {
    private final SelenideElement accessoriesLink = $x("//div[@class = 'catalog-navigation-list__aside-title'" +
            " and text() = ' Комплектующие ']");
    private final ElementsCollection computerAndNetworksSections = $$x("//*[@data-id = '2']" +
            "//div[contains(@class,'aside-title')]");

    public AccessoriesPage clickOnAccessories() {
        accessoriesLink.click();
        return new AccessoriesPage();
    }

    public void isComputersAndNetworksSectionsExistAndDisplayed(List<String> sections){
        computerAndNetworksSections.filter(visible)
                .shouldBe(size(computerAndNetworksSections.size()),ofSeconds(15));
        computerAndNetworksSections.should(containExactTextsCaseSensitive(sections),ofSeconds(15));
    }

}
