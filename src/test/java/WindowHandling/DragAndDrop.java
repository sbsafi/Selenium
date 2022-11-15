package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
		
		Thread.sleep(4000);
		driver.close();
		

	}

}
