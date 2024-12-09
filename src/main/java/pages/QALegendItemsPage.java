package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class QALegendItemsPage {

	WebDriver driver;
	private PageUtilities pageUtilities;
	@FindBy(xpath = "(//i[@class='fa fa-plus-circle'])[2]")
	WebElement addItemButton;
	@FindBy(id = "title")
	WebElement itemTitle;
	@FindBy(xpath = "//button[@class = 'btn btn-primary']")
	WebElement itemSaveButton;
	@FindBy(id = "item_rate")
	WebElement itemRate;
	@FindBy(xpath = "//div[@id ='item-table_filter']//descendant::input")
	WebElement itemSearchBox;
	@FindBy(xpath = "(//tr[@class='odd' or @class ='even']//child::td[text()])[1]")
	WebElement itemTitleInTable;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement editIcon;
 
	public QALegendItemsPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddItemButton() {
		pageUtilities.clickOnElement(addItemButton);
	}
	public String addItem(String title, String rate) {
		pageUtilities.enterTextIntoElement(itemTitle, title);
		pageUtilities.enterTextIntoElement(itemRate, rate);
		pageUtilities.clickOnElement(itemSaveButton);
		return title;
	}
	public void searchItem(String itemData) {
		pageUtilities.enterTextIntoElement(itemSearchBox, itemData);
	}
	public void waitForSearchBox() {
		String modal = "ajaxModalContent";
		modal = "\"" + modal + "\"";
		System.out.println(modal);
		WaitUtility.waitForInVisibilityOfElement(driver, modal);
	}
	public String getTitleFromTable() {
		return itemTitleInTable.getText();
	}
	public String editAddedItem(String newTitle, String newRate) {
		pageUtilities.clickOnElement(editIcon);
		pageUtilities.clearElement(itemTitle);
		String updatedTitle = addItem(newTitle,newRate);
		return updatedTitle;
	}
	public void clearSeachBox() {
		pageUtilities.clearElement(itemSearchBox);
	}
}
