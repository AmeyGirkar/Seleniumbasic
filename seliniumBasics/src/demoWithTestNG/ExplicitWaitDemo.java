package demoWithTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	ChromeDriver driver; // Declaring the object

	@BeforeTest
	public void launchApplication() {
		// 1) Open the browser
		driver = new ChromeDriver(); // Initializing the object
		// 1.1) Maximize the browser
		driver.manage().window().maximize();
	}

	@Test
	public void titleVerification() {
		// 3) Navigate to application
		driver.get("https://whitecircleschool.com/explicit-wait-demo1/");
		// 4) Click on Start button
		driver.findElementById("start").click();
		// 5) Verify the text - Hello world!' appears on the page
		String expectedText = "Hello World!";
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
		String actualText = driver.findElementByCssSelector("#finish > h4").getText();
		// System.out.println("Text read from the page = " + actualText);
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
