package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomer extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addcustomer(Hashtable<String,String> data) throws InterruptedException {
		
		if(!data.get("Runmode").equals("Y")) {
			throw new SkipException("Skipping the test case as the run mode is not set to Y");
		}
		click("addcustbtn_CSS");
		log.debug("Successfully navigated to  Add customer page");		
		type("firstname_XPATH",data.get("FirstName"));
		type("lastname_XPATH",data.get("LastName"));
		type("PostCode_XPATH",data.get("PostCode"));
		click("addbtn_XPATH");
		Thread.sleep(1000);
		//driver.switchTo().alert().accept();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("AlertText")));
		log.debug("Successfully Added customer");
		Thread.sleep(1000);
		alert.accept();

		
		
	}
	
	
	

}
