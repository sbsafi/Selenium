package waitInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitRecap {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/ajax.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//By using the Explicit Wait command, the WebDriver is directed to wait until a certain condition occurs 
		//before proceeding with executing the code.
		//Setting Explicit Wait is important in cases where there are certain elements that naturally 
		//take more time to load.
		WebElement yesRadioBttn = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.id("yes")));
		yesRadioBttn.click();
				
		driver.findElement(By.id("yes")).click();
		driver.findElement(By.id("buttoncheck")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement text = driver.findElement(By.xpath("//p[@class='radiobutton']"));
//		System.out.println(text.getText());
		wait.until(ExpectedConditions.visibilityOf(text));
		System.out.println(text.getText());
		

	}

}
