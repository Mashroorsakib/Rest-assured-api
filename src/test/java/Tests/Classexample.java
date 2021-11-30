package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Classexample {
  // @Test
   public void getsomething() {
	   baseURI="https://reqres.in/api";
	     given().
	      get("/users?page=2").
	      then().statusCode(200).
	      body("data[4].first_name",equalTo("George")).
	      body("data.first_name",hasItems("George","Rachel"));
   }
   
   @Test
   public String testpost() {
	 Map<String, Object> map=new HashMap<String, Object>();
	
	 JSONObject obj=new JSONObject();
	 obj.put("name","sakib");
	 obj.put("job","leader");
	    RestAssured.baseURI="https://reqres.in/api";
	    RequestSpecification request=RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(obj.toJSONString());
        Response response=request.post("/users");
        JsonPath jsonpath=response.jsonPath();
        String name = jsonpath.get("job");
        //System.out.println(name);
       // String str=response.asString();
     //   System.out.println(str);
        return name;
   }
   
  // @Test
     public void edr() {
	   JSONObject obj=new JSONObject();
		 obj.put("name","sakib");
		 obj.put("job","leader");
	   baseURI = "https://reqres.in/api";
       Response res =
               given().
                 header("Content-Type", "application/json")
                       .contentType("application/json")
                       .body(obj.toJSONString()).
                       when()
                       .post("/users").
                       then()
                       .assertThat().statusCode(201).extract().response();

       System.out.println(res.asString());
   }
 
    
}
