package vtiger_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_new_Organization {
	public Create_new_Organization(WebDriver driver) {
		PageFactory.initElements(driver,this  );
	}
	
		@FindBy(name ="accountname")
		private WebElement createNewOrgLink;

		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveOrgButton;

		public WebElement getCreateNewOrgLink() {
		return createNewOrgLink;
		}

		public WebElement getSaveOrgButton() {
		return saveOrgButton;
		
		}
		
		
		@FindBy(name ="industry")
		private WebElement Chemicaldropdown;
		
		@FindBy(name="accounttype")
		private WebElement Customertypedropdown;


		public WebElement getChemicaldropdown() {
			return Chemicaldropdown;
		}

		public WebElement getCustomertypedropdown() {
			return Customertypedropdown;
		}
		
}
