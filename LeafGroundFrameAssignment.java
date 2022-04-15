package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrameAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {

		//Chrome Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Get the url and maximize the screen
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		// Added Implicit Wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Switch to 1st Frame
		driver.switchTo().frame(0);
		//Select Click Me button of 1st Frame
		driver.findElement(By.id("Click")).click();
		//Add a sleep of 3s
		Thread.sleep(3000);
		//Created a source file for screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		//Create an object for file with desired location
		File destination = new File("./snaps/screenshot.png");
		//Copy the image from source to destination
		FileUtils.copyFile(source, destination);
		//Come out of the Frame
		driver.switchTo().defaultContent();
		//Get the iframe tags using Find elements by tagname
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		//Print the Size
		System.out.println("Total No of Frames: " + totalFrames.size());
		//Close the browser
		driver.close();

	}

}
