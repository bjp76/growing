package biju.joseph.growing.sorters;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of @see <a href="http://en.wikipedia.org/wiki/Merge_sort">Merge Sort</a>
 *
 * @author Biju Joseph
 *         Created on : 10/7/12 9:13 AM
 */
public class BubbleSorter implements Sorter {

    /**
     * This method will sort the input list and return a sorted list back.
     *
     * @param list - The list of Objects to sort
     * @param <T>  - An object implementing java.lang.Comparable interface
     * @return sorted list
     */
    @Override
    public <T extends Comparable> List<T> sort(List<T> list) {
        ArrayList<T> retList = new ArrayList<T>(list);
        if (retList.isEmpty()) return retList;

        int length = list.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                T a = retList.get(i);
                T b = retList.get(j);

                if (a.compareTo(b) > 0) {
                    retList.set(i, b);
                    retList.set(j, a);
                }
            }
        }

        return retList;

    }
}
