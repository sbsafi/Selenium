package WindowHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingInSeleniumNewTab2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String parentTab = driver.getWindowHandle();
		WebElement downloadLink = driver.findElement(By.linkText("Download"));
		Actions actions = new Actions(driver);
		actions
		.keyDown(Keys.CONTROL)
		.click(downloadLink)
		.keyUp(Keys.CONTROL)
		.build().perform();
		
		Set<String> allTabs = driver.getWindowHandles();
		Iterator<String> it = allTabs.iterator();
		while(it.hasNext()) {
			String childTab = it.next();
			if(!parentTab.equals(childTab)) {
				driver.switchTo().window(childTab);
				break;
			}
		}
		
		WebElement radioBttn = driver.findElement(By.id("version-1.12.1"));
		if(radioBttn.isDisplayed()) {
			if(radioBttn.isEnabled()) {
				if(!radioBttn.isSelected()) {
					radioBttn.click();
				}
			}
		}
		
		Thread.sleep(6000);
		driver.quit();
	}

}
