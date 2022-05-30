package oodp_notice.oodp_decorator;

import oodp_notice.*;

public class NoticeTeamPrintDecorator extends NoticeDisplay{

    @Override
    public void draw(Notice team, String teamName){
        System.out.println("현재 팀은 " + teamName +"입니다.");   
    }
}
