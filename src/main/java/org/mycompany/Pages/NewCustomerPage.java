package org.mycompany.Pages;


import org.mycompany.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage extends BaseClass{

	@FindBy(linkText="New Customer" )
	WebElement newCustomerLink;
	
	
	
	public  NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void NewCustomerClick()
	{
		newCustomerLink.click();
		 
	}
}
