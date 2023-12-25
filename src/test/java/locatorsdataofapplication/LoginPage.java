package locatorsdataofapplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	
	
	@FindBy(xpath = "//input[@id='user-name' and @name='user-name']")
	private WebElement Defaultusrname;
	
	
	
	@FindBy(xpath = "//input[@id='password' or @name='password']")
	private  WebElement Defaultpasword;
	
	
	
	@FindBy(xpath="//input[@name='login-button']")
	private WebElement LButton;
	
	
	@FindBy(xpath="//div[contains(@class, 'error-message')]")
	private WebElement Pop;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public AccountPage navigateToAccountPage(String Uniqname, String Uniqpass)
	
	{
		Defaultusrname.sendKeys(Uniqname);
		Defaultpasword.sendKeys(Uniqpass);
		LButton.click();
		
		return new AccountPage(driver);
		
	}

	public boolean Notification()
	{
		boolean result= Pop.isDisplayed();
		return result;
	}


	
	

}
