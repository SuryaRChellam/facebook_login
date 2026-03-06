package page_obj_modl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class fb_login extends base_page {
	
	public fb_login(WebDriver driver)
	
	{
		super(driver);
		
	}
	
	@FindBy(id ="email") 
	WebElement EmailFld;  
	
	@FindBy(id ="password") 
	WebElement PassFld;
	
	@FindBy(css = "button[type='submit']")
	WebElement LoginBtn;
	
	public void EmailFld(String email) {
        EmailFld.sendKeys(email);
    }

	public void PassFld(String password) {
	    PassFld.sendKeys(password);
	}
	
	public void Loginbtnclk() {
		LoginBtn.click();  

	}
	
	

}