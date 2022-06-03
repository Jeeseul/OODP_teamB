package oodp_meetSchedule;

import java.util.Comparator;

public class scheduleSortByDate implements Comparator<scheduleDAO> {
	@Override
	public int compare(scheduleDAO o1, scheduleDAO o2) {
		// return o1.getCurrent_date().compareTo(o2.getCurrent_date());
		if (o1.getDue_date().isAfter(o2.getDue_date())) {
			return 1;
		} else if (o1.getDue_date().isBefore(o2.getDue_date())) {
			return -1;
		}
		return 0;

	}
}
