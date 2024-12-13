package Testcases;



import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BasePackage.BaseClass;
import PomPackage.PomClass;

public class Homepage extends BaseClass
{
	public WebDriver driver;
	public PomClass pom;
	
	@BeforeMethod
	public void setup()
	{
		this.driver=super.driver;
		
	}
	
	@Test
	public void HandleLocPopup()
	{
		pom=new PomClass(driver);
		pom.getpincode().sendKeys("560086");
		
			//driver.findElement(By.xpath("(//*[@class=\"icon-close\"])[2]")).click();
		pom.getProceedbutton().click();	 
			
			 
		
	}
	
	@Test
	public void PersonalCare() throws IOException, InterruptedException
	{
	 
		
	pom.getpersonal_care().click();
	System.out.println(driver.getTitle());
	
	driver.findElement(By.xpath("//div[@class='category-header']/div/div/div[2]/div/div/div/div[5]")).click();
	System.out.println(driver.getTitle());
	
	driver.findElement(By.xpath("//div[@class='content-body container-fluid']/div/div/div/div[1]/div/div/div[2]/div/div/div/div[4]")).click();
	System.out.println(driver.getTitle());
	
	
	WebElement product3 = driver.findElement(By.xpath("(//*[@class='product-link cursor-pointer'])[3]"));
	System.out.println(product3.getLocation());
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(400,400)");
	
	driver.findElement(By.id("wrap-close-button-1454703513202")).click(); //remove holi bar
	
	
	TakesScreenshot ts=(TakesScreenshot) driver;

	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./test-output/screenshots/maskList.jpeg");
	FileHandler.copy(src,dst);
	
	}

}
