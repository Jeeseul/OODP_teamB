package oodp_notice;

/*
 *  공지 템플릿을 위한 클래스
 */

public class NoticeMenu {
	
	public static void displayNoticeManager()
    {
        System.out.println("\n*** Notice Management ***");
        System.out.println("0. Quit program");
        System.out.println("1. Add notice");
        System.out.println("2. Edit notice");
        System.out.println("3. Remove notice");
        System.out.println("4. Show notices ALL");
        System.out.println("5. find notices ALL");
        System.out.println("6. save notices using Memento");
        System.out.println("7. restore notices using Memento");
        System.out.println("\nPlease Select Menu: ");
    } 
	public static void displayTeamManager()
    {
        System.out.println("\n*** Team Management ***");
        System.out.println("0. Quit program");
        System.out.println("1. Select team");
        System.out.println("2. Show teams ALL");
        System.out.println("\nPlease Select Menu: ");
    } 
}
