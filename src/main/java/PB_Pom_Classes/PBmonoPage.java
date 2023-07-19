package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBmonoPage 
{
@FindBy(xpath="(//input[@type='number'])[2]")private WebElement moNum;
@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPwd;
public PBmonoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void InputPBMonumPageMOnum(String mobile)
{
moNum.sendKeys(mobile);
}
public void clickPBMonumPageSignInWithPwd()
{
	signInWithPwd.click();
}
}
