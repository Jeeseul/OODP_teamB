package oodp_meetRecord;
import java.util.Comparator;
import java.util.List;

public class NameSortStratagy implements SortStratagy{
    @Override
    public void sort(List<recordDAO> list) {
		System.out.println("print Name sorted list");
		
        // int i=0;
		// System.out.print("** list, " + l.size() + " ***");
		// for (recordDAO item : l.getList()) {
		// 	i++;
		// 	System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
		// 			+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
		// }
    }

}
