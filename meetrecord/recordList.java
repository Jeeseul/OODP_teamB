package meetrecord;
import java.util.*;

public class recordList {
    private List<recordDAO> list;

	public recordList() {
		this.list = new ArrayList<recordDAO>();
	}

	public void addItem(recordDAO t) {
		list.add(t);
	}

	public void deleteItem(recordDAO todoItem) {
		list.remove(todoItem);
	}

	void editItem(recordDAO t, recordDAO updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	public ArrayList<recordDAO> getList() {
		return new ArrayList<recordDAO>(list);
	}

	public void sortByName() {
		//Collections.sort(list, new TodoSortByName());
	}

	public void listAll() {
		System.out.println("\n"
				+ "inside list_All method\n");
		int i=0;
		for (recordDAO myitem : list) {
			i++;
			System.out.println(i + "] " + myitem.getTitle() + " : " + myitem.getDesc()+ " : " + myitem.getCurrent_date() + " : " + myitem.getCategory()+ " : " + myitem.getDue_date());
		}
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}

	public void sortByDate() {
		//Collections.sort(list, new TodoSortByDate());
	}

	public recordDAO indexOf(int num) {
		return list.get(num);
	}

	public Boolean isDuplicate(String title) {
		for (recordDAO item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
}
