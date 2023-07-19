package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage 
{
@FindBy(xpath="//div[text()='My Account']")private WebElement myAcc;
public PBHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement OpenDDOptFrmPbHomePage() 
{
return myAcc;	
}
}
