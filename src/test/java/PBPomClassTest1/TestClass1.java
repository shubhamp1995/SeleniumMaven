package PBPomClassTest1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.annotations.ITest;

import PB_Pom_Classes.PBHomePage;
import PB_Pom_Classes.PBLoginPage;
import PB_Pom_Classes.PBProfilePage;
import PB_Pom_Classes.PBPwdPage;
import PB_Pom_Classes.PBmonoPage;
import PB_Pom_Classes.PBmyAccPage;
import PB_Pom_Classes.PBmyPolicyPage;
import libraryFiles.BaseClass1;
import libraryFiles.UtilityClass1;

public class TestClass1 extends BaseClass1
{
	PBLoginPage login;
	PBmonoPage mono;
	PBPwdPage pwd;
	PBHomePage home;
	PBmyAccPage myAcc;
	PBProfilePage myProfile;
	PBmyPolicyPage myPolicy;
	int TCID;
	
	@BeforeClass
	public void OpenBrowser() throws IOException
	{
		InitializedBrwoser();
		login=new PBLoginPage(driver);
		mono=new PBmonoPage(driver);
		pwd=new PBPwdPage(driver);
		home=new PBHomePage(driver);
		myAcc=new PBmyAccPage(driver);
		myProfile=new PBProfilePage(driver);
		myPolicy =new PBmyPolicyPage(driver);
		
	}
	@BeforeMethod
	public void LoginTOApp() throws IOException, InterruptedException 
	{
	login.clickOnPBLoginPageSignIn();
	mono.InputPBMonumPageMOnum(UtilityClass1.GetPfData("MONO"));
	mono.clickPBMonumPageSignInWithPwd();
	pwd.InputPBpwdPagePwd(UtilityClass1.GetPfData("PWD"));
	pwd.ClickOnPBPwdPageSignIn();
	Thread.sleep(2000);
	}
	@Test(priority=1)
	public void verifyFullName() throws EncryptedDocumentException, IOException
	{
		TCID=102;
		WebElement Element = home.OpenDDOptFrmPbHomePage();
		UtilityClass1.mouseOverAction(driver, Element);
		myAcc.clickOnPBMyAccPagemyProfile();
		UtilityClass1.SwitchToWindow(driver, 1);
		
		SoftAssert soft=new SoftAssert();
		
		String ActName = myProfile.GetPBProfilepageFullname();
		String ExpName = UtilityClass1.GetTestData(0, 2);
		
		String ActEmail = myProfile.GetPBProfilepageEmail();
		String ExpEmail = UtilityClass1.GetTestData(0, 3);
		soft.assertEquals(ActName, ExpName,"Fialed: if both are not same");
		soft.assertEquals(ActEmail, ExpEmail,"failed: if both are not same");
		soft.assertAll();
	}
	@Test(priority=2)
	public void GetTextFromMypolicy() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement Element = home.OpenDDOptFrmPbHomePage();
		UtilityClass1.mouseOverAction(driver, Element);
		myPolicy.ClickOnPBpolicyPageMyPlociy();
		UtilityClass1.SwitchToWindow(driver, 1);
		Thread.sleep(2000);	
		String ActText = myPolicy.GetTextFrmPBPolicyPageMyPolicy();
		String ExpText = UtilityClass1.GetTestData(0, 4);
		Assert.assertEquals(ActText, ExpText,"Failed if both are diff");
		
	}
	@AfterMethod
	public void ssOfFailedTc(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass1.captureSS(driver, TCID);
		}
	}
	@AfterMethod	
	public void LogOutfromApp() throws InterruptedException 
	{
	Thread.sleep(2000);	
	driver.close();
	UtilityClass1.SwitchToWindow(driver, 0);
	WebElement Element = home.OpenDDOptFrmPbHomePage();
	UtilityClass1.mouseOverAction(driver, Element);
	Thread.sleep(2000);	
	myAcc.logoutFrmPBProfilePage();
	Thread.sleep(3000);
	
	}
	@AfterClass	
	public void ClosedBrowser() throws InterruptedException 
	{
		Thread.sleep(2000);	
		//driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
