package _06_DefiningClasses.Exercise._05_CarSalesman;

public class Car {
    private final String model;
    private final Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String weight;
        String displacement;
        if (getWeight() == -1) {
            weight = "n/a";
        } else {
            weight = String.valueOf(getWeight());
        }
        if (getEngine().getDisplacement() == -1) {
            displacement = "n/a";
        } else {
            displacement = String.valueOf(getEngine().getDisplacement());
        }
        return String.format("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s", getModel(), getEngine().getModel(), getEngine().getPower(), displacement, getEngine().getEfficiency(), weight, getColor());
    }
}
