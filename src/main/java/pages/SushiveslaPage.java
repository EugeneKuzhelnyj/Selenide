package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SushiveslaPage extends BasePage {

    private static final String SUSHIVESLA_URL = "https://catalog.onliner.by/sushivesla";
    private final SelenideElement rolls = $x("//span[@class = 'schema-filter__checkbox-text' and text() = 'роллы']");


    public SushiveslaPage openSushivesla(){
        open(SUSHIVESLA_URL);
        return this;
    }

    public SushiveslaPage selectRolls(){
        executeJavaScript("arguments[0].click()",rolls);
        return this;
    }


}
