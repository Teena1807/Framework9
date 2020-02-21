package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RateAssignmentPOM {
	private WebDriver driver; 
	
	public RateAssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='page']/div/div[2]/div/div/div[2]/h4/a")
	private WebElement ClickCourse; 
	
	@FindBy(xpath="//*[@id='istooldesc_13647']")
	private WebElement ClickAssignment; 
	
	
	@FindBy(xpath="//*[@id='146']/td[3]/a")
	private WebElement ClickExercise; 
	

	@FindBy(xpath="//*[@id='147']/td[7]/div/a[2]/img")
	private WebElement ClickCheck; 
	
	@FindBy(id="qualification")
	private WebElement score;
	
	@FindBy(xpath="/html/body")
	private WebElement textbox; 
	
	@FindBy(id="work_comment_button")
	private WebElement sendmsgBttn; 
	
	@FindBy(xpath="//*[@id='cm-content']/div/ul/li[2]")
	private WebElement Backtoassignment; 
	
	public void clickCourse() {
		this.ClickCourse.click(); 
	}
	
	public void clickAssignment() {
		this.ClickAssignment.click(); 
	}
	
	public void clickExercise() {
		this.ClickExercise.click(); 
	}
	
	public void clickCheck() {
		this.ClickCheck.click(); 
	}
	
	public void sendScore(String score) {
		this.score.clear();
		this.score.sendKeys(score);
	}
	
	public void enterQuizText(String textBox) {	
		driver.switchTo().frame(0);
		WebElement el  =  driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		this.textbox.sendKeys(textBox);
	}
	
	public void clickSendmsgBttn() {
		 driver.switchTo().defaultContent();
		this.sendmsgBttn.click();    
	}
	
	public void Backtoassignment() {
				this.Backtoassignment.click();    
	}
}
