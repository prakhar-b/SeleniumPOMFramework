package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.LandingPage;
import PageClasses.LogInPage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import utilities.ExcelData;

public class LogInTest extends BaseTestClass {
	String[] num = new String[2];
	String[] num1 = new String[2];

	@Test(groups = { "smoke" })
	public void verifyLogInWithvalidCredentials() {
		logger = report.createTest("Login practo.com  ");

		LandingPage landingPage = invokeLandingPage();
		LogInPage logInPage = landingPage.clickOnLoginBtn();
		try {
			num = ExcelData.readExcel("InputLogin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logInPage.doLogIn("9386133185","Hackathon@321", logInPage).getTitle(
				"Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests");
		logInPage.takeScreenShotOnFailure();
		flushReports();

	}

	@Test(groups = { "regression" })
	public void verifyLogInWithInvalidCredentials() {
		try {
			num1 = ExcelData.readExcel1("InputLogin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger = report.createTest("Login practo.com  ");
		LandingPage landingPage = invokeLandingPage();
		LogInPage logInPage = landingPage.clickOnLoginBtn();
		waitLoad(8);
		logInPage.enterUserId(num1[0]);
		logInPage.enterPassword(num1[1]);

		PageBaseClass pagebaseClass = logInPage.clickLogInBtn();
		WebElement alertmsg = driver.findElement(By.xpath("//*[@id='usernameErrorBlock']"));
		try {
			pagebaseClass.takeScreenShotOnFailure();
			Assert.assertEquals(alertmsg.getText(), "Mobile Number / Email ID field cannot be empty");
			pagebaseClass.reportPass("Actual Text : " + alertmsg.getText() + " - equals to Expected Text : "
					+ "Mobile Number / Email ID field cannot be empty");
		} catch (Exception e) {
			pagebaseClass.reportFail(e.getMessage());
		} finally {
			flushReports();
		}

	}

}
