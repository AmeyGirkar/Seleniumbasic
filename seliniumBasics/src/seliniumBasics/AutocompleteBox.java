package seliniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutocompleteBox {
	
	public static void main(String[] args) {
		// 1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		//2) Maximize it
		driver.manage().window() .maximize();
		// 3) Navigate to application
		driver.get("https://google.com");
		//4) Type 'mobile' in the search box
		driver.findElementByName("q").sendKeys("mobile");
		//4.1) Wait for all the items to appear in the auto-complete box
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions. visibilityOfElementLocated(By.xpath("(//ul[contains (@role, 'listbox')])[1]")));
		// 5) Select 4th item from the drop-down
		Actions actions = new Actions (driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
		sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ENTER).build().perform();
		}

}
