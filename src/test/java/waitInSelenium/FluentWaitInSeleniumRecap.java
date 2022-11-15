package waitInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitInSeleniumRecap {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Fluent Wait looks for a web element repeatedly at regular intervals until timeout happens or until 
		//the object is found. before throwing the “ElementNotVisibleException”.
		//Fluent Wait commands are most useful when interacting with web elements 
		//that can take longer durations to load. This is something that often occurs in Ajax applications.
		WebElement text = driver.findElement(By.xpath("//div[text()='umbra blue ']"));
		System.out.println("Without Fluent wait => " + text.getText());
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Element was still not visible");
		fWait.until(ExpectedConditions.visibilityOf(text));
		System.out.println("With Fluent wait => " + text.getText());
				

		
		
		
		driver.close();

	}

}
