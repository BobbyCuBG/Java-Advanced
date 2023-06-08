package _06_DefiningClasses.Exercise._04_RawData;

public class Cargo {
   private int cargoWeight;
   private String cargoType;


    public String getCargoType() {
        return cargoType;
    }

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
}
