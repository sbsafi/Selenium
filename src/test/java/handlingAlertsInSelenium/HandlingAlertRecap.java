package handlingAlertsInSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlertRecap {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//the alert/pop ups that we see on a webbrower are JavaScript alerts
		//There are three type of them
		//1- Alert box
		//2- Confirmation Alert box
		//3- Prompt Alert box
		//Authentication prompt
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Alert
		//we have to accept the alert
		driver.findElement(By.linkText("See an example alert")).click();
		Thread.sleep(3000);
		Alert alertBox = wait.until(ExpectedConditions.alertIsPresent());
		alertBox.accept();
		
		//Confirm Alert
		//we can either accept or dismiss the alert
		driver.findElement(By.linkText("See a sample confirm")).click();
		Thread.sleep(3000);
		Alert alertConfirm = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alertConfirm.getText());
		alertConfirm.accept();
//		alertConfirm.dismiss();
		//Prompt Alert
		//we can send text to alert input field and then accept or dismiss the alert
		driver.findElement(By.linkText("See a sample prompt")).click();
		Alert alertPrompt = wait.until(ExpectedConditions.alertIsPresent());
		alertPrompt.sendKeys("Panthers");
		Thread.sleep(3000);
		alertPrompt.accept();
//		alertPrompt.dismiss();
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
