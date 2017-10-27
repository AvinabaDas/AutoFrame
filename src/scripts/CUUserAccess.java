package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.AccesGrants;
import objectRepository.Dasboard;



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
			
		    driver.findElement(By.xpath(AccesGrants.lastBtn)).sendKeys(Keys.TAB);
			driver.findElement(By.xpath(AccesGrants.editViewBtn)).click();
			HTMLReport.logTest("Access Management Page", "List page selected", "PASS", "click", "View button clicked", "");
			System.out.println("Search btn clicked");						
			Thread.sleep(2000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			int alength = assertion.length;
			
			for (int i=0;i<alength;)
			{
				//WebElement elementToClick  = driver.findElement(By.xpath("//td[contains(text(),'"+assertion[i]+"')]/preceding-sibling::td/input[@type='checkbox']"));
				WebElement elementToClick  = driver.findElement(By.xpath("//td/input[@type='checkbox' and @value= '"+assertion[i]+"']"));
				System.out.println("Checked: "+elementToClick );
				
				try
				{
					driver.findElement(By.xpath("//td/input[@type='checkbox' and @value= '"+assertion[i]+"']")).click();
				}
				catch(Exception e)
				{
					Point classname = elementToClick.getLocation();
			        int xcordi = classname.getX();
			        xcordi =  xcordi-20;
			        System.out.println("Element's Position from left side "+xcordi+" pixels.");
			        
			        int ycordi = classname.getY();
			        ycordi = ycordi-20;
			        System.out.println("Element's Position from top "+ycordi+" pixels.");
			        
			        //jse.executeScript("arguments[0].scrollIntoView();",elementToClick);
					jse.executeScript("window.scrollBy("+xcordi+","+ycordi+")");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//td/input[@type='checkbox' and @value= '"+assertion[i]+"']")).click();	
				}


				System.out.println("Clicked: "+assertion[i]);
				i=i+1;
			}
			
			

			Thread.sleep(2000);
			
			try
			{
     	   	
	     	   driver.findElement(By.xpath(AccesGrants.addtoRoleBtn)).click();
	     	   	
			}
			catch(Exception e){
				
				WebElement addelementToClick  = driver.findElement(By.xpath(AccesGrants.addtoRoleBtn));
				System.out.println(e);
				Point classname = addelementToClick.getLocation();
		        int xcordi = classname.getX();
		        xcordi =  xcordi-20;
		        System.out.println("Element's Position from left side "+xcordi+" pixels.");
		        
		        int ycordi = classname.getY();
		        ycordi = ycordi-20;
		        System.out.println("Element's Position from top "+ycordi+" pixels.");
		        
		        //jse.executeScript("arguments[0].scrollIntoView();",elementToClick);
				jse.executeScript("window.scrollBy("+xcordi+","+ycordi+")");
				driver.findElement(By.xpath(AccesGrants.addtoRoleBtn)).click();
				Thread.sleep(2000);
			}
			
     	   
			try
			{
				driver.findElement(By.xpath(AccesGrants.checkAllMakerBtn)).click();
				driver.findElement(By.xpath(AccesGrants.checkAllMakerBtn)).sendKeys(Keys.TAB);
				driver.findElement(By.xpath(AccesGrants.checkAllCheckerBtn)).click();
				System.out.println("Checker All btn clicked");						
				Thread.sleep(2000);
				
				System.out.println("Maker All btn clicked");
			}
			catch(Exception e){
				
				WebElement addelementToClick  = driver.findElement(By.xpath(AccesGrants.addtoRoleBtn));
				System.out.println(e);
				Point classname = addelementToClick.getLocation();
		        int xcordi = classname.getX();
		        xcordi =  xcordi-20;
		        System.out.println("Element's Position from left side "+xcordi+" pixels.");
		        
		        int ycordi = classname.getY();
		        ycordi = ycordi-20;
		        System.out.println("Element's Position from top "+ycordi+" pixels.");
		        
		        //jse.executeScript("arguments[0].scrollIntoView();",elementToClick);
				jse.executeScript("window.scrollBy("+xcordi+","+ycordi+")");
				driver.findElement(By.xpath(AccesGrants.addtoRoleBtn)).click();
				driver.findElement(By.xpath(AccesGrants.checkAllMakerBtn)).sendKeys(Keys.TAB);
				driver.findElement(By.xpath(AccesGrants.checkAllCheckerBtn)).click();
				System.out.println("Checker All btn clicked");						
				Thread.sleep(2000);
			}	
			Thread.sleep(2000);
						
		    
			jse.executeScript("scroll(0, document.body.scrollHeight)"); 
			
			driver.findElement(By.xpath(AccesGrants.submitBtn)).click();
			System.out.println("Submit btn clicked");						
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
	
		}
