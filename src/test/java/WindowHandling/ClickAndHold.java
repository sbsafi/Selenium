package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAndHold {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement aElement = driver.findElement(By.xpath("//li[@name='A']"));
		WebElement lElement = driver.findElement(By.xpath("//li[@name='L']"));
//		Actions actions = new Actions(driver);
//		actions.clickAndHold(aElement).perform();
//		actions.moveToElement(lElement).perform();
		
		//how to perform composite actions?
		Actions actions = new Actions(driver);
		actions.clickAndHold(aElement).moveToElement(lElement).build().perform();
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
