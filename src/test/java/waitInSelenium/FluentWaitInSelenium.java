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

public class FluentWaitInSelenium {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Fluent wait (dynamic wait/smart wait)
		//Fluent wait look for a web element repeatedly at a regular interval until time out happens
		//if element is not found. then after the time out happens, it will through noSuchElementFound
		//exception
		//Fluent wait commands are most useful when interacting with webelements that can take longer
		//to load. this is something happens mostly with AJAX element
		//AJAX = Asynchronous JavaScript And XML
		WebElement text = driver.findElement(By.xpath("//div[text()='umbra blue ']"));
//		System.out.println("Without Fluent wait => " + text.getText());
		
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("Element was not found!");
		fWait.until(ExpectedConditions.visibilityOf(text));
		System.out.println("With Fluent wait => " + text.getText());

	}

}
