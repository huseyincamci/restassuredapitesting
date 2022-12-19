package restassured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

    @Test
    public void getCall() {
            given()
                    .when()
                    .get("https://api.zippopotam.us/us/90210")
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .contentType(ContentType.JSON)
                    .body("country", equalTo("United States"));
    }


}
