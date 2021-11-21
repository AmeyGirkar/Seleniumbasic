package seliniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webtable {

	public static void main(String[] args) {
		
		//1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window() .maximize();
		//3) Navigate to application
		driver.get("https://www.bseindia.com/markets/debt/debt_corporate_EOD.aspx?curPage=1");
		//	4) Click on LIQUIDETF in the webtable
		//	4.1) Locate the table on webpage
	WebElement table = driver.findElementById("ContentPlaceHolder1_GridViewrcdsFC");
		//	4.2) create a list of all the rows taken from the table
	List<WebElement> rows = table.findElements(By.tagName("tr"));
		//	4.3) Pick one row at a time from the list
	boolean valueFound = false;
	for (int i = 1; i < rows.size(); i++) {
		WebElement row = rows.get(i);
		//4.4)Get all the values (td tags) from the row
		List<WebElement> columns = row.findElements(By.tagName("td"));
		// 4.5 Iterate through its cells (td tags) one by one
		for (WebElement x : columns) {
			if (x.getText().equals("LIQUIDETF")) {
				x.click();
				valueFound = true;
				break;
			}
		}
	if (valueFound == true) {
	break;
	}
	}

	}

}
