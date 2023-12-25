package automationcodeofapplication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Incorrectdetailsofapplication.Details;
import commoncodeofapplication.CommonForTest;
import locatorsdataofapplication.AccountPage;
import locatorsdataofapplication.CheckoutPage;
import locatorsdataofapplication.LoginPage;
import locatorsdataofapplication.ProductsPage;
import testcasedataofapplication.DataProvForLoginApplication;

public class CheckoutTest extends CommonForTest
{
	public WebDriver driver;
	public AccountPage act;
	public LoginPage log;
	public ProductsPage prd;
	public CheckoutPage chk;
	public SoftAssert soft;
	
	
	
	
	
	public CheckoutTest()throws Exception
	{
		super();
	}
	
	@BeforeMethod()
	public void setup()
	{
		driver= openApplication();
		log = new LoginPage(driver);

	}
	
	@Test(dataProvider="Amrutham", dataProviderClass=DataProvForLoginApplication.class)
	public void orderPlaced(String Uniqname, String Uniqpass) throws Exception
	{
		
		act=log.navigateToAccountPage(Uniqname, Uniqpass);
		prd=act.navigateToProductsPage();
		soft= new SoftAssert();
		soft.assertTrue(prd.itemsInTheCart());
		chk=prd.navigateToCheckoutPage();
		chk.placingTheOrder(pr1.getProperty("firsttxt"), pr1.getProperty("lasttxt"), Details.POST);
	    Thread.sleep(2000);
	    soft.assertTrue(chk.successfullyPlacedTheOrder());
	    soft.assertAll();
	    
	}
	
	@AfterMethod()
	public void close()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
