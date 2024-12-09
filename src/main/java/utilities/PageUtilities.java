package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities {
	public WebDriver driver;
	
	public PageUtilities(WebDriver driver) { // chaining of object , here driver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnElement(WebElement element) {// also for checkbox , radiobutton
		element.click();
	}
	
	public void enterTextIntoElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void clearElement(WebElement element) {
		element.clear();
	}
	
	public void selectByVisibleText(WebElement dropDown,String visibleText) {
		Select drp = new Select(dropDown);
		drp.selectByVisibleText(visibleText);
	}

	public void selectByValue(WebElement dropDown,String value) {
		Select drp = new Select(dropDown);
		drp.selectByValue(value);
	}
	
	public void selectByIndex(WebElement dropDown,int index) {
		Select drp = new Select(dropDown);
		drp.selectByIndex(index);
	}
	
	public void dragAndDrop(WebElement source,WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	
	public void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void rightClickOnElement() {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();;
	}
	
	public void rightClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();;
	}
	
	public void doubleClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();;
		
	}
	
	public void scrollPageUsingJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void scrollPageUsingJS_0_250(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-250)");
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	//click using JsExec - hidden element . Is this correct ?
	public void findHiddenElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');",element);
	}
	
	public boolean isElementVisible(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public void enterKeyPress() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();	
	}
	
	public void controlKeyPress() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).build().perform();
	}
	
	public void controlKeyCommand() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.COMMAND).build().perform();
	}
	
	public void escKeyPress() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void shiftKeyPress() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SHIFT).build().perform();
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public void windowMinimize() {
		driver.manage().window().minimize();
	}
	
	public String getAlertMessage() {
		return driver.switchTo().alert().getText();
	}
	
	public void navigateTo(String URL) {
		driver.navigate().to(URL);
	}
	
	public void scrollAndClickUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		js.executeScript("arguments[0].click();", element);
	}
}
