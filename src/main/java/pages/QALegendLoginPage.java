package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class QALegendLoginPage {
	public WebDriver driver;
	private PageUtilities pageUtilities;
	@FindBy(id = "email")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class ='btn btn-lg btn-primary btn-block mt15']")
	WebElement signInButton;
	@FindBy(xpath = "//span[@class='topbar-user-name']")
	WebElement userNameDisplay;
	@FindBy(xpath = "//span[text()='Authentication failed!']")
	WebElement authFailedAlert;
	//for QALegendSignUpPageTest
	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement loginSignUpButton;
	
	public QALegendLoginPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this); // when using pagefactory
	}
	
	public void LoginToQALegent(String username,String password) {
		pageUtilities.enterTextIntoElement(userNameField, username);
		pageUtilities.enterTextIntoElement(passwordField, password);
		pageUtilities.clickOnElement(signInButton);
	}
	
	public boolean isUserNameDisplayed() {
		return userNameDisplay.isDisplayed();
	}
	public boolean isAuthFailedAlertDisplayed() {
		return authFailedAlert.isDisplayed();
	}
	//for signup test
	 public void clickOnSignUpButton() {
		 loginSignUpButton.click();
	}
}
