package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.FakerUtility;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;


public class QALegendNotePageTest extends Base{
	public WebDriver driver;
	String noteTitle;
	
	@Test(priority = 1)
	public void addNote() throws AWTException, InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnNotesMenuButton();
		notesPage.clickOnAddNoteButton();
		noteTitle = notesPage.addNote(properties.getProperty("NOTE_TITLE")+FakerUtility.randomNumberGenerator(), properties.getProperty("NOTE_DESCRIPTION")+FakerUtility.randomNumberGenerator());
		notesPage.waitForSearchBox();
		notesPage.searchNote(noteTitle);
		Assert.assertEquals(notesPage.getNoteTitle(), noteTitle);
	}
	@Test(priority = 2)
	public void editItem() throws InterruptedException, AWTException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnNotesMenuButton();
		notesPage.searchNote(noteTitle);
		String newTitle = notesPage.editAddedItem(properties.getProperty("ITEM_TITLE")+FakerUtility.randomNumberGenerator(),properties.getProperty("ITEM_RATE")+FakerUtility.randomNumberGenerator());	
		notesPage.waitForSearchBox();
		notesPage.clearSeachBox();
		notesPage.searchNote(newTitle);
		Assert.assertEquals(notesPage.getNoteTitle(),newTitle);
	}
}
