package selectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassFacebookExampleNoSelectClassReusableMethod {

	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(2000);
		List<WebElement> listOfMonths = driver.findElements(By.xpath("//select[@id='month']//child::option"));
		getElementBasedOnVisibleText(listOfMonths, "Aug");
		Thread.sleep(2000);
		List<WebElement> listOfDays = driver.findElements(By.xpath("//select[@id='day']//child::option"));
		getElementBasedOnVisibleText(listOfDays, "9");
		Thread.sleep(2000);
		List<WebElement> listOfYear = driver.findElements(By.xpath("//select[@id='year']//child::option"));
		getElementBasedOnVisibleText(listOfYear, "2009");

	}
	public static void getElementBasedOnVisibleText(List<WebElement> list, String text) {
		for(WebElement element : list) {
			if(element.getText().equalsIgnoreCase(text)) {
				element.click();
				break;
			}
		}

	}

}
