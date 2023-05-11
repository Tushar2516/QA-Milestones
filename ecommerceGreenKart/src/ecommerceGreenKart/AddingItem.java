package ecommerceGreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/");
		// Implicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		Thread.sleep(1000);  

		// Expected Array for adding multiple items
		String[] productArray = { "Cucumber", "Brocolli" };
		// calling Method
		addItems(driver, productArray);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// Explicit Wait
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
//		driver.findElement(By.cssSelector("//button[normalize-space()='Place Order']")).click();
	}
	
	public static void addItems(WebDriver driver, String[] productArray) throws InterruptedException {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// convert array to arrayList
		List<String> productList = Arrays.asList(productArray);

		for (int i = 0; i < products.size(); i++) {
			String[] productName = products.get(i).getText().split("-");
			String formatedName = productName[0].trim();
			// check whether name you extracted is present in arrayList or not
			// convert array into arrayList for easy search

			int j = 0;
			if (productList.contains(formatedName)) {
				// Add to cart click 
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				Thread.sleep(1000);
				
				if (j == productArray.length) {
					break;
				}
				
			}
		}

	}

}
