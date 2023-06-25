import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class AddControllerTest {
    @Test
    void testAddNumbers() {
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

    @Test
    void testAddTwoNulls() {
        String requestBody = "{\n" +
                "  \"number1\": "+null+",\n" +
                "  \"number2\": "+null+"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(200)
                .body(equalTo("The result is: "+0));
    }
    @Test
     void testInvalidBody() {


        /*String requestBody = "{\n" +
                "  \"number1\": 10,\n" +
                "  \"number2\": 20\n" +
                "}";*/
        String requestBody = "";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8081/integers/add")
                .then()
                .statusCode(400);

}

}
