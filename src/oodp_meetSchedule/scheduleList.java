package oodp_meetSchedule;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class scheduleList extends abstractList{
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

	public void editItem(scheduleDAO t, scheduleDAO updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}

	public ArrayList<scheduleDAO> getList() {
		return new ArrayList<scheduleDAO>(list);
	}
	@Override
	public void sortByName() {
		//Collections.sort(list, new scheduleSortByName());
	}
	@Override
	public void listAll() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		System.out.println("\n"
				+ "inside list_All method\n");
		int i=0;
		for (scheduleDAO myitem : list) {
			i++;
			System.out.println(i + "] " + myitem.getTitle() + " : " + myitem.getTeam()+ " : " + myitem.getDue_date().format(formatter) +  " : " +myitem.getCurrent_date());
		}
	}
	@Override
	public void reverseList() {
		Collections.reverse(list);
	}
	@Override
	public void sortByDate() {
		Collections.sort(list, new scheduleSortByDate());
	}

	public scheduleDAO indexOf(int num) {
		return list.get(num);
	}
	@Override
	public Boolean isDuplicate(String title) {
		for (scheduleDAO item : list) {
			if (title.equals(item.getTitle())) return true;
		}
		return false;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

}
