package org.mycompany.Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mycompany.Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class MyUtility extends BaseClass{

	public static long IMPLICITLY_WAIT= 10;
	public static long PAGE_LOAD_WAIT = 10;
	public static String guru99datasheet="C:\\Users\\lakshmi.murugand\\eclipse-workspace\\Guru99\\src\\main\\java\\org\\"
			+ "mycompany\\DataDriven\\Guru99_Data.xlsx" ;
	static String SHEET_NAME="NewCustomer";
	
	public static Object[][] getCustomerData() throws Exception 
	{
		
		FileInputStream fis = new FileInputStream(guru99datasheet);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SHEET_NAME);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				DataFormatter df = new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}
	
	public static void getSnapshot()
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(file, new File(projectdir+"\\Error Snapshots\\"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

