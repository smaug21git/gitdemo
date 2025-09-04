package com.comcast.crm.listenerUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListnetImpLoglevel {
	
	//dependency
	// selenium-java, webdrivermanager(io.github.bonigracia)
	
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		File file= new File("report.html");
		ExtentSparkReporter spark= new ExtentSparkReporter(file);
		
		ExtentReports reports= new ExtentReports();
		reports.attachReporter(spark);
		
		
		String base64=captureSc();
		String path=captureSc("chatgpt.com");
	
		driver= new ChromeDriver();
		driver.get("https://chatgpt.com/");
		
		
		reports.createTest("screenshot test 1","this is for sc atteching at test level")
		.info("thsi is a info message")
		.addScreenCaptureFromBase64String(base64);

		reports.createTest("screenshot test 2","this is for sc atteching at test level")
		.info("thsi is a info message")
		.addScreenCaptureFromBase64String(base64,"chat gpt homepage");
		
		
		Throwable t= new Throwable();
		
		
		reports.createTest("screenshot test 3","this is for sc atteching at test level")
		.info("thsi is a info message")
		.addScreenCaptureFromPath(path);

		reports.createTest("screenshot test 4","this is for sc atteching at test level")
		.info("thsi is a info message")
		
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("this is failed point",MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		
		
				
		
		
		
		
		
		reports.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());;
		
	}

	
	
	public static String captureSc() {
		TakesScreenshot ts=  (TakesScreenshot) driver ;
		String base64code = ts.getScreenshotAs(OutputType.BASE64);
		
		
		System.out.println("screenshot save successfully");
		
		return base64code;
	
	}
	
	public static String captureSc(String filename) {
		TakesScreenshot ts=  (TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File f= new File("./screenshot/"+filename);
		
		try {
			org.openqa.selenium.io.FileHandler.copy(source, f);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("screenshot save successfully");
		
		return f.getAbsolutePath();
		
			
			
	}
	}


