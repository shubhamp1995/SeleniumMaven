package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage
{
@FindBy(xpath="//input[@name='personName']")private WebElement verifyFullName;
@FindBy(xpath="//input[@name='email']")private WebElement verifyEmail;

public PBProfilePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public String GetPBProfilepageFullname()
{
String ActName = verifyFullName.getAttribute("value");	
return ActName;
}
public String GetPBProfilepageEmail()
{
String ActEmail = verifyEmail.getAttribute("value");	
return ActEmail;
}

}
