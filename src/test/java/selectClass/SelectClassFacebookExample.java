package selectClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassFacebookExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create new account")).click();
		
		WebElement month = driver.findElement(By.id("month"));
		Select selectM = new Select(month);
//		selectM.selectByIndex(0);
//		selectM.selectByValue("2");
		selectM.selectByVisibleText("Dec");
		if(selectM.isMultiple()) {
			System.out.println("Month dropdown is multi select");
		}else {
			System.out.println("Month dropdown is NOT multi select");
		}
		
		WebElement day = driver.findElement(By.id("day"));
		Select selectD = new Select(day);
//		selectD.selectByIndex(0);
//		selectD.selectByValue("2");
		selectD.selectByVisibleText("21");
		
		WebElement year = driver.findElement(By.id("year"));
		Select selectY = new Select(year);
//		selectY.selectByIndex(1);
//		selectY.selectByValue("2018");
		selectY.selectByVisibleText("2000");
		

	}

}
