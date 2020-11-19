package baseClasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.ConsultantPage;
import PageClasses.DiagnosticsPage;
import PageClasses.DoctorPage;
import PageClasses.LandingPage;
import PageClasses.PharmacyPage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.logger=logger;
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public ExtentTest logger;

	

	/****************** OpenApplication ***********************/
	public LandingPage OpenApplication() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get("https://www.practo.com/");
		logger.log(Status.PASS, "Successfully Opened the https://www.practo.com/");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	
	/****************** Accept Java Script Alert ***********************/
	public void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.log(Status.PASS, "Page Alert Accepted");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Cancel Java Script Alert ***********************/
	public void cancelAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();;
			logger.log(Status.PASS, "Page Alert Rejected");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Select value From DropDown ***********************/
	public void selectDropDownValue(WebElement webElement, String value){
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			logger.log(Status.PASS, "Selectd the Value : " + value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	
	/****************** Verify Element is Present ***********************/
	public void veriyElementIsDisplayed(WebElement webElement){
		try {
			if(webElement.isDisplayed()){
				reportPass("Password Box is Displayed");
			}else {
				reportFail("Password box is not appeared");
			}
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Get All Elements of DropDown ***********************/
	public List<WebElement> getAllElementsOfDropDown(WebElement webElement){
		try {
			Select select = new Select(webElement);
			List<WebElement> allElements = select.getOptions();
			return allElements;
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		 return null;
	}
	

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/******************Scroll Down************************/
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}




	@FindBy(xpath = "//*[@id=\'root\']/div/div/div[1]/div[1]/div[2]/div/div[1]/span/a/i")
	public WebElement homePageLink;
	public LandingPage goToHomePage()
	{
		logger.log(Status.INFO, "Clicking the Home-Page Link");
		homePageLink.click();
		logger.log(Status.PASS, "Clicked the Sing-Out Link");
		LandingPage landingPage = new LandingPage(driver,logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]")
	public WebElement doctorsLink;
	public DoctorPage goToDoctorPage()
	{
		logger.log(Status.INFO, "Clicking the Doctor-Page Link");
		doctorsLink.click();
		logger.log(Status.PASS, "Clicked the Doctor-Page Link");
		DoctorPage doctorPage = new DoctorPage(driver,logger);
		PageFactory.initElements(driver, doctorPage);
		return doctorPage;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/a/div[1]")
	public WebElement consultantLink;
	public ConsultantPage goToConsultantPage()
	{
		logger.log(Status.INFO, "Clicking the Consultant-Page Link");
		consultantLink.click();
		logger.log(Status.PASS, "Clicked the Consultant-Out Link");
		ConsultantPage consultantPage = new ConsultantPage(driver,logger);
		PageFactory.initElements(driver, consultantPage);
		return consultantPage;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[3]/a/div[1]")
	public WebElement pharmacyLink;
	public PharmacyPage goToPharmacyPage()
	{
		logger.log(Status.INFO, "Clicking the Pharmacy-Page Link");
		pharmacyLink.click();
		logger.log(Status.PASS, "Clicked the Pharmacy-Out Link");
		PharmacyPage pharmacyPage = new PharmacyPage(driver,logger);
		PageFactory.initElements(driver, pharmacyPage);
		return pharmacyPage;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[4]/a/div[1]")
	public WebElement diagnosticLink;
	public DiagnosticsPage goToDiagnosticPage()
	{
		logger.log(Status.INFO, "Clicking the Diagnostic-Page Link");
		diagnosticLink.click();
		logger.log(Status.PASS, "Clicked the Diagnostic-Out Link");
		DiagnosticsPage diagnosticPage = new DiagnosticsPage(driver,logger);
		PageFactory.initElements(driver, diagnosticPage);
		return diagnosticPage;
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/span[1]")
	public WebElement profile;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[3]/span/div/div[10]/a")
	public WebElement singoutLink;

	public LandingPage singOutApplication() {
		logger.log(Status.INFO, "Clicking the Profile Link");
		profile.click();
		logger.log(Status.PASS, "Clicked the Profile Link");
		logger.log(Status.INFO, "Clicking the Sing-Out Link");
		singoutLink.click();
		logger.log(Status.PASS, "Clicked the Sing-Out Link");
		LandingPage logoutPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, logoutPage);
		return logoutPage;
	}

}
