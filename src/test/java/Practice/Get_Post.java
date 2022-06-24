package Practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class Get_Post {
    @Test
    public void Get() {
        baseURI = "https://reqres.in/api";
        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[4].first_name", equalTo("George")).
            body("data.first_name", hasItems("Rachel"));
    }

    @Test
    public void Post() {
        Map<String, Object> map = new HashMap<>();
        map.put("Name","Hasan");
        map.put("Title", "Internee");
        System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("Name", "Shehriyar");
        request.put("Title", "Internee2");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
           header("Content-Type", "application/json").
           contentType(ContentType.JSON).
           accept(ContentType.JSON).
           body(request.toJSONString()).
        when().
           post("/users").
        then().
           statusCode(201).
           log().all();
    }
}
