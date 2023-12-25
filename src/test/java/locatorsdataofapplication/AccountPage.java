package locatorsdataofapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 
{

	public WebDriver driver;
	
	
	@FindBy(xpath= "//span[@class='title']")
	private WebElement ttle;
	
	@FindBy(xpath = "//button[contains(@id, 'burger-menu')]")
	private WebElement diplaybtn;
	
	@FindBy(xpath= "//a[text()='Logout']")
    private WebElement outbtn;
	
	
	@FindBy(xpath="//button[contains(@id,'backpack')]")
	private WebElement item1;
	
	@FindBy(xpath="//button[contains(@id ,'fleece')]")
	private WebElement item2;
	
	@FindBy(xpath="//span[contains(@class, 'shopping')]")
	private WebElement caaart;
	
	
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean tDisplay()
	{
	   boolean res = ttle.isDisplayed();
	   return res;
	}
	
	
	public void logoutPrc()
	{
		diplaybtn.click();
		
	}
	
	public void logoutPrd()
	{
		outbtn.click();

	}
	
	
	public ProductsPage navigateToProductsPage()
	{
		item1.click();
		item2.click();
		caaart.click();
		
		return new ProductsPage(driver);
		
	}
	
	
}


