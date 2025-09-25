package Lesson_8;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TestPut
{
    @Test
    public void testPutRequest()
    {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"value1\": \"value3\"}")
                .when()
                .put("/put")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        response.jsonPath().getString("json.value1").equals("value3");
    }
}
