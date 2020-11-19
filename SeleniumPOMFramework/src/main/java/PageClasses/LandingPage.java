package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;


public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[1]/div/input")
	public WebElement cityName;

	public void enterCity(String city) {
		logger.log(Status.INFO, "Entering city name");
		while(!cityName.getAttribute("value").equals(""))
			cityName.sendKeys(Keys.BACK_SPACE);
		
		//cityName.clear();
		cityName.sendKeys(city);
		waitLoad(3);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/span[1]/div")).click();
		
		logger.log(Status.PASS, "City name Entered");
		return ;
	}

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	public WebElement searchContext;

	public SearchPage enterSearchContext(String context) {
		logger.log(Status.INFO, "Entering search context");
		searchContext.clear();
		searchContext.sendKeys(context);
		waitLoad(3);
		logger.log(Status.PASS, "Search context entered");
		driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]")).click();
		SearchPage searchPage = new SearchPage(driver, logger);
		PageFactory.initElements(driver, searchPage);
		return searchPage ;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/a")
	public WebElement loginBtn;

	public LogInPage clickOnLoginBtn() {
		logger.log(Status.INFO, "Clicking on log in btn");
		loginBtn.click();
		
		logger.log(Status.PASS, "Clicked on log in btn");
		LogInPage loginPage = new LogInPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		return loginPage ;
	}
	
	@FindBy(linkText="Corporate Wellness")
	 public WebElement corporateWellness;
	public CorporateWellnessPage goToCorporateWllness() {
		//String winHandleBefore= driver.getWindowHandle();

		   // Perform the click operation that opens new window
		   corporateWellness.click();
		   logger.log(Status.INFO, "Switching to new tab");
		   waitLoad(3);
		   logger.log(Status.PASS, "Corporate Wellness newtab opened");
		   
		   // Switch to new window opened
		   for(String winHandle : driver.getWindowHandles()){
		      driver.switchTo().window(winHandle);
		   }
		   CorporateWellnessPage corporate = new CorporateWellnessPage(driver,logger);
		   PageFactory.initElements(driver, corporate);
			return corporate ;
	}

	
}
