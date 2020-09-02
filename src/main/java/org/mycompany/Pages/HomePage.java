package org.mycompany.Pages;


import org.mycompany.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

	@FindBy(linkText="New Customer" )
	WebElement newCustomerLink;
	
	@FindBy(linkText="Edit Customer" )
	WebElement editCustomerLink;
	
	
	public  HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public NewCustomerPage NewCustomerLink()
	{
		newCustomerLink.click();
		return new NewCustomerPage();
	}
	
	public EditCustomerPage EditCustomerLink()
	{
		editCustomerLink.click();
		return new EditCustomerPage();
	}

	public void NewCustomerSetData(String name, String genderl, String dob, String addr, String city, String state, String pin, String mobno, String eaddr, String pswd) throws InterruptedException
	{
		driver.findElement(By.linkText("New Customer")).click();		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(name);		
		String genderwebma = driver.findElement(By.xpath("//*[@name='rad1' and @value='m']")).getAttribute("value");				
		if(genderwebma.equalsIgnoreCase(genderl))
		{
			driver.findElement(By.xpath("//*[@name='rad1' and @value='m']")).click();	
		}
		else
		{
			driver.findElement(By.xpath("//*[@name='rad1' and @value='f']")).click();	
		}
		
		driver.findElement(By.cssSelector("input[type='date'][name='dob']")).sendKeys(dob);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea[name='addr']")).sendKeys(addr);	
		driver.findElement(By.cssSelector("input[name^='ci']")).sendKeys(city);		
		driver.findElement(By.cssSelector("input[name$='ate']")).sendKeys(state);		
		driver.findElement(By.cssSelector("input[name*='inn']")).sendKeys(pin);		
		driver.findElement(By.cssSelector("input[name*='phoneno']")).sendKeys(mobno);		
		driver.findElement(By.cssSelector("input[name^='emai']")).sendKeys(eaddr);		
		driver.findElement(By.cssSelector("input[type$='word']")).sendKeys(pswd);
		
	}	
	
}
