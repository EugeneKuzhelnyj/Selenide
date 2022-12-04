package onliner_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import selenide.DriverProvider;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureListener.class)
public class BaseTest {

    @BeforeAll
    public static void navigateToOnliner() {
        Configuration.browser = DriverProvider.class.getName();
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

}
