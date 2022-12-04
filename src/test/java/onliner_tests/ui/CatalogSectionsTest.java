package onliner_tests.ui;

import io.qameta.allure.Step;
import onliner_tests.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnlinerCatalogPage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class CatalogSectionsTest extends BaseTest {
    private final List<String> sections = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");
    private static MainPage mainPage;
    private static OnlinerCatalogPage onlinerCatalogPage;
    private static final String ONLINER_URL = "https://www.onliner.by/";

    @BeforeAll
    public static void initPage() {
        open(ONLINER_URL);
        mainPage = new MainPage();
        onlinerCatalogPage = new OnlinerCatalogPage();
    }

    @Step("Are All Catalog Sections Exist And Displayed?")
    @Test
    public void isAllCatalogSectionsExistAndDisplayedTest() {
        mainPage.clickOnCatalog();
        onlinerCatalogPage.isAllCatalogSectionsExistAndDisplayed(sections);
    }

}
