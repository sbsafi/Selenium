package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboadActions_PressSHIFTsendKeys {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement textField = driver.findElement(By.id("searchInput"));
		String strText = "tv";
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT)
		.sendKeys(textField, strText)
		.keyUp(Keys.SHIFT)
		.build().perform();
		
		
		
		Thread.sleep(4000);
		driver.close();

	}

}
