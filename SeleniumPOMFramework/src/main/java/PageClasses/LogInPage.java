package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LogInPage extends PageBaseClass
{

	public LogInPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement userId;
	
	public void enterUserId(String username) 
	{
		logger.log(Status.INFO, "Entering username");
		userId.sendKeys(username);
		logger.log(Status.PASS, "Entered username");
		
	}
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement pwd;
	
	public void enterPassword(String password)
	{
		logger.log(Status.INFO, "Entering password");
		pwd.sendKeys(password);
		logger.log(Status.PASS, "Entered password");
		
	}
	
	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement loginBtn;
	
	public LandingPage clickLogInBtn()
	{
		
		loginBtn.click();
		logger.log(Status.PASS, "clicked login button");
		LandingPage landingPage = new LandingPage(driver,logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
		
	}
	/****************** Do LogIn ***********************/
	public LandingPage doLogIn(String username,String password,LogInPage logInPage) 
	{
		
			logInPage.enterUserId(username);
			logInPage.enterPassword(password);
			return logInPage.clickLogInBtn();
		
		}
		
		

	}
	
	/*@FindBy(xpath = "//*[@id=\"facebookbtn\"]")
	WebElement loginWithFb;
	
	public LandingPage clickLogInBtnWithFb()
	{
		
		loginWithFb.click();
		logger.log(Status.PASS, "clicked login button");
		LandingPage landingPage = new LandingPage(driver,logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
		
	}*/

	

