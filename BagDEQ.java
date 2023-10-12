
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

public class BagDEQ<T> {

    private int units;
    private double totalWeight;
    private ExtendedQueueInterface<T> collection;

    public Bag(String collectionType) {
        this.units = 0;
        this.totalWeight = 0;
        try {
            this.collection =
                (ExtendedQueueInterface<T>)
                Class.forName(collectionType).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUnits(int units) {
        this.units = 0;
    }

    public void setDouble(double totalWeight) {
        this.totalWeight = 0;
    }

    public void setCollection(ExtendedQueueInterface<T> collection) {
        this.collection = collection;
    }

    public int getUnits() {
        return units;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public ExtendedQueueInterface<T> getCollection() {
        return collection;
    }

    public void addItem(T item) {
        collection.enqueue(item);
        units++;
        totalWeight += ((Sample)item).getWeight();
    }

    public void addFront(T item) {
        collection.enqueueFront(item);
        units++;
        totalWeight += ((Sample)item).getWeight();
    }

    /**
     * Make sure collection is not empty first
     * @return
     */
    public T popItem() {
        T item = collection.dequeue();
        units--;
        totalWeight -= ((Sample)item).getWeight();
        return item;
    }

    /**
     * Make sure collection is not empty first
     * @return
     */
    public T popBack() {
        T item = collection.dequeueBack();
        units--;
        totalWeight -= ((Sample)item).getWeight();
        return item;
    }

    public String toString() {
        return String.format("Number of units: %d%n"
                             +"Weight: %.2f%n"
                             +"Items: %n%s%n",
                             units, totalWeight, collection.toString().replaceAll("[.] ", ".\n"));
    }

}