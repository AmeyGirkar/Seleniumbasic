package seliniumBasics;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingTabs {

	
	public static void main(String[] args) throws InterruptedException {
		// 1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window() .maximize();
		// 3) Navigate to application
		driver.get("https://www.facebook.com/");
		// 4) Click on Instagram
		driver.findElementByLinkText("Instagram").click();
		// 5) Shift focus on new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		//6) Enter email id on Instagram tab
		driver.findElementByName("username").sendKeys("abc@gmail.com");
		}

}
