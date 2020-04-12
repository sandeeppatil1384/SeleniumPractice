package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {
	public static WebDriver driver;
	
	//Handling WebElement present or not
	
	public static boolean isElementPresent(By by) {
		
		try {
			
		driver.findElement(by);
		
		return true;
		
		}catch (Throwable t) {
			
			return false;
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(isElementPresent(By.xpath("//*[@id=\"searchLanguage\"]")));
		/*
		 * WebElement dropDown =
		 * driver.findElement(By.xpath("//select[@id='searchLanguage']")); Select select
		 * = new Select(dropDown); //select.selectByVisibleText("Eesti");
		 * select.selectByValue("hi");
		 * 
		 * List<WebElement> values = driver.findElements(By.tagName("option"));
		 * System.out.println(values.size());
		 * 
		 * //Capture WebElement through indexing
		 * System.out.println(values.get(7).getText());
		 * 
		 * for (int i = 0; i < values.size(); i++) {
		 * System.out.println(values.get(i).getAttribute("lang"));
		 * 
		 * }
		 * 
		 * System.out.println("--- Total Links On The Page ---");
		 * 
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * System.out.println(links.size());
		 * 
		 * for (WebElement link:links) { System.out.println(link.getText() +
		 * " --- URL is --- " + link.getAttribute("href"));
		 * 
		 * }
		 * 
		 * System.out.println("------- Find element from perticular one block --------"
		 * );
		 * 
		 * WebElement block =
		 * driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		 * List<WebElement>blockSection_Links = block.findElements(By.tagName("a"));
		 * System.out.println(blockSection_Links.size()); for (WebElement block_link :
		 * blockSection_Links) { System.out.println(block_link.getText()); }
		 */
		
		driver.quit();

	}

}
