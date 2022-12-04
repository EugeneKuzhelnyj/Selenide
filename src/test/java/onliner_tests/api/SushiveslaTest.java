package onliner_tests.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.Step;
import onliner_tests.BaseTest;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.SushiveslaPage;
import entity.Product;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class SushiveslaTest extends BaseTest {
    private static final String SUSHIVESLA_ENDPOINT = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";
    private static final String SUSHI_VESLA_ROLLS_ENDPOINT = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla?sushi_typ[0]=roll&sushi_typ[operation]=union";
    private SushiveslaPage sushvesla = new SushiveslaPage();

    @BeforeEach
    void openSushivesla() {
        sushvesla.openSushivesla();
    }

    @Step("Are Sushi Attributes Not Null?")
    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void isSushiAttributesNotNullTest() {
        List<Product> products = given()
                .when()
                .get(SUSHIVESLA_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .jsonPath()
                .getList("products", Product.class);
        assertThat(products).withFailMessage("Some sushi attributes are empty")
                .extracting("id", "key", "name", "full_name").isNotIn("");
    }

    @Step("Is Name Prefix Contains Rolls?")
    @Test
    @JsonIgnoreProperties(ignoreUnknown = true)
    public void isNamePrefixContainsRollsTest() {
        sushvesla.selectRolls();
        List<String> prefixNames = given()
                .when()
                .get(SUSHI_VESLA_ROLLS_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .jsonPath()
                .getList("products.name_prefix", String.class);
        assertThat(prefixNames).withFailMessage("Some name_prefix from the response doesn't contain the selected filter (\"Роллы\")")
                .filteredOn(el -> el.equals("Роллы")).hasSameSizeAs(prefixNames);
    }

}
