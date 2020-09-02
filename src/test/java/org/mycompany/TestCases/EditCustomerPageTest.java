package org.mycompany.TestCases;
import org.mycompany.Base.BaseClass;
import org.mycompany.Pages.EditCustomerPage;
import org.mycompany.Pages.HomePage;
import org.mycompany.Pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//understanding of Extend reports -> can be by adding listeners annotation at class level or call listers at testNG level
@Listeners(org.mycompany.Reports.ExtentReportsUtility.class)
public class EditCustomerPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	EditCustomerPage editcustomerpage;
	boolean flag;
	public EditCustomerPageTest()
	{
		super();
	}

	@BeforeSuite
	public void setUp()
	{
	initialisation();
	loginpage = new LoginPage();
	editcustomerpage = new EditCustomerPage();
	}
	
	@Test(priority=1)
	public void testLogin()
	{
		homepage=loginpage.login();
		
	}
	
	@Test(priority =2)
	public void testEditCustomerLink()
	{
		editcustomerpage =homepage.EditCustomerLink();
	}
	
	@Test(priority =3)
	public void testEditCustomerID()
	{
		editcustomerpage =editcustomerpage.EditCustomerID("id");
		
	}
}
