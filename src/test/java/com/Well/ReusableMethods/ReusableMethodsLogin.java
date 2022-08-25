package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {
	
	public void Login() throws IOException, InterruptedException {

		

		if(Environment.equalsIgnoreCase("Test")) {
			
			String Username = data.getCellData("Login", "UserName", 3);
			String Password = data.getCellData("Login", "Password", 3);;
			
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
		testlog.pass("Successful Login");
		}

	}
}

	/*public void LoginIntoLO(String SheetName, int rowNum) throws IOException, InterruptedException {
		String Username;
		String Password;
		Username = data.getCellData(SheetName, "UserName", rowNum);
		Password = data.getCellData(SheetName, "Password", rowNum);

		if (Environment.equalsIgnoreCase("Dev")) {
			Username = data.getCellData(SheetName, "DevUserName", rowNum);
			Password = data.getCellData(SheetName, "DevPassword", rowNum);
			CommonMethod.click("AccountDev");
		}

		// CommonMethod.click("AcceptCookies");
		testlog.info("Check on Accepting Cookies");
		Thread.sleep(3000);
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Username);
		CommonMethod.sendKeys("Password", Password);
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);

		if (Environment.equalsIgnoreCase("STG")) {

			CommonMethod.scrolldowntoElement("AgreeCheckBox");
			CommonMethod.click("AgreeCheckBox");
			testlog.info("Clicking Agree Checkbox");
			CommonMethod.scrolldowntoElement("LoginButton");
			CommonMethod.click("LoginButton");
			testlog.info("Clicking on Submit Button");
			CommonMethod.WaitUntilVisibility("SuccessfulLogin",60);
			testlog.pass("Successful Login");
		} if (Environment.equalsIgnoreCase("QAS") || Environment.equalsIgnoreCase("STG") || Environment.equalsIgnoreCase("PRD")) {
			CommonMethod.scrolldowntoElement("AgreeCheckBoxQAS");
			CommonMethod.click("AgreeCheckBoxQAS");
			testlog.info("Clicking Agree Checkbox");
			CommonMethod.scrolldowntoElement("LoginButtonQAS");
			CommonMethod.click("LoginButtonQAS");
			testlog.info("Clicking on Submit Button");
			CommonMethod.WaitUntilVisibility("SuccessfulLogin",60);
			testlog.pass("Successful Login");
		} else {

			CommonMethod.scrolldowntoElement("AgreeCheckBoxDev");
			CommonMethod.click("AgreeCheckBoxDev");
			testlog.info("Clicking Agree Checkbox");
			CommonMethod.scrolldowntoElement("LoginButtonDev");
			do {
				CommonMethod.click("LoginButtonDev");
			}while(!CommonMethod.isElementsExist("LoginButtonDev", 5));
			
			testlog.info("Clicking on Submit Button");
			CommonMethod.WaitUntilVisibility("SuccessfulLogin",120);
			testlog.pass("Successful Login");

		}
	}

	public void LoginWithCIR(String SheetName, int rowNum) throws IOException, InterruptedException {

		String Username = data.getCellData(SheetName, "CIRPrimaryEmail", rowNum);
		String Password = data.getCellData(SheetName, "Password", rowNum);

		// CommonMethod.click("AcceptCookies");
		// testlog.info("Accepting Cookies");
		// Thread.sleep(3000);
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Username);
		CommonMethod.sendKeys("Password", Password);
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("AgreeCheckBox");
		CommonMethod.click("AgreeCheckBox");
		testlog.info("Clicking Agree Checkbox");
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.click("LoginButton");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilVisibility("SuccessfulLogin", 30);
		testlog.pass("Successful Login");

	}

	public void LoginWithTeamCredentials(String SheetName, int rowNum, String Username, String Password)
			throws IOException, InterruptedException {

		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Username);
		CommonMethod.sendKeys("Password", Password);
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("AgreeCheckBox");
		CommonMethod.click("AgreeCheckBox");
		testlog.info("Clicking Agree Checkbox");
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.click("LoginButton");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilVisibility("SuccessfulLogin", 30);
		testlog.pass("Successful Login");

	}

	public void SignOut() throws InterruptedException, IOException {

		if(Environment.equalsIgnoreCase("stg")) {
		driver.get("https://leedonline-stg.usgbc.org/user/logout");
		}
		else if(Environment.equalsIgnoreCase("qas")) {
	    driver.get("https://leedonline-qas.usgbc.org/user/logout");
		}
		else if(Environment.equalsIgnoreCase("prd")) {
		    driver.get("https://leedonline.com/user/logout");
			}
		else {
	  driver.get("https://leedonline-dev.usgbc.org/user/logout");	
		}
		CommonMethod.WaitUntilPresence("Username", 10);
	}

}*/
