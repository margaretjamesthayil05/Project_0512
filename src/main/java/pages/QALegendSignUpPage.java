package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class QALegendSignUpPage {

	public WebDriver driver;
	private PageUtilities pageUtilities;

	@FindBy(id = "first_name")
	WebElement firstNameField;
	@FindBy(id = "last_name")
	WebElement lastNameField;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "retype_password")
	WebElement retypePasswordField;
	@FindBy(xpath = "//button[text()=\"Sign up\"]")
	WebElement signUpButton;
	//try for radio button
	//alert - Your account has been created successfully! 
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement SignInButton;
	
	public QALegendSignUpPage(WebDriver driver) {
		this.driver = driver;
		this.pageUtilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton() {
		WaitUtility.waitForVisibilityOfElement(driver, SignInButton);
		pageUtilities.clickOnElement(SignInButton);
	}
	
	public void clickOnSignUpBtn() {
		pageUtilities.scrollAndClickUsingJS(signUpButton);
	}
	
	public void waitForSignIn() {
		
	}
	public void enterSignUpDetails(String firstName,String lastname, String email,String password) {
		pageUtilities.enterTextIntoElement(firstNameField, firstName);
		pageUtilities.enterTextIntoElement(lastNameField, lastname);
		emailField.clear();
		pageUtilities.enterTextIntoElement(emailField, email);
		passwordField.clear();
		pageUtilities.enterTextIntoElement(passwordField, password);
		pageUtilities.enterTextIntoElement(retypePasswordField, password);
		
	}
}
