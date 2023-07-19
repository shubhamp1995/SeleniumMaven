package PB_Module1_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_PwdPage 
{
@FindBy(xpath="//input[@name='password']")private WebElement pwd;
@FindBy(xpath="//span[text()='Sign in']")private WebElement signIn;


public PB_PwdPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void InpPbPwdPagePWd(String password)
{
pwd.sendKeys(password);	

}
public void clickOnPWdPageSignIn() 
{
signIn.click();	
}










}
