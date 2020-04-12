package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class);

	public static void click(String locatorKey) {
		if (locatorKey.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith("_linkText")) {
			driver.findElement(By.linkText(OR.getProperty(locatorKey))).click();

		}

		log.info("Click on Next button field :" + locatorKey);

	}

	public static void type(String locatorKey, String value) {
		if (locatorKey.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

		} else if (locatorKey.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);

		} else if (locatorKey.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);

		}

		log.info("Typing in an Element : " + locatorKey + "entered the value as :" + value);
	}

	public static void main(String[] args) throws IOException {

		Properties or = new Properties();
		Properties config = new Properties();
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		log.info("OR properties are loaded !!!");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		log.info("config properties are loaded !!!");

		if (config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched !!!");

		} else if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to :" + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		// WebDriverWait wait = new WebDriverWait(driver,
		// Integer.parseInt(config.getProperty("explicit.wait")));

		type("username_XPATH", "sandeepvpatil1984@gmail.com");
		// log.info("Entering user name field :" +OR.getProperty("username_XPATH") );
		// driver.findElement(By.xpath(OR.getProperty("nextButton_XPATH"))).click();
		click("nextButton_XPATH");

		// driver.findElement(By.cssSelector(OR.getProperty("password_CSS"))).sendKeys("123456");
		
		driver.quit();
		log.info("Test Execution completed !!!");

	}

}
