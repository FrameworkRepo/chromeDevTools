package Selenium.ChromeDevToolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.ConnectionType;


import io.github.bonigarcia.wdm.WebDriverManager;

public class networkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//wait to make network speed slow to test
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//If network fail then to capture below steps
		
		devTools.send(Network.emulateNetworkConditions(true, 1000, 2000, 100, Optional.of(ConnectionType.CELLULAR2G)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed ->
		{
			System.out.println(loadingFailed.getErrorText());
			
			System.out.println(loadingFailed.getTimestamp());
			
		});
		
		Long startTime = System.currentTimeMillis();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		
		Long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		driver.close();	

	}

}
