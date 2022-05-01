package oopd.notice;

import java.util.Scanner;


/*
 *  공지 템플릿을 위한 클래스
 */

public class NoticeMenu {
	
	public static void displayNoticeManager()
    {
        System.out.println("\n<공지 관리 기능>");
        System.out.println("\n<원하는 메뉴를 선택하세요!>");
        System.out.println("1. 공지추가");
        System.out.println("2. 공지변경");
        System.out.println("3. 공지삭제");
        System.out.println("4. 공지전체출력");
        System.out.println("5. 프로그램 종료");
    } 
	public static void displayTeamManager()
    {
        System.out.println("\n<팀 선택 추가 기능>");
        System.out.println("\n<원하는 메뉴를 선택하세요!>");
        System.out.println("1. 팀 추가");
        System.out.println("2. 팀 선택");
        System.out.println("3. 팀 전체출력");
        System.out.println("4. 프로그램 종료");
    } 

	
}
