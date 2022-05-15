import java.util.Scanner;
import java.util.StringTokenizer;

public class TodoMain {
    public static void start() {
	
		Scanner sc = new Scanner(System.in);
		meetList l = new meetList();
		boolean isList = false;
		boolean quit = false;
		TodoMeet.loadList(l, "todolist.txt");
		TodoMeet.displaymenu();
		
		do {
			TodoMeet.prompt();
			//사용법을 매번 표현하지 않고 hel명령어 입력 시에 나타나도록 수정
			//menu.propmpt()추가
			isList = false;
			String choice = sc.nextLine();
			
			if(choice.contains("find_cate")){
				StringTokenizer st = new StringTokenizer(choice, " ");
				String find_cate = st.nextToken();
				String str = st.nextToken();
				TodoMeet.find_cate(l, str);
			}
			else if(choice.contains("find")) {
				StringTokenizer st = new StringTokenizer(choice, " ");
				String find = st.nextToken();
				String str = st.nextToken();
				TodoMeet.find(l, str);
			}
			else {
				switch (choice) {
				
				case "help":
                TodoMeet.displaymenu();
					break;
				case "add":
                TodoMeet.createItem(l);
					break;
				
				case "del":
                TodoMeet.deleteItem(l);
					break;
					
				case "edit":
                TodoMeet.updateItem(l);
					break;
					
				case "ls":
                TodoMeet.listAll(l);
					break;
					
				case "ls_cate":
                TodoMeet.listCate(l);
					break;
	
				case "ls_name_asc":
					l.sortByName();
					isList = true;
					break;
	
				case "ls_name_desc":
					l.sortByName();
					l.reverseList();
					isList = true;
					break;
					
				case "ls_date":
					l.sortByDate();
					isList = true;
					break;
					
				case "ls_date_desc":
					l.sortByDate();
					l.reverseList();
					isList = true;
					break;
	
				case "exit":
                TodoMeet.saveList(l, "todolist.txt");
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
