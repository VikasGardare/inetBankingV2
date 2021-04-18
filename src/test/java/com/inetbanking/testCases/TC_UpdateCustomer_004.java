package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.UpdateCustomerPage;

public class TC_UpdateCustomer_004 extends BaseClass{
	@Test
	public void updateCustomer() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.ClickSubmit();
		
		Thread.sleep(3000);
		UpdateCustomerPage ucustp=new UpdateCustomerPage(driver);
		ucustp.lnkEditcustomerDeatils();
		ucustp.updateCustId("14042");
		ucustp.uodateCustSub();
	}
}
