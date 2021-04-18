package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.ClickSubmit();
		Thread.sleep(3000);
		AddNewCustomerPage addnewcust=new AddNewCustomerPage(driver);
		addnewcust.ClickAddNewCustomer();
		addnewcust.custName("Vikas Gardare");
		addnewcust.gender("male");
		addnewcust.custDob("03","07","1990");
		Thread.sleep(3000);
		addnewcust.custAddr("Dhankwadi");
		addnewcust.custCity("Pune");
		addnewcust.custState("Maharashatra");
		addnewcust.custPinNo("411046");
		addnewcust.custTelephone("9877887766");
		String email=RandomEmail()+"@gmail.com";
		addnewcust.custEmail(email);
		addnewcust.custPassword("abcd123");
		addnewcust.custSub();
		Thread.sleep(3000);
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			//customer id=14042
		}
		else
		{
			captureScreen(driver,"AddNewCustomer");
			Assert.assertTrue(res);
		}
	}
	
	public String RandomEmail() {
		String randomString=RandomStringUtils.randomAlphabetic(8);
		return randomString;
	}
}
