package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLogin extends TestBase{
	@Test
	public void LoginAsBankManager() throws IOException {	
		//verifyEquals("XYZ","ABC");
		click("bnkmlbt_CSS");
		log.debug("successfully verified bank manager login button !!!");
		Assert.assertFalse(isElementPresent(By.xpath(OR.getProperty("bnkmlbt_CSS"))),"Successfully logged in to Bank Manager Login");
		Reporter.log("Login Successfully Executed");
		//Assert.fail();
		
		
		
	}

}
