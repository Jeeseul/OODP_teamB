package oodp_notice.oodp_noticeReading;

import oodp_notice.Notice;
import oodp_notice.oodp_decorator.*;

public class NoticeReader implements NoticePrintStrategy {

    @Override
    public void draw(Notice team, String teamName) {
        NoticeDisplay printAllNotice = new NoticepPrintAllDecorator(new NoticeCountDecorator(new NoticeTeamPrintDecorator()));
        printAllNotice.draw(team, teamName);
    }

}