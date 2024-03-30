package Selenium.ChromeDevToolsProtocol;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v115.fetch.Fetch;
import org.openqa.selenium.devtools.v115.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v115.network.model.ErrorReason;

import io.github.bonigarcia.wdm.WebDriverManager;

public class networkFailRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		Optional<List<RequestPattern>> patterns = Optional
				.of(Arrays.asList(new RequestPattern(Optional.of("*search*"), Optional.empty(), Optional.empty())));

		devTools.send(Fetch.enable(patterns, Optional.empty()));

		devTools.addListener(Fetch.requestPaused(), request ->

		{
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.INTERNETDISCONNECTED));

		});

		driver.get("https://www.google.com/");

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("chrome",Keys.ENTER);

		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("main-message")).getText());
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
