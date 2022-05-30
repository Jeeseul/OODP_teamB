package oodp_meetSchedule;

import java.util.Scanner;
import java.util.StringTokenizer;


public class scheduleMain {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		scheduleList l = new scheduleList();
		boolean isList = false;
		boolean quit = false;
		scheduleRecord.loadList(l, "Schedulelist.txt");
		scheduleRecord.displaymenu();
		
		do {
			scheduleRecord.prompt();
			//������ �Ź� ǥ������ �ʰ� hel���ɾ� �Է� �ÿ� ��Ÿ������ ����
			//menu.propmpt()�߰�
			isList = false;
			String choice = sc.nextLine();
			
			if(choice.contains("find")) {
				StringTokenizer st = new StringTokenizer(choice, " ");
				String find = st.nextToken();
				String str = st.nextToken();
				scheduleRecord.find(l, str);
			}
			else {
				switch (choice) {
				
				case "help":
                scheduleRecord.displaymenu();
					break;
				case "add":
                scheduleRecord.createItem(l);
					break;
				
				case "del":
                scheduleRecord.deleteItem(l);
					break;
					
				case "edit":
                scheduleRecord.updateItem(l);
					break;
					
				case "ls":
                scheduleRecord.listAll(l);
					break;
					
				case "ls_name_asc":
					l.sortByName();
					isList = true;
					break;
	
				case "ls_name_team":
					l.sortByName();
					l.reverseList();
					isList = true;
					break;
					
				case "ls_date":
					l.sortByDate();
					isList = true;
					break;
					
				case "ls_date_team":
					l.sortByDate();
					l.reverseList();
					isList = true;
					break;
	
				case "exit":
                scheduleRecord.saveList(l, "Schedulelist.txt");
					quit = true;
					break;
					
				default:
					System.out.println("enter mentioned command (commands - help)");
					break;
				}
			}
			
			if(isList) l.listAll();
		} while (!quit);
	}
}
