package onliner_tests.ui;

import io.qameta.allure.Step;
import onliner_tests.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ComputersAndNetworksPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class ComputerAndMobilePhoneSectionsTest extends BaseTest {

    List<String> sections = Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static MainPage mainPage;
    private static ComputersAndNetworksPage computersAndNetworksPage;
    private static final String ONLINER_URL = "https://www.onliner.by/";

    @BeforeAll
    public static void initPage(){
        open(ONLINER_URL);
        mainPage = new MainPage();
        computersAndNetworksPage = new ComputersAndNetworksPage();
    }

    @Step("Are Computer And Networks Sections Exist And Displayed?")
    @Test
    public void isComputerAndNetworksSectionsExistAndDisplayedTest() {
        mainPage.clickOnCatalog()
                .clickOnComputerAndNetworks();
        computersAndNetworksPage.isComputersAndNetworksSectionsExistAndDisplayed(sections);
    }

}
