package oopd.notice;

/*
 * 실제 사용자가 사용할 클래스, 이 클래스를 통해서 공지를 추가함! 
 */

public class NoticeRunner {

	public void run() {

		NoticeDAO n = new NoticeDAO();
		boolean exitToMenu = true; // 공지 관리 기능
		boolean quitTheRunner = false; // 팀 선택 추가 기능
		int choice;

		do {
			NoticeMenu.displayTeamManager();
			
			// 팀이 없을 경우
			if (n.isExist() != true) {
				System.out.println("팀이 없습니다. \n");
				n.addTheTeam();
				n.printAllTeam();
				NoticeMenu.displayTeamManager();
			} 
			
			choice = NoticeConsole.putIntegerToconsole();
			switch (choice) {
			
			//팀 추가
			case 1:
				n.addTheTeam();
				break;
				
			//팀 선택
			case 2:
				// 잘못된 팀을 선택한 경우!
				if(!n.selectTheTeam())
					break;
				
				// 공지 관리 기능으로 넘어가기!
				exitToMenu = false;
				break;
				
			//팀 전체 출력 
			case 3:
				n.printAllTeam();
				break;
				
			//종료하기
			case 4:
				quitTheRunner = true;
				break;
			default:
				System.out.println("잘못 입력하셨습니다!");
				break;
			}
			
			//공지 관리 메뉴
			while(!exitToMenu) {
				NoticeMenu.displayNoticeManager();
				choice = NoticeConsole.putIntegerToconsole();
				switch (choice) {
				
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
					
				//공지 전체출력하기
				case 4:
					n.readAllNotion();
					break;
					
				//종료하기
				case 5:
					exitToMenu = true;
					break;
				
				default:
					System.out.println("잘못 입력하셨습니다!");
					break;
				}
			}
		} while (!quitTheRunner);

	}

	public static void main(String[] args) {
		NoticeRunner n = new NoticeRunner();
		n.run();
	}

}
