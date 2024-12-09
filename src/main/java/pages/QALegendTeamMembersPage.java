package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class QALegendTeamMembersPage {

	public WebDriver driver;
	private PageUtilities pageUtilities;
	
	@FindBy(xpath = "//div[@id='team_member-table_filter']//descendant::input")
	WebElement memberSearchField;
	@FindBy(xpath = "//i[@class='fa fa-times fa-fw']")
	WebElement crossIcon;
	@FindBy(id = "confirmDeleteButton")
	WebElement confirmDeleteButton;
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement isFound; // if anything present then this element cannot be found.
	@FindBy(xpath = "(//i[@class='fa fa-plus-circle'])[2]")
	WebElement addMemberButton;
	@FindBy(id = "first_name")
	WebElement memberFirstName;
	@FindBy(id = "last_name")
	WebElement memberLastName;
	@FindBy(id = "form-next")
	WebElement nextButton;
	@FindBy(id = "job_title")
	WebElement jobTitleField;
	@FindBy(id = "email")
	WebElement memberEmail;
	@FindBy(id = "generate_password")
	WebElement generatePwdButton;
	@FindBy(id = "password")
	WebElement generatedPassword;
	@FindBy(id = "form-submit")
	WebElement memberSaveButton;
	@FindBy(xpath ="(//tr[@class ='odd' or @class='even']//descendant::a)[1]")
	WebElement tableTeamMembers;
	
	
	
	public QALegendTeamMembersPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	 public void seachMember(String memberEmailId) throws InterruptedException {
		pageUtilities.enterTextIntoElement(memberSearchField, memberEmailId);
	}
	 public void waitForSearchBox() {
			String modal = "ajaxModalContent";
			modal = "\"" + modal + "\"";
			System.out.println(modal);
			WaitUtility.waitForInVisibilityOfElement(driver, modal);
		}
	 public void deleteMember() throws InterruptedException {
		pageUtilities.clickOnElement(crossIcon);
		pageUtilities.clickOnElement(confirmDeleteButton);
	}
	 public String isRecordFound() {
		 System.out.println(isFound.getText());
		return isFound.getText();
	}
	 public void clickOnAddMemberButton() {
		 addMemberButton.click();
	}
	 public String enterMemberDetails(String firstName, String lastName, String jobTitle, String email) {
		 pageUtilities.enterTextIntoElement(memberFirstName, firstName);
		 pageUtilities.enterTextIntoElement(memberLastName, lastName);
		 nextButton.click();
		 pageUtilities.enterTextIntoElement(jobTitleField, jobTitle);
		 nextButton.click();
		 pageUtilities.enterTextIntoElement(memberEmail, email);
		 generatePwdButton.click();	 
		 String memberName = firstName+" "+lastName;
		 System.out.println(memberName);
		 return memberName;
	 }
	 public String getGeneratedPassword() {
		return generatedPassword.getText();
	}
	 public void clickOnMemberSave() {
		 memberSaveButton.click();
	}
	public String getteamMemberName() {
			return tableTeamMembers.getText();
	}
}
