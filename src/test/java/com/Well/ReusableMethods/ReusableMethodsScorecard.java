package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsScorecard extends BaseClass {

	public void clickScoreCard() throws IOException
{
		CommonMethod.WaitUntilClickble("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.WaitUntilClickble("WellV2ScorecardTab", 60);
		CommonMethod.click("WellV2ScorecardTab");
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
}

	public void UploadFileinFeature() throws IOException, InterruptedException {
		
		clickScoreCard();

		List<WebElement> Credit = CommonMethod.findElements("ScoreCardFeatureClick");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Credit) {
			
			  String Creditname = ele.getText(); 
			  System.out.println(Creditname);
			  Creditname = Creditname.replaceAll("\\.",""); 
			  if (Creditname.equalsIgnoreCase("Meet Thresholds for Organic Gases")) {
			 
		   // CommonMethod.scrolldowntoLast();
			//CommonMethod.scrolldowntoElement(ele);
			CommonMethod.click(ele);
			//CommonMethod.scrolldowntoElement("ScorecardFeatureVerificationTab");
			CommonMethod.WaitUntilClickble("ScorecardFeatureVerificationTab", 30);
			CommonMethod.click("ScorecardFeatureVerificationTab");
			CommonMethod.WaitUntilClickble("ScoreCardAddOptionbutton", 30);
			CommonMethod.click("ScoreCardAddOptionbutton");
			List<WebElement> AddButton = CommonMethod.findElements("ScoreCardAddButton");
			for (WebElement ele1 : AddButton) {
				CommonMethod.click(ele1);
				Thread.sleep(1000);
			}
		}
		}
}
}