package objectRepository;


/*
 * Locators displayed on Login Page
 * 
 * 
 */
public class RegisterUser {

	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------ID----------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	
	//BBCU or BBPOU type selection 
	public static String userTypeOu="userTypeOu";
	public static String userTypeCu="userTypeCu";
	
	//Availibility check
	
	public static String outext="outext";
	public static String oulist="oulist";
	public static String loginId="loginId";
	public static String checkAvailibilitybtn="loaderIcon";
	
	//Data entry 
	public static String empId="empId";
	public static String userName="userName";
	
	
	
	public static String lastName="lastName";
	public static String emailId="emailId";
	public static String mobileNo="mobileNo";
	public static String departmntlst="departmntlst";
	public static String desglst="desglst";
	public static String admnlst="admnlst";
	
	//Error Messages
	public static String loadedErrorResult="loadedErrorResult";
	
	//Success Messages
	public static String loadedSuccessResult="loadedSuccessResult";	
		
	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------XPATH-------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	public static String createUser=".//*[@id='addUpdateUserDetail']/div[1]/div/h2";
	
	public static String empIdsucc=".//*[@id='tremp']/div";
	public static String empIderr=".//*[@id='emapiderr']";
	
	public static String userNameerr=".//*[@id='userNameerr']";
	public static String lastNameerr=".//*[@id='lastNameerr']";
	
	public static String emailiderr=".//*[@id='emailiderr']";
	public static String emailidavail=".//*[@id='emailidavail']";
	
	public static String moberr=".//*[@id='moberr']";
	public static String mobsucc=".//*[@id='mobavail']";
	
	
	public static String OUID=".//*[@id='orgunitid']";
	
	public static String depterr=".//*[@id='depterr']";
	public static String designerr=".//*[@id='desinerr']";
	
	public static String ouerr=".//*[@id='ouerr']";
	
	public static String popupConfirm=".//*[@id='popup_overlay']";
	public static String popupOk=".//*[@id='popup_ok']";
	public static String popupCancel=".//*[@id='popup_cancel']";
	
	public static String msgSuccess=".//*[@id='msg']";
	
	public static String submitBtn=".//*[@id='btncreate']/button";
	public static String clearBtn=".//*[@id='btnClr']";
	
}
