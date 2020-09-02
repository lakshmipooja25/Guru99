package org.mycompany.Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.mycompany.Utility.MyUtility;
import org.mycompany.Utility.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass {
	public static Properties prop ;
	public static WebDriver driver;
	public static EventFiringWebDriver efdriver;
	public static WebEventListener welistener ;
	public static String projectdir;
	public BaseClass() 
	{
		prop= new Properties();
		try {
		FileInputStream fis = new FileInputStream("C:\\Users\\lakshmi.murugand\\eclipse-workspace\\Guru99\\src\\main\\java\\org\\"
				+ "mycompany\\Configuration\\config.txt");
		
			prop.load(fis);
			projectdir=prop.getProperty("projectdir");
		} catch (IOException e) {
		
		}
		
	}
	
	public void initialisation()
	{
		boolean flag = false ;
		String browserName = prop.getProperty("browser");
		String url= prop.getProperty("url");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.out.println("page is under construction");
		}
		
		
		efdriver = new EventFiringWebDriver(driver);
		welistener = new WebEventListener();
		efdriver.register(welistener);
		driver = efdriver;
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(MyUtility.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(MyUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		
		
	}
}
