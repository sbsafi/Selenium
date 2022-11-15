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

public class HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//the alert/pop ups that we see on a webbrower are JavaScript alerts
		//There are three type of them
		//1- Simple Alert
		//2- Confirmation Alert
		//3- Prompt Alert
		//Authentication
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
//		//Simple Alert
//		WebElement simpleAlert = driver.findElement(By.linkText("See an example alert"));
//		simpleAlert.click();
//		Thread.sleep(3000);
//		Alert alertpromptAlert = wait.until(ExpectedConditions.alertIsPresent());
//		//if we get an alert with only OK button, we can accept that method which is equal to clicking OK
//		alert.accept();
		
		//Confirm Alert
//		WebElement confirmAlert = driver.findElement(By.xpath("//h2[@id='confirm']//following-sibling::p[1]//a"));
//		confirmAlert.click();
//		Thread.sleep(3000);
//		Alert alertpromptAlert = wait.until(ExpectedConditions.alertIsPresent());
////		alert.accept();
//		alert.dismiss();
		
		//Prompt Alert
		WebElement promptAlert = driver.findElement(By.linkText("See a sample prompt"));
		promptAlert.click();
		Thread.sleep(3000);
		Alert alertpromptAlert = wait.until(ExpectedConditions.alertIsPresent());
		alertpromptAlert.sendKeys("Panthers");
		alertpromptAlert.accept();

	}

}
