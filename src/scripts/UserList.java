package scripts;

import org.openqa.selenium.By;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.UserListObj;


public class UserList extends Driver{	
	

	public static void UserListMenu() 
	{
		testSuiteName="UserList";
		testCaseName="UserListMenu";
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
				driver.findElement(By.xpath(Dasboard.userListmenu)).click();
				System.out.println("userListmenu menu Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("User Management Page", "User mgmt Menu", "PASS", "click", "User List Clicked", "");
				//HTMLReport.logTest("User List menu", "DashboardView", "INFO", "Found"+assertion[0], "Value"+assertion[0], "");
				
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				HTMLReport.endTest();
				ExcelReport.screenShot(testCaseName);
				
		}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	//**CU Admin Data Entry and submission **//
	
	public static void Seaarchandupdate(String[] data,String[] assertion) 
	
	{
		
		System.out.println("User List Population");
						
		try{
			
			testSuiteName="UserList";
			testCaseName="Seaarchandupdate";
				
			UserListMenu();
			System.out.println("ab");
			HTMLReport.startTest(testSuiteName,testCaseName);
			System.out.println("cd");
			//* Search by Login Id Start
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).sendKeys(data[0]);
			System.out.println("Value selected for LoginId");
			HTMLReport.logTest("User Management Page", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
			System.out.println("ef");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).click();
			HTMLReport.logTest("User Management Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(UserListObj.addBtn)).click();
			HTMLReport.logTest("User Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

		
			driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).sendKeys(data[1]);
			HTMLReport.logTest("User Management Page", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
			System.out.println("Value entered for login ID");
			driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).click();
			HTMLReport.logTest("User Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
			System.out.println("Value selected for searchbydropdnw");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			HTMLReport.logTest("User Management Page", "Search button clicked", "PASS", "click", "seach button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(UserListObj.selectBtn)).click();
			HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
			System.out.println("record Selected from the grid");						
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.viewBtn)).click();
			HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(UserListObj.deptDrowpDown)).sendKeys(data[2]);
			driver.findElement(By.xpath(UserListObj.deptDrowpDown)).click();
			System.out.println("department dropdown clicked");	
			HTMLReport.logTest("User Management Page", "Selected a record and clicked on View", "PASS", "click", "Department dropdown data selected", "");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(UserListObj.updateBtn)).click();
			System.out.println("Update btn clicked");
			HTMLReport.logTest("User Management Page", "Selected a record and update a data", "PASS", "click", "Update button clicked", "");
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
	public static void Searchstatus(String[] data,String[] assertion) 
	
	{
		
		System.out.println("User List Population");
						
		try{
			
			testSuiteName="UserList";
			testCaseName="Searchstatus";
			
			UserListMenu();
			
			//* Search by Login Id Start
			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).sendKeys(data[0]);
			System.out.println("sTATUS Dropdown opened");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).click();
			System.out.println("sTATUS selected from searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).sendKeys(data[1]);
			System.out.println("sTATUS Dropdown opened");
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).click();
			System.out.println("sTATUS selected from searchbydropdnw");
			Thread.sleep(2000);
	
			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			System.out.println("Add btn Clicked");
			Thread.sleep(2000);

			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			
		//	ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
		//	ExcelReport.screenShot(testCaseName);			
			
			
		}
		catch(Exception e){
			
			System.out.println(e);
	}
	
				
	
	}
	}
