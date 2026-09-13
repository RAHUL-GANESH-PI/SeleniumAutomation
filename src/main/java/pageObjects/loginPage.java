package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='userEmail']")
	WebElement usrName;
	
	@FindBy(css="input[id='userPassword']")
	WebElement pwrd;
	
	@FindBy(css="input[id='login']")
	WebElement loginBtn;
	
	@FindBy(css="a.forgot-password-link")
	WebElement frgtPswrdBtn;
	
	@FindBy(css="input[formcontrolname='userEmail']")
	WebElement frgtPswrdEMail;
	
	@FindBy(css="input[id='userPassword']")
	WebElement frgtPswrdNwPswrd;
	
	@FindBy(css="input[id='confirmPassword")
	WebElement frgtPswrdconfirmPswrd;
	
	@FindBy(css="button.btn-block")
	WebElement frgtPswrdSavePswrdBtn;
	
	public void login(String userName,String password) {
		usrName.sendKeys(userName);
		pwrd.sendKeys(password);
		loginBtn.click();
	}
	
	public void forgotpwrd(String eMail, String newPassword, String confirmPswrd) {
		frgtPswrdBtn.click();
		frgtPswrdEMail.sendKeys(eMail);
		frgtPswrdNwPswrd.sendKeys(newPassword);
		frgtPswrdconfirmPswrd.sendKeys(confirmPswrd);
		frgtPswrdSavePswrdBtn.click();
	}
}
