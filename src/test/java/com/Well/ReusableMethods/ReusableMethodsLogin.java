package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {
	
	public void Login() throws IOException, InterruptedException {

		String Username=null;
		String Password=null;
		if(Environment.equalsIgnoreCase("Test")) {
			
			Username = data.getCellData("Login", "UserName", 3);
			Password = data.getCellData("Login", "Password", 3);
			
		}
		else {
			Username = data.getCellData("Login", "UserName", 2);
		    Password = data.getCellData("Login", "Password", 2);
		}
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Username);
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above").sendKeys(Password);;
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.click("LoginButton");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilVisibility("SuccessfulLogin", 30);
		testlog.pass("Verfies Login Successful");

		
	}
	}


