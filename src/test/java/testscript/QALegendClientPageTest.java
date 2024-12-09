package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.FakerUtility;

public class QALegendClientPageTest extends Base{
	WebDriver driver;
	String companyName;
	
	@Test(priority=1)
	public void addClient() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnClientMenuButton();
		clientsPage.clickOnAddClientButton();
		companyName = clientsPage.addClient(properties.getProperty("CLIENT_COMPANYNAME")+FakerUtility.randomNumberGenerator());	
		clientsPage.waitForSearchBox();
		clientsPage.searchClient(companyName);
		Assert.assertEquals(clientsPage.getCompanyName(),companyName);
	}
	
	@Test(priority=2)
	public void editClient() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnClientMenuButton();
		clientsPage.searchClient(companyName);
		String newCompanyName = clientsPage.editClient(properties.getProperty("CLIENT_COMPANYNAME")+FakerUtility.randomNumberGenerator());	
		clientsPage.waitForSearchBox();
		clientsPage.clearSearchBox();
		clientsPage.searchClient(newCompanyName);
		Assert.assertEquals(clientsPage.getCompanyName(),newCompanyName);
	}

}
