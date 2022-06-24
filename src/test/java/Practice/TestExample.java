package Practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TestExample {

    @Test
    public void test(){
        Response response =/*RestAssured.*/get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));
        Assert.assertEquals(/*Expected*/200, /*Actual*/response.getStatusCode());
    }

    @Test
    public void test2(){
        baseURI = "https://reqres.in/api";
        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[1].id", equalTo(8)).
            log().all();
    }

}
