package WindowHandling;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingInSelenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*
		 * getWindowHandle() => the return type for is String
		 * getWindowHandles() => the return type is Set<String>
		 * 
		 * Set<String>: this method will help us to set the windows in a form of String
		 * 
		 * Iterator: will help us to iterator through the windows that we have stored in a Set<String>
		 * 
		 * switchTo to switch to next or previous window
		 * 
		 */
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent Window => " + parentWin);
		
		WebElement newWindowBttn = driver.findElement(By.id("newWindowBtn"));
		newWindowBttn.click();
		
		//Set<String>
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		//we have to check and make sure, there is a second window open and we have the 
		//handle of that window and we can loop through the Set<String>
		while(it.hasNext()) {
			//if it.next(); then that means there is a second/child window and we can now
			//store that one as well as a String
			String childWindow = it.next();
			System.out.println("Child Window Name => " + childWindow);
			//if the parent window is not equal to child window
			if(!parentWin.equals(childWindow)) {
				//then we want to switch to that child window
				driver.switchTo().window(childWindow);
				break;
			}
		}
		WebElement dropDown = driver.findElement(By.id("selectnav1"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("-- Selenium");
		
//		driver.close();
		
		//after closing the child window, if we want to perform some action(s) on the parent window
		//then we need to switch back to parent window
		driver.switchTo().window(parentWin);
		driver.findElement(By.id("name")).sendKeys("Test Passed!");
		
		Thread.sleep(3000);
//		driver.close();
//		driver.quit();

	}

}
