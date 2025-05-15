package vtiger_genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method is used to maximize the browse
	 * 
	 * @param driver
	 */
	public void tomaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method is used to minimize the browse
	 * 
	 * @param driver
	 */

	public void tominimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait until the element got loaded in webpage
	 * 
	 * @param driver
	 * 
	 */
	public void toWaitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will to wait until the element element is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void toElementtobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method will wait until visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to handel dropdown by using index
	 * 
	 * @param element
	 * @param index
	 * 
	 */

	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * this method is used to handel dropdown by using value
	 * 
	 * @param element
	 * @param value
	 * 
	 */

	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * this method is used to handel dropdown by using visible text
	 * 
	 * @param element
	 * @param text
	 * 
	 */

	public void toHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		;
	}

	/**
	 * 3 ways to switch to another webpage
	 * 1
	 * this method is used to Switch driver control to frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * 2
	 * this method is used to Switch driver control to frame using id_name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);

	}

	/**
	 * 3
	 * this method is used to Switch driver control to frame using WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}
	/**
	 * switch back to the immediate parent
	 * to method is used to switch driver control back to the immediate parent
	 * @param driver
	 */
	public void toSwitchToImmidateParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * switch back to the Main page
	 * to method is used to switch driver control back to the Main page
	 * @param driver
	 */
	public void toSwitchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	* this method is used to perform move to element
	* @param driver
	* @param element
	*/
	public void toMouseHover(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	}
	/**
	* this method is used to perform right click provided webelemnet
	* @param driver
	* @param element
	*/
	public void toRightClick(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.contextClick(element).perform();
	}
	/**
	* this method is used to perform double click provided webelement
	* @param driver
	* @param element
	*/
	public void toDoubleClick(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.doubleClick(element).perform();
	}
	/**
	* this method is used to perform drag and drop
	* @param driver
	* @param element
	* @param target
	*/
	public void toDragandDrop(WebDriver driver, WebElement src, WebElement target) {
	Actions action = new Actions(driver);
	action.dragAndDrop(src, target).perform();
	}
	/**
	* this method is used to handle alert popUp by using accepting
	* @param driver
	*/
	public void toHandleAlertPopUpByAccepting(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	alert.accept();
	}
	/**
	* this method is used to handle alert popUp by using dismissing
	* @param driver
	*/
	public void toHandleAlertPopUpByDismissing(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	}
	/**
	* this method is used to capture the text present in Popup and accepting it
	* @param driver
	* @return
	*/
	public String toCaptureTextInAlert(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	String textinPopup = alert.getText();
	alert.accept();
	return textinPopup;
	}
	/**
	* this method is used to switch driver control to window provided with Title
	*
	* @param driver
	* @param partialwindowTitle
	*/
	public void toSwitchWindow(WebDriver driver, String partialwindowTitle) {
	Set<String> allWindowIds = driver.getWindowHandles();

	for(String id : allWindowIds ) {
	String windowTitle = driver.switchTo().window(id).getTitle();
	if(windowTitle.contains(partialwindowTitle)) {
	break;
	}
	 }
	}
	/**
	* this method is used to TakessScreenshot of entire webPage
	* @param driver
	* @param screenshotname
	* @throws IOException
	*/
	public String toTakeSceenshot(WebDriver driver, String screenshotname) throws IOException {
	TakesScreenshot ts =(TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File src = new File("./errorShots/" + screenshotname + ".png");
	FileHandler.copy(temp, src);
	
	return src.getAbsolutePath();
	}

}
