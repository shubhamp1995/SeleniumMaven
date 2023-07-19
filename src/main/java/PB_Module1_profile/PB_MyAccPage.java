package PB_Module1_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PB_MyAccPage 
{
@FindBy(xpath="//span[text()=' My profile ']")private WebElement myProfile;
@FindBy(xpath="//span[text()='Sign out']")private WebElement logOut;
public PB_MyAccPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void clickOnPbMyAccPageMyProfile() 
{
	myProfile.click();
	
}
public void logoutFrmPBProfilePage() 
{
	logOut.click();
}





}
