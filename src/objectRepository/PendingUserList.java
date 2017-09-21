package objectRepository;


/*
 * Locators displayed on Login Page
 * 
 * 
 */

public class PendingUserList {

	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------ID----------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	//Search criteria selection 
	
	public static String btnAdd="btnAdd";
	public static String removeOubtn="remOu";
	public static String srchUserNametxtbx="srchUserName";
	
	//Error Messages
	
	
	//Success Messages
		
	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------XPATH-------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	//Search buttons 
	
	public static String pendingUserApprovalListHeader=".//*[@id='page-wrapper']/div/div/div/h2";
	public static String searchLbl=".//*[@id='searchCriteria']/tbody/tr[1]/td[1]/label";
	public static String btnSearch=".//*[@id='btnSearch']";
	
	//.//*[@id='selList']
	public static String ouSelected=".//*[@id='ouSelect']";
	public static String ouNameSearch=".//*[@id='ouIdList']/td[1]/label";
	public static String logInIdSearch=".//*[@id='loginIdList']/td[1]/label";
	public static String searchBylistDropDown=".//*[@id='selList']";
	public static String removebtnlogin=".//*[@id='remLogin']";
	
	
	
	//Grid
	
	//
			
			
			
	public static String radioBtnSelected=".//*[@id='usrSelected']";
	public static String showRecordsPagelbl=".//*[@id='usrListTable_length']/label";
	public static String noOfRecordsdrpdwn=".//*[@id='usrListTable_length']/label/select";
	public static String searchtxtbxgrid=".//*[@id='usrListTable_filter']/label";
	
	public static String chkboxCol=".//*[@id='usrListTable']/thead/tr/th[1]";
	public static String logIdCol=".//*[@id='usrListTable']/thead/tr/th[2]/div";
	public static String fNameCol=".//*[@id='usrListTable']/thead/tr/th[3]/div";
	public static String lNameCol=".//*[@id='usrListTable']/thead/tr/th[4]/div";
	public static String eMailCol=".//*[@id='usrListTable']/thead/tr/th[5]/div";
	public static String mobCol=".//*[@id='usrListTable']/thead/tr/th[6]/div";
	public static String statuscol=".//*[@id='usrListTable']/thead/tr/th[7]/div";
	public static String orgUnitCol=".//*[@id='usrListTable']/thead/tr/th[8]/div";
	
	public static String usrTypeCol=".//*[@id='usrListTable']/thead/tr/th[9]/div";
	public static String createDateCol=".//*[@id='usrListTable']/thead/tr/th[10]/div";
	
	public static String recordCount=".//*[@id='usrListTable_wrapper']/div[3]";
	
	public static String viewBtn=".//*[@id='btnView']";
	public static String approveBtn=".//*[@id='addUpdateUserDetail']/div[2]/div/table/tbody/tr/td[1]/button";
	public static String rejectBtn=".//*[@id='addUpdateUserDetail']/div[2]/div/table/tbody/tr/td[2]/button";
	public static String backBtn=".//*[@id='btnBack']";
	
	
	public static String okBtn=".//*[@id='popup_ok']";
	public static String cancelBtn=".//*[@id='popup_cancel']";
	public static String commentsBox=".//*[@id='comment']";
	
}
