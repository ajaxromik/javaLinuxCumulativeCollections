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

        ExtendedQueueInterface<T> mainDEQ = new DEQ<>();

        System.out.println("\nSelect from the following menu:\n"
                           +"\t0. Exit Program\n"
                           +"\t1. Insert item at back\n"
                           +"\t2. Insert item at front\n"
                           +"\t3. Remove item from front\n"
                           +"\t4. Remove item from back\n"
                           +"\t5. Display front item\n"
                           +"\t6. Display last item\n"
                           +"\t7. Clear collection\n"
                           +"\t8. Display number of items "
                           +"and content of collection\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushBack(mainDEQ);
                break;
            case 2:
                pushFront(mainDEQ);
                break;
            case 3:
                popFront(mainDEQ);
                break;
            case 4:
                popBack(mainDEQ);
                break;
            case 5:
                peekFront(mainDEQ);
                break;
            case 6:
                peekBack(mainDEQ);
                break;
            case 7:
                dequeueAll(mainDEQ);
                break;
            case 8:
                printQueue(mainDEQ);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    public static void pushBack(ExtendedQueueInterface<T> deq) throws IOException {
        System.out.print("You are now adding an item"+
                         " to the end of the DEQ.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        deq.enqueue(itemName);
        System.out.printf("Item %s inserted onto"+
                          " the back of the DEQ.%n%n", itemName);
    }

    public static void pushFront(ExtendedQueueInterface<T> deq) throws IOException {
        System.out.print("You are now adding an item"+
                         " to the front of the DEQ.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        deq.enqueueFront(itemName);
        System.out.printf("Item %s inserted onto"+
                          " the front of the DEQ.%n%n", itemName);
    }

    public static void popFront(ExtendedQueueInterface<T> deq) {
        if(deq.isEmpty())
            System.out.println("DEQ is empty.\n\n");
        else {
            System.out.printf("Item %s removed from"+
                              " the DEQ.%n%n", deq.dequeue());
        }
    }

    public static void popBack(ExtendedQueueInterface<T> deq) {
        if(deq.isEmpty())
            System.out.println("DEQ is empty.\n\n");
        else {
            System.out.printf("Item %s removed from"+
                              " the DEQ.%n%n", deq.dequeueBack());
        }
    }

    public static void peekFront(ExtendedQueueInterface<T> deq) {
        if(deq.isEmpty())
            System.out.println("DEQ is empty.\n\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " the front of the DEQ.%n%n",
                              deq.peek());
        }
    }

    public static void peekFront(ExtendedQueueInterface<T> deq) {
        if(deq.isEmpty())
            System.out.println("DEQ is empty.\n\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " the back of the DEQ.%n%n",
                              deq.peekBack());
        }
    }

    public static void dequeueAll(ExtendedQueueInterface<T> deq) {
        deq.dequeueAll();
        System.out.println();
    }

    public static void printQueue(ExtendedQueueInterface<T> deq) {
        if(deq == null || deq.isEmpty())
            System.out.print("DEQ is empty.\n\n");
        else
            System.out.printf("DEQ has the following items: %s%n%n",
                              deq.toString());
    }

}