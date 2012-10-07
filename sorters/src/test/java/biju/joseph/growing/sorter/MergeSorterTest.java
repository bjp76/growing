package biju.joseph.growing.sorter;

import biju.joseph.growing.sorters.MergeSorter;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Biju Joseph
 *         Created on : 10/7/12 8:35 AM
 */

public class MergeSorterTest {

    private MergeSorter sorter;

    @Before
    public void setUp() {
        sorter = new MergeSorter();
    }

    @Test
    public void testSort() {
        List<Integer> in = Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4);
        List<Integer> out = sorter.sort(in);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), out);

    }

    @Test
    public void testSortStrings() {
        List<String> in = Arrays.asList("IN", "AU" , "US" , "UK" , "RU" , "CA");
        List<String> out = sorter.sort(in);
        assertEquals(Arrays.asList("AU", "CA", "IN", "RU", "UK", "US"), out);
    }


    @Test
    public void testSortURLs() throws Exception {
        List<URI> in = Arrays.asList(
                new URI("http://java.sun.com/j2se/1.5"),
                new URI("http://java.sun.com/j2se/1.2"),
                new URI("http://java.sun.com/j2se/1.4"),
                new URI("http://java.sun.com/j2se/1.3")
                );
        List<URI> out = sorter.sort(in);
        assertEquals(Arrays.asList(
                new URI("http://java.sun.com/j2se/1.2"),
                new URI("http://java.sun.com/j2se/1.3"),
                new URI("http://java.sun.com/j2se/1.4"),
                new URI("http://java.sun.com/j2se/1.5")) , out );
    }


    //must throw NPE when the input is null
    @Test(expected = NullPointerException.class)
    public void testSortNullList() {
        sorter.sort(null);
    }

    //must return empty list when the input is empty.
    @Test
    public void testSortEmptyList() {
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> out = sorter.sort(in);
        assertTrue(out.isEmpty());

    }

    @Test
    public void testSortListWith1Elements() {
        List<Integer> in = Arrays.asList(8);
        List<Integer> out = sorter.sort(in);
        assertEquals(1, out.size());
        assertEquals(8, out.get(0));
    }

    @Test
    public void testSortListWith2Elements() {
        //unsorted list
        {
            List<Integer> in = Arrays.asList(8, 2);
            List<Integer> out = sorter.sort(in);
            assertEquals(2, out.size());
            assertEquals(2, out.get(0));
            assertEquals(8, out.get(1));
        }

        //already sorted list
        {
            List<Integer> in = Arrays.asList(2, 8);
            List<Integer> out = sorter.sort(in);
            assertEquals(2, out.size());
            assertEquals(2, out.get(0));
            assertEquals(8, out.get(1));
        }

        //already sorted list, with same elements
        {
            List<Integer> in = Arrays.asList(2, 2);
            List<Integer> out = sorter.sort(in);
            assertEquals(2, out.size());
            assertEquals(2, out.get(0));
            assertEquals(2, out.get(1));
        }
    }

    @Test
    public void testSortListWith3Elements() {
        {
            List<Integer> in = Arrays.asList(2, 8, 3);
            List<Integer> out = sorter.sort(in);
            assertEquals(3, out.size());
            assertEquals(2, out.get(0));
            assertEquals(3, out.get(1));
            assertEquals(8, out.get(2));
        }
        {
            List<Integer> in = Arrays.asList(2, 8, 2);
            List<Integer> out = sorter.sort(in);
            assertEquals(3, out.size());
            assertEquals(2, out.get(0));
            assertEquals(2, out.get(1));
            assertEquals(8, out.get(2));
        }
    }


}
