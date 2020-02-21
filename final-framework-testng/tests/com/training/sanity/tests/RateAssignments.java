package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AssessmentPOM;
import com.training.pom.AssignmentPOM;
import com.training.pom.EditProfilePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM1;
import com.training.pom.RateAssignmentPOM;
import com.training.pom.TeacherCreateCoursePOM;
import com.training.pom.TeacherCreateTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

import java.util.concurrent.TimeUnit;

public class RateAssignments {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM1 loginPOM;
	private RateAssignmentPOM rateassignPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	
	//private static WaitTypes wtypes;

	/*@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		
	}*/

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM1(driver); 
		rateassignPOM = new RateAssignmentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		gmethod = new GenericMethods(driver);
		
		// open the browser 
		driver.get(baseUrl);
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html");
	    test = report.startTest("ExtentDemo");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		report.endTest(test);
	    report.flush();
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.sendUserName("manzoor1118");
		boolean Result1=gmethod.validateTextBox(driver,"id","login","manzoor1118");
      	Assert.assertTrue(Result1);
        System.out.println("Username exists");
        test.log(LogStatus.PASS, "Username Entered");
   screenShot.captureScreenShot("Login1");
      	
      	
		loginPOM.sendPassword("manzoor");
		boolean Result2=gmethod.validateTextBox(driver,"id","password","manzoor");
      	Assert.assertTrue(Result2);
        System.out.println("Password");
       test.log(LogStatus.PASS, "Password Entered");
    	screenShot.captureScreenShot("Login2");
      	
		loginPOM.clickLoginBtn(); 
		String expected= driver.getTitle();
		String Actual = "My Organization - My education - My courses";
	Assert.assertTrue(expected.equals(Actual));
	 System.out.println("LoginSucessful");
	test.log(LogStatus.PASS, "LoginSucessful");
 	screenShot.captureScreenShot("Login");
       
	}
	@Test(priority=2)
	public void validRateAssignment() throws InterruptedException {   
		rateassignPOM.clickCourse();
		boolean Result50=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li/a");
    	Assert.assertTrue(Result50);
	    System.out.println("Click Course");
		test.log(LogStatus.PASS, "Course page appeared");
	    screenShot.captureScreenShot("Course");
	    
	    rateassignPOM.clickAssignment();
	    boolean Result51=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[2]");
    	Assert.assertTrue(Result51);
	    System.out.println("Click Assignment");
		test.log(LogStatus.PASS, "Assignment page appeared");
	    screenShot.captureScreenShot("Assignment");
	    
	    rateassignPOM.clickExercise();
	    boolean Result52=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[3]");
    	Assert.assertTrue(Result52);
	    System.out.println("Click Exercise");
		test.log(LogStatus.PASS, "Exercise page appeared");
	    screenShot.captureScreenShot("Exercise");
	    
	    rateassignPOM.clickCheck();
	    boolean Result53=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[5]");
    	Assert.assertTrue(Result53);
	    System.out.println("Click Add Course");
		test.log(LogStatus.PASS, "Course page appeared");
	    screenShot.captureScreenShot("Course");
	    
	    rateassignPOM.sendScore("40");
	    Thread.sleep(10000);
		boolean Result54=gmethod.validateTextBox(driver,"id","qualification","40");
      	Assert.assertTrue(Result54);
        System.out.println("Score");
       test.log(LogStatus.PASS, "Score Entered");
    	screenShot.captureScreenShot("Score");
    	
    	 
    	 rateassignPOM.enterQuizText("Scored Entered");
		    Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
		    System.out.println("TextDisplayed");
	       test.log(LogStatus.PASS, "Assignment Score Entered");
	   	screenShot.captureScreenShot("AssignmentScore");
	   	
	   	rateassignPOM.clickSendmsgBttn();
	    boolean Result55=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/div[3]/div/div[3]");
    	Assert.assertTrue(Result55);
	    System.out.println("Comment Updated");
		test.log(LogStatus.PASS, "Updated appeared");
	    screenShot.captureScreenShot("Updated");
	    
	    rateassignPOM.Backtoassignment();
	}
}