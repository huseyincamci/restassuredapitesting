package restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

    @Test
    public void api_returns_200_with_us_and_expected_post_code() {
        given()
                .when()
                .get("https://api.zippopotam.us/us/90210")
                .then()
                .statusCode(200)
                .assertThat()
                .contentType(ContentType.JSON)
                .body("country", equalTo("United States"));
    }


    @Test
    public void api_returns_404_with_us_and_expected_post_code() {
        given()
                .when()
                .get("https://api.zippopotam.us/us/902101111")
                .then()
                .statusCode(404);
    }
}
