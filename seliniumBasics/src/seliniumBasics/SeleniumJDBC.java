package seliniumBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1) Open the browser
		ChromeDriver driver = new ChromeDriver();
		// 2) Maximize it
		driver.manage().window().maximize();
		// 3) Navigate to application
		driver.get("https://amazon.in");
		// 4) Hover pointer over Hello Sign in menu
		WebElement helloSignIn = driver.findElementById("nav-link-accountList");
		Actions actions = new Actions(driver);
		actions.moveToElement(helloSignIn).build().perform();
		// 5) Click on Sign in button
		driver.findElementByLinkText("Sign in").click();
		// 6) Verify the text displayed on Sign in page matches to the text present in
		// DB
		String textFromwebpage = driver.findElementByXPath("//h1[contains(@class,'a-spacing-small')]").getText();
		// Retrieve info from DB
		String dburl = "jdbc:mysql://localhost: 3306/animatanimated_movies";
		String username = "root";
		String password = "root";
		String query = "select title from movies where director = 'Amey';";

		Class. forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dburl, username, password);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String textFromDB = null;
		while (rs.next()) {
			textFromDB = rs.getString("title");
		}
		// Compare D value and value from webpage!
		if (textFromwebpage.equals(textFromDB)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
	}

}
