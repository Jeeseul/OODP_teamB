package oodp_notice.oodp_noticeReading;

import oodp_notice.Notice;
import oodp_notice.oodp_decorator.*;

public class NoticeFinder implements NoticePrintStrategy {

    @Override
    public void draw(Notice team, String teamName) {
        NoticeDisplay findAllNotion = new NoticeFindAllDecorator(new NoticeTeamPrintDecorator());
        findAllNotion.draw(team, teamName);

    }
    
}