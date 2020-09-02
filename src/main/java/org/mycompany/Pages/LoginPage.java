package org.mycompany.Pages;


import org.mycompany.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

	@FindBy(name="uid")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submitButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public HomePage login()
	{
		
		uname.sendKeys(prop.getProperty("username"));
		pswd.sendKeys(prop.getProperty("password"));
		submitButton.click();
		return new HomePage();
	}
	
}
