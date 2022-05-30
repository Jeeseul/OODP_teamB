package oodp_meetSchedule;

import java.util.Comparator;

public class scheduleSortByDate implements Comparator<scheduleRecord>{
	@Override
    public int compare(scheduleRecord o1, scheduleRecord o2) {
        //return o1.getCurrent_date().compareTo(o2.getCurrent_date());
        return 0;
    }
}
