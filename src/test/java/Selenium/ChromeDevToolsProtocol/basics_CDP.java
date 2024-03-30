package Selenium.ChromeDevToolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basics_CDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		driver.manage().window().maximize();
		
		devTools.send(Emulation.setDeviceMetricsOverride(500, 800, 95, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
//		driver.get("https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html");
		driver.get("https://chromedriver.chromium.org/");
		
		driver.findElement(By.cssSelector(".wFCWne")).click();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
