package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframe {
	
	public static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		
		String fielName = d.toString().replace(":","_").replace(" ","_")+".jpeg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot, new File("./screenshot/"+fielName));
		
	}

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeCount.size());
		
		for(WebElement frame: iframeCount) {
			System.out.println(frame.getAttribute("id"));
		}
		
		driver.switchTo().frame("iframeResult");
		//driver.findElement(By.xpath("/html/body/button")).click();
		((JavascriptExecutor)driver).executeScript("myFunction()");
		
		 captureScreenshot();
		
		

	}

}
