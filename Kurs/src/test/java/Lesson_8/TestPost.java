package Lesson_8;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TestPost
{

    @Test
    public void testPostRequest()
    {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .queryParam("value1", "value2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        response.jsonPath().getString("json.value1").equals("value2");
    }

}
