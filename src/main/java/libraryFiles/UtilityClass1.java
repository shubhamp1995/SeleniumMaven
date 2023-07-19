package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.common.value.qual.ArrayLen;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilityClass1 
{
public static String GetTestData(int rowIndex, int collIndex) throws EncryptedDocumentException, IOException
{
FileInputStream	file=new FileInputStream("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\TestData\\book2.xls");
Sheet sh = WorkbookFactory.create(file).getSheet("Sheet7");
String value = sh.getRow(rowIndex).getCell(collIndex).getStringCellValue();
return value;
}
public static void captureSS(WebDriver driver ,int TCID) throws IOException
{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File dest=new File("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\FailedTestCasesScreenshot\\TestCaseId"+TCID+".jpg");
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
public static void mouseOverAction(WebDriver driver, WebElement Element) 
{
	Actions act=new Actions(driver);
	act.moveToElement(Element).perform();
}
public static void SwitchToWindow(WebDriver driver, int Index)
{
	Set<String> allids = driver.getWindowHandles();
	ArrayList<String> a1=new ArrayList<String>(allids);
	driver.switchTo().window(a1.get(Index));
}




















}
