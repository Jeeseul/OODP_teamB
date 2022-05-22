package oodp_notice;

import oodp_user.NoticeObserver;

/*
 * 실제 사용자가 사용할 클래스, 이 클래스를 통해 공지를 추가함, caretaker의 역할도 수행함!
 */

// 여기서 이제 팀추가를 빼고, 팀을 teamDAO에서 받아오는 방법을 생각해야 할 듯!
public class NoticeRunner {

	private NoticeDAO n;
	private NoticeMemento snapshot;
	
	public void run(String teamName, NoticeObserver teamDAO) {

		boolean exitToMenu = true; // 공지 관리 기능
		boolean quitTheRunner = false; // 팀 선택 추가 기능
		int choice;
		n = new NoticeDAO(teamName,teamDAO);
		
		do {
			NoticeMenu.displayTeamManager();
		
			choice = NoticeConsole.putIntegerToconsole();
			switch (choice) {
			
			//종료하기
			case 0:
				quitTheRunner = true;
				break;
			//팀 선택
			case 1:
				// 잘못된 팀 선택한 경우
				if(!n.selectTheTeam())
					break;
				// 공지 관리 기능으로 넘어가기
				exitToMenu = false;
				break;
			//팀 전체 출력
			case 2:
				n.printAllTeam();
				break;
			//error
			default: //input error, retry an entry. 
        		System.out.println("Error: Invalid input. Please try again.");
        		break;
			}
			
			//공지 관리 메뉴
			while(!exitToMenu) {
				NoticeMenu.displayNoticeManager();
				choice = NoticeConsole.putIntegerToconsole();
				switch (choice) {
				
				//종료하기
				case 0:
					exitToMenu = true;
					break;
				//공지 추가하기
				case 1:
					n.addTheNotice();
					break;
				//공지 수정하기
				case 2:
					n.updateTheNotice();
					break;
				//공지 삭제하기
				case 3:
					n.deleteTheNotice();
					break;
				//공지 전체 출력하기
				case 4:
					n.readAllNotion();
					break;
				// 공지 저장하기!
				case 5:
					this.snapshot = n.createNoticeDAOMemento();
					break;
				//이전 공지 불러오기!
				case 6:
					n.restoreNoticeDAOMemento(this.snapshot);
					break;
				//error
				default: //input error, retry an entry. 
            		System.out.println("Error: Invalid input. Please try again.");
            		break;
				}
			}
		} while (!quitTheRunner);

	}


}
