
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

public class QueueCRAB<T> implements QueueInterface{

	int numItems;
	T[] items;
	int back;
	int front;

	public QueueCRAB() {
		items = (T[]) new Object[3];
		numItems = front = back = 0; //multiple assignments
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public T peek() {
		if(numItems != 0)
			return items[front];
		else throw QueueException();
	}

	public void enqueue(T item) {
		int itemsLen = items.length;
		if(numItems == itemsLen)
			resize();
		items[back] = item;
		back = (back + 1) % itemsLen;
	}

	private void resize() {
		int itemsLen = items.length;
		T[] temp = (T[]) new Object[itemsLen*2];
		for(int i = 0; i < numItems; i++) {
			temp[i] = items[(front+i) % items.length];
		}
		items = temp;
	}

	public T dequeue() {
		if(numItems != 0) {
			T result = items[front];
			items[front] = null;
			front = (front + 1) % items.length; //modulo removes comparison
			numItems--;
			return result;
		}
		else throw new QueueException("dequeue: queue is empty");
	}

}