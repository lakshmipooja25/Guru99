package org.mycompany.TestCases;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.mycompany.Base.BaseClass;
import org.mycompany.Pages.EditCustomerPage;
import org.mycompany.Pages.HomePage;
import org.mycompany.Pages.LoginPage;
import org.mycompany.Pages.NewCustomerPage;
import org.mycompany.Utility.MyUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class HomePageTest extends BaseClass{
	HomePage homepage;
	NewCustomerPage newcustomerpage;
	LoginPage loginpage;
	EditCustomerPage editcustomerpage;
	
	Assertion a;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeSuite
	public void setUp()
	{
		initialisation();
		loginpage = new LoginPage();
		loginpage.login();
		homepage = new HomePage();
		
	}
	
	@Test(priority=1)
	public void testVerifyTitle()
	{
		String actualtitlename =homepage.verifyTitle();
		a= new Assertion();
		a.assertEquals(actualtitlename, "Guru99 Bank Manager HomePage", "The title value is verified");
		
	}
	
	@Test(priority =2)
	public void testNewCustomerLink()
	{
		newcustomerpage	=homepage.NewCustomerLink();
	}
	
	@DataProvider
	public Object[][] getNewCustomerData() throws Exception
	{
		Object[][] newcusdata= MyUtility.getCustomerData();
		return newcusdata;
	}
	
	
	@Test(priority=3,dataProvider="getNewCustomerData")
	
	public void newCustomerDataProvider(String name, String genderl, String dob, String addr, String city, String state, String pin, String mobno, String eaddr, String pswd ) throws InterruptedException
	{
		homepage.NewCustomerSetData(name, genderl, dob, addr, city, state, pin, mobno, eaddr, pswd);
	}

	
	
	
}
