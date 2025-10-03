public class Car {
    private String plateNumber;
    private String model;
    private boolean available;

    public Car(String plateNumber, String model) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.available = true;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }

    @Override
    public String toString() {
        return model + " (" + plateNumber + ") - " + (available ? "Available" : "Rented");
    }
}
