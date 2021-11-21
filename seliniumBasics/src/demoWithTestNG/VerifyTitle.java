package demoWithTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitle {
		ChromeDriver driver; //Declaring the object
		@BeforeTest
		public void launchApplication() {
		//1) Open the browser
		driver = new ChromeDriver(); //Initializing the object
		//1.1) Maximize the browser
		driver.manage().window() .maximize();
		// 2) Navigate to the application
		driver.get("https://www.linkedin.com/");
		}
		@Test
		public void titleVerification() {
		// 3) Verify title of the page is - 'LinkedIn: Log In or Sign Up
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		}
		@AfterTest
		public void closeBrowser() {
		driver.quit();
		}

}
