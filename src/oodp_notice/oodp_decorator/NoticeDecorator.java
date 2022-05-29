package oodp_notice.oodp_decorator;
import oodp_notice.*;

public class NoticeDecorator extends NoticeDisplay{

    private NoticeDisplay decoratedDisplay;

    public NoticeDecorator(NoticeDisplay display){
        this.decoratedDisplay =  display;
    }
    public void draw(Notice team, String teamName){
        decoratedDisplay.draw(team, teamName);
    }
}
