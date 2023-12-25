package locatorsdataofapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage
{

	public WebDriver driver;
	
	
   @FindBy(xpath="//button[contains(@id,'backpack')]")
   private WebElement Item1;
   
   
   @FindBy(xpath="//button[contains(@id ,'fleece')]")
   private WebElement Item2;
  
   @FindBy(xpath="//button[@id='checkout']")
   private WebElement CBttn;
	
   
public ProductsPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
	
}
	

public boolean itemsInTheCart()
{
	boolean res=(Item1.isDisplayed() && Item2.isDisplayed());
	return res;
	
}
	
public CheckoutPage navigateToCheckoutPage()
{
	CBttn.click();
	return new CheckoutPage(driver);
}
	
}
