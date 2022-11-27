import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.AllureListener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import selenide.DriverProvider;

@ExtendWith(AllureListener.class)
public class BaseTest {

    @BeforeAll
    public static void navigateToOnliner() {
        Configuration.browser = DriverProvider.class.getName();
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

}
