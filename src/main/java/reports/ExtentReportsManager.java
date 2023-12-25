package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager 
{
	
public static ExtentReports extent;
public static ExtentSparkReporter spark;




public static ExtentReports generateReport()
{
	if(extent==null)
	{
//This is a ExtentReports class that is responsible for creating a Extent Report With the data provided by ExtentSparkReporter class with in that location. 	

//This report(HTML) is a visual representation of information about test cases results, screenshots, log messages etc.. we chooose to include.

	extent = new ExtentReports();
	
	
	spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\TheExtentReports\\");
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Sauce_Report");
	spark.config().setDocumentTitle("ProjectN_JIRAStory_QA/ExtentReport");
	spark.config().setTimeStampFormat("MM/dd/yy: HH:mm:ss");
	
	extent.attachReporter(spark);
	
	}
	return extent;  
	
   }

}
