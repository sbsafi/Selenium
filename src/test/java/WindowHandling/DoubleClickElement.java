package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		//We need to create object of Actions class
		//Actions is a class
		//Action is an interface. Is an action builder
		Actions actions = new Actions(driver);
		//since we are performing one single actions, we just call the perform method
		actions.doubleClick(doubleClick).perform();
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.accept();
		
		
		driver.close();

	}

}
