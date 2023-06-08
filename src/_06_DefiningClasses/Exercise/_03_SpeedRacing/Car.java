package _06_DefiningClasses.Exercise._03_SpeedRacing;

public class Car {
    //  Model, fuel amount, fuel cost for 1 kilometer, and
    //distance traveled
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled = 0;

    public Car(String mode, int fuelAmount, double fuelCost) {
        this.model = mode;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public double travelDistance (int distance, double fuelCost) {
        return distance * fuelCost;
    }
}
