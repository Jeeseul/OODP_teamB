package oodp_meetRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Todorecord 
{
	public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. Add a new item ( add )");
        System.out.println("2. Delete an existing item ( del )");
        System.out.println("3. Update an item  ( edit )");
        System.out.println("4. List all items ( ls )");
        System.out.println("5. sort the list by date ( ls_cate )");
        System.out.println("6. Find items ( find )");
        System.out.println("7. Find category ( find_cate )");
        System.out.println("8. sort the list by name ( ls_name_asc )");
        System.out.println("9. sort the list by name ( ls_name_desc )");
        System.out.println("10. sort the list by date ( ls_date )");
        System.out.println("11. sort the list by date ( ls_date_desc )");
        System.out.println("12. exit (exit)");
    }
    
    public static void prompt()
    {
    	System.out.println();
        System.out.print("Command > ");
    }

    public static void createItem(recordList list) {
		
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n"
				+ "*** Create item ***\n"
				+ "title : ");
		
		title = sc.nextLine();
		if (list.isDuplicate(title)) {
			System.out.printf("title can't be duplicate");
			return;
		}
		
		System.out.print("description : ");
		desc = sc.nextLine();
		
		System.out.print("category : ");
		category = sc.nextLine();
		
		System.out.print("due_date : ");
		due_date = sc.nextLine();
		
		recordDAO t = new recordDAO(title, desc, category, due_date);
		list.addItem(t);
	}

	public static void deleteItem(recordList l) {
		
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


	public static void updateItem(recordList l) {
		
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
		sc.nextLine(); //버퍼 비우가
		System.out.print("new title : ");
		String new_title = sc.nextLine();
		if (l.isDuplicate(new_title)) {
			System.out.println("title can't be duplicate");
			return;
		}
		
		System.out.print("new description : ");
		String new_description = sc.nextLine();
		
		System.out.print("new category : ");
		String new_category = sc.nextLine().trim();
		
		System.out.print("new due_date : ");
		String new_due_date = sc.nextLine().trim();
		
		l.deleteItem(l.indexOf(num));
		recordDAO t = new recordDAO(new_title, new_description, new_category, new_due_date);
		l.addItem(t);
		System.out.println("item updated");

	}

	public static void listAll(recordList l) {
		int i=0;
		System.out.print("** list, " + l.size() + " ***");
		for (recordDAO item : l.getList()) {
			i++;
			System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
					+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
		}
	}
	
	public static void saveList(recordList l, String filename) {
		//filewriter이용
		try {
			Writer w = new FileWriter(filename);
			
			for (recordDAO item : l.getList()) {
				recordDAO i = new recordDAO(item.getTitle(), item.getDesc(), item.getCurrent_date(), item.getCategory(), item.getDue_date());
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
	
	public static void loadList(recordList l, String filename) {
		//bufferedreader, filereader, string tokenize
		try {
			BufferedReader  br = new BufferedReader(new FileReader(filename));
			
			String oneline;
			while((oneline = br.readLine()) != null) {
				// System.out.print((char) oneline);
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String title = st.nextToken();
				String desc = st.nextToken();
				String date = st.nextToken();
				String category = st.nextToken();
				String due_date = st.nextToken();
				
				recordDAO i = new recordDAO (title, desc, date, category, due_date);
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

	public static void find(recordList l, String str) {
		int i=0;
		int count = 0;
		for (recordDAO item : l.getList()) {
			i++;
			if(item.getTitle().contains(str) || item.getDesc().contains(str)) {
				System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
					+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
				count++;
			}	
		}
		System.out.println("find " + count + "item");
	}

	public static void find_cate(recordList l, String str) {
		int i=0;
		int count = 0;
		for (recordDAO item : l.getList()) {
			i++;
			if(item.getCategory().contains(str)) {
				System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
					+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
				count++;
			}	
		}
		System.out.println("find " + count + "item");
	}

	public static void listCate(recordList l) {
		HashSet<String> cate = new HashSet<String>();//HashSet생성
		for (recordDAO item : l.getList()) {
			cate.add(item.getCategory());
		}
		System.out.println(cate);
		System.out.println("total cate " + cate.size() + ".");
	}

}
