package oodp_meetRecord;
import java.util.Comparator;
import java.util.List;

public class DateSortStratagy implements SortStratagy{
    @Override
    public void sort(List<recordDAO> list) {
		System.out.println("print Date sorted list");
	// 	recordList sortedlist  = new recordList();

	// 	//sort by date  
	// 	recordDAO max = new recordDAO("", "", "", "");
	// 	int maxindx = 0;
	// 	for (int i = 0; i < sortedlist.size(); i++){
	// 		for (int j = 0; j < sortedlist.size(); j++){
	// 			if(l.indexOf(j).getCurrent_date().compareTo(max.getCurrent_date()) > 0){
	// 				max = l[j];
	// 				maxindx = j;
	// 			}
	// 		}
	// 		sortedlist.addItem(max);
	// 		l.deleteItem(l.indexOf(maxindx));
	// 	}

    //     int i=0;
	// 	System.out.print("** list, " + sortedlist.size() + " ***");
	// 	for (recordDAO item : sortedlist.getList()) {
	// 		i++;
	// 		System.out.println("\n " + i + "] " + item.getTitle() + "\n    " + item.getDesc()
	// 				+ "\n    " + item.getCurrent_date()+ "\n    " + item.getCategory()+ "\n    " + item.getDue_date());
	// 	}
     }
}
