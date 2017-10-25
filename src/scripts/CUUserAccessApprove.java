package scripts;

import java.awt.event.FocusEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.ui.Window;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.AccesGrants;
import objectRepository.Dasboard;
import objectRepository.PendingUserList;
import objectRepository.RegisterUser;



public class CUUserAccessApprove extends Driver{	
	
	//**User List Menu opening **//
	public static void CUUserAccessApproveMenu() 
	{
		testSuiteName="CUUserAccessApprove";
		testCaseName="CUUserAccessApproveMenu";
		HTMLReport.startTest(testSuiteName,testCaseName);
			
		try
		{
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.accessMgmtApprove)).click();
				System.out.println("Access Mgmt Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("Access Management menu", "Access mgmt Menu", "PASS", "click", "Access Manegment Clicked", "");
				
				driver.findElement(By.xpath(Dasboard.accessApproves)).click();
				System.out.println("Access Grants Approves menu Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("Access Management Page", "Access Grants Approve Menu", "PASS", "click", "Access grants List Clicked", "");
				//HTMLReport.logTest("User List menu", "DashboardView", "INFO", "Found"+assertion[0], "Value"+assertion[0], "");
				
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				HTMLReport.endTest();
				ExcelReport.screenShot(testCaseName);
				
		}
		
		catch(Exception e)
		{
			
			System.out.println(e);
		}
	}

	
	//**Search an user and Approve the access points **//
	public static void ApproveAccess(String[] data,String[] assertion) 
	
	{
		
		System.out.println("access List Population");
						
		try{
			
			testSuiteName="CUUserAccessApprove";
			testCaseName="ApproveAccess";
				
			CUUserAccessApproveMenu();
			
			HTMLReport.startTest(testSuiteName,testCaseName);
			System.out.println("cd");
			//* Search by Login Id Start
			driver.findElement(By.xpath(AccesGrants.searchByDrpdwn)).sendKeys(data[0]);
			System.out.println("Value selected for LoginId");
			HTMLReport.logTest("Access Management Page", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
			System.out.println("ef");
			Thread.sleep(2000);
			driver.findElement(By.xpath(AccesGrants.searchByDrpdwn)).click();
			HTMLReport.logTest("Access Management Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(AccesGrants.addBtn)).click();
			HTMLReport.logTest("Access Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

			driver.findElement(By.xpath(AccesGrants.searchByOUIDtxtBx)).sendKeys(data[1]);
			HTMLReport.logTest("Access Management Page", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
			System.out.println("Value entered for login ID");
			driver.findElement(By.xpath(AccesGrants.searchByOUIDtxtBx)).click();
			HTMLReport.logTest("Access Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(AccesGrants.searchBtn)).click();
			HTMLReport.logTest("Access Management Page", "Search button clicked", "PASS", "click", "seach button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(AccesGrants.selectBtn)).click();
			HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
			System.out.println("record Selected from the grid");						
			Thread.sleep(2000);
			
		    driver.findElement(By.xpath(AccesGrants.lastBtn)).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(AccesGrants.editViewBtn)).click();
			HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(5000);
			
				
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, document.body.scrollHeight)"); 
			
			driver.findElement(By.xpath(AccesGrants.approveBtn)).click();
			System.out.println("Approve btn clicked");						
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(AccesGrants.okBtn)).click();
			System.out.println("OK btn clicked");						
			Thread.sleep(2000);
			
			
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			ExcelReport.screenShot(testCaseName);
			HTMLReport.endTest();
		}
		catch(Exception e){
			
			System.out.println(e);
			HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Dashboard", "" +e, "");
	}
	
	}
	
	
	
	//**Search an user and Approve the access points **//
		public static void RejectAccess(String[] data,String[] assertion) 
		
		{
			
			System.out.println("access List Population");
							
			try{
				
				testSuiteName="CUUserAccessApprove";
				testCaseName="RejectAccess";
					
				CUUserAccessApproveMenu();
				
				HTMLReport.startTest(testSuiteName,testCaseName);
				System.out.println("cd");
				//* Search by Login Id Start
				driver.findElement(By.xpath(AccesGrants.searchByDrpdwn)).sendKeys(data[0]);
				System.out.println("Value selected for LoginId");
				HTMLReport.logTest("Access Management Page", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
				System.out.println("ef");
				Thread.sleep(2000);
				driver.findElement(By.xpath(AccesGrants.searchByDrpdwn)).click();
				HTMLReport.logTest("Access Management Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
				System.out.println("Value selected for searchbydropdnw");
				Thread.sleep(2000);
		
				driver.findElement(By.xpath(AccesGrants.addBtn)).click();
				HTMLReport.logTest("Access Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
				System.out.println("Add btn Clicked");
				Thread.sleep(2000);

				driver.findElement(By.xpath(AccesGrants.searchByOUIDtxtBx)).sendKeys(data[1]);
				HTMLReport.logTest("Access Management Page", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
				System.out.println("Value entered for login ID");
				driver.findElement(By.xpath(AccesGrants.searchByOUIDtxtBx)).click();
				HTMLReport.logTest("Access Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
				System.out.println("Value selected for searchbydropdnw");
				Thread.sleep(2000);
			
				driver.findElement(By.xpath(AccesGrants.searchBtn)).click();
				HTMLReport.logTest("Access Management Page", "Search button clicked", "PASS", "click", "seach button clicked", "");
				System.out.println("Search btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(AccesGrants.selectBtn)).click();
				HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
				System.out.println("record Selected from the grid");						
				Thread.sleep(2000);
				
			    driver.findElement(By.xpath(AccesGrants.lastBtn)).sendKeys(Keys.TAB);
				driver.findElement(By.xpath(AccesGrants.editViewBtn)).click();
				HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "View button clicked", "");
				System.out.println("Search btn clicked");						
				Thread.sleep(5000);
									
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, document.body.scrollHeight)"); 
				
				driver.findElement(By.xpath(AccesGrants.rejectBtn)).click();
				System.out.println("Reject btn clicked");						
				Thread.sleep(2000);
								
				driver.findElement(By.xpath(AccesGrants.okBtn)).click();
				System.out.println("OK btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(AccesGrants.comments)).sendKeys(data[2]);
				System.out.println("Value entered in commentsBox");
				Thread.sleep(2000);
		
				driver.findElement(By.xpath(AccesGrants.rejectBtn)).click();
				System.out.println("Reject btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(AccesGrants.okBtn)).click();
				System.out.println("Ok btn clicked");						
				Thread.sleep(2000);
		
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				ExcelReport.screenShot(testCaseName);
				HTMLReport.endTest();
			}
			catch(Exception e){
				
				System.out.println(e);
				HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Dashboard", "" +e, "");
		}
		
		}
		
	
	
	}
