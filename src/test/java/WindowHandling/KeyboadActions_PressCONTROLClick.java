package WindowHandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboadActions_PressCONTROLClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		Thread.sleep(3000);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		//keyDown and keyUp
		//control key, shift key, tab key
		//keyDown(Keys.CONTROL) once your perform your actions keyUp(Keys.CONTROL)
//		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.CONTROL)
//		.click(item1)
//		.click(item2)
//		.click(item3)
//		.click(item4)
//		.keyUp(Keys.CONTROL)
//		.build().perform();
		
		/*
		 * Action is an interface and it's an actions builder
		 * let's use Actions class and Action interface to perform the same actions above
		*/
		Actions actions2 = new Actions(driver);
		Action builder = actions2
				.keyDown(Keys.CONTROL)
				.click(item1)
				.click(item2)
				.click(item3)
				.click(item4)
				.keyUp(Keys.CONTROL)
				.build();
		builder.perform();

		
		
		Thread.sleep(4000);
		driver.close();
	}

}
