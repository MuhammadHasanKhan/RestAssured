package Practice;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

public class Put_Patch_Delete {
    @Test
    public void Put() {
        JSONObject request = new JSONObject();
        request.put("Name", "Hasan");
        request.put("Title", "Internee");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/users/2").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void Patch(){
        JSONObject request = new JSONObject();
        request.put("Name", "Umer");
        request.put("Title", "Probation");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";
        given().
           header("Content-Type", "apploication/json").
           contentType(ContentType.JSON).
           accept(ContentType.JSON).
           body(request.toJSONString()).
        when().
           patch("/api/users/2").
        then().
           statusCode(200).
           log().all();
    }

    @Test
    public void Delete(){
        baseURI = "https://reqres.in";
        when().
           delete("/api/users/2").
        then().
           statusCode(204).
           log().all();
    }
}
