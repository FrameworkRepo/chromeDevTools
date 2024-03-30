package Selenium.ChromeDevToolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class networkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request->
		{
		
			if(request.getRequest().getUrl().contains("search?q")){
				
				String mockedUrl = request.getRequest().getUrl().replace("=chrome", "=facebook");
				
				System.out.println(mockedUrl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
			else
			{
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
			
		});
		
		driver.get("https://www.google.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("chrome");
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys(Keys.ENTER);

		
		Thread.sleep(3000);
		
		driver.close();

	}

}
