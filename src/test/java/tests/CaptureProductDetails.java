package tests;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureProductDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/en-gb/product/macbook");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		List<WebElement> productDetails = driver.findElements(By.xpath("(//h1[text()='MacBook']/following-sibling::ul[@class='list-unstyled'])[1]//li"));
		int listSize = productDetails.size(); //Total = 4 elemetns. Indexing starts from 0
		System.out.println("size of list = " + listSize);
		
		//Map<String,String> prodDetailsMap = new HashMap<String,String>(); --> HashMap doesn't preserve the order of insertion --> like ul tag
		Map<String,String> prodDetailsMap = new LinkedHashMap<String,String>(); //LinkedHasMap --> preserves the order of insertion --> like ol tag
		
		//Get Brand details
		//WebElement firstLine = productDetails.get(0);
		//System.out.println(firstLine.getText()); //Brand: Apple
		
		
		for(int i=0; i<listSize; i++) {
			String lineDetails = productDetails.get(i).getText();
			String[] arr = lineDetails.split(":");
			String key=arr[0].trim();
			String value=arr[1].trim();

			prodDetailsMap.put(key, value);
		}
		
		//shortcut
		System.out.println(prodDetailsMap.toString());
		
		
		  //Iterate through hashMap 
		  Iterator<Entry<String, String>> it = prodDetailsMap.entrySet().iterator();
		  
		  while(it.hasNext()) { 
			  // Get the next entry (key-value pair)
	            Entry<String, String> entry = it.next();
			  System.out.println(entry.getKey() + " = " + entry.getValue());
		  
		  }
		 
		 
		
		driver.quit();
		
	}

}
