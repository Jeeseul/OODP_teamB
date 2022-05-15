package oodp_notice;

import java.util.TreeMap;

/*
 * 공지 추가, 출력, 삭제 등 요청하는 클래스
 */
public class NoticeDAO {

	private static TreeMap<String, Notice> teams;
	private String teamName;

	public NoticeDAO() {
		NoticeDAO.teams = new TreeMap<String, Notice>();
		this.teamName = "";
	}
	
	public boolean isEmpty() {
		if (teams.isEmpty())
			return true;
		else
			return false;
		
	}

	public void printAllTeam() {
		int i = 1;
		for (String team : teams.keySet()) {
			System.out.println(i++ + ". " + team);
		}
	}

	public void addTheTeam() {

		System.out.println("추가할 팀을 입력하십시오.");

		String teamName = NoticeConsole.putStringToconsole();
		Notice team = new Notice();
		teams.put(teamName, team);
	}

	public boolean selectTheTeam() {
		String str;

		System.out.println("<팀 목록>");
		printAllTeam();
		System.out.println("팀을 선택하십시오. (문자열 입력!)\n" 
				+ "ex) 회계팀");
		str = NoticeConsole.putStringToconsole(); 
		
		//선택한 팀의 존재 유뮤 확인
		if(teams.containsKey(str)) {
			this.teamName = str;
			return true;
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			return false;
		}
	}

	public void addTheNotice() {
		Notice team = teams.get(this.teamName);
		String insertValue;
		System.out.println(this.teamName);
		System.out.println("공지를 입력하십시오.");
		String newNotice = NoticeConsole.putStringToconsole();
		if(team.addNotice(newNotice) == false)
			System.out.println("공지입력이 실패했습니다.");
		else {
			System.out.println("공지입력이 성공했습니다.");
			insertValue = team.getNoticeText(team.getLen());
			System.out.println(insertValue);
			
		}

	}

	public void updateTheNotice() {
		Notice team = teams.get(teamName);
		int index;
		String newNotice;	
		String updateValue;
		while (true) {
			try {
				readAllNotion();
				System.out.println("변경할 공지를 선택하십시오.");
				index = NoticeConsole.putIntegerToconsole();
				
				System.out.println("새로운 공지를 입력하십시오.");
				newNotice = NoticeConsole.putStringToconsole();
				if(team.setNoticeText(index, newNotice) == false)
					System.out.println("공지 변경이 실패했습니다.");
				else {
					System.out.println("공지 변경이 성공했습니다.");
					updateValue = team.getNoticeText(index);
					System.out.println(updateValue);
				}
				break;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("잘못된 번호입니다." + "\n" + "다시 입력하십시오." + "\n");
			}
		}

	}

	public void deleteTheNotice() {
		Notice team = teams.get(teamName);
		String returnValue;
		int index;
		while (true) {
			try {
				readAllNotion();
				System.out.println("삭제할 공지를 선택하십시오.");
				index = NoticeConsole.putIntegerToconsole();
				
				returnValue = team.getNoticeText(index);
				if(team.deleteTheNotice(index) == false)
					System.out.println("공지 삭제가 실패했습니다.");
				else {
					System.out.println("공지 삭제가 성공했습니다.");
					System.out.println(returnValue);
				}
				break;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("잘못된 번호입니다." + "\n" + "다시 입력하십시오." + "\n");
			}
		}
	}
	
	public void readAllNotion() {
		Notice team = teams.get(teamName);
		System.out.println(this.teamName);
		team.printAllNotices();
	}

}
