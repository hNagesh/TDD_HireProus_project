package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ReusableMethodsExam extends BaseClass {
	
	public void RegisterExam(String SheetName,int rowNum) throws IOException, InterruptedException {

		   CommonMethod.click("TrainingNavBar");
		   CommonMethod.click("WELLExamRatingNavBar");
		   CommonMethod.click("WFContinuebtn");
		   CommonMethod.selectdropdown("WPROwnerCountry",  data.getCellData(SheetName, "country", rowNum));
		   CommonMethod.selectdropdown("WPROwnerState",  data.getCellData(SheetName, "state", rowNum));
		   String ProjectAddress = USfaker.address().streetAddress();
		   String ProjectCity = USfaker.address().cityName();
		   String PostalCode = USfaker.address().zipCode();
		   CommonMethod.sendKeys("WPROrgAddress", ProjectAddress);
	       CommonMethod.sendKeys("WPROrgCity", ProjectCity);
	       CommonMethod.sendKeys("WPROrgPostalcode", PostalCode);
	       CommonMethod.sendKeys("APPhoneNo", "9999999999");
		   CommonMethod.click("APRegContinue");
		  
	}

}
