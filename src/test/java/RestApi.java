import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestApi {
    @Test
    public void getTest() {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/get")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void rowPostTest() {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/post")
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void formPostTest() {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/post")
                .contentType(ContentType.JSON)
                .body("{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}")
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void putTest() {
        given() .baseUri("https://postman-echo.com")
                .basePath("/put")
                .contentType(ContentType.JSON)
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void patchTest() {
        given() .baseUri("https://postman-echo.com")
                .basePath("/patch")
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch()
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void deleteTest() {
        given() .baseUri("https://postman-echo.com")
                .basePath("/delete")
                .contentType(ContentType.JSON)
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}