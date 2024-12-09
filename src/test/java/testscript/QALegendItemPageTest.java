package testscript;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.FakerUtility;

public class QALegendItemPageTest extends Base{
	WebDriver driver;
	String title;
	
	@Test(priority = 1)
	public void addItem() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnItemsMenuButton();
		itemsPage.clickOnAddItemButton();
		title = itemsPage.addItem(properties.getProperty("ITEM_TITLE")+FakerUtility.randomNumberGenerator(),properties.getProperty("ITEM_RATE")+FakerUtility.randomNumberGenerator());	
		itemsPage.waitForSearchBox();
		itemsPage.searchItem(title);
		Assert.assertEquals(itemsPage.getTitleFromTable(),title);
	}
	@Test(priority = 2)
	public void editItem() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnItemsMenuButton();
		itemsPage.searchItem(title);
		String newTitle = itemsPage.editAddedItem(properties.getProperty("ITEM_TITLE")+FakerUtility.randomNumberGenerator(),properties.getProperty("ITEM_RATE")+FakerUtility.randomNumberGenerator());	
		itemsPage.waitForSearchBox();
		itemsPage.clearSeachBox();
		itemsPage.searchItem(newTitle);
		Assert.assertEquals(itemsPage.getTitleFromTable(),newTitle);
	}
}
