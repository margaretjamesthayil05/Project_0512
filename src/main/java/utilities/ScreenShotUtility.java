package utilities;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShotUtility {
	public void captureFailedScreenshots(WebDriver driver,String name ) throws IOException {
		System.out.println("Inside captureFailedScreenshots");
		TakesScreenshot sShot = (TakesScreenshot)driver;
		File screenShot = sShot.getScreenshotAs(OutputType.FILE);
		File f1 = new File(System.getProperty("user.dir")+"//screenshot-output");
		if(!f1.exists()) {
			f1.mkdir();
		}
		File finalDestination = new File(System.getProperty("user.dir")+"//screenshot-output//"+name+".png");
		Files.copy(screenShot, finalDestination);
	}
}
