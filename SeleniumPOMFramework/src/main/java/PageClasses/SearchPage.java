package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class SearchPage extends PageBaseClass {

	public SearchPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/div")
	WebElement checkBox247;
	
	public void check247Box()  {
		checkBox247.click();
		waitLoad(5);
		
	}
	
	@FindBy(xpath = "//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[4]/span/span")
	WebElement filter;
	
	public void allFilter() {
		filter.click();
	}
	

	@FindBy(xpath = "//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[2]/div/div/div/label[1]/div")
	WebElement parking;
	
	public void checkParking() {
		parking.click();
		waitLoad(5);
		
	}
	
	@FindBy(xpath = "//h2[@data-qa-id='hospital_name']")
	List<WebElement> hospitals;
	
	public String[] getHospitalList() 
	{
		String[] hospitalList = new String[hospitals.size()];
		for(int i=0;i<hospitals.size();i++) {
			hospitalList[i]=hospitals.get(i).getText();
		}
		return hospitalList;
		
	}
	
}
