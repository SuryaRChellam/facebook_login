package test_Cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import page_obj_modl.fb_login;
import test_Base.base_class;

public class TC_Login1 extends base_class {
	private static final Logger log = LogManager.getLogger(TC_Login.class);
	@Test
	public void opnLoginpage() throws InterruptedException {
		
		log.info("********* Test Started: loginTest **********");
		log.info("Launching browser");

		fb_login fb_lp = new fb_login(driver);
		
		log.info("Entering username");
		fb_lp.EmailFld("suryachellam99@gmail.com");
		Thread.sleep(5000);
		
		log.info("Entering password");
		fb_lp.PassFld("Surya@1996");
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(10000);
		
		log.info("Clicking Login Button");
		fb_lp.Loginbtnclk();
		
		log.info("Successful Login");
		
	}


}
