package selectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		/*
		 * WebDriver support the class select, this class provides methods 
		 * for interacting with select options. User can perform the select
		 * and deselect operations on a select dropdown.
		 * we can also get the text of the values in the dropdown and 
		 * the option which are selected by the user. To use these options, 
		 * the Select Tag should have "multiple" attribute.
		 */
		WebElement allDepart = driver.findElement(By.id("search"));
		Select select = new Select(allDepart);
		//the indexing the dom starts from 0
		select.selectByIndex(1);
		Thread.sleep(2000);
		select.selectByIndex(2);
		Thread.sleep(2000);
		select.selectByIndex(3);
		Thread.sleep(2000);
		select.selectByValue("5");
		Thread.sleep(2000);
		select.selectByVisibleText("Sports");
		

	}

}
