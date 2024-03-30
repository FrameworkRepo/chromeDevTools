package Selenium.ChromeDevToolsProtocol;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class invokeCDPwithoutSeleniumCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		Map deviceMetrics = new HashMap();

		deviceMetrics.put("width", 500);
		deviceMetrics.put("height", 800);
		deviceMetrics.put("deviceScaleFactor", 95);
		deviceMetrics.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

		driver.get("https://chromedriver.chromium.org/");

		driver.findElement(By.cssSelector(".wFCWne")).click();

		Thread.sleep(3000);

		driver.close();

	}

}
