package handlingAlertsInSelenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenerateMyOwnAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("hhttps://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//with the help of JavascripExector interface, we can generate our own alerts
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("confirm('This is my own alert')");


	}

}
