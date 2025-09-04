package practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Mock3 {
	
	@Test
	public void productlist() throws Throwable, IOException {
	WebDriver driver= new FirefoxDriver();
	driver.get("https://www.myntra.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();	
	
	driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("shoes", Keys.ENTER);
	String price1 = driver.findElement(By.xpath("//h4[.='Men Colourblocked PU Sneakers']/following-sibling::div/span//span[@class='product-discountedPrice']")).getText();

	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles", Keys.ENTER);
	String price = driver.findElement(By.xpath("//h4[.='iPhone 14 Phone Bumper Case']/following-sibling::div/span/span[@class='product-discountedPrice']")).getText();
	
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("bag", Keys.ENTER);
	String price2 = driver.findElement(By.xpath("//h4[.='Girls Printed Backpack']/following-sibling::div/span//span[@class='product-discountedPrice']")).getText();
	
	
	FileInputStream fis= new FileInputStream("./TestData/test data.xls");
	Workbook book= WorkbookFactory.create(fis);
	book.getSheet("messo").getRow(3).createCell(2).setCellValue(price);
	book.getSheet("messo").getRow(1).createCell(2).setCellValue(price1);
	book.getSheet("messo").getRow(2).createCell(2).setCellValue(price2);
	
	FileOutputStream fos= new FileOutputStream("./TestData/test data.xls");
	book.write(fos);
	book.close();
	
	
	
	
	driver.quit();
	
	}
}
