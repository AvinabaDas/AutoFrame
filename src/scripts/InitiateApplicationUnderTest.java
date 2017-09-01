package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import commonFunctions.FrameworkFunctions;
import driver.Driver;
import objectRepository.*;

public class InitiateApplicationUnderTest extends Driver {
	
	
	public static void openApplicationURL()
	{
		try{
			
			testSuiteName="InitiateApplicationUnderTest";
			testCaseName="openApplicationURL";
			
			driver.manage().window().maximize();
			driver.get(QA_ENVIRONMENT);
			
			
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
			
			FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
			FrameworkFunctions.screenShot(testCaseName);
			
			
		}catch(Exception e){
			
			System.out.println(e);
			try {
				FrameworkFunctions.screenShot("Error"+testCaseName);
			} catch (HeadlessException | IOException | AWTException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
}
