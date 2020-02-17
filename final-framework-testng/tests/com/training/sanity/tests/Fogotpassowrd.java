package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.ForgotpwdPOM;
import com.training.pom.SignUpPOM;
//import com.training.pom.LoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//import Assertmethods.validateUrl;

//import Assertmethods.validateUrl;

public class Fogotpassowrd {

	private WebDriver driver;
	private String baseUrl;
	private ForgotpwdPOM forgotpwdPom;
	private static Properties properties;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println(System.getProperty("user.dir"));
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html");
	    test = report.startTest("ExtentDemo");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		forgotpwdPom = new ForgotpwdPOM(driver); 
		gmethod = new GenericMethods(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		report.endTest(test);
	    report.flush();
		driver.quit();
	}
	@Test
	public void forgotPwdTest() {
		forgotpwdPom.clickLostpwd();
	Boolean Result=	gmethod.isElementFound("//legend[text()='I lost my password']","xpath");
	Assert.assertTrue(Result);
	//System.out.println("Registraion Page exists");
	test.log(LogStatus.PASS, "Sign Up page Loaded Sucessfully");
	screenShot.captureScreenShot("First");
		
	forgotpwdPom.sendEmail("manzoor@gmail.com");
      	Boolean Result1=gmethod.validateTextBox(driver,"id","lost_password_user","manzoor@gmail.com");
    	Assert.assertTrue(Result1);
    //	System.out.println("Firstname exists");
    	test.log(LogStatus.PASS, "Email Entered");
    	screenShot.captureScreenShot("Second");
    	
		
    	forgotpwdPom.clickSendMsgBtn();
       
        boolean Result10=GenericMethods.elementSelected(driver,"//*[@class='alert alert-info']");
        Assert.assertTrue(Result10);
        System.out.println("User exists");
        test.log(LogStatus.PASS, "User Already Registered ");
        screenShot.captureScreenShot("Eleven");
    	
	}
	
		
		}
