package vtiger_genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.LoginPage;

public class BaseClass {
PropertyfileUtility putil=new PropertyfileUtility();
WebDriverUtility wutil=new WebDriverUtility();
public WebDriver driver=null;
public static WebDriver sDriver;
@BeforeSuite(groups= {"smoke","Regression"})
public void beforesuitconfig() {
	Reporter.log("----Data connection established----", true);
}
//@Parameters("browsername")
//@BeforeTest
//comment 2 line  to do cross browser testing and and uncomment after test

//comment 2 line  to do cross browser testing and and uncomment after test

@BeforeClass(groups= {"smoke","Regression"})
            //beforeclassconfig(String BROWSER) ADD String BROWSER


public void beforeclassconfig(/*String BROWSER*/) throws IOException {
	String BROWSER=putil.toReadDataFromPropertyFile("browser");
	String URL=putil.toReadDataFromPropertyFile("url");
	
	
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("edge")) {
	driver=new EdgeDriver();
	}else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		}
	sDriver=driver;
	wutil.tomaximize(driver);
	Reporter.log("Browser got login----=========================------", true);
	
	wutil.toWaitForElement(driver);
	driver.get(URL);
}
	
@BeforeMethod(groups= {"smoke","Regression"})
public void beforemethodconfig() throws IOException {
	String USERNAME=putil.toReadDataFromPropertyFile("username");
	String PASSWORD=putil.toReadDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.getUsernameTextField().sendKeys(USERNAME);
	lp.getPasswordTextfield().sendKeys(PASSWORD);
	lp.getLoginbutton().click();
	Reporter.log("----Successfully login----------", true);
}

@AfterMethod(groups= {"smoke","Regression"})
public void afteremethodconfig() {
	
	HomePage hp=new HomePage(driver);
	wutil.toMouseHover(driver,hp.getLoginLink());//admistator logout link is named as login need to change
	hp.getSignoutLink().click();
	Reporter.log("----Logout Successfully ----------", true);
}
@AfterClass(groups= {"smoke","Regression"})
public void afterclassconfig() {
	Reporter.log("----Browser got closed -------============---", true);
	driver.quit();
}
@AfterSuite(groups= {"smoke","Regression"})
public void aftersuit() {
	Reporter.log("----Database disconnected ----------", true);
	
}

	
	
	
	
	

}
