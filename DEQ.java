public class DEQ<T> extends QueueCRAB<T> implements ExtendedQueueInterface<T>{

	public DEQ() {
		super();
	}

	//peek == peekFront

	public T peekBack() {
		if(numItems != 0)
			return items[back-1];
		else throw new ExtendedQueueException("peek: DEQ is empty");
	}

	//enqueue == enqueueBack

	public void enqueueFront(T item) {
		numItems++;
		int itemsLen = items.length;
		if(numItems == itemsLen)
			resize();
		front = (front - 1) % itemsLen;
		items[front] = item;
	}

	//dequeue == dequeueFront

	public T dequeueBack() {
		if(numItems != 0) {
			back = (back - 1) % items.length; //modulo removes comparison
			T result = items[back];
			items[back] = null;
			numItems--;
			return result;
		}
		else throw new ExtendedQueueException("dequeue: DEQ is empty");
	}

}