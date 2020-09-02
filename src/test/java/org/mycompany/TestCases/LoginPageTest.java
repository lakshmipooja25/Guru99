package org.mycompany.TestCases;
import org.mycompany.Base.BaseClass;
import org.mycompany.Pages.HomePage;
import org.mycompany.Pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	boolean flag;
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
	initialisation();
	loginpage = new LoginPage();
	}
	
	@Test
	public void testLogin()
	{
		homepage=loginpage.login();
		
	}
}
