package seliniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class Invaliduser {
	
	
	public static void main(String[] args) {
		
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Navigate to the application
		driver.get("https://facebook.com");
		//3) Enter an invalid username
		driver.findElementById("email").sendKeys("batman554466@gmail.com");
		// 4) Enter an invalid password
		driver.findElementById("pass").sendKeys("password");
		// 5) Click on Login button
		driver.findElementByName("login").click();
		// 6) Verify the error message 'Invalid username or password' is displayed.
		String expectedText = "Invalid username or password";
		String actualText = driver.findElementByCssSelector("#error_box > div:nth-child(2)").getText();
		if(expectedText.equals(actualText)) {
		System.out.println("Test Case Passed");
		}
		else {
		System.out.println("Test Case Failed");
		}
		//close the browser
		driver.quit();
	}

}
