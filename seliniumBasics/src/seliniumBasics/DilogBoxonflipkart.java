package seliniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DilogBoxonflipkart {

	public static void main(String[] args) {
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window() .maximize();
		//3) Navigate to application
		driver.get("https://www.flipkart.com/");
driver.findElementByXPath("(//input[contains(@type,'text')])[2]").sendKeys("abc@gmail.com");
		
		//	5) Enter password - password 
		driver.findElementByXPath("//input[contains(@type,'password')]").sendKeys("password");
		
		//	6) Click Login button
		driver.findElementByXPath("(//button[contains(@type,'submit')])[2]").click();
		
		//	7) Verify toast message displays the text - 'You are not registered with us. Please Sign up.'
		String expectedMessage = "You are not registered with us. Please sign up.";
		

		//7.1 Wait for toast message to appear
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions. visibilityOfElementLocated(By.xpath ("//div[text()='You are not registered with us. Please sign up.']")));
		
		String actualMessage = driver.findElementByXPath("//div[text()='You are not registered with us. Please sign up.']").getText();
		
		if(expectedMessage.equals(actualMessage)) {
			System.out.println("Test cAse passed");
		}
		
		else {
			System.out.println("Test Case failed");
		}
		
	
		
		
		
		
	}

}
