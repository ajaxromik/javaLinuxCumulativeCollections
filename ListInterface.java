/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 10/10/22
 * Submitted:  10/10/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.10
 */

public interface ListInterface<T>
{
    boolean isEmpty();
    int size();
    void add(int index, T item) throws ListIndexOutOfBoundsException;
    T get(int index) throws ListIndexOutOfBoundsException;
    T remove(int index) throws ListIndexOutOfBoundsException;
    void removeAll();
    String toString();
}  // end ListInterface