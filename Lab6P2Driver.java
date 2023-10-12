import java.io.*;

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

public class Lab6P2Driver {

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        Bag<Package> deliveryBag = new Bag<>(args[0]);
        Bag<Sample> sampleBag = new Bag<>(args[0]);

        System.out.println("\nSelect from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t\t1. Pick up order\n"
                           +"\t\t2. Drop off order\n"
                           +"\t\t3. Display delivery bag info: number of packages, weight, and content\n"
                           +"\t\t4. Display samples bag info: number of samples, weight, and content\n"
                           +"\t\t5. Enjoy an item from samples bag\n"
                           +"\t\t6. Enjoy all the samples in the samples bag\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushOrder(deliveryBag);
                break;
            case 2:
                dropOrder(deliveryBag, sampleBag);
                break;
            case 3:
                bagInfo("Delivery", deliveryBag);
                break;
            case 4:
                bagInfo("Sample", sampleBag);
                break;
            case 5:
                enjoySample(sampleBag);
                break;
            case 6:
                enjoyAllSamples(sampleBag);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        double inputDouble;
        try {
            inputDouble = Double.parseDouble(stdin.readLine().trim());
            System.out.print(inputDouble);
        } catch(Exception ex) {
            inputDouble = 0;
        }
        return inputDouble;
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        int inputDouble;
        try {
            inputDouble = Integer.parseInt(stdin.readLine().trim());
            System.out.print(inputDouble);
        } catch(Exception ex) {
            inputDouble = 0;
        }
        return inputDouble;
    }

    public static void pushOrder(Bag b) throws IOException {
        System.out.print("Please specify package info: "+
                         "\nitem name: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        double itemWeight = readDouble("item weight: ");
        int numItems = readInt("\nnumber of items: ");

        System.out.print("\nis this a healthy item?(Y/N): ");
        char healthy =
            (stdin.readLine().toUpperCase().trim().charAt(0));
        System.out.println(healthy);

        System.out.print("sender: ");
        String sender = stdin.readLine().trim();
        System.out.println(sender);

        System.out.print("reciever: ");
        String reciever = stdin.readLine().trim();
        System.out.println(reciever);

        try {
            b.addItem(new Package(itemName, itemWeight,
                                  numItems, healthy == 'Y', sender, reciever));

            System.out.printf("A package of %ss, each weighing %.2f"+
                              " lbs are now in the delivery bag.%n%n", itemName, itemWeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dropOrder(Bag deliveryBag, Bag sampleBag) throws IOException {
        if(deliveryBag.getUnits() == 0)
            System.out.println("No deliveries to process!\n\n");
        else {
            Package pop = (Package)deliveryBag.popItem();
            boolean healthy = pop.getHealthy();
            char donated = 'n';
            System.out.printf("Here is your package %s. %n", pop.getReceiver());
            if(healthy) {
                System.out.print("May I please, please keep a sample(Y/N)? ");
                donated =
                    (stdin.readLine().toUpperCase().trim().charAt(0));
                System.out.println(donated);
            }
            System.out.printf("Your package contains: %s %n", pop);
            if(healthy) {
                if(donated == 'Y') {
                    System.out.println("Thanks for letting me keep a "+pop.getName()+"! \n");
                    ((Bag<Sample>)sampleBag).addItem(new Sample(pop.getName(), pop.getUnitWeight()));
                } else
                    System.out.println("Thanks anyway.");
            }
            System.out.println();
        }
    }

    /**
     * prints the bag info with bagname as a header
     * @param bagName
     * @param bag   cannot be null
     */
    public static void bagInfo(String bagName, Bag bag) {
        System.out.print(bagName+" bag has:  ");
        if(bag.getUnits() == 0)
            System.out.print("nothing.\n\n");
        else
            System.out.printf("%n%s%n",
                              bag.toString());
    }

    public static void enjoySample(Bag sampleBag) {
        if(sampleBag.getUnits() == 0)
            System.out.println("no samples to enjoy!\n");
        else
            System.out.printf("This %s is amazing. I love free stuff!%n%n", ((Sample)sampleBag.popItem()).getName());
    }

    public static void enjoyAllSamples(Bag sampleBag) {
        int units = sampleBag.getUnits();
        if(units == 0) {
            System.out.println("Sample bag is already empty.\n");
        } else {
            for(int i = 0; i < units; i++) {
                System.out.println("Enjoying "+((Sample)sampleBag.popItem()).getName());
            }
            System.out.println("Sample bag has been emptied.\n");
        }
    }

}