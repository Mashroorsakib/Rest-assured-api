package Tests;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Putpatchdelete {
  
	@Test
	 public void update() {
		 RestAssured.baseURI="https://reqres.in/api";
		 JSONObject obj=new JSONObject();
		 obj.put("name","akib");
		 obj.put("job","employee");
		 Response res=
				 given().
                 header("Content-Type", "application/json")
                       .contentType("application/json")
                       .body(obj.toJSONString()).
                       when()
                       .put("/users/2").
                       then()
                       .assertThat().statusCode(200).extract().response();
		 System.out.println(res.asString());

	 }
	 
	 @Test
	  public void delete() {
		 RestAssured.baseURI="https://reqres.in/api";
		 Response res=
				  given().
		 header("Content-Type", "application/json")
		       .contentType("application/json").
		       when()
		       .put("/users/2").
		       then()
		       .assertThat().statusCode(200).extract().response();
		 System.out.println(res.asString());
		 
		 
	 }
				 
				 
 }
