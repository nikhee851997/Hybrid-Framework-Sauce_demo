package locatorsdataofapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage
{

public WebDriver driver;


@FindBy(xpath = "//input[@name='firstName']")
private WebElement Credential;

@FindBy(xpath = "//input[@name='lastName']")
private WebElement Credentials ;

@FindBy(xpath = "//input[@name='postalCode']")
private WebElement Address;


@FindBy(xpath = "//input[@id='continue' and @name= 'continue']")
private WebElement Next;


@FindBy(xpath="//button[@id='finish' and @name= 'finish']")
private WebElement Done;


@FindBy(xpath = "//h2[text()='Thank you for your order!']")
private WebElement succes;






public CheckoutPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}


public void placingTheOrder(String firsttext,String lasttext, long post)
{
	 Credential.sendKeys(firsttext);
	 Credentials.sendKeys(lasttext);
	 //To convert long to String 
	 String sampler = String.valueOf(post);
	 Address.sendKeys(sampler);
	 Next.click();
	 Done.click();
}


public boolean successfullyPlacedTheOrder()
{
	boolean relt= succes.isDisplayed();
	return relt;
}






}