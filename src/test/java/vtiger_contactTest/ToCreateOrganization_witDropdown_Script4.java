package vtiger_contactTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import vtiger_ObjectRepository.Create_new_Organization;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.OrganizationPage;
import vtiger_ObjectRepository.Organization_Info_Page;
import vtiger_genericUtility.BaseClass;
import vtiger_genericUtility.ExcelFileUtility;


public class ToCreateOrganization_witDropdown_Script4 extends BaseClass {
	
@Test(groups = "Regression")
 public void tocCreateContactTest_001() throws EncryptedDocumentException, IOException {
	
	//to click on Organization link
	HomePage hp=new HomePage(driver);
	hp.getOrganizationsLink().click();
	
	//to click on create organizatio lookup image
	OrganizationPage op=new OrganizationPage(driver);
	op.getOrganizationLookupImageLink().click();
	
	//to fill in mandatory details
	ExcelFileUtility eutil=new ExcelFileUtility();
	String ORGNAME = eutil.toReadDataFromExcelFile("Organization", 1, 2);
	
	Random r=new Random();
	int random=r.nextInt(1000);
	Create_new_Organization cop= new Create_new_Organization(driver);
    cop.getCreateNewOrgLink().sendKeys(ORGNAME+random);
   
	cop.getCustomertypedropdown().click();
    cop.getChemicaldropdown().click();
    
    	cop.getSaveOrgButton().click();
	
	//to validate it
	
	Organization_Info_Page oip=new Organization_Info_Page(driver);
	String org_name = oip.getVerifylink().getText();
	
	Reporter.log(org_name, true);
	Reporter.log(ORGNAME, true);
	/*
	if(org_name.contains(ORGNAME)) {
		Reporter.log(org_name+ "--passed",true);
		}
	else{
		Reporter.log(org_name+ "--failed",true);
	}*/
	
	Assert.assertTrue(org_name.contains(ORGNAME));
	
	System.out.println("pass=======================================");
}


}
