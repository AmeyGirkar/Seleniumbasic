package demoWithTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MutipleValidation {
	
	ChromeDriver driver; // Declaring the object


	@BeforeTest
	public void launchApplication() {
	//1) Open the browser
	driver = new ChromeDriver(); //Initializing the object
	//1.1) Maximize the browser
	driver.manage().window() .maximize();
	// 2) Navigate to the application
	driver.get("https://www.linkedin.com/");
}
	@Test(priority=0)
	public void titleVerification() {
	// 3) Verify title of the page is - 'LinkedIn: Log In or Sign Up
	String expectedTitle = "LinkedIn: Log In or Sign Up";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	//4) Verify the text - Welcome to your professional community - is present on the page
	@Test (priority=1)
	public void verifyText() {
	String expectedText = "Welcome to your professional community";
	String actualText = driver.findElementByCssSelector("#main-content > section.section.hero > div > h1").getText();
	Assert.assertEquals(actualText, expectedText);
	}
	// 5) Verify that Sign in btn is enabled
	@Test (priority=2,dependsOnMethods="titleVerification")
	public void verifySignInBtnIsEnabled() {
	boolean signInBtnStatus = driver. findElementByCssSelector("#main-content > section.section.hero > div > div > form > button").isEnabled();
	Assert.assertTrue(signInBtnStatus);
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.quit();
	}
	
}
