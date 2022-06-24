package Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;
public class Local_host_testing {
    @Test
    public void get(){
        baseURI = "http://localhost:3000";
        given().
           get("/users").
        then().
           statusCode(200).
           log().all();
    }

    @Test
    public void post(){
        JSONObject request = new JSONObject();
        request.put("firstName", "Shehriyar");
        request.put("lastName", "Ahsan");
        request.put("subjestId", "3");

        baseURI = "http://localhost:3000";

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();
    }

    @Test
    public void put(){
        JSONObject request = new JSONObject();
        request.put("firstName", "Umer");
        request.put("lastName", "Shahab");
        request.put("subjectId", "4");

        baseURI = "http://localhost:3000";
        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/users/5").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void patch(){
        JSONObject request = new JSONObject();
        request.put("subjectId","3");

        baseURI = "http://localhost:3000";
        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            patch("/users/4").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void delete(){
        baseURI = "http://localhost:3000";
        when().
            delete("/users/6").
        then().
            statusCode(200).
            log().all();
    }
}
