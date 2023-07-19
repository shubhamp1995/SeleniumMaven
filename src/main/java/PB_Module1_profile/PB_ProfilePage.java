package PB_Module1_profile;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PB_ProfilePage 
{
@FindBy(xpath="//input[@name='personName']")private WebElement verifyFullName;
WebDriver driver1;
public PB_ProfilePage (WebDriver driver) 
{
	PageFactory.initElements(driver, this);
	driver1=driver;
}
public void switchToSwitchChildWindow() 
{
Set<String> allid = driver1.getWindowHandles();	
ArrayList<String> al=new ArrayList<String>(allid);
driver1.switchTo().window(al.get(1));

}
public String getPBProfilePageFullName() 
{
	String actName = verifyFullName.getAttribute("value");
			return actName;
}




}
