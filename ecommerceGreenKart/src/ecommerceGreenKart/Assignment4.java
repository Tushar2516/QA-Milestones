package ecommerceGreenKart;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	private static final String Set = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href*='windows']")).click();		
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String>it = tabs.iterator(); //Switching
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		

		}

}
