package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowser 
{
	WebDriver driver=null;
	
	@Parameters("browsername")
	@BeforeMethod
	public void setup(String browsername)
	{
		System.out.println("Browser name is "+ browsername);
		System.out.println("Thread id is "+ Thread.currentThread().getId());
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
	}
	
	@Test
	public void tests() throws InterruptedException
	{
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
		System.out.println("test completed succesfully");
	}

}
