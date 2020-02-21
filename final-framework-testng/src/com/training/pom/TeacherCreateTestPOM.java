package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TeacherCreateTestPOM {
	private WebDriver driver; 
	
	public TeacherCreateTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Tests']")
	private WebElement Testlink; 
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement createTestBttn;
	
	@FindBy(id="exercise_title")
	private WebElement Testname; 
	
	@FindBy(id="advanced_params")
	private WebElement AdvanceSettings; 
	
	@FindBy(xpath="/html/body")
	private WebElement textBox; 

	@FindBy(id="exerciseType_0")
	private WebElement Feedbakradio1; 
	
	@FindBy(name="activate_start_date_check")
	private WebElement activatetime; 
	
	@FindBy(id="pass_percentage")
	private WebElement passpercentage; 
	
	@FindBy(id="exercise_admin_submitExercise")
	private WebElement proceedbttn; 
	
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[6]/div/ul/li[2]/div/a/img")
	private WebElement mutiplechoice; 
	
	@FindBy(id="question_admin_form_questionName")
	private WebElement question1; 
	
	@FindBy(xpath="/html/body")
	private WebElement option1; 
	
	@FindBy(xpath="/html/body")
	private WebElement option2; 
	
	@FindBy(xpath="/html/body")
	private WebElement option3; 
	
	@FindBy(xpath="/html/body")
	private WebElement option4; 
	
	@FindBy(name="correct[1]")
	private WebElement ans1; 
	
	@FindBy(name="correct[2]")
	private WebElement ans2; 
	
	@FindBy(id="submit-question")
	private WebElement submitqbttn; 
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[4]/a[2]/img")
	private WebElement preview; 
	
	@FindBy(xpath="//*[text()='Start test']")
	private WebElement startTest;
	
	@FindBy(xpath="//*[text()='selenium']")
	private WebElement choice1; 
	
	@FindBy(xpath="//*[text()='Next question']")
	private WebElement nextquestion;
	
	@FindBy(xpath="//*[text()='java']")
	private WebElement choice2; 
	
	@FindBy(name="save_now")
	private WebElement EndTest; 
	
	@FindBy(xpath="//*[@id='cm-content']/div/ul/li[1]/a")
	private WebElement backtocourse; 

	public void clickBackToCourse() {
		this.backtocourse.click();
	}
	
	
	public void clickTestLink() {
		this.Testlink.click();
	}
	
	public void clickCreateTestBttn() {
		this.createTestBttn.click();
	}
	
	public void sendTestname(String Testname) {
		this.Testname.clear(); 
		this.Testname.sendKeys(Testname); 
	}
	
	public void clickAdvanceSettings() {
		this.AdvanceSettings.click();
	}
	
	public void enterQuizText(String textBox) {	
		driver.switchTo().frame(0);
		WebElement el  =  driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		this.textBox.sendKeys(textBox);
	}
	
	public void clickFeedbackradio() {
		 driver.switchTo().defaultContent();
		this.Feedbakradio1.click();    
	}
	
	public void clickEnablestart() {
		this.activatetime.click();    
	}
	
	public void enterPassPer(String passpercentage) {
		this.passpercentage.clear(); 
		this.passpercentage.sendKeys(passpercentage); 
	}
	
	public void clickProceedrBttn() {
		this.proceedbttn.click();
	}
	
	public void clickMultipleChoice() {
		this.mutiplechoice.click();
	}
	
	public void sendQuestion1(String question1) {
		this.question1.clear(); 
		this.question1.sendKeys(question1); 
		
	
	    }
	    
	public void enterText1(String option1) {
	driver.switchTo().frame(1);
		WebElement el  =  driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		this.option1.sendKeys(option1);
	}
	
	public void enterText2(String option2) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(3);
			WebElement el  =  driver.switchTo().activeElement();
			new Actions(driver).moveToElement(el).perform();
			this.option2.sendKeys(option2);
		}
	public void enterText3(String option3) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(5);
			WebElement el  =  driver.switchTo().activeElement();
			new Actions(driver).moveToElement(el).perform();
			this.option3.sendKeys(option3);
		}
		
	public void enterText4(String option4) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(7);
			WebElement el  =  driver.switchTo().activeElement();
			new Actions(driver).moveToElement(el).perform();
			this.option4.sendKeys(option4);
		}
	
	public void clickFirstRadio() {
		  driver.switchTo().defaultContent();
		this.ans1.click();
	}
	
	public void clickSubmitQtn() {
		  driver.switchTo().defaultContent();
		this.submitqbttn.click();
	}
	
	public void clickSecondRadio() {
		  driver.switchTo().defaultContent();
		this.ans2.click();
	}
	
	public void clickPreviewBttn() {
		  driver.switchTo().defaultContent();
		this.preview.click();
	}
	
	public void clickStartTestBttn() {
		this.startTest.click();
	}
	
	public void clickAns1() {
		this.choice1.click();
	}
	
	public void clickNextButton() {
		this.nextquestion.click();
	}
	
	public void clickAns2() {
		this.choice2.click();
	}
	
	public void clickEndTest() {
		this.EndTest.click();
	}
}
