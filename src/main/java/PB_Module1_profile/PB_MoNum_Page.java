package PB_Module1_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_MoNum_Page 
{

	@FindBy(xpath="(//input[@type='number'])[2]")private WebElement moNum;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPwd;
	
	public PB_MoNum_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void inpPbMoNumPageMoNUm(String monum) 
	{
		moNum.sendKeys(monum);
		
	}
	public void clickOnPbMoNumPageSignInWithPwd() 
	{
		signInWithPwd.click();
	}
	
	
	
	
	
	
	
	
	
	
}
