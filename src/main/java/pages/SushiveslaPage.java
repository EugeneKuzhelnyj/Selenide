package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public class SushiveslaPage extends BasePage {

    private static final String SUSHIVESLA_URL = "https://catalog.onliner.by/sushivesla";
    private static final String SUSHI_TYPE_PATTERN = "//span[@class = 'schema-filter__checkbox-text' and text() = '%s']";

    public SushiveslaPage openSushivesla(){
        open(SUSHIVESLA_URL);
        return this;
    }

    public SushiveslaPage selectRolls(){
        executeJavaScript("arguments[0].click()",getWebDriver().findElement(By.xpath(format(SUSHI_TYPE_PATTERN,"роллы"))));
        return this;
    }

}
