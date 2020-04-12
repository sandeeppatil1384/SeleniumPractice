package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebSite {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(title.length());
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("sandip_patil_84@yahoo.co.in");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-passwd\"]"))).sendKeys("asdfg");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"password-challenge\"]/form/p")).getText());
		driver.quit();

	}

}
