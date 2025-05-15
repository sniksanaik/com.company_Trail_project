package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Info_Page {
	public Organization_Info_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}

		@FindBy(xpath ="//span[@class='dvHeaderText']")
		private WebElement verifylink;

		public WebElement getVerifylink() {
			return verifylink;
		}

		
		
		
}
