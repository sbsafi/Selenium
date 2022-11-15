package selectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassFacebookExampleNoSelectClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create new account")).click();
		//This is how we can handle dynamic dropdowns without select tag
		//for example below, the node does have select tag, but we are not using
		//select class and select class method to select one specific item
		List<WebElement> listOfMonths = driver.findElements(By.xpath("//select[@id='month']//child::option"));
		for(int i = 0; i < listOfMonths.size(); i++) {
			if(listOfMonths.get(i).getText().equalsIgnoreCase("Jul")) {
				listOfMonths.get(i).click();
				break;
			}
		}
		List<WebElement> listOfDays = driver.findElements(By.xpath("//select[@id='day']//child::option"));
		for(int i = 0; i < listOfDays.size(); i++) {
			if(listOfDays.get(i).getText().equalsIgnoreCase("18")) {
				listOfDays.get(i).click();
				break;
			}
		}
		List<WebElement> listOfYear = driver.findElements(By.xpath("//select[@id='year']//child::option"));
		for(int i = 0; i < listOfYear.size(); i++) {
			if(listOfYear.get(i).getText().equalsIgnoreCase("2002")) {
				listOfYear.get(i).click();
				break;
			}
			
		}
	}

}
