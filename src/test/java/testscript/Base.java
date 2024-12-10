package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import pages.QALegendNotesPage;
import pages.QALegendSignUpPage;
import pages.QALegendTeamMembersPage;
import utilities.ScreenShotUtility;
import pages.QALegendClientPage;
import pages.QALegendHomePage;
import pages.QALegendItemsPage;
import pages.QALegendLoginPage;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	QALegendLoginPage loginPage;
	QALegendHomePage homePage;
	QALegendNotesPage notesPage;
	QALegendClientPage clientsPage;
	QALegendItemsPage itemsPage;
	QALegendSignUpPage signUpPage;
	QALegendTeamMembersPage teamMembersPage;
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void browserInitialization(String browserName) throws Exception {//browserName gets value now from @Parameters({"browser"})
		properties = new Properties();
		fis = new FileInputStream(Constants.CONFIGFILE);
		properties.load(fis);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			throw new Exception("InvalidNameException");
		}
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new QALegendLoginPage(driver);
		homePage = new QALegendHomePage(driver);
		notesPage = new QALegendNotesPage(driver);
		clientsPage = new QALegendClientPage(driver);
		itemsPage = new QALegendItemsPage(driver);
		signUpPage = new QALegendSignUpPage(driver);
		teamMembersPage = new QALegendTeamMembersPage(driver);
			
	}
	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {
		if(itResult.getStatus()==ITestResult.FAILURE) {
			ScreenShotUtility sc = new ScreenShotUtility();
			sc.captureFailedScreenshots(driver, itResult.getName());
		}
		if(driver!=null) {
			driver.quit();
		}
	}
}
