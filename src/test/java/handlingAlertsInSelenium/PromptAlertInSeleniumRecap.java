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

public class PromptAlertInSeleniumRecap {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Panthers");
		Thread.sleep(3000);
		alert.accept();
//		alert.dismiss();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("runbtn")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
