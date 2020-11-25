package TestCases;

import org.testng.annotations.Test;

import PageClasses.LandingPage;
import PageClasses.SearchPage;
import baseClasses.BaseTestClass;
import utilities.ExcelData;

public class SearchHospitalTest extends BaseTestClass 
{
	String[] context = new String[2];
	
	@Test(groups={"smoke"})
	public void getHospitalsNmaes() throws Exception 
	{
		logger = report.createTest("Getting Hospitals name :" );
		LandingPage landingPage = invokeLandingPage();
		context = ExcelData.getCity("InputLogin");
		landingPage.enterCity(context[0]);
		SearchPage searchPage = landingPage.enterSearchContext(context[1]);
		searchPage.check247Box();
		searchPage.allFilter();
		searchPage.checkParking();
		searchPage.scrollDown();
		waitLoad(5);
		searchPage.takeScreenShotOnFailure();
		
		String[] hospitalList = searchPage.getHospitalList();
		for(String temp:hospitalList)
			System.out.println(temp);
		ExcelData.writeExcel(hospitalList,"hospitalList");
		flushReports();
		
	}

}
