package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.degrees;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.aventstack.extentreports.reporter.configuration.ViewOrder;
import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;


public class ListeneImp implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("report coniguration");

		// spark report  config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		spark = new ExtentSparkReporter("./AdvanceReoprt22/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test suite result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		 spark.viewConfigurer().viewOrder().as(new ViewName[] {
				 ViewName.DASHBOARD,
				 ViewName.EXCEPTION,
				 ViewName.CATEGORY,
				 ViewName.DEVICE,
				 ViewName.TEST}).apply();

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome111");
		

	}

	public void onFinish(ISuite suite) {
		System.out.println("report backup");

		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "======START======");

		test = report.createTest(result.getMethod().getMethodName());// to ceate test case inside extent report

		UtilityClassObject.setTest(test);
		
		test.log(Status.INFO, result.getMethod().getMethodName() + "=====STARTED=======");

		test.assignAuthor("SANU");
		test.assignCategory("ContactTest");
		test.assignDevice("HP Pavilion ");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=========" + result.getMethod().getMethodName() + "======END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "=====COMPLETED=======");

	}

	public void onTestFailure(ITestResult result) {

		
		Throwable t= new Throwable();
		String testName = result.getMethod().getMethodName();
		TakesScreenshot sc = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = sc.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		
		test.fail("exception for failure:"+t,MediaEntityBuilder.createScreenCaptureFromBase64String(filepath, testName + "_" + time).build());
    
		
		test.log(Status.FAIL, result.getMethod().getMethodName() + "=====FAILED=======");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
