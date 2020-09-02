package org.mycompany.Pages;


import org.mycompany.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage extends BaseClass{

	
	@FindBy(linkText="Edit Customer" )
	WebElement editCustomerLink;
	
	
	public  EditCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public EditCustomerPage EditCustomerID(String ID)
	{
		String editcustomerxpath="//*[@name='cus123"+ID+"']";   //cus is valid; cud123 is invalid used to test Extend Reports
		driver.findElement(By.xpath(editcustomerxpath)).sendKeys("1234556");
		return new EditCustomerPage();
	}
	
}
