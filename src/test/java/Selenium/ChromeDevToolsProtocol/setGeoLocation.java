package Selenium.ChromeDevToolsProtocol;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class setGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		driver.manage().window().maximize();
		
		Map<String,Object> location = new HashMap<String,Object>();
		
		location.put("latitude", 40);
		location.put("longitude", 3);
		location.put("accuracy", 10);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", location);
		
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys("hotel near me",Keys.ENTER);
		
		driver.findElement(By.cssSelector(".LC20lb")).click();
	
		
		driver.close();
	}

}
