package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
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
import com.training.pom.EditProfilePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM1;
import com.training.pom.TeacherCreateCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

import java.util.concurrent.TimeUnit;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM1 loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	private EditProfilePOM editprofile;
	private TeacherCreateCoursePOM createCorPOM;
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
		editprofile = new EditProfilePOM(driver);
		createCorPOM = new TeacherCreateCoursePOM(driver); 
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
	@Test(enabled=false)
	public void editProfileTest() {
		editprofile.editProfile();
		String expected= driver.getTitle();
		String Actual = "My Organization - My education - Profile";
	Assert.assertTrue(expected.equals(Actual));
	 System.out.println("TitleMatch");
	test.log(LogStatus.PASS, "Edit Profile page ");
 	screenShot.captureScreenShot("EditProfile1");
       
        editprofile.sendPassword("manzoor");
		boolean Result2=gmethod.validateTextBox(driver,"id","password1","manzoor");
      	Assert.assertTrue(Result2);
        System.out.println("Password");
        test.log(LogStatus.PASS, "Password Entered ");
     	screenShot.captureScreenShot("EditProfile2");
      	

        editprofile.sendNewPassword("manzoor");
		boolean Result3=gmethod.validateTextBox(driver,"id","profile_password2","manzoor");
      	Assert.assertTrue(Result3);
        System.out.println("new Password");
        test.log(LogStatus.PASS, "New Password");
     	screenShot.captureScreenShot("EditProfile3");
        
        editprofile.saveSetting();
		boolean Result4=GenericMethods.elementSelected(driver,"//div[@class='alert alert-info']");
    	Assert.assertTrue(Result4);
		
		    System.out.println("Saved");
		    test.log(LogStatus.PASS, "Saved");
		 	screenShot.captureScreenShot("EditProfile4");
	}
	@Test(priority=2)
	public void clickCreateCourse() throws InterruptedException  {
		createCorPOM.clickCreateCourse();	
		boolean Result1=GenericMethods.elementSelected(driver,"//*[text()='My courses']");
    	Assert.assertTrue(Result1);
	    System.out.println("Add Course");
		test.log(LogStatus.PASS, "Add Course page appeared");
	    screenShot.captureScreenShot("Add Course");
		
	    createCorPOM.sendCourseTitle("selenium");
	  	boolean Result2=gmethod.validateTextBox(driver,"id","title","selenium");
      	Assert.assertTrue(Result2);
        System.out.println("selenium");
        test.log(LogStatus.PASS, "Course Code Entered");
    	screenShot.captureScreenShot("CourseCode");
    	
    	createCorPOM.clickAdvanceSetting();
     	boolean Result3=GenericMethods.elementSelected(driver,"//*[@id='advanced_params_options']/div[1]/div[1]/div/button/div/div/div");
    	Assert.assertTrue(Result3);
	    System.out.println("Catagory,Course box appeared");
		test.log(LogStatus.PASS, "Course box appeared");
	    screenShot.captureScreenShot("Coursebox");
	    
	    createCorPOM.selectCourse("Projects");
	    if(driver.findElement(By.xpath("//*[@id='advanced_params_options']/div[1]/div[1]/div/button/div/div/div")).isDisplayed());
		{
		System.out.println("Projects displayed");
		}
		test.log(LogStatus.PASS, "Projects Didplayed ");
		screenShot.captureScreenShot("Projects");
		
		createCorPOM.enterCode("Se2907");
		boolean Result4=gmethod.validateTextBox(driver,"id","add_course_wanted_code","Se2907");
      	Assert.assertTrue(Result4);
        System.out.println("Code Displayed");
        test.log(LogStatus.PASS, "Code Entered");
    	screenShot.captureScreenShot("CourseCode");
    	
    	createCorPOM.selectLanguage("English");
    	if(driver.findElement(By.xpath("//*[@id='add_course_course_language']")).isDisplayed());
		{
		System.out.println("Language displayed");
		}
		test.log(LogStatus.PASS, "Language Displayed ");
		screenShot.captureScreenShot("Language");
		
		createCorPOM.clickCreateCorBttn();
		String expected= driver.getTitle();
		String Actual = "My Organization - My education - selenium";
	Assert.assertTrue(expected.equals(Actual));
		    System.out.println("Created Course");
		test.log(LogStatus.PASS, "Created Course page appeared");
	    screenShot.captureScreenShot("CreateCourse");
	    
	    createCorPOM.clickInstBttn();
	 Thread.sleep(10000);
	  //  driver.switchTo().parentFrame();
	   // boolean Result6=GenericMethods.elementSelected(driver,"//*[@id='introduction_text_intro_cmdUpdate']");
     	//Assert.assertTrue(Result6);
	  	 System.out.println("IFrame selected");
		test.log(LogStatus.PASS, "IFrame selected");
	    screenShot.captureScreenShot("IFrame");
	   
	    
	    createCorPOM.enterText("this is a selenium course");
	    Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
	  //  boolean Result7=gmethod.validateTextBox(driver,"xpath","/html/body","this is a selenium course");
      //	Assert.assertTrue(Result7);
	    Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
        System.out.println("Text Displayed");
        test.log(LogStatus.PASS, "Text Entered");
    	screenShot.captureScreenShot("Coursetext");
    	
    	createCorPOM.clickSaveBttn();
    	
    	WebElement Result7=gmethod.getElement("//*[@class='alert alert-success' and text()='Intro was updated']","xpath");
    	Assert.assertNotNull(Result7);
    	  System.out.println("Text Saved");
          test.log(LogStatus.PASS, "Text SAVED");
      	screenShot.captureScreenShot("SVAED");
	}
	

}
