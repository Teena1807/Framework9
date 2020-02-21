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
import com.training.pom.TeacherCreateCoursePOM;
import com.training.pom.TeacherCreateTestPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

import java.util.concurrent.TimeUnit;

public class Login_Course_test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM1 loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	private TeacherCreateTestPOM createTestPOM;
	private TeacherCreateCoursePOM createCorPOM;
	private AssessmentPOM assessPOM;
	private AssignmentPOM assignPOM;
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
		createTestPOM = new TeacherCreateTestPOM(driver);
		createCorPOM = new TeacherCreateCoursePOM(driver);
		assessPOM = new AssessmentPOM(driver);
		assignPOM = new AssignmentPOM(driver);
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
	@Test(enabled=false)
	public void clickrse() throws InterruptedException  {
	driver.findElement(By.xpath("//*[@id='page']/div/div[4]/div/div/div[2]/h4/a")).click();
	
	}
	@Test(priority=2)
	public void clickCreateCourse() throws InterruptedException  {
		createCorPOM.clickCreateCourse();	
		boolean Result1=GenericMethods.elementSelected(driver,"//*[text()='My courses']");
    	Assert.assertTrue(Result1);
	    System.out.println("Add Course");
		test.log(LogStatus.PASS, "Add Course page appeared");
	    screenShot.captureScreenShot("Add Course");
		
	    createCorPOM.sendCourseTitle("Selenium915");
	  	boolean Result2=gmethod.validateTextBox(driver,"id","title","Selenium915");
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
		
		createCorPOM.enterCode("Se2915");
		boolean Result4=gmethod.validateTextBox(driver,"id","add_course_wanted_code","Se2915");
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
	
	@Test(priority=3)
	public void clickCreateTest() throws InterruptedException  {
		createTestPOM.clickTestLink();
		boolean Result1=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[2]");
    	Assert.assertTrue(Result1);
	    System.out.println("Add Test");
		test.log(LogStatus.PASS, "Add Test page appeared");
	    screenShot.captureScreenShot("AddTest");
		
	    createTestPOM.clickCreateTestBttn();
	    boolean Result211=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[3]");
    	Assert.assertTrue(Result211);
	   	System.out.println("OnlineQuiz");
        test.log(LogStatus.PASS, "Execrcise Title Entered");
    	screenShot.captureScreenShot("ExeTitle");
    	
    	createTestPOM.sendTestname("Quiz");
    	boolean Result23=gmethod.validateTextBox(driver,"id","exercise_title","Quiz");
      	Assert.assertTrue(Result23);
        System.out.println("Test name Entered");
        test.log(LogStatus.PASS, "Test name Entered");
       screenShot.captureScreenShot("Test1");
      
       createTestPOM.clickAdvanceSettings();
       Thread.sleep(10000);
     	boolean Result43=GenericMethods.elementSelected(driver,"//*[@id='advanced_params']");
   	      Assert.assertTrue(Result43);
	    System.out.println("Addtional Settings appeared");
		test.log(LogStatus.PASS, "Addtional Settings appeared");
	    screenShot.captureScreenShot("AdvSettings");
	    
	       assignPOM.enterAssignText("online quiz");
		    Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
		    System.out.println("TextDisplayed");
	       test.log(LogStatus.PASS, "Assignment name Entered");
	   	screenShot.captureScreenShot("AssignmentName");
	   	
    	createTestPOM.clickFeedbackradio();
    	WebElement option1= driver.findElement(By.id("exerciseType_0"));
		option1.click();
		if (option1.isSelected())
		{
			System.out.println("Checkbox is selected");
		}
    	//WebElement Result4=gmethod.getElement("exerciseType_0","id");
    	//Assert.assertNotNull(Result4);
    	 System.out.println("Feedback Radio");
          test.log(LogStatus.PASS, "Feedback Radio");
      	screenShot.captureScreenShot("Feedback");
    	
      	createTestPOM.clickEnablestart();
    	//WebElement Result5=gmethod.getElement("start_time_alt_text","id");
    	WebElement Timebox= driver.findElement(By.id("start_time_alt_text"));
		
		if (Timebox.isDisplayed())
		{
			System.out.println("Time setup is selected");
		}
    	//Assert.assertNotNull(Result5);
    	 System.out.println("date setup");
          test.log(LogStatus.PASS, "date setup");
      	screenShot.captureScreenShot("date");
      	
      	createTestPOM.enterPassPer("50");
    	boolean Result6=gmethod.validateTextBox(driver,"id","pass_percentage","50");
      	Assert.assertTrue(Result6);
      	System.out.println("Pass %");
        test.log(LogStatus.PASS, "Pass Percentage Entered");
    	screenShot.captureScreenShot("Passper");
    	
    	createTestPOM.clickProceedrBttn();
    	WebElement Result7=gmethod.getElement("//*[@id='cm-content']/div/div[3]","xpath");
    	Assert.assertNotNull(Result7);
    	System.out.println("Proceed Button clicked");
        test.log(LogStatus.PASS, "Proceed Button clicked");
      	screenShot.captureScreenShot("Proceed");
    
      	createTestPOM.clickMultipleChoice();

      	WebElement Result8=gmethod.getElement("//*[@id='cm-content']/div/ul/li[4]","xpath");
    	Assert.assertNotNull(Result8);
    	System.out.println("Mutiple Choice clicked");
        test.log(LogStatus.PASS, "Mutiple Choice clicked");
      	screenShot.captureScreenShot("Multiple");
    
      	createTestPOM.sendQuestion1("which course your learning?");
    	boolean Result9=gmethod.validateTextBox(driver,"id","question_admin_form_questionName","which course your learning?");
      	Assert.assertTrue(Result9);
      	System.out.println("Question1");
        test.log(LogStatus.PASS, "Question1");
    	screenShot.captureScreenShot("Question1");
      	
    	            
    	
    	 createTestPOM.enterText1("selenium");
 	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
 	    System.out.println("Ans1 Displayed");
         test.log(LogStatus.PASS, "Ans1 Entered");
     	screenShot.captureScreenShot("Ans1");
     	
     	 createTestPOM.enterText2("java");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Ans2 Displayed");
          test.log(LogStatus.PASS, "Ans2 Entered");
      	screenShot.captureScreenShot("Ans2");
      	
      	createTestPOM.enterText3("C");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Ans3 Displayed");
          test.log(LogStatus.PASS, "Ans3 Entered");
      	screenShot.captureScreenShot("Ans3");
      	
      	createTestPOM.enterText4("C#");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Ans4 Displayed");
          test.log(LogStatus.PASS, "Ans4 Entered");
      	screenShot.captureScreenShot("Ans4");
      	
      	createTestPOM.clickFirstRadio();
     	WebElement Result10=gmethod.getElement("correct[1]","name");
    	Assert.assertNotNull(Result10);
    	System.out.println("First Answer Selected");
        test.log(LogStatus.PASS, "First Answer Selected");
      	screenShot.captureScreenShot("Ans1Selecetd");
      	
    	createTestPOM.clickSubmitQtn();
    	WebElement Result11=gmethod.getElement("//*[@id='cm-content']/div/div[3]","xpath");
    	Assert.assertNotNull(Result11);
    	System.out.println("Question1Added");
        test.log(LogStatus.PASS, "Question1Added");
      	screenShot.captureScreenShot("Ques1");
      	
      	createTestPOM.clickMultipleChoice();
      	WebElement Result12=gmethod.getElement("//*[@id='cm-content']/div/ul/li[4]","xpath");
    	Assert.assertNotNull(Result12);
    	System.out.println("Mutiple Choice clicked Again");
        test.log(LogStatus.PASS, "Mutiple Choice clicked Again");
      	screenShot.captureScreenShot("Multiple2");
      	
      	createTestPOM.sendQuestion1("which language are you using in selenium?");
    	boolean Result13=gmethod.validateTextBox(driver,"id","question_admin_form_questionName","which language are you using in selenium?");
      	Assert.assertTrue(Result13);
      	System.out.println("Question2");
        test.log(LogStatus.PASS, "Question2");
    	screenShot.captureScreenShot("Question2");
      	
    	 createTestPOM.enterText1("python");
 	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
 	    System.out.println("Q2Ans1 Displayed");
         test.log(LogStatus.PASS, "Q2Ans1 Entered");
     	screenShot.captureScreenShot("Q2Ans1");
     	
     	 createTestPOM.enterText2("java");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Q2Ans2 Displayed");
          test.log(LogStatus.PASS, "Q2Ans2 Entered");
      	screenShot.captureScreenShot("Q2Ans2");
      	
      	createTestPOM.enterText3("C");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Q2Ans3 Displayed");
          test.log(LogStatus.PASS, "Q2Ans3 Entered");
      	screenShot.captureScreenShot("Q2Ans3");
      	
      	createTestPOM.enterText4("C#");
  	  	Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
  	    System.out.println("Q4Ans4 Displayed");
          test.log(LogStatus.PASS, "Q4Ans4 Entered");
      	screenShot.captureScreenShot("Q4Ans4");
      	
      	createTestPOM.clickSecondRadio();
     	WebElement Result14=gmethod.getElement("correct[2]","name");
    	Assert.assertNotNull(Result14);
    	System.out.println("Second Answer Selected");
        test.log(LogStatus.PASS, "Second Answer Selected");
      	screenShot.captureScreenShot("Ans2Selecetd");
      	
      	createTestPOM.clickSubmitQtn();
    	WebElement Result15=gmethod.getElement("//*[@id='cm-content']/div/div[3]","xpath");
    	Assert.assertNotNull(Result15);
    	System.out.println("Question2Added");
        test.log(LogStatus.PASS, "Question2Added");
      	screenShot.captureScreenShot("Ques2");
      	
      	createTestPOM.clickPreviewBttn();
        WebElement Result16=gmethod.getElement("//*[@id='cm-content']/div/ul","xpath");
    	Assert.assertNotNull(Result16);
    	System.out.println("PreviewPage");
        test.log(LogStatus.PASS, "PreviewPage");
      	screenShot.captureScreenShot("PreviewPage");
      	
      	createTestPOM.clickStartTestBttn();
      	WebElement Result17=gmethod.getElement("//*[@id=\"cm-content\"]/div/ul/li[3]","xpath");
    	Assert.assertNotNull(Result17);
    	System.out.println("Question1appears");
        test.log(LogStatus.PASS, "Question1appears");
      	screenShot.captureScreenShot("Question1appears");
     
      	createTestPOM.clickAns1();
      	WebElement Result18=gmethod.getElement("//*[text()='selenium']","xpath");
    	Assert.assertNotNull(Result18);
    	System.out.println("Ans1Selected");
        test.log(LogStatus.PASS, "Ans1Selected");
      	screenShot.captureScreenShot("Ans1Selected");
      	
      	createTestPOM.clickNextButton();
      	WebElement Result19=gmethod.getElement("//*[@id='cm-content']/div/ul/li[3]","xpath");
    	Assert.assertNotNull(Result19);
    	System.out.println("NextQuestion");
        test.log(LogStatus.PASS, "NextQuestion");
      	screenShot.captureScreenShot("NextQuestion");
      	
      	createTestPOM.clickAns2();
      	WebElement Result20=gmethod.getElement("//*[text()='java']","xpath");
    	Assert.assertNotNull(Result20);
    	System.out.println("Ans2Selected");
        test.log(LogStatus.PASS, "Ans2Selected");
      	screenShot.captureScreenShot("Ans2Selected");
      	
      	createTestPOM.clickEndTest();
      	WebElement Result22=gmethod.getElement("//*[@id='cm-content']/div/ul/li[3]","xpath");
    	Assert.assertNotNull(Result22);
    	System.out.println("EndTest");
        test.log(LogStatus.PASS, "EndTest");
      	screenShot.captureScreenShot("EndTest");
      	
      	createTestPOM.clickBackToCourse();
	}
	
	@Test(priority=4)
	public void clickAssessment() throws InterruptedException  {
		assessPOM.clickAssessLink();
		boolean Result30=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[2]");
    	Assert.assertTrue(Result30);
	    System.out.println("Add Assessment");
		test.log(LogStatus.PASS, "Add Assessment page appeared");
	    screenShot.captureScreenShot("AddAssess");
		
	 
	    assessPOM.clickAddOnlineAct();
	    boolean Result31=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[3]");
    	Assert.assertTrue(Result31);
        System.out.println("OnlineQuiz");
        test.log(LogStatus.PASS, "Execrcise Title Entered");
    	screenShot.captureScreenShot("ExeTitle");
	
    	assessPOM.sendActivity("Tests");
        if(driver.findElement(By.xpath("//*[@id='create_link']/fieldset/div/div[1]/div/button/div/div/div")).isDisplayed());
		{
			System.out.println("Test displayed");
		}
		test.log(LogStatus.PASS, "Tests Selected ");
		screenShot.captureScreenShot("Ninth");
    	
		assessPOM.sendQuiz("online quiz");
        if(driver.findElement(By.xpath("//*[@id='add_link']/fieldset/div[1]/div[1]/div/button/div/div/div")).isDisplayed());
		{
			System.out.println("Quiz displayed");
		}
		test.log(LogStatus.PASS, "Quiz Selected ");
		screenShot.captureScreenShot("Quiz");
		
		
		assessPOM.sendWeightage("1");
		boolean Result32=gmethod.validateTextBox(driver,"id","weight_mask","1");
      	Assert.assertTrue(Result32);
        System.out.println("Weightage");
        test.log(LogStatus.PASS, "Weightage Entered ");
     	screenShot.captureScreenShot("Weightage");
     	
    	
    	assessPOM.clickVisible();
     	WebElement Result33=gmethod.getElement("visible","name");
    	Assert.assertNotNull(Result33);
    	System.out.println("Visible Selected");
        test.log(LogStatus.PASS, "Visible Selected");
      	screenShot.captureScreenShot("VisibleSelected");
      	
      	assessPOM.clickAddLearning();
        WebElement Result34=gmethod.getElement("//*[@id='cm-content']/div/div[3]/div/div","xpath");
    	Assert.assertNotNull(Result34);
    	System.out.println("AddLearningActivity");
        test.log(LogStatus.PASS, "AddedLearning Activity");
      	screenShot.captureScreenShot("AddLearningActivity");
      	
      	assessPOM.clickEditCtagory();
      	 WebElement Result35=gmethod.getElement("//*[@id='cm-content']/div/ul/li[3]","xpath");
     	Assert.assertNotNull(Result35);
     	System.out.println("EditCatagory");
         test.log(LogStatus.PASS, "EditCatagory");
       	screenShot.captureScreenShot("EditCatagory");
       	
       	assessPOM.clickEditCtagoryBtn();
        WebElement Result36=gmethod.getElement("//*[@id='cm-content']/div/div[3]/div/div","xpath");
     	Assert.assertNotNull(Result36);
     	System.out.println("CatagoryUpdated");
         test.log(LogStatus.PASS, "CatagoryUpdated");
       	screenShot.captureScreenShot("CatagoryUpdated");
       	
       	assessPOM.clickCertificate();
       	WebElement Result37=gmethod.getElement("//*[@id='cm-content']/div/ul/li[3]","xpath");
     	Assert.assertNotNull(Result37);
     	System.out.println("CertificatePage");
         test.log(LogStatus.PASS, "CertificatePage");
       	screenShot.captureScreenShot("CertificatePage");
     
    	createTestPOM.clickBackToCourse();
       		
}
	@Test(priority=5)
	public void createAssignment() throws InterruptedException  {
		
		assignPOM.clickAssessLink();
		boolean Result40=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/ul/li[2]");
    	Assert.assertTrue(Result40);
	    System.out.println("Add Assignment");
		test.log(LogStatus.PASS, "Add Assignment page appeared");
	    screenShot.captureScreenShot("AddAssign");
		
	    assignPOM.clickCreateAssignk();
	   	boolean Result41=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/div[3]/a[1]/img");
    	Assert.assertTrue(Result41);
        System.out.println("Assignment Page");
        test.log(LogStatus.PASS, "Assignment Page");
    	screenShot.captureScreenShot("AssignmentPage");
    	
        assignPOM.sendAssignName("hands on exercises");
        Thread.sleep(10000);
		boolean Result42=gmethod.validateTextBox(driver,"id","form1_new_dir","hands on exercises");
      	Assert.assertTrue(Result42);
        System.out.println("ExerciseName");
        test.log(LogStatus.PASS,"ExerciseName");
     	screenShot.captureScreenShot("ExerciseName");
     	
     	assignPOM.enterAssignText("exercise");
	    Assert.assertNotNull(driver.findElement(By.xpath("/html/body")));
	    System.out.println("TextDisplayed");
        test.log(LogStatus.PASS, "Assignment name Entered");
    	screenShot.captureScreenShot("AssignmentName");
    	
    	assignPOM.clickAdvanceSettings();
    	boolean Result43=GenericMethods.elementSelected(driver,"//*[@id='form1_qualification']");
    	Assert.assertTrue(Result43);
	    System.out.println("Addtional Settings appeared");
		test.log(LogStatus.PASS, "Addtional Settings appeared");
	    screenShot.captureScreenShot("AddSettings");
	    
	    assignPOM.enterMaxScore("50");
	    boolean Result44=gmethod.validateTextBox(driver,"id","form1_qualification","50");
      	Assert.assertTrue(Result44);
        System.out.println("MAxScore");
        test.log(LogStatus.PASS, "MAxScore Entered ");
     	screenShot.captureScreenShot("MAxScore");
     	
     	assignPOM.clickValidateBttn();
     	boolean Result45=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/div[3]");
    	Assert.assertTrue(Result45);
	    System.out.println("Directory Created");
		test.log(LogStatus.PASS, "Directory Created");
	    screenShot.captureScreenShot("DirectoyCreated");
     
	    assignPOM.clickCheckBox();
	    boolean Result46=GenericMethods.elementSelected(driver,"//*[@id='jqg_workList_142']");
    	Assert.assertTrue(Result46);
	    System.out.println("Checkbox Selecetd");
		test.log(LogStatus.PASS, "Checkbox Selecetd");
	    screenShot.captureScreenShot("CheckboxSelecetd");
		createTestPOM.clickBackToCourse();
}
}