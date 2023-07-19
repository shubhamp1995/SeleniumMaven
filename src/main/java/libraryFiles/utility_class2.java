package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class utility_class2 
{
public static String getTestData(int rowIndex,int collIndex) throws EncryptedDocumentException, IOException 
{
FileInputStream file =new FileInputStream("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\TestData\\book2.xls");
Sheet sh = WorkbookFactory.create(file).getSheet("Sheet7");
String value = sh.getRow(rowIndex).getCell(collIndex).getStringCellValue();
return value;
}

public static void captureSS(WebDriver driver, int TCID) throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\FailedTestCasesScreenshot\\failTestCase"+TCID+".jpg");
	FileHandler.copy(src, dest);	
}
public static String getPfData(String key) throws IOException
{
	FileInputStream file=new FileInputStream("C:\\Users\\shubham\\eclipse-workspace\\seleniumMaven\\propertyFile.properties");
	Properties p=new Properties();
	p.load(file);
	String value = p.getProperty(key);
	return value;
	
}
public static  void mouseoverAction(WebDriver driver, WebElement Element)
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
