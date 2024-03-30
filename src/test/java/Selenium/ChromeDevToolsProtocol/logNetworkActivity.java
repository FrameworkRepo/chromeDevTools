package Selenium.ChromeDevToolsProtocol;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.Request;
import org.openqa.selenium.devtools.v117.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logNetworkActivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();

			System.out.println(req.getUrl());

		});

		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();

			if(res.getStatus().toString().startsWith("4")){
			System.out.println(res.getStatus());}

		});
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://chromedriver.chromium.org/");

		Thread.sleep(3000);

		driver.close();

	}

}
