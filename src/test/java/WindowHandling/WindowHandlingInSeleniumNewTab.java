package WindowHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingInSeleniumNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String parentTab = driver.getWindowHandle();
		driver.findElement(By.id("newTabBtn")).click();
		
		Set<String> allTabs = driver.getWindowHandles();
		Iterator<String> it = allTabs.iterator();
		while(it.hasNext()) {
			String childTab = it.next();
			if(!parentTab.equals(childTab)){
				driver.switchTo().window(childTab);
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		driver.switchTo().window(parentTab);
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
