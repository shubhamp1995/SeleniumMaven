package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility_Class 
{
public static String getTestData(int rowIndex ,int ColIndex) throws EncryptedDocumentException, IOException
{
	FileInputStream file =new FileInputStream("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\TestData\\book2.xls");
	Sheet Sh = WorkbookFactory.create(file).getSheet("Sheet7");
	String value = Sh.getRow(rowIndex).getCell(ColIndex).getStringCellValue();
	
	 return value;
	
	
}
public  static void captureSS(WebDriver driver ,int TCID) throws IOException
{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
File dest =new File("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\FailedTestCasesScreenshot\\testCaseID"+TCID+".jpg");
org.openqa.selenium.io.FileHandler.copy(src, dest);
}
public static String GetPfData(String key) throws IOException 
{
	FileInputStream file=new FileInputStream("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\propertyFile.properties");
	Properties p=new Properties();
	p.load(file);
	
	String value = p.getProperty(key);
	return value;
	
}
}
