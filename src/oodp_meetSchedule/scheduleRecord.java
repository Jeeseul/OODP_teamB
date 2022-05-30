package oodp_meetSchedule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class scheduleRecord {
	public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. Add a new item ( add )");
        System.out.println("2. Delete an existing item ( del )");
        System.out.println("3. Update an item  ( edit )");
        System.out.println("4. List all items ( ls )");
        System.out.println("5. Find items ( find )");
        System.out.println("6. sort the list by name ( ls_name_asc )");
        System.out.println("7. sort the list by name ( ls_name_team )");
        System.out.println("8. sort the list by date ( ls_date )");
        System.out.println("9. sort the list by date ( ls_date_team )");
        System.out.println("10. exit (exit)");
    }
    
    public static void prompt()
    {
    	System.out.println();
        System.out.print("Command > ");
    }

    public static void createItem(scheduleList list) {
		
		String title, team, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "*** Create item ***\n"
				+ "title : ");
		
		title = sc.nextLine();
		if (list.isDuplicate(title)) {
			System.out.printf("title can't be duplicate");
			return;
		}
		
		System.out.print("team : ");
		team = sc.nextLine();
		
		System.out.print("due_date : ");
		due_date = sc.nextLine();
		
		scheduleDAO t = new scheduleDAO(title, team, due_date);
		list.addItem(t);
	}

	public static void deleteItem(scheduleList l) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("\n"
				+ "*** Delete Item ***\n"
				+ "num : ");
		
		int num = sc.nextInt();
		
		System.out.print("delete the " + num + " ? (y/n)");
		String check = sc.next();
		if(check.equals("y")) {
			l.deleteItem(l.indexOf(num-1));
			System.out.println("delete the " + num);
		}
		
		
	}


	public static void updateItem(scheduleList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "*** Edit Item ***\n"
				+ "num : ");
		int num = sc.nextInt();
		num--;
		if (num > l.size()) {
			System.out.println("num doesn't exist");
			return;
		}
		sc.nextLine(); //���� ��찡
		System.out.print("new title : ");
		String new_title = sc.nextLine();
		if (l.isDuplicate(new_title)) {
			System.out.println("title can't be duplicate");
			return;
		}
		
		System.out.print("new team : ");
		String new_team = sc.nextLine();
		
		System.out.print("new due_date : ");
		String new_due_date = sc.nextLine().trim();
		
		l.deleteItem(l.indexOf(num));
		scheduleDAO t = new scheduleDAO(new_title, new_team, new_due_date);
		l.addItem(t);
		System.out.println("item updated");

	}

	public static void listAll(scheduleList l) {
		int i=0;
		System.out.print("** list, " + l.size() + " ***");
		for (scheduleDAO item : l.getList()) {
			i++;
			System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getTeam()
					+ "\n    " + item.getCurrent_date()+ "\n    " + item.getDue_date());
		}
	}
	
	public static void saveList(scheduleList l, String filename) {
		//filewriter�̿�
		try {
			Writer w = new FileWriter(filename);
			
			for (scheduleDAO item : l.getList()) {
				scheduleDAO i = new scheduleDAO(item.getTitle(), item.getTeam(), item.getCurrent_date(), item.getDue_date());
				w.write(i.toSaveString());
			}
			w.close();
			
			System.out.println("sucess save list");
		} catch (FileNotFoundException e) {
			System.out.println("file no exist\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadList(scheduleList l, String filename) {
		//bufferedreader, filereader, string tokenize
		try {
			BufferedReader  br = new BufferedReader(new FileReader(filename));
			
			String oneline;
			while((oneline = br.readLine()) != null) {
				// System.out.print((char) oneline);
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String title = st.nextToken();
				String team = st.nextToken();
				String date = st.nextToken();
				String due_date = st.nextToken();
				
				scheduleDAO i = new scheduleDAO (title, team, date, due_date);
				l.addItem(i);
			}
			System.out.println("\n sucess loading data");
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("file no exist\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void find(scheduleList l, String str) {
		int i=0;
		int count = 0;
		for (scheduleDAO item : l.getList()) {
			i++;
			if(item.getTitle().contains(str) || item.getTeam().contains(str)) {
				System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getTeam()
					+ "\n    " + item.getCurrent_date()+ "\n    " +  item.getDue_date());
				count++;
			}	
		}
		System.out.println("find " + count + "item");
	}


	public static void listTeam(scheduleList l) {
		HashSet<String> Teams = new HashSet<String>();//HashSet����
		for (scheduleDAO item : l.getList()) {
			Teams.add(item.getTeam());
		}
		System.out.println(Teams);
		System.out.println("total team " + Teams.size() + ".");
	}
}