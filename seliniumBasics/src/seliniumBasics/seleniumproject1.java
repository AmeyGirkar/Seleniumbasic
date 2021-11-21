package seliniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumproject1 {
	
	public static void main(String arg[]) {
		// 1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Navigate to the application
		driver.get("https://www.linkedin.com/");
		//3) Verify title of the page is - 'LinkedIn: Log In or Sign Up
		String expectedTitle = "LinkedIn: Log In or Sign Up";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
		System.out.println("Test Case Passed");
		}
		else {
		System.out.println("Test case Failed");
		}
		//4) Close the browser
		driver.quit();

}}
