import java.io.*;

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

public class Lab6P1Driver {

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {

        QueueInterface<String> mainQueue;
        try {
            mainQueue = (QueueInterface<String>)
                        Class.forName(args[0]).newInstance();
        }
        catch(Exception e) {
            mainQueue = new QueueCRAB<>();
        }

        System.out.println("\nSelect from the following menu:\n"
                           +"\t0. Exit Program\n"
                           +"\t1. Insert item at back of FIFO collection\n"
                           +"\t2. Remove item from front of FIFO collection\n"
                           +"\t3. Display front item of FIFO collection\n"
                           +"\t4. Clear FIFO collection\n"
                           +"\t5. Display number of items and content\n"
                           +" of FIFO collection");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushBack(mainQueue);
                break;
            case 2:
                popFront(mainQueue);
                break;
            case 3:
                peekFront(mainQueue);
                break;
            case 4:
                dequeueAll(mainQueue);
                break;
            case 5:
                printQueue(mainQueue);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    public static void pushBack(QueueInterface<String> queue) throws IOException {
        System.out.print("You are now adding an item"+
                         " to the end of the queue.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        queue.enqueue(itemName);
        System.out.printf("Item %s inserted onto"+
                          " the top of the queue.%n%n", itemName);
    }

    public static void popFront(QueueInterface<String> queue) {
        if(queue.isEmpty())
            System.out.println("Queue is empty.\n\n");
        else {
            System.out.printf("Item %s removed from"+
                              " the queue.%n%n", queue.dequeue());
        }
    }

    public static void peekFront(QueueInterface<String> queue) {
        if(queue.isEmpty())
            System.out.println("Queue is empty.\n\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " the top of the queue.%n%n",
                              queue.peek());
        }
    }

    public static void dequeueAll(QueueInterface<String> queue) {
        queue.dequeueAll();
        System.out.println();
    }

    public static void printQueue(QueueInterface<String> queue) {
        if(queue == null || queue.isEmpty())
            System.out.print("Queue is empty.\n\n");
        else
            System.out.printf("Queue has the following items: %s%n%n",
                              queue.toString());
    }

}