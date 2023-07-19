package PB_Module1_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_LoginPage 
{
@FindBy(xpath="//a[text()='Sign in']")private WebElement signIn;

public PB_LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void clickOnPbLoginPagesignIn()
{
	signIn.click();
}



}