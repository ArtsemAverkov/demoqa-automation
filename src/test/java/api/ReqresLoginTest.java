package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class ReqresLoginTest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void successfulLoginTest(){

        given()
               .log().all()
                .contentType(ContentType.JSON)
                .body("""
                {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                }
            """)
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .statusCode(anyOf(is(200), is(403)));
    }
}

