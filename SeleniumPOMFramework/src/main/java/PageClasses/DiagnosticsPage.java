package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class DiagnosticsPage extends PageBaseClass {

	public DiagnosticsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@class='u-text--center']/div[2]")
	List<WebElement> topCities;
	
	public String[] getTopCities() {
		
		String[] cities = new String[topCities.size()];
		for(int i=0;i<topCities.size();i++) {
			cities[i]=topCities.get(i).getText();
			
		}
		return cities;
	}
	 

}
