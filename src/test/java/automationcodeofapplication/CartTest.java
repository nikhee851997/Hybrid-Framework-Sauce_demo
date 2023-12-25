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


public class CartTest extends CommonForTest
{

	public WebDriver driver;
	public LoginPage log;
    public ProductsPage pdcts;
    public AccountPage act;
    public CheckoutPage chck;
    public SoftAssert soft;
    
    
   
     public CartTest() throws Exception
      {
    		super();
      }
    

 @BeforeMethod
 public void setup()
 {
	 driver=openApplication();
	 log= new LoginPage(driver);

 }
     
  
@Test(dataProvider= "Amrutham", dataProviderClass=DataProvForLoginApplication.class )
public void addingItemsToCart(String Uniqname,String Uniqpass) throws Exception 

{
     act=log.navigateToAccountPage(Uniqname, Uniqpass);
     Thread.sleep(2000);
     pdcts=act.navigateToProductsPage();
     soft = new SoftAssert();
     Thread.sleep(2000);
     soft.assertTrue(pdcts.itemsInTheCart());
     chck=pdcts.navigateToCheckoutPage();
     soft.assertAll();
    
}
  

@AfterMethod
public void close()
{
	driver.quit();
}

	
}
