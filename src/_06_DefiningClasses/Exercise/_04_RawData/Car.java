package _06_DefiningClasses.Exercise._04_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public String getCarCargoType () {
        return this.cargo.getCargoType();
    }

    public boolean getTyrePressure () {
        return this.tire.getTyre1Pressure() < 1 || this.tire.getTyre2Pressure() < 1 || this.tire.getTyre3Pressure() < 1 || this.tire.getTyre4Pressure() < 1;
    }

    public boolean getEnginePowerGreaterThan() {
        return this.engine.getEnginePower() > 250;
    }
}
