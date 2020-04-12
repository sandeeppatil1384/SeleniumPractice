package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[3]/input")).sendKeys("sandeepvpatil1984@gmail.com");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"load_form\"]/fieldset[1]/input"))).sendKeys("Sandeep");
		//driver.findElement(By.xpath("//following-sibling::h3[contains(text(),'Registration Form')]/following-sibling::fieldset[1]/input[@type='text']")).sendKeys("Sandeep");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Sandeep");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		//*[@id="load_form"]/fieldset[1]/input

	}

}
