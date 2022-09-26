package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsMembership extends BaseClass {

	public void RegisterMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPUserMenu", 60);
		CommonMethod.click("MPUserMenu");
		CommonMethod.click("MPMyMembership");
		CommonMethod.WaitUntilVisibility("MPMembershipLanding", 60);
		CommonMethod.refreshBrowser();
		CommonMethod.scrolldowntoElement("MPCornerstoneAmount");
		testlog.info("MembershipName:" +MembershipName);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.click("MPCornerstonebtn");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.click("MPKeystonebtn");
		}
		testlog.info("organizationName:" +data.getCellData(SheetName, "organization", rowNum));
		testlog.info("organizationwebsite:" +data.getCellData(SheetName, "organizationwebsite", rowNum));
		CommonMethod.sendKeys("MPorganization", data.getCellData(SheetName, "organization", rowNum));
		CommonMethod.uploadFile("WFProvideUpload", SampleJpgfile);
		CommonMethod.ClickCheckbox("MPNumberofyearsrtn");
		CommonMethod.sendKeys("MPorganizationwebsite", data.getCellData(SheetName, "organizationwebsite", rowNum));
		CommonMethod.WaitUntilVisibility("MPorgcontinuebtn", 30);
		CommonMethod.click("MPorgcontinuebtn");
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollMembership(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Point Contact
		 */
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		String firstName = USfaker.address().firstName();
		testlog.info("email:" +data.getCellData(SheetName, "organizationwebsite", rowNum));
		testlog.info("firstName:" +firstName);
		testlog.info("phonenumber:" +data.getCellData(SheetName, "phonenumber", rowNum));
		CommonMethod.sendKeys("MPNamePointContact", firstName);
		CommonMethod.sendKeys("MPEmail", data.getCellData(SheetName, "email", rowNum));
		CommonMethod.sendKeys("MPJobtitle", data.getCellData(SheetName, "jobtitle", rowNum));
		CommonMethod.sendKeys("MPPhonenumber", data.getCellData(SheetName, "phonenumber", rowNum));
		CommonMethod.ClickCheckbox("MPContactdetailscheckbox");
		CommonMethod.click("MPContinuebutton");
		/*
		 * Owner details
		 */
		CommonMethod.WaitUntilVisibility("MPOwnername", 30);
		CommonMethod.sendKeys("MPOwnername", firstName);
		CommonMethod.sendKeys("MPOwnerEmail", data.getCellData(SheetName, "email", rowNum));
		testlog.info("Ownerjob:" +data.getCellData(SheetName, "jobtitle", rowNum));
		CommonMethod.sendKeys("MPOwnerjob", data.getCellData(SheetName, "jobtitle", rowNum));
		CommonMethod.sendKeys("MPOwnernumber", data.getCellData(SheetName, "phonenumber", rowNum));
		CommonMethod.click("MPMembershipOwnerContinue");
		/*
		 * Office Address
		 */
		CommonMethod.WaitUntilVisibility("MPOfficecountry", 30);
		CommonMethod.selectdropdown("MPOfficecountry", data.getCellData(SheetName, "country", rowNum));
		CommonMethod.selectdropdown("MPOfficestate", data.getCellData(SheetName, "state", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("PostalCode:" +PostalCode);

		CommonMethod.sendKeys("MPOfficestreet", ProjectAddress);
		CommonMethod.sendKeys("MPOfficecity", ProjectCity);
		CommonMethod.sendKeys("MPOfficePostalCode", PostalCode);
		CommonMethod.click("MPOfficecontinuebtn");
		/*
		 * Term
		 */
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.ClickCheckbox("MPTermscheckbox");
		CommonMethod.scrolldowntoElement("MPProcedtopaymentbtn");
		CommonMethod.click("MPProcedtopaymentbtn");
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.click("MPProcedtoConfirmationPaymentbtn");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies Enrollment successfully**");
	}

	public void BillingMembership(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
		v2project.Billing(SheetName, rowNum);
		testlog.info("MembershipName:" +MembershipName);
		CommonMethod.WaitUntilVisibility("MPValidMembershipeType", 60);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "CORNERSTONE MEMBERSHIP", "Verified Cornerstone Membership Name");
		}
		testlog.pass("**Verified Membership Name successfully**");
	}

}