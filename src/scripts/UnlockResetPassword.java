package scripts;

import org.openqa.selenium.By;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.UserListObj;


public class UnlockResetPassword extends Driver{	
	

	public static void UnlockResetMenu() 
	{
		testSuiteName="UnlockResetPassword";
		testCaseName="UnlockResetmenu";
		HTMLReport.startTest(testSuiteName,testCaseName);
			
		try
		{
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.userMgmt)).click();
				System.out.println("User Mgmt Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("User Management Page", "User mgmt Menu", "PASS", "click", "User Manegment Clicked", "");
				driver.findElement(By.xpath(Dasboard.resetUnloclmenu)).click();
				System.out.println("UnlockResetListmenu menu Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("User Management Page", "User mgmt Menu", "PASS", "click", "UnlockResetListmenu Clicked", "");
				//HTMLReport.logTest("User List menu", "DashboardView", "INFO", "Found"+assertion[0], "Value"+assertion[0], "");
				
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				HTMLReport.endTest();
				ExcelReport.screenShot(testCaseName);
				
		}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	//**Record selection and reset**//
	
	public static void SeaarchandReset(String[] data,String[] assertion) 
	
	{
		
		System.out.println("Reset Unlock List Population");
						
		try{
			
			testSuiteName="UnlockResetPassword";
			testCaseName="SeaarchandReset";
				
			UnlockResetMenu();
			System.out.println("ab");
			HTMLReport.startTest(testSuiteName,testCaseName);
			System.out.println("cd");
			//* Search by Login Id Start
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).sendKeys(data[0]);
			System.out.println("Value selected for LoginId");
			HTMLReport.logTest("Unlock Reset ", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
			System.out.println("ef");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).click();
			HTMLReport.logTest("Unlock Reset Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(UserListObj.addBtn)).click();
			HTMLReport.logTest("User Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

		
			driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).sendKeys(data[1]);
			HTMLReport.logTest("Unlock Reset ", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
			System.out.println("Value entered for login ID");
			driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).click();
			HTMLReport.logTest("User Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			HTMLReport.logTest("Unlock Reset page", "Search button clicked", "PASS", "click", "seach button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(UserListObj.selectBtn)).click();
			HTMLReport.logTest("Unlock Reset Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
			System.out.println("record Selected from the grid");						
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.viewBtn)).click();
			HTMLReport.logTest("Unlock Reset Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(UserListObj.resetBtn)).click();
			System.out.println("reset btn clicked");
			HTMLReport.logTest("Unlock Reset Page", "Selected a record and Reset a data", "PASS", "click", "Reset button clicked", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.okBtn)).click();
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
//		
	public static void SeaarchandUnlock(String[] data,String[] assertion) 
	
	{
		
		System.out.println("Reset Unlock List Population");
						
		try{
			
			testSuiteName="UnlockResetPassword";
			testCaseName="SeaarchandUnlock";
				
			UnlockResetMenu();
			System.out.println("ab");
			HTMLReport.startTest(testSuiteName,testCaseName);
			System.out.println("cd");
			//* Search by Login Id Start
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).sendKeys(data[0]);
			System.out.println("Value selected for OU Name");
			HTMLReport.logTest("Unlock Reset ", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
			System.out.println("ef");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).click();
			HTMLReport.logTest("Unlock Reset Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(UserListObj.addBtn)).click();
			HTMLReport.logTest("User Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

		
			driver.findElement(By.xpath(UserListObj.ouSearchDrpdown)).sendKeys(data[1]);
			HTMLReport.logTest("Unlock Reset ", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
			System.out.println("Value entered for login ID");
			driver.findElement(By.xpath(UserListObj.ouSearchDrpdown)).click();
			HTMLReport.logTest("User Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			HTMLReport.logTest("Unlock Reset page", "Search button clicked", "PASS", "click", "seach button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(UserListObj.selectBtn)).click();
			HTMLReport.logTest("Unlock Reset Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
			System.out.println("record Selected from the grid");						
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.viewBtn)).click();
			HTMLReport.logTest("Unlock Reset Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(UserListObj.unlockBtn)).click();
			System.out.println("reset btn clicked");
			HTMLReport.logTest("Unlock Reset Page", "Selected a record and unlock a data", "PASS", "click", "Unlock button clicked", "");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.okBtn)).click();
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
