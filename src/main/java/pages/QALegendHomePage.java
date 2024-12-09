package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QALegendHomePage {
	public WebDriver driver;
	PageUtilities pageUtilities;
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement notesMenuButton;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientMenuButton;
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsMenuButton;
	@FindBy(xpath = "//span[text()='Team members']")
	WebElement teamMembersMenuButton;

	public QALegendHomePage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNotesMenuButton() {
		pageUtilities.clickOnElement(notesMenuButton);
	}
	public void clickOnClientMenuButton() {
		pageUtilities.clickOnElement(clientMenuButton);
	}
	public void clickOnItemsMenuButton() {
		pageUtilities.clickOnElement(itemsMenuButton);
	}
	public void clickOnTeamMemberButton() {
		teamMembersMenuButton.click();
	}
}
