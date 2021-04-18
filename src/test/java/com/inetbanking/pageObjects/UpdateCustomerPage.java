package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpdateCustomerPage {
	
	WebDriver driver;
	public UpdateCustomerPage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver,this);
	}
	@FindBy(how=How.LINK_TEXT,using="Edit Customer")
	@CacheLookup
	WebElement lnkEditCust;
	
	@FindBy(how=How.NAME,using="cusid")
	@CacheLookup
	WebElement customerId;
	
	@FindBy(how=How.NAME,using="AccSubmit")
	@CacheLookup
	WebElement cidSubmit;
	
	public void lnkEditcustomerDeatils() {
		lnkEditCust.click();
	}
	public void updateCustId(String cid)
	{
		customerId.sendKeys(cid);
	}
	
	public void uodateCustSub()
	{
		cidSubmit.click();
	}
	
	
}
