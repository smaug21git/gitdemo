package practice.Test;

import org.testng.annotations.Test;

public class mock {

	@Test
	public void hrm()
	{
		[4:32 pm, 11/04/2025] Sanu Jio: WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		
		//login
		Random random=new Random();
		int randomNumber=random.nextInt(100000);
		
		FileInputStream fis=new FileInputStream("./testData/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String username=wb.getSheet("ninza").getRow(1).getCell(0).getStringCellValue();
		String password=wb.getSheet("ninza").getRow(1).getCell(1).getStringCellValue();
		String project_name=wb.getSheet("ninza").getRow(1).getCell(2).getStringCellValue();

		
		wb.close();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
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
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys("Shiighjhklvvaamm");
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys("sassdsdsdfg@gmail.com");
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys("7833650047");
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys("sadsdfgddfgh");
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys("scaddfgdfg");
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys("7");
		
        WebElement dropdownemp=driver.findElement(By.xpath("//select[@name='project']"));
		
		Select selobj=new Select(dropdownemp);
		selobj.selectByVisibleText(projectname);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(2000);
		
		TakesScreenshot ts=(TakesScreenshot)driver;

		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./Screenshots/homep.png");
		FileHandler.copy(srcfile, destfile);
		driver.quit();
[5:20 pm, 11/04/2025] Sanu Jio: WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		
		//login
		Random random=new Random();
		int randomNumber=random.nextInt(100000);
		
		FileInputStream fis=new FileInputStream("./commondata/book.xls");
		Workbook wb=WorkbookFactory.create(fis);
		String username=wb.getSheet("Sheet3").getRow(1).getCell(0).getStringCellValue();
		String password=wb.getSheet("Sheet3").getRow(1).getCell(1).getStringCellValue();
		String project_name=wb.getSheet("Sheet3").getRow(1).getCell(2).getStringCellValue();

		
		wb.close();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
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
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys("Shiighjhklvvaamm_"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys("sass"+randomNumber+"dsdsdfg@gmail.com");
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys("7833650047");
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys("sadsdfgddfgh"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys("scaddfgdfg"+randomNumber+"");
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys("7");
		
        WebElement dropdownemp=driver.findElement(By.xpath("//select[@name='project']"));
		
		Select selobj=new Select(dropdownemp);
		selobj.selectByVisibleText(projectname);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(2000);
	}
}
