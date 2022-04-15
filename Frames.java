package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		// Added Implicit Wait of 15 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Switch to Frame1
		driver.switchTo().frame("frame1");
		//Give value in the text field
		driver.findElement(By.xpath("//b[@id = 'topic']/following::input")).sendKeys("Frames");
		//Switch to Frame3
		driver.switchTo().frame("frame3");
		//Select the inner frame checkbox
		driver.findElement(By.id("a")).click();
		//Come out of the frames
		driver.switchTo().defaultContent();
		//Switch to Frame2
		driver.switchTo().frame("frame2");
		// Selected Baby Cat option value in select
		driver.findElement(By.xpath("//option[text() = 'Baby Cat']")).click();
		//Added a wait of 3s
		Thread.sleep(3000);
		//Close the browser
		driver.close();


	}

}
