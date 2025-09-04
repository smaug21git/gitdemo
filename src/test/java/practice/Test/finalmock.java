package practice.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class finalmock {

	@Test
	public void ninja() throws InterruptedException, Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		
		//login
		Random random=new Random();
		int randomNumber=random.nextInt(100000);
		
		FileInputStream fis=new FileInputStream("./TestData/test data.xls");
		Workbook wb=WorkbookFactory.create(fis);
		String username=wb.getSheet("ninzahrm").getRow(1).getCell(0).getStringCellValue();
		String password=wb.getSheet("ninzahrm").getRow(1).getCell(1).getStringCellValue();
		String project_name=wb.getSheet("ninzahrm").getRow(1).getCell(2).getStringCellValue();

		
		wb.close();
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		String projectname=project_name+randomNumber;
	
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectname);
		driver.findElement(By.xpath("//input[@Name='createdBy']")).sendKeys("78964");
		
		WebElement dropdown=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select sel=new Select(dropdown);
		sel.selectByVisibleText("Completed");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Thread.sleep(3000);
		//navigate to employees
		driver.findElement(By.linkText("Employees")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys("Sutishna_"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys("sutishna"+randomNumber+"@gmail.com");
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys("9123807378");
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys("monu"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys("manage"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys("7");
		
        WebElement dropdownemp=driver.findElement(By.xpath("//select[@name='project']"));
		
		Select selobj=new Select(dropdownemp);
		selobj.selectByVisibleText(projectname);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(2000);
		
		
	}
}
