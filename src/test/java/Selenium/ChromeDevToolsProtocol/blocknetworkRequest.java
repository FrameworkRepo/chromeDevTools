package Selenium.ChromeDevToolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class blocknetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//block specific api call like css or png or jpg or java script to make efficient 
		//make page to load efficient
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css","*.png","*.svg","*images*","*image*")));
		
		Long starttime = System.currentTimeMillis();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
				
		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("chrome",Keys.ENTER);

		Long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - starttime);
		
		//2158 2128 2213
		
		

	}

}
