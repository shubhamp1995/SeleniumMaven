package PB_Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBmyPolicyPage 
{
@FindBy(xpath="//span[text()='Access all of policies']")private WebElement myPolicy;
@FindBy(xpath="//h3[text()='Your Policies']")private WebElement yourPolicy;

public PBmyPolicyPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void ClickOnPBpolicyPageMyPlociy()
{
myPolicy.click();	
}
public String GetTextFrmPBPolicyPageMyPolicy() 
{
	String ActText = yourPolicy.getText();
	return ActText;
}




}
