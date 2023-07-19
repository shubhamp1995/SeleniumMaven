package PB_module1_profile_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PB_Module1_profile.PB_HomePage;
import PB_Module1_profile.PB_LoginPage;
import PB_Module1_profile.PB_MoNum_Page;
import PB_Module1_profile.PB_MyAccPage;
import PB_Module1_profile.PB_ProfilePage;
import PB_Module1_profile.PB_PwdPage;
import libraryFiles.Base_Class;
import libraryFiles.Utility_Class;

public class Test_POM_DDF_TestNG extends Base_Class
{
	
	PB_LoginPage login;
	PB_MoNum_Page monum;
	PB_PwdPage pwd;
	PB_HomePage home;
	PB_MyAccPage myAcc;
	PB_ProfilePage myprofile;
	int TCID;
	@Parameters("browserName")
	@BeforeClass
	public void OpenBrwoser(String browserName) throws EncryptedDocumentException, IOException
	{
		InitializedBrowser(browserName);
		login=new PB_LoginPage(driver);
		monum=new PB_MoNum_Page(driver);
		pwd=new PB_PwdPage(driver);
		home= new PB_HomePage(driver);
		myAcc=new PB_MyAccPage(driver);
		myprofile=new PB_ProfilePage(driver);

	}
	
	@BeforeMethod
	public void LoginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.clickOnPbLoginPagesignIn();
		monum.inpPbMoNumPageMoNUm(Utility_Class.GetPfData("MONO"));
		monum.clickOnPbMoNumPageSignInWithPwd();
		pwd.InpPbPwdPagePWd(Utility_Class.GetPfData("PWD"));
		pwd.clickOnPWdPageSignIn();
		Thread.sleep(3000);
	}
	@Test
	public void VerifyFullName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=102;
		home.OpenDDOptFrmPBHomePageMyAcc();
		Thread.sleep(2000);
		myAcc.clickOnPbMyAccPageMyProfile();
		myprofile.switchToSwitchChildWindow();
		String actResult=myprofile.getPBProfilePageFullName();
		String expResult=Utility_Class.getTestData(0, 2);
		Assert.assertEquals(actResult, expResult,"Failed: both results are diff-: ");
	}
//	@Test
//	public void tc2()
//	{ TCID=103;
//		Reporter.log("hello",true);
//	}
	@AfterMethod	
	public void LogOutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureSS(driver, TCID);
		}
	}
	
	@AfterClass	
	public void ClosedBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
