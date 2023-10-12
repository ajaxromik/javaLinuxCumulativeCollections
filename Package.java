
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

public class Package extends Sample {

    private int amount;
    private boolean healthy;
    private String sender;
    private String receiver;

    public Package(String name, double weight, int amount, boolean healthy, String sender, String receiver) {
        super(name, weight);
        this.amount = amount;
        this.healthy = healthy;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getHealthy() {
        return healthy;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getWeight() {
        return amount*getUnitWeight();
    }

    public String toString() {
        return String.format("%d %ss, each weighing %.2f lbs"
                             +" from %s to %s.",
                             amount, super.getName(), super.getWeight(), sender, receiver);
    }

}