
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

public class QueueSLS {

	Node front;
	Node end;

	public QueueSLS() {
		front = null;
		end = null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public T peek() {
		return front.getItem();
	}

	public void enqueue(T item) {
		Node temp = new Node(item);
		if(end != null)
			end.setNext(temp);
		else
			front = temp;
		end = temp;
	}

	public T dequeue() {
		if(front != null) {
			T result = front.getItem();
			front = front.getNext();
			if(front == null)
				end = null;
			return result;
		}
		else throw new QueueException();
	}

}