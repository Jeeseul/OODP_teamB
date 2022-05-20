package oodp_notice;

import java.util.TreeMap;

import oodp_notice.NoticeObserver;

import java.util.ArrayList;
/*
 * 공지 추가, 출력, 삭제 등 요청하는 클래스
 * 메멘토 패턴이 적용되어있기 때문에 얘가 originator의 기능도 하고 있음!
 * 
 * 옵저버 패턴의 경우는 apprunner 클래스가 관찰 대상이라고 생각을 해야할듯!
 *  => teamDAO를 가지고 있다고 생각하는 모양새가 좀 이상하다고 생각함!
 * 	만약에 아닌거 같으면 그냥 teamDAO를 가지고 있는 방식으로 하자!
 */
public class NoticeDAO {

	// teamMember 변수 여기다 넣을지 잘 생각하기!

	private TreeMap<String, Notice> teams;
	private String teamName;
	private NoticeObserver teamMember;
	
	public NoticeMemento createNoticeDAOMemento() {
		// deep copy
		TreeMap<String, Notice> stateOfTeams = new TreeMap<String, Notice>();
		Notice temp = new Notice();
		String stateOfName = new String(teamName);
		ArrayList<String> copyingForMem = teams.get(teamName).getteamNotices();
		
		for(String t: copyingForMem)
				temp.addNotice(t);
		stateOfTeams.put(teamName, temp);

		NoticeMemento snapshot = new NoticeMemento(stateOfTeams,stateOfName);
		return snapshot;
	}

	public void restoreNoticeDAOMemento(NoticeMemento memento) {
		this.teams = memento.getStateMap();
		this.teamName = memento.getTeamName();
	}

	public NoticeDAO(String teamName, NoticeObserver teamDAO) {
		this.teams = new TreeMap<String, Notice>();
		this.teamName = teamName;
		Notice team = new Notice();
		teams.put(teamName, team);
		this.teamMember = teamDAO;
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
			// 옵저버 패턴
			notifyingUpdate(insertValue);
			
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
					// 옵저버 패턴
					notifyingUpdate(updateValue);
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
					// 옵저버 패턴
					notifyingUpdate(returnValue);
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


	public void notifyingUpdate(String upadatedValue){
		teamMember.updateNotification(upadatedValue);
	}


}
