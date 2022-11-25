package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMclass;

public class POMLogin extends BaseHRMclass {
	
	@FindBy(name= "username")
	WebElement Username;
	
	@FindBy(name= "password")
	WebElement Password;
	
	@FindBy(xpath= "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbtn;
	
	
	public POMLogin()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void typeusername(String name)
	{
		Username.sendKeys(name);
	}
	
	public void typepassword (String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickbtn()
	{
		Loginbtn.click();
	}
	
	public String verify()
	{
		return driver.getTitle();
	}

}
