package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPwdPage 
{
@FindBy(xpath="//input[@name='password']")private WebElement pwd;
@FindBy(xpath="//span[text()='Sign in']")private WebElement signIn;
public PBPwdPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void InputPBpwdPagePwd(String password)
{
pwd.sendKeys(password);	
}
public void ClickOnPBPwdPageSignIn()
{
	signIn.click();
}
}
