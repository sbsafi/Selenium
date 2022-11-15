package handlingAlertsInSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptAlertInSelenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//we found the locator to our iframe, stored it in an instance of webelement and then 
		//switched to that iframe
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		//clicked on the 'Try it' button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//sent the text
		alert.sendKeys("Panthers");
		//accepted the alert
		alert.accept();
		Thread.sleep(3000);
		
		//to interact with elements on the default page/main content we have to first switch to default content
		//in order to be able to do that
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("runbtn")).click();

	}

}
