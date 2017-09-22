package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.PendingUserList;
import objectRepository.RegisterUser;

public class PendingUserListCU extends Driver{
	
	public static void pendingUserListMenu() 
	{
		try
		{
			
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.userMgmt)).click();
				System.out.println("User Mgmt Clicked");
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.pendingUserListCU)).click();
				System.out.println("PendingUserListCU menu Clicked");
				Thread.sleep(2000);
		}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	//**CU Admin Data Entry and submission **//
	
	public static void SearchandApproveCU(String[] data,String[] assertion) 
	
	{
		
		System.out.println("User List Population");
						
		try{
			
			testSuiteName="pendingUserList";
			testCaseName="SearchandApproveCU";
			
			pendingUserListMenu();
			
			//* Search by Login Id Start
			driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).sendKeys(data[0]);
			System.out.println("Value selected for LoginId");
			driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).click();
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.id(PendingUserList.btnAdd)).click();
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

		
			driver.findElement(By.id(PendingUserList.srchUserNametxtbx)).sendKeys(data[1]);
			System.out.println("Value entered for login ID");
			driver.findElement(By.id(PendingUserList.srchUserNametxtbx)).click();
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(PendingUserList.btnSearch)).click();
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(PendingUserList.removebtnlogin)).click();
			System.out.println("Remove btn Clicked");
			Thread.sleep(2000);
			
			//* Search by Login Id end
			
			//* Search by OU Name  Start
			
			driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).sendKeys(data[2]);
			System.out.println("Value Inputed for OU Name");
			driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).click();
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
			driver.findElement(By.id(PendingUserList.btnAdd)).click();
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(PendingUserList.ouSelected)).click();
			System.out.println("OU Name Selected");
			Thread.sleep(2000);
			driver.findElement(By.xpath(PendingUserList.ouSelected)).sendKeys(data[3]);
			System.out.println("Value Inputed for OU Name");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(PendingUserList.btnSearch)).click();
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			//* Search by OU name Id end
		
			//* For Approval-- selection from the grid start
			
			driver.findElement(By.xpath(PendingUserList.radioBtnSelected)).click();
			System.out.println("record Selected from the grid");						
			Thread.sleep(2000);
			driver.findElement(By.xpath(PendingUserList.viewBtn)).click();
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(PendingUserList.approveBtn)).click();
			System.out.println("Approve btn clicked");						
			Thread.sleep(2000);
		//	ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
		//	ExcelReport.screenShot(testCaseName);			
			//* For Approval --selection from the grid end			
			driver.findElement(By.xpath(PendingUserList.okBtn)).click();
			System.out.println("Ok btn clicked");						
			Thread.sleep(2000);
			
		}
		catch(Exception e){
			
			System.out.println(e);
	}
	}
			
	//* For Rejection-- selection from the grid start
	public static void RejectUser(String[] data,String[] assertion) 
			
	{
				
			System.out.println("Pending User List Population");
								
			try{
					
				testSuiteName="PendingUserListCU";
				testCaseName="RejectUser";
				
				pendingUserListMenu();
				
				
				driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).sendKeys(data[0]);
				System.out.println("Value selected for LoginId");
				driver.findElement(By.xpath(PendingUserList.searchBylistDropDown)).click();
				System.out.println("Value selected for searchbydropdnw");
				Thread.sleep(2000);
		
				driver.findElement(By.id(PendingUserList.btnAdd)).click();
				System.out.println("Add btn Clicked");
				Thread.sleep(2000);

				driver.findElement(By.id(PendingUserList.srchUserNametxtbx)).sendKeys(data[1]);
				System.out.println("Value entered for login ID");
				driver.findElement(By.id(PendingUserList.srchUserNametxtbx)).click();
				System.out.println("Value selected for searchbydropdnw");
				Thread.sleep(2000);
			
				driver.findElement(By.xpath(PendingUserList.btnSearch)).click();
				System.out.println("Search btn clicked");						
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath(PendingUserList.radioBtnSelected)).click();
				System.out.println("record Selected from the grid");						
				Thread.sleep(2000);
				driver.findElement(By.xpath(PendingUserList.viewBtn)).click();
				System.out.println("View btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PendingUserList.rejectBtn)).click();
				System.out.println("Reject btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PendingUserList.okBtn)).click();
				System.out.println("Ok btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PendingUserList.commentsBox)).sendKeys(data[2]);
				System.out.println("Value entered in commentsBox");
				Thread.sleep(2000);
		
				driver.findElement(By.xpath(PendingUserList.rejectBtn)).click();
				System.out.println("Reject btn clicked");						
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(PendingUserList.okBtn)).click();
				System.out.println("Ok btn clicked");						
				Thread.sleep(2000);
				//* For Rejection --selection from the grid end	
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				ExcelReport.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
	
	}
					
	public static void searchgridfilter(String[] data,String[] assertion) 
	
	{
				
			System.out.println("Pending User List Population");
								
			try{
					
				testSuiteName="PendingUserListCU";
				testCaseName="searchgridfilter";
				
				pendingUserListMenu();
				
				
				driver.findElement(By.xpath(PendingUserList.searchgridbox)).sendKeys(data[0]);
				System.out.println("Value selected for search box value");
				driver.findElement(By.xpath(PendingUserList.searchgridbox)).click();
				System.out.println("Value selected for searchbydropdnw");
				Thread.sleep(2000);
		
			
				//* For Rejection --selection from the grid end	
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				ExcelReport.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
	
	}
	}
