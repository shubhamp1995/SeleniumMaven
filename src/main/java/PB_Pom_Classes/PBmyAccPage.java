package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBmyAccPage 
{
@FindBy(xpath="//span[text()=' My profile ']") private WebElement myProfile;
@FindBy(xpath="//span[text()='Sign out']")private WebElement logOut;
public PBmyAccPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void clickOnPBMyAccPagemyProfile ()

{
	myProfile.click();
}
public void logoutFrmPBProfilePage() 
{
	logOut.click();
}

}
