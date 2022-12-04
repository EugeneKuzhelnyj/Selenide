package pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class AccessoriesPage extends  BasePage {
    private final ElementsCollection accessoriesName = $$x("//div[@class= 'catalog-navigation-list__aside-item " +
            "catalog-navigation-list__aside-item_active']//span[contains(@class,'dropdown-title')]");
    private final ElementsCollection accessoriesDescription = $$x("//div[@class= 'catalog-navigation-list__aside-item " +
            "catalog-navigation-list__aside-item_active']//span[contains(@class,'dropdown-description')]");

    public void areAllItemsContainNameTest() {
        String regularForName = "[a-zA-ZА-Яа-я]+.+";
        accessoriesName.filter(matchText(regularForName))
                .shouldHave(size(accessoriesName.size()), ofSeconds(15));
    }

    public void areAllItemsContainMinPriceAndCountOfGoodsTest() {
        String regularForPriceAndCount = "\\d*(,)?\\d*\\s*(товаров|товар)*\\s*(от)\\s*\\d*(,)?\\d*\\s*(р).";
        accessoriesDescription.filter(matchText(regularForPriceAndCount))
                .shouldHave(size(accessoriesDescription.size()),ofSeconds(15));
    }

}
