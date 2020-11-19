package TestCases;

import org.testng.annotations.Test;

import PageClasses.DiagnosticsPage;
import PageClasses.LandingPage;
import baseClasses.BaseTestClass;
import utilities.ExcelData;

public class DiagnosticTest extends BaseTestClass {

	@Test(groups={"smoke"})
	public void topCitiesTest() throws Exception {
		logger = report.createTest("Getting name of top cities from Diagnostics  " );
		LandingPage landingPage = invokeLandingPage();
		DiagnosticsPage diagnosticsPage = landingPage.goToDiagnosticPage();
		String[] topCities = diagnosticsPage.getTopCities();
		for(String temp:topCities)
			System.out.println(temp);
		ExcelData.writeExcel(topCities,"topCities");
		diagnosticsPage.takeScreenShotOnFailure();
		flushReports();
	}
}
