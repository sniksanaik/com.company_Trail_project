package vtiger_ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_NewContact_Page {
	public Create_NewContact_Page(WebDriver driver) {
		PageFactory.initElements(driver,this  );
		}

		@FindBy(name = "lastname")
		private WebElement lastnameTextfield;

		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
	

		public WebElement getLastnameTextfield() {
		return lastnameTextfield;
		}

		public WebElement getSaveButton() {
		return saveButton;
		}
	
		
		
		
}
