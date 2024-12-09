package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtilities;
import utilities.WaitUtility;

public class QALegendClientPage {
	WebDriver driver;
	private PageUtilities pageUtilities;
	
	@FindBy(xpath = "//a[@class = 'btn btn-default']")
	WebElement addClientButton;
	@FindBy(id = "company_name")
	WebElement clientCompanyName;
	@FindBy(xpath = "//button[@class = 'btn btn-primary']")
	WebElement addClientSaveButton;
	@FindBy(xpath = "//div[@id = 'client-table_filter']//descendant::input")
	WebElement clientSearchBox;
	//identify the table firstrow element ?
	@FindBy(xpath = "(//tr[@class='odd'  or @class ='even']//descendant::a)[1]")
	WebElement tableClientCompany;
	////tr[@class='odd'  or @class ='even']//descendant::a[text()] -- to get all the company names -- insert it into array 
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement editIcon;
	@FindBy(xpath = "//div[@id='ajaxModal' and @style='display: none;']")
	WebElement modal_display_none;

	public QALegendClientPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddClientButton() {
		addClientButton.click();
	}
	
	public void searchClient(String clientData) throws InterruptedException {
		//WaitUtility.waitForAttributeTobe(driver, modal_display_none, "style", "display: none;");

//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));
//				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxModalContent")));
		pageUtilities.enterTextIntoElement(clientSearchBox, clientData);
	}
	public void waitForSearchBox() {
		String modal = "ajaxModalContent";
		modal = "\"" + modal + "\"";
		System.out.println(modal);
		WaitUtility.waitForInVisibilityOfElement(driver, modal);
	}
	
	public String getCompanyName() {
		return tableClientCompany.getText();
	}
	
	public String addClient(String companyName) {
		pageUtilities.enterTextIntoElement(clientCompanyName, companyName);
		pageUtilities.clickOnElement(addClientSaveButton);
		return companyName;
	}
	
	public String editClient(String newCompanyName) {
		pageUtilities.clickOnElement(editIcon);
		pageUtilities.clearElement(clientCompanyName);
		return addClient(newCompanyName);
	}
	
	public void clearSearchBox() {
		pageUtilities.clearElement(clientSearchBox);
	}
}
