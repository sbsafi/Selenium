package waitInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitInSelenium {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/ajax.html");
		driver.manage().window().maximize();
		//dynamic waits/smart waits in selenium
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//static wait/hard wait
		//Thread.sleep(10000);
		
		//Explicit Wait
		//is a webdriverwait, and we use the explicit wait, for instances where one or more elements
		//may not load with the rest of the elements on the web page
		//WebDriver is directed to wait for a certain condition, before performing the next action
		WebElement yesBttn = driver.findElement(By.id("yes"));
		waitAndClick(yesBttn);
		driver.findElement(By.id("buttoncheck")).click();
//		WebElement element = driver.findElement(By.xpath("//p[@class='radiobutton']"));
		//but if the text of that element is not available, then we can use the explicit wait
		//to direct the webdriver to wait for some certain condition before performing this action
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(element));
//		System.out.println(element.getText());
		
		//same as selenium.dev example
		WebElement text = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='radiobutton']")));
		System.out.println(text.getText());
		
	}
	public static void waitAndClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
