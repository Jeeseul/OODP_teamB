package oodp_notice.oodp_decorator;

import oodp_notice.NoticeConsole;
import oodp_notice.*;

public class NoticeFindAllDecorator extends NoticepPrintAllDecorator {

    public NoticeFindAllDecorator(NoticeDisplay decoratedDisplay) {
		super(decoratedDisplay);
	}

	public void draw(Notice team, String teamName) {
		super.draw(team, teamName);
		findList(team);
	}

    public void findList(Notice team) {
        int i  = 0;
        
        System.out.println("검색할 문자를 입력하세요!");
        String target = NoticeConsole.putStringToconsole();
        // ArrayList<String> na =  team.getteamNotices(); 
		for (String str : team.getteamNotices()) {
			if (str.contains(target)) {
				System.out.println(str);
			i++;
			}
		}
		System.out.println("총 " + i + "개의 항목을 찾았습니다.");
	}
}
