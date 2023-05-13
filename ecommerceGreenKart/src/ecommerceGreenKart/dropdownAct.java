package ecommerceGreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dropdownAct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();
		
		// Action for dragging
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Thread.sleep(2000);
		a.dragAndDrop(source, target).build().perform(); 
		
		driver.switchTo().defaultContent();
		
	}

}
