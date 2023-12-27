package com.automationpractice.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {
	private static ExtentReports extent;
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	private static String basePath = GlobalVariable.basePath;
	private static String extentConfigFilePath = basePath+"/extent-config.xml";

	//Create an extent report instance
	private static ExtentReports createInstance() {
		String fileName = ResourceUtility.getReportFolderPath()+"test-report.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.loadXMLConfig(new File(extentConfigFilePath));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); 
		return extent;
	}

	static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) Thread.currentThread().getId());
	}

	public static synchronized void endTest() {
		getInstance().flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = getInstance().createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}


}
