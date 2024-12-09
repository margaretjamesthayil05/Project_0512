package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.FakerUtility;

public class QALegendSignUpPageTest extends Base{
	WebDriver driver;
	@Test
	public void SignUp() throws InterruptedException {
		loginPage.clickOnSignUpButton();
		String email = properties.getProperty("SIGNUP_EMAIL")+FakerUtility.randomNumberGenerator();
		String password =  properties.getProperty("SIGNUP_PASSWORD")+FakerUtility.randomNumberGenerator();
		signUpPage.enterSignUpDetails(properties.getProperty("SIGNUP_FIRSTNAME")+FakerUtility.randomNumberGenerator(), properties.getProperty("SIGNUP_LASTNAME")+FakerUtility.randomNumberGenerator(), email,password);
		signUpPage.clickOnSignUpBtn();
		//Thread.sleep(4000);
		signUpPage.clickOnSignInButton();
		loginPage.LoginToQALegent(email,password);
		Assert.assertEquals(loginPage.isUserNameDisplayed(),true);
	}
}
