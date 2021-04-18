package com.inetbanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("Open Url");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter UserName");
		lp.setPassword(password);
		logger.info("Enter Password");
		lp.ClickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Pass");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}
	
}
