package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOne {
	
	@Test
   public void test_1() {
	   Response response=get("https://reqres.in/api/users?page=2");
	   System.out.println(response.getStatusCode());
	   System.out.println(response.getTime());
	   System.out.println(response.getStatusLine());
	   Assert.assertEquals(response.getStatusCode(),200);
   }
	
  @Test
    
  public void test_2(){
	  
	  given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data[0].id", equalTo(7)).log().all();
	  
  }
  
  
}
