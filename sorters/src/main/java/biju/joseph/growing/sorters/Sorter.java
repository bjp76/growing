package biju.joseph.growing.sorters;

import java.util.List;

/**
 * @author Biju Joseph
 * Created on : 10/7/12 8:16 AM
 */
public interface Sorter {
    /**
     * Will sort the input list and return a new list with the elements in input list sorted in ascending order. The
     * sorting depends on the implementation of java.lang.Compareable#compareTo method
     *
     * @param list  - The list to sort
     * @return   - A new sorted list.
     */
    <T extends Comparable> List<T> sort(List<T> list);

}
