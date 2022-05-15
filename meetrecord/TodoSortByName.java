package meetrecord;
import java.util.Comparator;

public class TodoSortByName implements Comparator<Todorecord> {
    @Override
    public int compare(Todorecord o1, Todorecord o2) {
        //return o1.getTitle().compareTo(o2.getTitle());
        return 0;
    }
}