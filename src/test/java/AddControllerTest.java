import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddControllerTest {
    @Test
    public void testAddNumbers() {
        // Define the request payload
        String requestBody = "{\n" +
                "  \"number1\": 30,\n" +
                "  \"number2\": 20\n" +
                "}";

        // Make the POST request and validate the response
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(200)
                .body(equalTo("The result is: 50"));
    }

}
