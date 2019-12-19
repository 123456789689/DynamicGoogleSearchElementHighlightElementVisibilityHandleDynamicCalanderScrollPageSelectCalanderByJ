package JavaScriptExicuterConcepts;

import java.lang.module.FindException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementHighlight {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.get("https://www.facebook.com/");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page
																		// loaded before that remaining time will be
																		// ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page
																	// loaded before that remaining time will be ignored
		// Also this timeouts() are global variable no need to assign again & again to
		// wait until the page loads.

		d.findElement(By.xpath("//input[@id='email']")).sendKeys("mouryabhushan.kgl@gmail.com");
		d.findElement(By.xpath("//input[@id='pass']")).sendKeys("Manishmanvi@123");
		
		Thread.sleep(2000);

		WebElement str = d.findElement(By.xpath("//input[@id='u_0_2']"));
		flash(str, d);

		d.quit();
	}

	public static void flash(WebElement Element, WebDriver d) {
		JavascriptExecutor js = ((JavascriptExecutor) d);
		String bgcolor = Element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changecolor("rgb(0,200,0)", Element, d);
			changecolor(bgcolor, Element, d);
		}
	}

	public static void changecolor(String color, WebElement Element, WebDriver d) {
		JavascriptExecutor js = ((JavascriptExecutor) d);
		js.executeScript("argument[0].style.backgroundColor = '" + color + "'", Element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}
	}

}
