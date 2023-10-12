
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/11/23
 * Submitted:  10/11/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.11
 */

public class DEQ<T> extends QueueCRAB<T> implements ExtendedQueueInterface<T>{

	public DEQ() {
		super();
	}

	//peek == peekFront

	public T peekBack() {
		int itemsLen = items.length;
		if(numItems != 0)
			return items[(itemsLen + back - 1) % itemsLen];
		else throw new ExtendedQueueException("peek: DEQ is empty");
	}

	//enqueue == enqueueBack

	public void enqueueFront(T item) {
		int itemsLen = items.length;
		if(numItems == itemsLen){
			resize();
			itemsLen = itemsLen << 1; // items.length is doubled after resize
		}
		front = (itemsLen + front - 1) % itemsLen;
		items[front] = item;
		numItems++;
	}

	//dequeue == dequeueFront

	public T dequeueBack() {
		int itemsLen = items.length;
		if(numItems != 0) {
			back = (itemsLen + back - 1) % itemsLen; //modulo removes comparison
			T result = items[back];
			items[back] = null;
			numItems--;
			return result;
		}
		else throw new ExtendedQueueException("dequeue: DEQ is empty");
	}

}