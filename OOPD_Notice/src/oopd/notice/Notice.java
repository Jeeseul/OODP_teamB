package oopd.notice;

import java.util.ArrayList;

public class Notice {

	private ArrayList<String> teamNotices;
	
	public int getLen() {
		return teamNotices.size();
	}

	public Notice() {
		this.teamNotices = new ArrayList<String>();
		
	}
	
	public boolean addNotice(String newNotice) {
			return teamNotices.add(newNotice);
	}
	
	public String getNoticeText(int index) {
		if(teamNotices.isEmpty()) {
			System.out.println("공지가 없습니다!"+ "\n");
			return "";
		}
		index--; // set the index into list
		return index + 1 +". " + teamNotices.get(index);
	}
	
	public void printAllNotices() {
		int i  = 1;
		
		if(teamNotices.isEmpty()) {
			System.out.println("공지가 없습니다!"+ "\n");
			return ;
		}
		
		
		for(String str : teamNotices)
			System.out.println(i++ + ". " + str);
		System.out.println();
	}
	
	
	// This is for using update
	public boolean setNoticeText(int index, String newNotice) {
		if(teamNotices.isEmpty()) {
			System.out.println("공지가 없습니다!"+ "\n");
			return false;
		}
		
		index--; // set the index into list
		String oldNotice = teamNotices.get(index);
		
		//it returns previous string.
		if (teamNotices.set(index, newNotice).equals(oldNotice))
			return true;
		else
			return false;
	}

	public boolean deleteTheNotice(int index) {
		if(teamNotices.isEmpty()) {
			System.out.println("공지가 없습니다!"+ "\n");
			return false;
		}
		
		index--; // set the index into list
		// it returns deleted string.
		return teamNotices.remove(index) != null;
	}
	

}
