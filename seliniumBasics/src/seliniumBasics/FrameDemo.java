package seliniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		
		
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window() .maximize();
		//3) Navigate to application
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//3.1 Go inside the frame which contains 'DEPRRcated' hyperlink
		driver.switchTo().frame("classFrame");
		//4)click on DEPRECATED hyperlink
		driver.findElementByLinkText("DEPRECATED").click();
	}

}
