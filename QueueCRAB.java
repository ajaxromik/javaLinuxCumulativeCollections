
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 0
 * Status: Complete and thoroughly tested
 * Last update: 10/11/23
 * Submitted:  10/11/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.11
 */

public class QueueCRAB<T> implements QueueInterface<T> {

    protected int numItems;
    protected T[] items;
    protected int back;
    protected int front;

    public QueueCRAB() {
        items = (T[]) new Object[3];
        numItems = front = back = 0; //multiple assignments
    }

    public void dequeueAll() {
        items = (T[]) new Object[3];
        numItems = front = back = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public T peek() throws QueueException {
        if(numItems != 0)
            return items[front];
        else throw new QueueException("peek: queue is empty");
    }

    public void enqueue(T item) throws QueueException {
        if(numItems == items.length)
            resize();
        items[back] = item;
        back = (back + 1) % items.length;
        numItems++;
    }

    protected void resize() {
        T[] temp = (T[]) new Object[items.length*2];
        for(int i = 0; i < numItems; i++) {
            temp[i] = items[(front+i) % items.length];
        }
        //after all this happens, front and back are messed up
        this.front = 0;
        this.back = numItems;
        this.items = temp;
    }

    public T dequeue() throws QueueException {
        if(numItems != 0) {
            T result = items[front];
            items[front] = null;
            front = (front + 1) % items.length; //modulo removes comparison
            numItems--;
            return result;
        }
        else throw new QueueException("dequeue: queue is empty");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            sb.append(items[(front+i) % items.length] + " ");
        }
        return sb.toString();
    }

}