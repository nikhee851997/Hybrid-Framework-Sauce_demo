package listenersconceptofapplication;

import java.awt.Desktop;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reports.ExtentReportsManager;

public class MyListeners implements ITestListener
// ITestListener is an interface that gives status of testcases by using its unimplemented methods like onTestSuccess,onTestFailure,onTestSkipped etc.
{

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter Spark;
	public ExtentTest test;
	

	

@Test(priority=1)
public void onStart(ITestContext context)
//ITestContext is an interface , It is used to share data between testcases in same class.
{
	String TestCase = context.getName();
	extent = ExtentReportsManager.generateReport();
    test=extent.createTest(TestCase);
    test.log(Status.INFO,  TestCase + "-------------> Started Excecuting");

}



@Test(priority=2)
public void onTestStart(ITestResult result)
//ITestResult is an interface, It gives endresult of testcase by using its methods.

{
	String TestCasee =  result.getName();
	test= extent.createTest(TestCasee);
	test.log(Status.INFO,  TestCasee + "------------> Test Started Executing");
	
}


@Test(priority=3)
public void onTestSuccess(ITestResult result)
{
	String TestCaseS= result.getName();
	test.log(Status.PASS, TestCaseS +" -------------> Successfully Passed");
}



@Test(priority=4)
public void onTestFailure(ITestResult result)
{
	 String TestCaseF= result.getName();
	
	 driver=null;
	 try
	 {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	 }
	 
	 catch(IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
	 {
		 e.printStackTrace();
	 }
	 
	//TakesScreenshot is an interface that enables driver to capture screenshots.
	
	//getScreenshotAs is a method that captures screenshot and store it in specified location.
	
	File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	String Dest= (System.getProperty("user.dir")+"\\test-output\\Screenshots\\"+TestCaseF+".png");	
	
	try 
	{
		//For copying files, moving files, deleting files.
		FileUtils.copyFile(srce, new File(Dest));
		
	}
	
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	test.addScreenCaptureFromPath(Dest);
	test.log(Status.FAIL, TestCaseF + "--------------> It Failed");
	
}



@Test(priority=5)
public  void onTestSkipped(ITestResult result)
{
	String TestCaseI = result.getName();
	test.log(Status.SKIP, TestCaseI + "--------------> Really it skipped");
}



@Test(priority=6)
public void onFinish(ITestContext context)
{
	String TestCaseN = context.getName();
	test.log(Status.INFO, TestCaseN+ "----------------> Finished Executing");
	extent.flush();
	
	String PathOfExtentReport= (System.getProperty("user.dir")+"\\TheExtentReports\\Index.html");
	
	File ExtentReportPath = new File(PathOfExtentReport);

	try 
	{
		Desktop.getDesktop().browse(ExtentReportPath.toURI()); // URI is Uniform Resource Identifier
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
  }	
}
