package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TeacherCreateCoursePOM {
	private WebDriver driver; 
	
	public TeacherCreateCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Create a course']")
	private WebElement createCourse; 
	
	@FindBy(id="title")
	private WebElement courseName;
	
	@FindBy(id="advanced_params")
	private WebElement advSettingBtn; 
	
	@FindBy(xpath="//*[@id='advanced_params_options']/div[1]/div[1]/div/button/div/div/div")
	private WebElement Category; 

	@FindBy(id="add_course_wanted_code")
	private WebElement Code; 
	
	@FindBy(id="add_course_course_language")
	private WebElement language; 
	
	@FindBy(id="add_course_submit")
	private WebElement createCoursebttn; 
	
	@FindBy(xpath="//*[@id='course_tools']/div[1]/div/div[1]/a")
	private WebElement instbttn; 
	
	@FindBy(xpath="/html/body")
	private WebElement textBox; 
	
	@FindBy(id="introduction_text_intro_cmdUpdate")
	private WebElement savebttn; 
	
	public void clickCreateCourse() {
		this.createCourse.click();
	}
	
	public void sendCourseTitle(String courseName) {
		this.courseName.clear(); 
		this.courseName.sendKeys(courseName); 
	}
	
	public void clickAdvanceSetting() {
		this.advSettingBtn.click();
	}
	public void selectCourse(String Category) {
		Actions builder = new Actions(driver);
		WebElement dropdown= this.Category;
		Actions dpdn= builder.moveToElement(dropdown).click().sendKeys(Category).sendKeys(Keys.ENTER);
		dpdn.build().perform();     
        
		// Select cat = new Select(this.Category);
	      // cat.selectByVisibleText(Category);
	}
	public void enterCode(String Code) {
		this.Code.clear(); 
		this.Code.sendKeys(Code); 
	}
	
	public void selectLanguage(String language) {
		 Select lan = new Select(this.language);
	       lan.selectByVisibleText(language);
	}
	
	public void clickCreateCorBttn() {
		this.createCoursebttn.click();
	}
	
	public void clickInstBttn() {
		this.instbttn.click();
	}
	public void enterText(String textBox) {
		
	
		driver.switchTo().frame(0);
		WebElement el  =  driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		this.textBox.sendKeys(textBox);
	}
	
	public void clickSaveBttn() {
		  driver.switchTo().defaultContent();
		this.savebttn.click();
	}
	
}
