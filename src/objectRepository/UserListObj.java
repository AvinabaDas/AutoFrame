package objectRepository;

/*
 *
 */
public class UserListObj {

	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------ID----------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	/*----------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------XPATH-------------------------------------------------------*/
	/*----------------------------------------------------------------------------------------------------------*/
	
	public static String userListHdr=".//*[@id='page-wrapper']/div/div/div/h2";
	
	public static String searchByDrpdwn=".//*[@id='selList']";
	public static String searchByLbl=".//*[@id='searchCriteria']/tbody/tr[1]/td[1]/label";
	
	public static String searchByOUIDLbl=".//*[@id='loginIdList']/td[1]/label";
	public static String searchByOUIDtxtBx=".//*[@id='srchUserName']";
	
	public static String ouSearchDrpdown=".//*[@id='ouSelect']";
	
	public static String searchByStatusLbl=".//*[@id='statusList']/td[1]/label";
	public static String searchByStatusDrpdwn=".//*[@id='statusSelect']";
	
	public static String searchByOULbl=".//*[@id='ouIdList']/td[1]/label";
	public static String searchByOUDrpdwn=".//*[@id='ouIdList']/td[1]/label";
		
	public static String removeOUBtn=".//*[@id='remOu']";
	public static String removeLoginIdBtn=".//*[@id='remLogin']";
	public static String removeStatusBtn=".//*[@id='remStatus']";
	
	public static String addBtn=".//*[@id='btnAdd']";
	public static String searchBtn=".//*[@id='btnSearch']";
	
	public static String selectBtn=".//*[@id='usrSelected']";
	
	public static String searchtxtboxgrid=".//*[@id='usrListTable_filter']/label/input";
	public static String viewBtn=".//*[@id='btnView']";
	
	public static String deptDrowpDown=".//*[@id='departmntlst']";
	public static String updateBtn=".//*[@id='bUpdate']";

	
	public static String deactivateBtn=".//*[@id='bDeactivate']";
	public static String deleteBtn=".//*[@id='bDelete']";
	
	public static String okBtn=".//*[@id='popup_ok']";
	public static String cancelBtn=".//*[@id='popup_cancel']";

	public static String resetBtn=".//*[@id='addUpdateUserDetail']/div[2]/div/div/button[2]";
	public static String unlockBtn=".//*[@id='addUpdateUserDetail']/div[2]/div/div/button[1]";	
}
