
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

public class QueueSLS<T> implements QueueInterface<T> {

    protected Node<T> front;
    protected Node<T> end;

    public QueueSLS() {
        this.front = null;
        this.end = null;
    }

    public void dequeueAll() {
        this.front = null;
        this.end = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() throws QueueException {
        if(front != null)
            return front.getItem();
        else throw new QueueException("peek: queue is empty");
    }

    public void enqueue(T item) throws QueueException {
        Node temp = new Node(item);
        if(end != null)
            end.setNext(temp);
        else
            this.front = temp;
        this.end = temp;
    }

    public T dequeue() throws QueueException {
        if(front != null) {
            T result = front.getItem();
            this.front = front.getNext();
            if(front == null)
                end = null;
            return result;
        }
        else throw new QueueException("dequeue: queue is empty");
    }

    public String toString() {
        Node current = front;
        StringBuilder sb = new StringBuilder();
        while(current != null) {
            sb.append(current.getItem() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }

}