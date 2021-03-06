package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	public void loginDDT(String unm,String pwd) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(unm);
		logger.info("usename given");
		lp.setPassword(pwd);
		logger.info("password is given");
		lp.ClickSubmit();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
			captureScreen(driver, "LoginPage");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.ClickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path="./src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1", 1);
		String loginData[][]=new String[rownum][colcount];
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);
				
			}
		}
		return loginData;
	}
}
