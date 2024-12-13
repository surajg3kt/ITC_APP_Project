package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass 
{
  @FindBy(xpath="//*[@placeholder='Enter your pincode']")
  public WebElement pincode;
  
  public WebElement getpincode()
  {
	  return pincode;
  }
  
  @FindBy(xpath = "//*[text()='Proceed']")
  public WebElement proceed_b;
  
  public WebElement getProceedbutton()
  {
	  return proceed_b;
  }
  
  @FindBy(xpath="//*[@title='Personal Care']")
  public WebElement personal_care;
  
  public WebElement getpersonal_care()
  {
	  return personal_care;
  }
  
  
  public PomClass(WebDriver driver) 
   {
	PageFactory.initElements(driver, this);
   }
  

  
}

