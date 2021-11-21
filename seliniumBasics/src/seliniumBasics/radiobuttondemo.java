package seliniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class radiobuttondemo {
	
	public static void main(String[] args) throws InterruptedException {
		//	1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		//	2) Maximize it
		driver.manage().window() .maximize();
		//	3) Navigate to application
		driver.get("https://facebook.com");
		Thread. sleep(2000);
		//	4) Click on 'Create New Account' btn
		driver.findElementByLinkText("Create New Account").click();
		Thread.sleep(2000);
		//	4.1) Verify that 'Custom' button is not selected by default
		boolean customBtnStatus = driver.findElementByXPath("(//input[contains (@type, 'radio')])[3]").isSelected();
		if(customBtnStatus == false) {
			System.out.println("Custome btn is not selected by default");
		}
		else{
			System.out.println("Custom btn is selected by default");
		}
		//	5) Select 'Male' radio button
		driver.findElementByXPath("(//input[contains (@type, 'radio')]) [2]").click();
		
		//	6)close the browser
		driver.quit();
		}

}
