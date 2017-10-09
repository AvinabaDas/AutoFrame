package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.ExcelReport;
import driver.Driver;
import objectRepository.*;
import commonFunctions.*;

public class InitiateApplicationUnderTest extends Driver {
	
	
	public static void openApplicationURL()
	{
		try{
			
			testSuiteName="InitiateApplicationUnderTest";
			testCaseName="openApplicationURL";
			HTMLReport.startTest(testSuiteName,testCaseName);
			
			driver.manage().window().maximize();
			Thread.sleep(500);
			driver.get(QA_ENVIRONMENT);
			HTMLReport.logTest("Browser", "Open Browser", "INFO", "CHROME", "The CHROME Browser Launched", "");
			HTMLReport.logTest("Browser", "Open Browser", "PASS", "CHROME", "The CHROME browser was opened.", "");
			
			
			Thread.sleep(500);
			
			String title=driver.getTitle();
			
			
			//Assert and write Report to File
			System.out.println(title);
			
			if(title.equalsIgnoreCase("Admin Login Page"))
			{
				Result="Pass";
				
			}else{
				
				Result="Fail";
				
			}
			
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			HTMLReport.endTest();
			ExcelReport.screenShot(testCaseName);
			
			
		}catch(Exception e){
			
			System.out.println(e);
			try {
				ExcelReport.screenShot("Error"+testCaseName);
			} catch (HeadlessException | IOException | AWTException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
