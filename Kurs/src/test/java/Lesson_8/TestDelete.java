package Lesson_8;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TestDelete
{
    @Test
    public void testDeleteRequest()
    {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .when()
                .delete("/delete?value1=value3")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        response.jsonPath().getString("json.value1").equals("value3");
    }
}
