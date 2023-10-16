
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
		if(numItems != 0)
			return items[(items.length + back - 1) % items.length];
		else throw new ExtendedQueueException("peek: DEQ is empty");
	}

	//enqueue == enqueueBack

	public void enqueueFront(T item) {
		if(numItems == items.length)
			resize();
		front = (items.length + front - 1) % items.length;
		items[front] = item;
		numItems++;
	}

	//dequeue == dequeueFront

	public T dequeueBack() {
		if(numItems != 0) {
			back = (items.length + back - 1) % items.length; //modulo removes comparison
			T result = items[back];
			items[back] = null;
			numItems--;
			return result;
		}
		else throw new ExtendedQueueException("dequeue: DEQ is empty");
	}

}