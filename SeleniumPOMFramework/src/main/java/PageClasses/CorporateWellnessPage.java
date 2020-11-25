package PageClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class CorporateWellnessPage extends PageBaseClass  {

public CorporateWellnessPage(WebDriver driver, ExtentTest logger) {
 super(driver, logger); }

 
 
 @FindBy(id="name")
 public WebElement name;
 
 @FindBy(id="organization_name")
 public WebElement organizationName;
 
 @FindBy(id="official_email_id")
 public WebElement emailId;
 
 @FindBy(id="official_phone_no")
 public WebElement phoneNo;
 
 @FindBy(id="button-style")
 public WebElement schedule;
 
 public void scheduleDemo() {
 
  try {
   String winHandleBefore= driver.getWindowHandle();

   // Perform the click operation that opens new window
   /*corporateWellness.click();
   logger.log(Status.INFO, "Switching to new tab");
   waitLoad(3);
   logger.log(Status.PASS, "Corporate Wellness newtab opened");
   
   // Switch to new window opened
   for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
   }*/
   
   logger.log(Status.INFO, "Entering details to schedule");
   name.sendKeys("John Snow");
   organizationName.sendKeys("CTS");
   emailId.sendKeys("abcd@gmail.com");
   phoneNo.sendKeys("9876543210");
   
   schedule.click();
   takeScreenShotOnFailure();
   Alert alert = driver.switchTo().alert();
   System.out.println("!!! ALERT !!!\n"+alert.getText());
   
   
   logger.log(Status.PASS, "Corporate Wellness newtab opened");
   alert.accept();
   
   // Close the new window, if that window no more required
   driver.close();

   // Switch back to original browser (first window)
   driver.switchTo().window(winHandleBefore);

   // Continue with original browser (first window)
   driver.quit();
  } catch (Exception e) {
   reportFail(e.getMessage());
   
  }finally {
	  	flushReports();
  }
 
  /*CorporateWellness corporateWellness = new CorporateWellness(driver, logger);
  PageFactory.initElements(driver, corporateWellness);
  return corporateWellness ;*/
 
 }
 
}