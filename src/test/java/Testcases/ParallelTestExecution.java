package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestExecution 
{
	public WebDriver driver;
	
 @Test
 public void test1() throws InterruptedException
 {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://www.selenium.dev/");
	 System.out.println("test1 executed "+ Thread.currentThread().getId());
	 Thread.sleep(3000);
	 driver.close();
	 
 }
 
 @Test
 public void test2() throws InterruptedException
 {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://www.amazon.com");
	 System.out.println("test2 executed "+ Thread.currentThread().getId());
	 Thread.sleep(3000);
	 driver.quit();
 }
}
