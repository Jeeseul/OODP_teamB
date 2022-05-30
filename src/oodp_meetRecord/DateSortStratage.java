package oodp_meetRecord;
import java.util.Comparator;

public class DateSortStratage extends SortStratage{
    @Override
    public void sort(recordList l) {
        int i=0;
		System.out.print("** list, " + l.size() + " ***");
		for (recordDAO item : l.getList()) {
			i++;
			System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
					+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
		}
    }
}
