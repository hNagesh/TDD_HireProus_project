package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;


public class ReusableMethodsMembership extends BaseClass {

	public void RegisterMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPUserMenu", 60);
		CommonMethod.RobustclickElementVisible("MPUserMenu","MPMyMembership");
		CommonMethod.RobustclickElementVisible("MPMyMembership","MPMembershipLanding");
		CommonMethod.WaitUntilVisibility("MPMembershipLanding", 60);
		CommonMethod.refreshBrowser();
		CommonMethod.scrolldowntoElement("MPCornerstoneAmount");
		testlog.info("MembershipName:" +MembershipName);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.click("MPCornerstonebtn");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.click("MPKeystonebtn");
		}
		String firstName = USfaker.address().firstName();
		CommonMethod.sendKeys("MPorganization", firstName);
		data.setCellData(SheetName, "Organization", rowNum, CommonMethod.getattributeValue("MPorganization"));
		CommonMethod.uploadFile("WFProvideUpload", SampleJpgfile);
		CommonMethod.ClickCheckbox("MPNumberofyearsrtn");
		CommonMethod.sendKeys("MPorganizationwebsite", "https://test-nuxt.wellcertified.com/");
		data.setCellData(SheetName, "Organizationwebsite", rowNum, CommonMethod.getattributeValue("MPorganizationwebsite"));
		CommonMethod.WaitUntilVisibility("MPorgcontinuebtn", 30);
		testlog.info("organizationName: "+ data.getCellData(SheetName, "Organization", rowNum));
		testlog.info("organizationwebsite: " +data.getCellData(SheetName, "Organizationwebsite", rowNum));
		CommonMethod.RobustclickElementVisible("MPorgcontinuebtn","MPNamePointContact");
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollMembership(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Point Contact
		 */
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		String firstName = USfaker.address().firstName();
		String PhoneNumber = USfaker.number().digits(10);
		String email = USfaker.internet().emailAddress();
		testlog.info("website:" +"https://test-nuxt.wellcertified.com/");
		testlog.info("firstName:" +firstName);
		testlog.info("phonenumber: " +PhoneNumber);
		CommonMethod.sendKeys("MPNamePointContact", firstName);
		data.setCellData(SheetName, "Name", rowNum, CommonMethod.getattributeValue("MPNamePointContact"));
		CommonMethod.sendKeys("MPEmail", email);
		data.setCellData(SheetName, "Email", rowNum, CommonMethod.getattributeValue("MPEmail"));
		CommonMethod.sendKeys("MPJobtitle", "Testing");
		data.setCellData(SheetName, "JobTitle", rowNum, CommonMethod.getattributeValue("MPJobtitle"));
		CommonMethod.sendKeys("MPPhonenumber", PhoneNumber);
		data.setCellData(SheetName, "PhoneNumber", rowNum, CommonMethod.getattributeValue("MPPhonenumber"));
		CommonMethod.ClickCheckbox("MPContactdetailscheckbox");
		testlog.info("Name: " +data.getCellData(SheetName, "Name", rowNum));
		testlog.info("Email: " +data.getCellData(SheetName, "Email", rowNum));
		testlog.info("JobTitle: " +data.getCellData(SheetName, "JobTitle", rowNum));
		CommonMethod.RobustclickElementVisible("MPContinuebutton","MPMembershipOwnerContinue");
		/*
		 * Owner details
		 */
		CommonMethod.WaitUntilVisibility("MPOwnername", 30);
		CommonMethod.sendKeys("MPOwnername", firstName);
		data.setCellData(SheetName, "Name", rowNum, CommonMethod.getattributeValue("MPOwnername"));
		CommonMethod.sendKeys("MPOwnerEmail", email);
		data.setCellData(SheetName, "Email", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
		testlog.info("Ownerjob:" +"Testing");
		CommonMethod.sendKeys("MPOwnerjob", "Testing");
		data.setCellData(SheetName, "JobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerjob"));
		CommonMethod.sendKeys("MPOwnernumber", PhoneNumber);
		data.setCellData(SheetName, "PhoneNumber", rowNum, CommonMethod.getattributeValue("MPOwnernumber"));
		CommonMethod.RobustclickElementVisible("MPMembershipOwnerContinue","MPOfficecontinuebtn");
		/*
		 * Office Address
		 */
		CommonMethod.WaitUntilVisibility("MPOfficecountry", 30);
		CommonMethod.selectdropdownVisibletext("MPOfficecountry", "United States");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("MPOfficestate");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("MPOfficestate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("MPOfficestreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("MPOfficestreet"));
		CommonMethod.sendKeys("MPOfficecity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("MPOfficecity"));
		CommonMethod.sendKeys("MPOfficePostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("MPOfficePostalCode"));
		testlog.info("Country: " +data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " +data.getCellData(SheetName, "State", rowNum));
		testlog.info("Street: " +data.getCellData(SheetName, "Street", rowNum));
		testlog.info("PostalCode: " +data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("MPOfficecontinuebtn","MPTermscheckbox");
		/*
		 * Term
		 */
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.ClickCheckbox("MPTermscheckbox");
		CommonMethod.scrolldowntoElement("MPProcedtopaymentbtn");
		CommonMethod.click("MPProcedtopaymentbtn");
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.RobustclickElementVisible("MPProcedtoConfirmationPaymentbtn","BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies Enrollment successfully**");
	}

	public void BillingMembership(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
		rc.Billing(SheetName, rowNum);
		testlog.info("MembershipName:" +MembershipName);
		CommonMethod.WaitUntilVisibility("MPValidMembershipeType", 60);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "CORNERSTONE MEMBERSHIP", "Mismatch Cornerstone Membership Name");
		}
		else if(MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "KEYSTONE MEMBERSHIP", "Mismatch KEYSTONE Membership Name");
		}
		testlog.pass("**Verified Membership Name successfully**");
	}
	
	public void AdminMembershipNavigation(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminMembershipNavBar");
		CommonMethod.WaitUntilPresence("AdminMembershipNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminMembershipNavBar", "MPViewButton");
		CommonMethod.WaitUntilPresence("MPViewButton", 60);
		CommonMethod.RobustclickElementVisible("MPViewButton","ProfileTab");
		CommonMethod.RobustclickElementVisible("ProfileTab","MPLicensingProgramCheckbox");
		CommonMethod.RobustclickElementVisible("MPLicensingProgramCheckbox", "MPProfileUpdateButton");
		CommonMethod.RobustclickElementVisible("MPProfileUpdateButton", "MPLicensingTab");
		CommonMethod.RobustclickElementVisible("MPLicensingTab", "MPDownloadApplicationform");
		CommonMethod.WaitUntilVisibility("MPDownloadApplicationform", 120);
		CommonMethod.RobustclickElementVisible("MPDownloadApplicationform","MPLicensingContinue");
		Thread.sleep(2000);
		CommonMethod.isFileExists(downloadPath);
		CommonMethod.RobustclickElementVisible("MPLicensingContinue", "MPApplicationform");
		testlog.pass("**Verifies Navigate to Product Licensing Page successfully**");
	}
public void UploadDocumentInLicensing(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
	CommonMethod.uploadFile("MPProductUploadForm", ProductInfoFormfileUpload,"MPValidUploadFile");
	testlog.pass("**Verifies Uploaded File successfully**");
	}
public void CreateLicensing(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
	for (int i=1;i<=3;i++) {
	CommonMethod.uploadFile("MPApplicationform", ProductInfoFormfileUpload,"MPApplicationformDeleteIcon");
	CommonMethod.uploadFile("MPSupportingdocuments", ProductInfoFormfileUpload,"MPSupportingdocumentsIcon");
	CommonMethod.selectdropdownrandom("MPSelectProductCategories");
	String ProductCategories = CommonMethod.getSelectedDropdownValue("MPSelectProductCategories");
	testlog.info("ProductCategories: "+ProductCategories);
	CommonMethod.selectdropdownrandom("MPSelectproductType");
	CommonMethod.WaitUntilVisibility("MPSelectPartname", 120);
	CommonMethod.RobustclickElementVisible("MPSelectPartname","MPSelectPartnameChild");
	CommonMethod.click("MPSelectPartnameChild");
	String GroupName = USfaker.address().firstName();
	testlog.info("GroupName: "+GroupName);
	CommonMethod.sendKeys("MPGroupName",GroupName);
	String getGroupName =CommonMethod.getattributeValue("MPGroupName");
	testlog.info("getGroupName: "+getGroupName);
	CommonMethod.sendKeys("MPLicenseComment","QA Team");
	CommonMethod.RobustclickElementVisible("MPSaveProductButton","MPValidGroupName");
	CommonMethod.scrolldowntoElement("MPValidUploadFile");
	CommonMethod.WaitUntilPresence("MPValidGroupName", 120);
}
CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard",3);
CommonMethod.assertcountListWebelementFromIndex("MPLicenseEdit",3);
CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon",3);
testlog.pass("**Verifies Created Product Licensing successfully**");
testlog.pass("**Verifies added 3 Product Licensing Group successfully**");
}

public void UpdateLicensing(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
	CommonMethod.WaitUntilVisibility("MPValidUploadFile", 120);
	CommonMethod.clickOnListWebelementFromIndex("MPLicenseEdit",0);
	CommonMethod.selectdropdownValue("MPSelectUpdateProductCategories", "9");
	CommonMethod.selectdropdownValue("MPSelectproductType","60");
	CommonMethod.WaitUntilVisibility("MPSelectPartname", 30);
	CommonMethod.RobustclickElementVisible("MPSelectPartname","MPSelectPartnameChild");
	CommonMethod.click("MPSelectPartnameChild");
	CommonMethod.WaitUntilVisibility("MPGroupName", 30);
	CommonMethod.WaitUntilVisibility("MPLicenseUpdateSaveButton", 120);
	CommonMethod.RobustclickElementVisible("MPLicenseUpdateSaveButton","MPApplicationformDeleteIcon");
	CommonMethod.scrolldowntoElement("MPValidUploadFile");
	CommonMethod.WaitUntilPresence("MPValidGroupName", 120);
	CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPValidType"),"Audio-Video Systems" , "GroupName doesn't match");
	CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPValidCategory"),"Communications" , "Category doesn't match");	
	softAssert.assertAll();
	testlog.pass("**Verifies Updated Product Licensing successfully**");
}
public void DeleteLicensing(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
	CommonMethod.WaitUntilPresence("MPValidUploadFile", 120);
	CommonMethod.clickOnListWebelementFromIndex("MPDeleteIcon",2);
	CommonMethod.RobustclickElementVisible("MPLicenseProductDelete","MPSelectProductCategories");
	CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon",2);
	testlog.pass("**Verifies Delete Product Licensing Group successfully**");
}

public void SubmitProductLicensingReview(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
	CommonMethod.WaitUntilVisibility("MPLicenseSubmitForReview", 120);
	CommonMethod.RobustclickElementVisible("MPLicenseSubmitForReview","MPLicenseDeleteProduct");
	CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard",2);
	CommonMethod.softAssertEqualsMessage(CommonMethod.getText("MPLicenseReviewStatus"),"UNDER REVIEW" , "Review Status doesn't match");	
	CommonMethod.RobustclickElementVisible("MPLicenseDeleteProduct","MPLicenseProductDelete");
	CommonMethod.RobustclickElementVisible("MPLicenseProductDelete","MPLicensingProgramCheckbox");
	CommonMethod.WaitUntilPresence("MPLicensingProgramCheckbox", 120);
	CommonMethod.RobustclickElementVisible("MPLicensingTab", "MPDownloadApplicationform");
	CommonMethod.WaitUntilInVisibility("MPLicenseDeleteProduct", 120);
	softAssert.assertAll();
	testlog.info("**Verifies Product Licensing Review Status successfully**");
	testlog.info("**Verifies Deleted Product Licensing successfully**");
	testlog.pass("**Verifies Submitted Product Licensing Review successfully**");
	
}
}