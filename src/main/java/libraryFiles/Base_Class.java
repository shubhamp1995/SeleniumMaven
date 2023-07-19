package libraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class 
{
public WebDriver driver=null;
public void InitializedBrowser(String browserName) throws IOException
{      
	
	if(browserName.equals("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browserName.equals("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("Edge"))
	{
		driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(Utility_Class.GetPfData("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
}
