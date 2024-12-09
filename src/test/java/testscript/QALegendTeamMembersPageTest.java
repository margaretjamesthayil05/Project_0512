package testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.FakerUtility;

public class QALegendTeamMembersPageTest extends Base{
	WebDriver driver;
	String password;
	String memberEmail;
	
	@Test(priority=1)
	public void addTeamMember() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnTeamMemberButton();
		teamMembersPage.clickOnAddMemberButton();
		memberEmail = properties.getProperty("TEAMMEMBER_EMAIL")+FakerUtility.randomNumberGenerator();
		String teamMemberName=teamMembersPage.enterMemberDetails(properties.getProperty("TEAMMEMBER_FNAME")+FakerUtility.randomNumberGenerator(), properties.getProperty("TEAMMEMBER_LNAME")+FakerUtility.randomNumberGenerator(), properties.getProperty("TEAMMEMBER_JOBTITLE")+FakerUtility.randomNumberGenerator(), memberEmail);
		//password = teamMembersPage.getGeneratedPassword();
		teamMembersPage.clickOnMemberSave();
		teamMembersPage.waitForSearchBox();
		teamMembersPage.seachMember(memberEmail);
		Assert.assertEquals(teamMembersPage.getteamMemberName(),teamMemberName);
	}
	
	@Test(priority=2)
	public void deleteTeamMember() throws InterruptedException {
		loginPage.LoginToQALegent(properties.getProperty("USERNAME"),properties.getProperty("PASSWORD"));
		homePage.clickOnTeamMemberButton();
		//teamMembersPage.seachMember(properties.getProperty("TEAMMEMBER_EMAIL"));
		teamMembersPage.waitForSearchBox();
		teamMembersPage.seachMember(memberEmail);
		teamMembersPage.deleteMember();
		Assert.assertEquals(teamMembersPage.isRecordFound(), "No record found.");
	}
}
