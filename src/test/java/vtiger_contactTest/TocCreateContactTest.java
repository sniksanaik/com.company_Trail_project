package vtiger_contactTest;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger_ObjectRepository.ContactInformPage;
import vtiger_ObjectRepository.ContactPage;
import vtiger_ObjectRepository.Create_NewContact_Page;
import vtiger_ObjectRepository.HomePage;
import vtiger_genericUtility.BaseClass;
import vtiger_genericUtility.ExcelFileUtility;

@Listeners(vtiger_genericUtility.ListnersImplementation.class)//moniter//it should be write on top of class
public class TocCreateContactTest extends BaseClass {
	
@Test(groups = "smoke")
 public void tocCreateContactTest_001() throws EncryptedDocumentException, IOException {
	
	//to click on contacts link
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	
	//to click on create contact lookup image
	ContactPage cp=new ContactPage(driver);
	cp.getContactlookupimageLink().click();
	
	//to fill in mandatory details
	ExcelFileUtility eutil=new ExcelFileUtility();
	String LASTNAME = eutil.toReadDataFromExcelFile("Contacts", 1, 2);
	
	Create_NewContact_Page ccp= new Create_NewContact_Page(driver);
	ccp.getLastnameTextfield().sendKeys(LASTNAME);
	ccp.getSaveButton().click();
	//Assert.fail();//to forcefully fail the execution
	//to validate it
	ContactInformPage cip=new ContactInformPage(driver);
	String lastname = cip.getContactinformLink().getText();
	/*if(lastname.contains(LASTNAME)) {
		Reporter.log(lastname+ "--passed",true);
		}
	else{
		Reporter.log(lastname+ "--failed",true);
	}
	*/
	
	
	
	Assert.assertTrue(lastname.contains(LASTNAME));//to replace if 5 line code
	//written for to make fail the script and take screenshot
	//Assert.fail();
	System.out.println("Just testing");

	
}


}
