package onliner_tests.ui;

import io.qameta.allure.Step;
import onliner_tests.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AccessoriesPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CheckAccessoriesSectionsTest extends BaseTest {
    private static MainPage mainPage;
    private static AccessoriesPage accessoriesPage;
    private static final String ONLINER_URL = "https://www.onliner.by/";

    @BeforeAll
    public static void classInit() {
        open(ONLINER_URL);
        mainPage = new MainPage();
        accessoriesPage = new AccessoriesPage();
    }

    @Step("Are All Items Contains Name And Min Price And Count Of Goods?")
    @Test
    public void areAllItemsContainANameAndMinPriceAndCountOfGoodsTest() {
        mainPage.clickOnCatalog().
                clickOnComputerAndNetworks().
                clickOnAccessories();
        accessoriesPage.areAllItemsContainNameTest();
        accessoriesPage.areAllItemsContainMinPriceAndCountOfGoodsTest();
    }

}
