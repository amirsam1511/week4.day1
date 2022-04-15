package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		// Added Implicit Wait of 15 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Added Username and password using id locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Submit using ClassName locator
		driver.findElement(By.className("decorativeSubmit")).click();
		//Select the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Select Contacts and Merge Contacts using path
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		//Selected Widget on From Contact
		driver.findElement(By.xpath("//input[@name = 'ComboBox_partyIdFrom']/following::a[1]")).click();
		//Get the windowHandles using set
		Set<String> windowHandles = driver.getWindowHandles();
		//Pass the set by adding an list
		List<String> listhandles = new ArrayList<String>(windowHandles);
		//Switched to list and get the new window
		driver.switchTo().window(listhandles.get(1));
		//Selected the First Resulting Contact Id
		driver.findElement(By.className("linktext")).click();
		// Switch back to old frame
		driver.switchTo().window(listhandles.get(0));
		//Selected Widget on To Contact
		driver.findElement(By.xpath("//input[@name = 'ComboBox_partyIdTo']/following::a[1]")).click();
		//Get the windowHandles using another set
		Set<String> windowHandle1 = driver.getWindowHandles();
		//Pass the set by adding an another list
		List<String> listhandle1 = new ArrayList<String>(windowHandle1);
		//Switched to list and get the new window
		driver.switchTo().window(listhandle1.get(1));
		Thread.sleep(3000);
		//Selected the Second Resulting Contact Id
		driver.findElement(By.xpath("(//div/table[@class='x-grid3-row-table']//tr/td[1]/div[1]/a)[2]")).click();
		// Switch back to old frame
		driver.switchTo().window(listhandle1.get(0));
		//Select Merge button
		driver.findElement(By.className("buttonDangerous")).click();
		//Switched to Alert and clicked OK
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//Get the title of the resulting page
		System.out.println(driver.getTitle());
		//Close the browser
		driver.close();
	}

}
