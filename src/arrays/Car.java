package arrays;

public class Car {
    private double price;
    private int airBags;
    private boolean isAutomatic;

    // Constructor
    public Car(double price, int doors, boolean isAutomatic) {
        this.price = price;
        this.airBags = doors;
        this.isAutomatic = isAutomatic;
    }

    // Method to print car properties
    public void printCarProperties() {
        System.out.println("Car Properties:");
        System.out.println("Price: $" + price);
        System.out.println("Number of Airbags: " + airBags);
        System.out.println("Automatic Transmission: " + (isAutomatic ? "Yes" : "No"));
    }

    // Getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAirbags() {
        return airBags;
    }

    public void setAirbags(int airBags) {
        this.airBags = airBags;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }

}