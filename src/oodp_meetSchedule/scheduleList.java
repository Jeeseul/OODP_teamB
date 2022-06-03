package oodp_meetSchedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class scheduleList {
	private List<scheduleDAO> list;

	public scheduleList() {
		this.list = new ArrayList<scheduleDAO>();
	}

	public void addItem(scheduleDAO t) {
		list.add(t);
	}

	public void deleteItem(scheduleDAO todoItem) {
		list.remove(todoItem);
	}

	void editItem(scheduleDAO t, scheduleDAO updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	public ArrayList<scheduleDAO> getList() {
		return new ArrayList<scheduleDAO>(list);
	}

	public void sortByName() {
		//Collections.sort(list, new scheduleSortByName());
	}

	public void listAll() {
		System.out.println("\n"
				+ "inside list_All method\n");
		int i=0;
		for (scheduleDAO myitem : list) {
			i++;
			System.out.println(i + "] " + myitem.getTitle() + " : " + myitem.getTeam()+ " : " + myitem.getCurrent_date() +  " : " +myitem.getDue_date());
		}
	}
	
	public void reverseList() {
		Collections.reverse(list);
	}

	public void sortByDate() {
		//Collections.sort(list, new scheduleSortByDate().compare(null, null));
	}

	public scheduleDAO indexOf(int num) {
		return list.get(num);
	}

	public Boolean isDuplicate(String title) {
		for (scheduleDAO item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
}
