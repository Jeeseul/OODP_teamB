package meetrecord;
import java.util.Scanner;
import java.util.StringTokenizer;

public class recordMain {
    public static void start() {
	
		Scanner sc = new Scanner(System.in);
		recordList l = new recordList();
		boolean isList = false;
		boolean quit = false;
		Todorecord.loadList(l, "todolist.txt");
		Todorecord.displaymenu();
		
		do {
			Todorecord.prompt();
			//사용법을 매번 표현하지 않고 hel명령어 입력 시에 나타나도록 수정
			//menu.propmpt()추가
			isList = false;
			String choice = sc.nextLine();
			
			if(choice.contains("find_cate")){
				StringTokenizer st = new StringTokenizer(choice, " ");
				String find_cate = st.nextToken();
				String str = st.nextToken();
				Todorecord.find_cate(l, str);
			}
			else if(choice.contains("find")) {
				StringTokenizer st = new StringTokenizer(choice, " ");
				String find = st.nextToken();
				String str = st.nextToken();
				Todorecord.find(l, str);
			}
			else {
				switch (choice) {
				
				case "help":
                Todorecord.displaymenu();
					break;
				case "add":
                Todorecord.createItem(l);
					break;
				
				case "del":
                Todorecord.deleteItem(l);
					break;
					
				case "edit":
                Todorecord.updateItem(l);
					break;
					
				case "ls":
                Todorecord.listAll(l);
					break;
					
				case "ls_cate":
                Todorecord.listCate(l);
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
                Todorecord.saveList(l, "todolist.txt");
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
