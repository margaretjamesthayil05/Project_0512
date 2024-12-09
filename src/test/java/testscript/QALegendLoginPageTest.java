package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import utilities.ExcelUtility;


public class QALegendLoginPageTest extends Base{
	WebDriver driver;
	ExcelUtility excelUtility;
	
	@Test
	private void LoginTestSuccess() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, Constants.EXCELPATH, Constants.EXCELSHEET_SUCESS);
		int psd = ExcelUtility.getIntData(0, 1, Constants.EXCELPATH, Constants.EXCELSHEET_SUCESS);
		String password = Integer.toString(psd);
		loginPage.LoginToQALegent(username, password);
		Assert.assertEquals(loginPage.isUserNameDisplayed(),true);
	
	}

	@Test(dataProvider = "datafailure")
	private void LoginTestFailure(String username,String password) throws IOException {
		loginPage.LoginToQALegent(username, password);
		Assert.assertEquals(loginPage.isAuthFailedAlertDisplayed(),true);
	}
	@DataProvider(name = "datafailure")
	public Object[][] getUserDataFailure() throws IOException{
		int j=0,k=1;//we have only 2 columns both in excel and in data-provider with values 0 and 1
		 Object[][] array = new String[3][2];
		 for (int x = 0; x < 3; x++) { // Outer loop for rows for excel and 2D array
				String username = ExcelUtility.getStringData(x, j, Constants.EXCELPATH, Constants.EXCELSHEET_FAIL);
				int psd = ExcelUtility.getIntData(x, k, Constants.EXCELPATH, Constants.EXCELSHEET_FAIL);
				String password = Integer.toString(psd);
			     array[x][j] = username; 
			     array[x][k] = password;	       
		 }
		 return array;
	}
	
	/*@Test
	private void LoginTest() throws IOException {
		int j=0,k=1;
		 Object[][] array = new String[4][2];
		 for (int x = 0; x < 4; x++) { // Outer loop for rows
				String username = ExcelUtility.getStringData(x, j, "//src//main//resources//TestInputData.xlsx", "LoginInputs");
				int psd = ExcelUtility.getIntData(x, k, "//src//main//resources//TestInputData.xlsx", "LoginInputs");
				String password = Integer.toString(psd);
				System.out.println(username);
				System.out.println(password);
			     array[x][j] = username; // Assign value
			     array[x][k] = password;
			       
		 }
	        // Print 
	        System.out.println("2D String Array:");
	        for (int i = 0; i < 4; i++) {
	            for (int p = 0; p < 2; p++) {
	                System.out.print(array[i][p] + "\t"); 
	            }
	            System.out.println(); // Newline after each row
	        }
				
//				loginPage.LoginToQALegent(username, password);
//				loginPage.isUserNameDisplayed();
//				System.out.println(loginPage.isUserNameDisplayed());
				//Assert.assertEquals(loginPage.isUserNameDisplayed(),true);
	}*/
	

}
