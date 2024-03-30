package Selenium.ChromeDevToolsProtocol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v117.log.model.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class consoleLogCaptureJavaScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		
		driver.findElement(By.linkText("Cart")).click();
		
		driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
		driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys("2");
		
		 LogEntries entry =  driver.manage().logs().get(LogType.BROWSER);
		 
		 List<org.openqa.selenium.logging.LogEntry> logs =  entry.getAll();
		 
		 for (org.openqa.selenium.logging.LogEntry e : logs ){
			 
			 System.out.println(e.getMessage());
			 System.out.println(e.getTimestamp());
		 }
		
		driver.close();
		
		
		
		
		
		
		
		

	}

}
