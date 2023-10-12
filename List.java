
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/12/22
 * Submitted:  10/12/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.12
 */

public class List<T> implements ListInterface<T> {

    private static final int MAX_LIST = 3;
    private T []items;  // an array of list items
    private int numItems;  // number of items in list

    public List()
    {
        items = (T[])new Object[MAX_LIST];
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = (T[])new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll

    public void add(int index, T item)
    throws  ListIndexOutOfBoundsException
    {
        resize();
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add

    public T get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public T remove(int index)
    throws ListIndexOutOfBoundsException
    {   T result;
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            result = items[index];
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for
            numItems--;
            items[numItems] = null;  //fixes memory leak
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
        return result;
    } //end remove

    /**
     * Returns a String version of the items in the list separated by a space
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            result.append(((i == 0) ? "" : " ") + items[i]);
        }
        return result.toString();
    }

    /**
     * Reverses the list in the superclass
     */
    public void reverse() {
        for(int i = 0; i < numItems/2; i ++) {
            T temp = items[i];
            items[i] = items[numItems-1-i];
            items[numItems-1-i] = temp;
        }
    }

    /**
     * Doubles the size of the items field when the list reaches its max
     */
    public void resize() {
        int currentLen = items.length;
        if(numItems == currentLen) { // if max is reached
            T[] tempItems = (T[])new Object[currentLen*2];
            for(int i = 0; i < numItems; i++) {
                tempItems[i] = items[i];
            }
            //after transferring data to items, move it into items
            items = tempItems;
        }
    }
}