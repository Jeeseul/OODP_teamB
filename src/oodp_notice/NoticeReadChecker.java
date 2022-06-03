package oodp_notice;

import java.util.ArrayList;
import oodp_user.TeamDAO;
import oodp_user.UserDAO;

public class NoticeReadChecker {

    private int totalCountReading;
    private int countReadingNotice;
    private ArrayList <String> userIDList;

    // 이제 하면 되는 거는! 이 클래스 러너나 앱러너에 적용시키면 된다! userdao는 커서로 해서 받는거로 하자!

    public NoticeReadChecker(TeamDAO presentTeam){
        this.totalCountReading = presentTeam.size();
        this.countReadingNotice = 0;
        this.userIDList = new ArrayList<String>();
    }

    public int getTotalCountReading() {
        return this.totalCountReading;
    }

    public void setTotalCountReading(int teamMemberNumbers) {
        this.totalCountReading = teamMemberNumbers;
    }

    public int getCountReadingNotice() {
        return this.countReadingNotice;
    }

    public void setCountReadingNotice(int countReadingNotice) {
        this.countReadingNotice = countReadingNotice;
    }

    public int increaseReadingCount(UserDAO presentUser){
        String userID = presentUser.getID();

        if(userIDList.contains(userID))
            return countReadingNotice;
        else{
            userIDList.add(userID);
            countReadingNotice++;
            totalCountReading--;
            return countReadingNotice;
        }
    }

    public void PrintCountReadingNotice() {
        System.out.println("안 읽은 팀원 수: " + totalCountReading);
    }

}
