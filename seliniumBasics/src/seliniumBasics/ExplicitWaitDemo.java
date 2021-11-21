package seliniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	
	public static void main(String[] args) 
	{
	//	1)open browser
	ChromeDriver driver = new ChromeDriver();
	//	2) Maximize the browser
	driver.manage().window().maximize();
	//	3) Navigate to application
	driver.get("https://whitecircleschool.com/explicit-wait-demo1/");
	//	4) Click on Start button
	driver.findElementById("start").click();
	//	5) Verify the text - Hello world!' appears on the page
	String expectedText = "Hello World!";
	// Explicit Wait
	WebDriverWait wait = new WebDriverWait (driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
	String actualText = driver.findElementByCssSelector("#finish > h4").getText();
	System.out.println("Text read from the page = " + actualText);
	if(expectedText.equals(actualText)) {
	System.out.println("Test Case Passed");
	}
	else {
	System.out.println("Test Case Failed");
	}
	//	8)close the browser
	driver.quit();

}
}

