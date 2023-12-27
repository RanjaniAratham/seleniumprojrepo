package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginoption;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailfield;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordfield;
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	
	
	public WebElement myAccountDropDown() {
		return myAccountDropDown;
	
	}
	
	public WebElement loginoption() {
		return loginoption;
		
	}
	
	public WebElement emailfield() {
		return emailfield;
		
	}
	
	public WebElement passwordfield() {
		return passwordfield;
		
	}
	
	public WebElement loginbutton() {
		return loginbutton;
		
	}
	
	

}
