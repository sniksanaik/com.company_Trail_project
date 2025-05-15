package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
		}
	@FindAll({@FindBy(xpath="//img[@title='Create Contact...']"),@FindBy(xpath = "//img[@alt='Create Contact...']")})
		private WebElement contactlookupimageLink;


		public WebElement getContactlookupimageLink() {
		return contactlookupimageLink;
		}
}
