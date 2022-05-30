package oodp_notice.oodp_decorator;
import oodp_notice.*;


public class NoticepPrintAllDecorator extends NoticeDecorator{
	public NoticepPrintAllDecorator(NoticeDisplay decoratedDisplay) {
		super(decoratedDisplay);
	}

	public void draw(Notice team, String teamName) {
		super.draw(team, teamName);
		readAllNotion(team, teamName);
	}

    public static void readAllNotion(Notice selectedteam, String teamName) {
		Notice team = selectedteam;
		team.printAllNotices();
	}
    
}
