package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformPage {
	public ContactInformPage(WebDriver driver) {
		PageFactory.initElements(driver,this  );
		}

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement contactinformLink;

		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement loginLink;

		@FindBy(linkText = "Sign Out")
		private WebElement signoutLink;

		public WebElement getContactinformLink() {
		return contactinformLink;
		}

		public WebElement getLoginLink() {
		return loginLink;
		}

		public WebElement getSignoutLink() {
		return signoutLink;
		}
}
