package scripts;

import java.awt.event.FocusEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import objectRepository.RegisterUser;



public class CUUserAccess extends Driver{	
	
	//**User List Menu opening **//
	public static void CUUserAccessMenu() 
	{
		testSuiteName="CUUserAccess";
		testCaseName="CUUserAccessMenu";
		HTMLReport.startTest(testSuiteName,testCaseName);
			
		try
		{
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.accessMgmt)).click();
				System.out.println("Access Mgmt Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("Access Management menu", "Access mgmt Menu", "PASS", "click", "Access Manegment Clicked", "");
				
				driver.findElement(By.xpath(Dasboard.accessGrants)).click();
				System.out.println("Access Grants menu Clicked");
				Thread.sleep(2000);
				HTMLReport.logTest("Access Management Page", "Access Grants  Menu", "PASS", "click", "Access grants List Clicked", "");
				//HTMLReport.logTest("User List menu", "DashboardView", "INFO", "Found"+assertion[0], "Value"+assertion[0], "");
				
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				HTMLReport.endTest();
				ExcelReport.screenShot(testCaseName);
				
		}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	//**Search an user and update **//
	public static void AddAccess(String[] data,String[] assertion) 
	
	{
		
		System.out.println("access List Population");
						
		try{
			
			testSuiteName="CUUserAccess";
			testCaseName="AddAccess";
				
			CUUserAccessMenu();
			
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
			
		    driver.findElement(By.xpath(AccesGrants.page5)).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(AccesGrants.editViewBtn)).click();
			HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(5000);
			
		    driver.findElement(By.xpath(AccesGrants.accessVelocit)).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(AccesGrants.accessAll)).click();
			HTMLReport.logTest("Access Management Page", "User Management", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(AccesGrants.addtoRoleBtn)).click();
			System.out.println("Ok btn clicked");						
			Thread.sleep(2000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(document.body.scrollHeight,0)"); 
			driver.findElement(By.xpath(AccesGrants.checkAllMakerBtn)).click();
			System.out.println("Maker All btn clicked");
			
				
			Thread.sleep(2000);
						
		    driver.findElement(By.xpath(AccesGrants.checkAllMakerBtn)).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(AccesGrants.checkAllCheckerBtn)).click();
			System.out.println("Checker All btn clicked");						
			Thread.sleep(2000);
			
			
			jse.executeScript("scroll(0, document.body.scrollHeight)"); 
			
			driver.findElement(By.xpath(AccesGrants.submitBtn)).click();
			System.out.println("Submit btn clicked");						
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
	
	
	//**Search an user and Deactivate **//
//	public static void Seaarchanddeactivate(String[] data,String[] assertion) 
//			
//			{
//				
//				System.out.println("User List Population");
//								
//				try{
//					
//					testSuiteName="UserList";
//					testCaseName="Seaarchanddeactivate";
//						
//					UserListMenu();
//					System.out.println("ab");
//					HTMLReport.startTest(testSuiteName,testCaseName);
//					System.out.println("cd");
//					//* Search by Login Id Start
//					driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).sendKeys(data[0]);
//					System.out.println("Value selected for LoginId");
//					HTMLReport.logTest("User Management Page", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
//					System.out.println("ef");
//					Thread.sleep(2000);
//					driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).click();
//					HTMLReport.logTest("User Management Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
//					System.out.println("Value selected for searchbydropdnw");
//					Thread.sleep(2000);
//			
//					driver.findElement(By.xpath(UserListObj.addBtn)).click();
//					HTMLReport.logTest("User Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
//					System.out.println("Add btn Clicked");
//					Thread.sleep(2000);
//
//				
//					driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).sendKeys(data[1]);
//					HTMLReport.logTest("User Management Page", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
//					System.out.println("Value entered for login ID");
//					driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).click();
//					HTMLReport.logTest("User Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
//					System.out.println("Value selected for searchbydropdnw");
//					Thread.sleep(2000);
//				
//					driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//					HTMLReport.logTest("User Management Page", "Search button clicked", "PASS", "click", "seach button clicked", "");
//					System.out.println("Search btn clicked");						
//					Thread.sleep(2000);
//					
//					driver.findElement(By.xpath(UserListObj.selectBtn)).click();
//					HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
//					System.out.println("record Selected from the grid");						
//					Thread.sleep(2000);
//					driver.findElement(By.xpath(UserListObj.viewBtn)).click();
//					HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "View button clicked", "");
//					System.out.println("Search btn clicked");						
//					Thread.sleep(2000);
//					
//					driver.findElement(By.xpath(UserListObj.deactivateBtn)).click();
//					System.out.println("Deactivate btn clicked");
//					HTMLReport.logTest("User Management Page", "Selected a record and deactivate a data", "PASS", "click", "Deactivate button clicked", "");
//					Thread.sleep(2000);
//					driver.findElement(By.xpath(UserListObj.okBtn)).click();
//					System.out.println("Ok btn clicked");						
//					Thread.sleep(2000);
//					
//					ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
//					ExcelReport.screenShot(testCaseName);
//					HTMLReport.endTest();
//				}
//				catch(Exception e){
//					
//					System.out.println(e);
//					HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Dashboard", "" +e, "");
//			}
//			
//				
//			}
//	
//	//**Search an user and Delete **//
//		public static void Seaarchanddelete(String[] data,String[] assertion) 
//				
//				{
//					
//					System.out.println("User List Population");
//									
//					try{
//						
//						testSuiteName="UserList";
//						testCaseName="Seaarchanddelete";
//							
//						UserListMenu();
//						System.out.println("ab");
//						HTMLReport.startTest(testSuiteName,testCaseName);
//						System.out.println("cd");
//						//* Search by Login Id Start
//						driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).sendKeys(data[0]);
//						System.out.println("Value selected for LoginId");
//						HTMLReport.logTest("User Management Page", "searchByDrpdwn", "PASS", "click", "Data entered in searchByDrpdwn", "");
//						System.out.println("ef");
//						Thread.sleep(2000);
//						driver.findElement(By.xpath(UserListObj.searchByDrpdwn)).click();
//						HTMLReport.logTest("User Management Page", "Login ID selected from the dropdown", "PASS", "click", "Login ID selected from the dropdown", "");
//						System.out.println("Value selected for searchbydropdnw");
//						Thread.sleep(2000);
//				
//						driver.findElement(By.xpath(UserListObj.addBtn)).click();
//						HTMLReport.logTest("User Management Page", "Login ID selected in searchByDrpdwn ", "PASS", "click", "Add button clicked", "");
//						System.out.println("Add btn Clicked");
//						Thread.sleep(2000);
//
//					
//						driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).sendKeys(data[1]);
//						HTMLReport.logTest("User Management Page", "OU name selected in searchByDrpdwn ", "PASS", "click", "OU Name - dropdown clicked", "");
//						System.out.println("Value entered for login ID");
//						driver.findElement(By.xpath(UserListObj.searchByOUIDtxtBx)).click();
//						HTMLReport.logTest("User Management Page", "OU name entered  in searchBytext box ", "PASS", "click", "OU id entered from param", "");
//						System.out.println("Value selected for searchbydropdnw");
//						Thread.sleep(2000);
//					
//						driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//						HTMLReport.logTest("User Management Page", "Search button clicked", "PASS", "click", "seach button clicked", "");
//						System.out.println("Search btn clicked");						
//						Thread.sleep(2000);
//						
//						driver.findElement(By.xpath(UserListObj.selectBtn)).click();
//						HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "Record selected from the grid", "");
//						System.out.println("record Selected from the grid");						
//						Thread.sleep(2000);
//						driver.findElement(By.xpath(UserListObj.viewBtn)).click();
//						HTMLReport.logTest("User Management Page", "List page selected", "PASS", "click", "View button clicked", "");
//						System.out.println("Search btn clicked");						
//						Thread.sleep(2000);
//						
//						
//						driver.findElement(By.xpath(UserListObj.deleteBtn)).click();
//						System.out.println("Deactivate btn clicked");
//						HTMLReport.logTest("User Management Page", "Selected a record and delete a data", "PASS", "click", "Delete button clicked", "");
//						Thread.sleep(2000);
//						driver.findElement(By.xpath(UserListObj.okBtn)).click();
//						System.out.println("Ok btn clicked");						
//						Thread.sleep(2000);
//						
//						ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
//						ExcelReport.screenShot(testCaseName);
//						HTMLReport.endTest();
//					}
//					catch(Exception e){
//						
//						System.out.println(e);
//						HTMLReport.logTest("Dashboard Page", "DashboardView", "INFO", "Dashboard", "" +e, "");
//				}
//				
//					
//				}
//		
//	
//	
//	//**Search an user **//
//	public static void Searchstatus(String[] data,String[] assertion) 
//	
//	{
//		
//		System.out.println("User List Population");
//						
//		try{
//			
//			testSuiteName="UserList";
//			testCaseName="Searchstatus";
//			
//			UserListMenu();
//			
//			//* Search by Login Id Start
//			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).sendKeys(data[0]);
//			System.out.println("sTATUS Dropdown opened");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).click();
//			System.out.println("sTATUS selected from searchbydropdnw");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//			System.out.println("Add btn Clicked");
//			Thread.sleep(2000);
//
//			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//			System.out.println("Search btn clicked");						
//			Thread.sleep(2000);
//		
//			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).sendKeys(data[1]);
//			System.out.println("sTATUS Dropdown opened");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath(UserListObj.searchByStatusDrpdwn)).click();
//			System.out.println("sTATUS selected from searchbydropdnw");
//			Thread.sleep(2000);
//	
//			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//			System.out.println("Add btn Clicked");
//			Thread.sleep(2000);
//
//			driver.findElement(By.xpath(UserListObj.searchBtn)).click();
//			System.out.println("Search btn clicked");						
//			Thread.sleep(2000);
//			
//			
//		//	ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
//		//	ExcelReport.screenShot(testCaseName);			
//			
//			
//		}
//		catch(Exception e){
//			
//			System.out.println(e);
//	}
//	
				
	
//	}
	}
