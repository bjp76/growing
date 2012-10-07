package biju.joseph.growing.sorters;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;

/**
 * Well java.util.Arrays.sort provides an implementation of merge/quick sort. This is a quick and dirty implementation
 * of  @see <a href="http://en.wikipedia.org/wiki/Merge_sort">Merge Sort</a>, with an intention to show how to write
 * effective automated test cases.
 *
 * @author Biju Joseph
 * Created on : 10/7/12 8:24 AM
 */
public class MergeSorter implements Sorter {

    private static Logger logger = Logger.getLogger(MergeSorter.class.getName());

    /**
     * This method will sort the input list and return a sorted list back.
     *
     * @param list - The list of Objects to sort
     * @param <T>  - An object implementing java.lang.Comparable interface
     * @return sorted list
     */
    @Override
    public <T extends Comparable> List<T> sort(List<T> list) {

        if (logger.isLoggable(FINE)) logger.log(FINE, "Sort => " + String.valueOf(list));

        int length = list.size();
        if (length < 2) return list;

        //divide the input list into half and sort & merge them separately.
        int half = length / 2;
        List<T> leftHalf = list.subList(0, half);
        List<T> rightHalf = list.subList(half, length);
        return merge(sort(leftHalf), sort(rightHalf));
    }


    /**
     * This method returns a sorted list which contains elements present in <code>aList</code> and <code>bList</code>.
     * The order of elements present in the returned list is governed by the implementation of @{Comparable#compareTo}.
     *
     * @param aList - a List consisting of objects implementing Comparable
     * @param bList - a List consisting of objects implementing Comparable
     * @param <T>   - an object implementing Comparable interface
     * @return - sorted list, consisting of elements in aList and bList.
     */
    private <T extends Comparable> List<T> merge(List<T> aList, List<T> bList) {
        if (logger.isLoggable(FINE))
            logger.log(FINE, "Merging : " + String.valueOf(aList) + " , " + String.valueOf(bList));

        int aLength = aList.size();
        int bLength = bList.size();


        int cLength = aLength + bLength;
        List<T> cList = new ArrayList<T>(cLength);   //returned list

        int i = 0, j = 0;
        for (int k = 0; k < cLength; k++) {

            T a = i < aLength ? aList.get(i) : null;
            T b = j < bLength ? bList.get(j) : null;

            //aList exhausted ?  - add rest of elements in bList to cList
            if (a == null) {
                cList.add(b);
                j++;
                continue;
            }

            //bList exhausted ? - add rest of elements in aList to cList
            if (b == null) {
                cList.add(a);
                i++;
                continue;
            }

            // add the smallest one to cList
            if (a.compareTo(b) < 0) {
                cList.add(a);
                i++;
            } else {
                cList.add(b);
                j++;
            }

        }
        return cList;
    }
}
