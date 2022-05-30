package oodp_notice.oodp_decorator;
import oodp_notice.*;

public class NoticeCountDecorator extends NoticeDecorator{
	public NoticeCountDecorator(NoticeDisplay decoratedDisplay) {
		super(decoratedDisplay);
	}

	public void draw(Notice team, String teamName) {
		super.draw(team, teamName);
        countAllNotion(team);
	}

    public static void countAllNotion(Notice selectedteam) {
        System.out.println("공지 개수! \n"+  "현재 개수는 " + selectedteam.getLen() + "입니다." );
	}
    
}