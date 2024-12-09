package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class FileUploadUtility {

	public void fileUploadUsingRobotClass(String path) throws AWTException {
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER); // to get enter key press in file explorer - file path
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL); // Cntrl+V
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void fileUploadForMac(String fileLocation) {
		//File Need to be imported
	    File file = new File(fileLocation);
	    StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
	    //Copy to clipboard
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    try {
	        Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_META);
	        robot.keyPress(KeyEvent.VK_W);
	        robot.keyRelease(KeyEvent.VK_META);
	        robot.keyRelease(KeyEvent.VK_W);
	        robot.keyPress(KeyEvent.VK_META);
	        robot.keyPress(KeyEvent.VK_SHIFT);
	        robot.keyPress(KeyEvent.VK_G);
	        robot.keyRelease(KeyEvent.VK_G);
	        robot.keyRelease(KeyEvent.VK_SHIFT);
	        robot.keyRelease(KeyEvent.VK_META);

	        // Paste the clipBoard content - Command ⌘ + V.
	        robot.keyPress(KeyEvent.VK_META);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_META);

	        // Press Enter (GO - To bring up the file.)
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.delay(1000 * 4);

	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	   
	}
}
