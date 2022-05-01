package oopd.notice;

import java.util.Scanner;

/*
 * 숫자 콘솔 및 문자열 입력을 위한 클래스!
 */

public class NoticeConsole {
	public static String putStringToconsole() {
		String newNotice = "";
		Scanner userInput = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("> ");
				newNotice = userInput.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("다시 입력하십시오");
			}
		}
		return newNotice;
	}

	public static int putIntegerToconsole() {
		int index = 0;
		Scanner userInput = new Scanner(System.in);
		while (true) {
			try {				
				System.out.print("> ");
				index = userInput.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("다시 입력하십시오");
				userInput.nextLine();
			}
		}
		return index;
	}
}
