package seliniumBasics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AmazonProject {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String Category = null;
		String Searchval = null;
		// 0)open Browser in incognito mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("−−incognito");

		// 1) Open the browse
		ChromeDriver driver = new ChromeDriver();

		// 2) Maximize the browser
		driver.manage().window().maximize();

		// 3) Navigate to web Application
		driver.get("https://amazon.in/");

		// 3.1)Adding ImplicitWait of 5 sec to load full website
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// 4)JDBC Setup for Amazon Database

		try {

			String dburl = "jdbc:mysql://localhost:3306/amazondetails";
			String username = "root";
			String password = "root";
			String query = "select * from Amazon where Category ='Electronics';";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, username, password);
			// System.out.println("connection established");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getString("Category") + " \t " + rs.getString("Searchval"));
				Category = rs.getString("Category");
				Searchval = rs.getString("Searchval");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");

		} catch (SQLException e) {
			System.out.println("Sql Exception");

		}

		// 5) Selecting category of product which is stored in Database

		WebElement SearchCategory = driver.findElement(By.xpath("//select[contains(@name,url)]"));
		Select selectOption = new Select(SearchCategory);
		selectOption.selectByVisibleText(Category);

		// 6) Entering the search appearance in Search Box & Entering Search from From  DB
		driver.findElementById("twotabsearchtextbox").sendKeys(Searchval);

		// 7) Clicking On Search Button
		driver.findElementById("nav-search-submit-button").click();

		// 8) Getting all Search Appearance Data , Total No of Data and Details of Data

		List<WebElement> getData = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		System.out.println("No of Results : " + getData.size());
		// 9)store data into Amazondetails database
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://Localhost:3306/amazondetails","root","root");
		

			for (WebElement e : getData) {
				String line = e.getText();
				line = line.replace("(", ": (");
				line =line.replace("'","");
				String[] arrOfStr = line.split(":");
				// System.out.println(Arrays.toString(arrOfStr));
				String Model = arrOfStr[0];
				String Spec = arrOfStr[1];
			
				//String query = "insert into electronics value('"+Model+"' ,'"+Spec+"');";
				String query = "insert into "+Category+" value('"+Model+"' ,'"+Spec+"');";

				//System.out.println(query);
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.execute();
				
				
				System.out.print("Model\t" + Model + "\n");
				System.out.print("Specification\t" + Spec + "\n");
				System.out.println("==============================================================================================================");
				
				
			}
		

		// 10)close connection;
		con.close();

		// 9) Close The Browser
		driver.close();

	}

}
