package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {

		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		//Create an object for Chrome Driver
		ChromeDriver driver = new ChromeDriver();
		//Get the url  
		driver.get("https://www.nykaa.com/");
		//Maximize the screen
		driver.manage().window().maximize();
		// Added Implicit Wait of 15 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Created an pbject for actions class
		Actions action = new Actions(driver);
		//Get the value of brand
		WebElement brand = driver.findElement(By.xpath("//a[text() = 'brands']"));
		//Hover onto brand
		action.moveToElement(brand).perform();
		//Search as L'oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		//Select the entered value
		driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
		// Get the title of the page
		System.out.println(driver.getTitle());
		//Sort by popularity
		driver.findElement(By.xpath("//span[contains(text(),'popularity')]")).click();
		//Select the customer rated
		driver.findElement(By.xpath("//span[contains(text(),'customer')]")).click();
		//Select the category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		//Added a wait of 3 secs
		Thread.sleep(3000);
		//Selected Hair under Category
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		//Selected Hair Care under hair list
		driver.findElement(By.xpath("//span[contains(text(),'Care')]")).click();
		//Selected Shampoo under Hair care list
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		//Added a wait of 3 secs
		Thread.sleep(3000);
		//Selected the Concern filter
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		//Selected the Color Protection
		driver.findElement(By.xpath("//span[contains(text(),'Color')]")).click();
		// Checked the shampoo value in filter
		String text = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		// Printed the text of the filter value of shampoo
		System.out.println(text);
		//Compare the filter value as Shampoo or not using if
		if(text.equals("Shampoo")){
			System.out.println("Filter is applied with Shampoo");
		}
		//Select L'Oreal Paris Shampoo
		WebElement hoverShampoo = driver.findElement(By.xpath("//div[contains(text(),'Shampoo')]"));
		//Added a wait of 3 secs
		Thread.sleep(3000);
		//Hover on the shampoo and click it
		action.moveToElement(hoverShampoo).click().perform();
		//Get the 2nd window
		Set<String> windowHandles = driver.getWindowHandles();
		// Create a list and add set into it
		List<String> listHandles = new ArrayList<String>(windowHandles);
		//Get the window Handle
		String secondWindow = listHandles.get(1);
		//Switch to second window
		driver.switchTo().window(secondWindow);
		//Get the size of the product
		String text2 = driver.findElement(By.xpath("//option[text() = '175ml']")).getText();
		//Check if 175ml is selected
		if(text2.contains("175ml")) {
			System.out.println("175ml is already selected");
		}
		//Get the MRP of the product
		String text3 = driver.findElement(By.xpath("//span[text() = 'MRP:']/following::span[1]")).getText().substring(1);
		//Print the MRP
		System.out.println("MRP is" + text3);
		//Click the Add Bag button
		driver.findElement(By.xpath("//span[contains(text(),'BAG')]")).click();
		//Click the added cart
		driver.findElement(By.xpath("//span[@class = 'cart-count']")).click();
		//Switch to 1st Frame
		driver.switchTo().frame(0);
		//Get the Grand Total text value
		String text4 = driver.findElement(By.xpath("//span[text() = 'Grand Total']/following::div[1]")).getText().substring(1);
		//Print the Grand total value
		System.out.println("Grand Total is" + text4);
		//Click Proceed button
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		//Get out of the frame
		driver.switchTo().defaultContent();
		//Click Continue as Guest
		driver.findElement(By.xpath("//button[contains(@class,'full big')]")).click();
		//Get the Grand Total text value
		String text5 = driver.findElement(By.xpath("//div[text() = 'Grand Total']/following::div[1]")).getText().substring(1);
		//Print the Grand total value
		System.out.println("Grand Total in checkout is" + text5);
		//Compare the Grand Total is same using if-else condition
		if(text5.equals(text4)) {
			System.out.println("Grand Total is same");
		}
		else {
			System.out.println("Grand Total is not same");
		}
		//Close all the browsers
		driver.quit();

	}

}
