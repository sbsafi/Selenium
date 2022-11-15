package selectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassMultiSelectOption {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement multipleSelect = driver.findElement(By.name("Month"));
		Select selectMulti = new Select(multipleSelect);
		selectMulti.selectByVisibleText("January");
		selectMulti.selectByVisibleText("February");
		selectMulti.selectByVisibleText("March");
		selectMulti.selectByVisibleText("April");
		//deselectAll or deselect specific items
		selectMulti.deselectByVisibleText("February");
		//will deselct all of the items we have previously selected
		Thread.sleep(2000);
		selectMulti.deselectAll();
		//how can we check if a dropdown has multi select options?
		if(selectMulti.isMultiple()) {
			System.out.println("is multi select");
		}else {
			System.out.println("is not multi select");
		}
		selectMulti.selectByVisibleText("August");
		selectMulti.selectByVisibleText("September");
		selectMulti.selectByVisibleText("October");
		selectMulti.selectByVisibleText("November");
		selectMulti.selectByVisibleText("December");
		//getAllSelectedOptions() this method will return list of webelements that
		//are selected
		List<WebElement> list = selectMulti.getAllSelectedOptions();
//		System.out.println("size of list: " + list.size());
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("Month: " + list.get(i).getText());
//		}
		for(WebElement elements : list) {
			System.out.println("Using forEachLoop: " + elements.getText());
		}
		

	}

}
