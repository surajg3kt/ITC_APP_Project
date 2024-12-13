package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   public WebDriver driver;
   
   public ExtentHtmlReporter HtmlReporter;
   public ExtentReports extent;
	
  @BeforeClass
  public void open()
  {
	  WebDriverManager.chromedriver().setup();
	  
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  
	  driver=new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://www.itcstore.in/");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  System.out.println(driver.getTitle());
	  
  }
  
  @AfterClass
  public void close()
  {
	  //driver.quit();
  }
  
}
