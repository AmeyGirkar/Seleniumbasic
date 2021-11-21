package demoWithTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	

	WebDriver driver; //Declaring the object
	@BeforeTest
	@Parameters("browser")
	public void launchApplication(String browser) {
	// 1) Open the browser
	if(browser.equals("Chrome")) {
	driver = new ChromeDriver(); //Initializing the object
	}
	else if(browser.equals("Firefox")) {
	driver = new FirefoxDriver();
	}
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
	String actualText = driver.findElement(By.xpath("//h1[contains(@data-test-id,'hero__headline')]")).getText();
	Assert.assertEquals(actualText, expectedText);
	}
	// 5) Verify that Sign in btn is enabled
	@Test (priority=2,dependsOnMethods="titleVerification")
	public void verifySignInBtnIsEnabled() {
	boolean signInBtnStatus = driver. findElement(By.xpath("//button[contains(@type,submit)]")).isEnabled();
	Assert.assertTrue(signInBtnStatus);
	}
	
	@AfterTest
	public void closeBrowser() {
	driver.quit();
	}

}
