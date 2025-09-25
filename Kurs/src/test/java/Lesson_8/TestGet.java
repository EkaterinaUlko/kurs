package Lesson_8;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestGet
{

    @Test
    public void testGetRequest() {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertThat(response.jsonPath().getString("json.foo1"), equalTo("bar1"));
        assertThat(response.jsonPath().getString("json.foo2"), equalTo("bar2"));
    }

}
