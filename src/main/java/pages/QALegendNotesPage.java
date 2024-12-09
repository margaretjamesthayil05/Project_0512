package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class QALegendNotesPage {
	public WebDriver driver;
	private PageUtilities pageUtilities;
	private FileUploadUtility uploadFileUtility;
	
	@FindBy(xpath = "//a[@class = 'btn btn-default']")
	WebElement addNoteButton;
	@FindBy(id = "title")
	WebElement noteTitle;
	@FindBy(id = "description")
	WebElement noteDescription;
	@FindBy(id = "s2id_note_labels")
	WebElement noteLabel;
	@FindBy(xpath = "//button[@class ='btn btn-primary']")
	WebElement addNoteSaveButton;
	@FindBy(xpath = "//i[@class='fa fa-camera']")
	WebElement uploadFileButton;
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement tableNoteTitle;
	@FindBy(xpath = "//div[@id = 'note-table_filter']//descendant::input")
	WebElement noteSearchBox;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement editIcon;
	
	public QALegendNotesPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		this.uploadFileUtility = new FileUploadUtility();
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNoteButton() {
		addNoteButton.click();
	}
	
	public String getNoteTitle() {
		String noteTitle = tableNoteTitle.getText();
		return noteTitle;
	}
	
	public void searchNote(String noteName) {
		pageUtilities.enterTextIntoElement(noteSearchBox, noteName);
	}
	public void waitForSearchBox() {
		String modal = "ajaxModalContent";
		modal = "\"" + modal + "\"";
		System.out.println(modal);
		WaitUtility.waitForInVisibilityOfElement(driver, modal);
	}
	public String addNote(String title,String description) throws AWTException {
		pageUtilities.enterTextIntoElement(noteTitle, title);
		pageUtilities.enterTextIntoElement(noteDescription, description);
		pageUtilities.clickOnElement(noteLabel);
		pageUtilities.enterKeyPress();
		//uploadFileButton.click();
		//String path = System.getProperty("user.dir")+"\\Documents\\Selenium\\testFileUpload.jpeg";
		//uploadFileUtility.fileUploadUsingRobotClass(path);
		//uploadFileUtility.fileUploadForMac(path);
		pageUtilities.clickOnElement(addNoteSaveButton);
		return title;
		
	}
	public String editAddedItem(String newTitle,String newDescription) throws AWTException {
		pageUtilities.clickOnElement(editIcon);
		pageUtilities.clearElement(noteTitle);
		String updatedTitle = addNote(newTitle,newDescription);
		return updatedTitle;
	}
	public void clearSeachBox() {
		pageUtilities.clearElement(noteSearchBox);
	}
}
