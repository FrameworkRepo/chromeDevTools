package Selenium.ChromeDevToolsProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URI;
import java.util.function.Predicate;

public class basicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
						
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		
		driver.manage().window().maximize();
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		
		System.out.println(driver.findElement(By.cssSelector("pre")).getText());

	}

}
