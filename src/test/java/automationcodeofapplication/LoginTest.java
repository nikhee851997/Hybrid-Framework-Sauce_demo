package automationcodeofapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Incorrectdetailsofapplication.Details;
import commoncodeofapplication.CommonForTest;
import locatorsdataofapplication.AccountPage;
import locatorsdataofapplication.LoginPage;
import testcasedataofapplication.DataProvForLoginApplication;


public class LoginTest extends CommonForTest
{

	
	    public WebDriver driver;
		public ChromeOptions opt;
		public WebDriverWait W;
		public SoftAssert soft;
		public LoginPage log;
		public AccountPage act;
	
		

	LoginTest() throws Throwable 
	{
		super();
	}
 
   
	
	
	@BeforeMethod
	public void Setup()
	{
		driver = openApplication();
		log = new LoginPage(driver);

	}
	
	
	
	@Test(priority = 1, dataProvider = "Amrutham", dataProviderClass = DataProvForLoginApplication.class)
	public void verifyLoginWithValidCredentials(String Uniqname, String Uniqpass) throws Exception 

	{

        act = log.navigateToAccountPage(Uniqname, Uniqpass);
       
		soft = new SoftAssert();
		
		Thread.sleep(3000);
		
        soft.assertTrue(act.tDisplay());
        
        soft.assertAll();
		
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword()
	
	{
      act=log.navigateToAccountPage(pr1.getProperty("Identifier"), pr2.getProperty("IncorrectPassword"));		
		
	}
	

	
	@Test(priority=3, dependsOnMethods="verifyLoginWithValidEmailInvalidPassword")
	public void verifyLoginWithInvalidEmailValidPassword() 
	
	{
		act=log.navigateToAccountPage(Details.GenerateEmailwithDatetimestamp(),pr1.getProperty("Code"));
		soft = new SoftAssert();
		soft.assertTrue(log.Notification());
		soft.assertAll();
         
	}
	

	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials()
	
	{
		
		act=log.navigateToAccountPage(Details.GenerateEmailwithDatetimestamp(),pr2.getProperty("IncorrectPassword"));
	
	}
	

	
	@Test(priority=5, dataProvider= "Amrutham", dataProviderClass=DataProvForLoginApplication.class)
	public void Logout(String Uniqname, String Uniqpass) throws Exception
	
	{
		act=log.navigateToAccountPage(Uniqname, Uniqpass);
		Thread.sleep(2000);
    	act.logoutPrc();
    	Thread.sleep(2000);
    	act.logoutPrd();
    	
	    
     
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
	
}
