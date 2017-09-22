package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.Dasboard;


public class DasboardVerification extends Driver{
	
	public static void DasboardView(String[] data,String[] assertion) 
	{
		testSuiteName="DasboardVerification";
		testCaseName="DasboardView";
		HTMLReport.startTest(testSuiteName,testCaseName);
		
		try
		{
			
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				boolean present;
				try {
					driver.findElement(By.xpath(Dasboard.pendingapprovalmonitorHeader));
				    present = true;
				    if (present = true)
				    {
				    String actualString = driver.findElement(By.xpath(Dasboard.pendingapprovalmonitorHeader)).getText();
				    actualString.equals(assertion[0]);
				    System.out.println("Value:"+assertion[0]);
				    //System.out.println("Value:"+assertion[0]);
				    
					HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Found"+assertion[0], "Value"+assertion[0], "");
				    }
				}
				    
				    catch (NoSuchElementException e) {
				   present = false;
				   HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Element Not Found,",""+e, "");
				}
				
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				ExcelReport.screenShot(testCaseName);
				HTMLReport.endTest();
				
			}
		
			catch(Exception e){
				
				System.out.println(e);
				HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Dashboard", "BBCU Radio Button Clicked", "");
				
		}
	}
	
	
	}
