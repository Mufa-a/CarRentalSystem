import java.util.ArrayList;

public class RentalAgency {
    private ArrayList<Car> cars;

    public RentalAgency() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void showAvailableCars() {
        System.out.println("\nAvailable Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public void rentCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equalsIgnoreCase(plateNumber) && car.isAvailable()) {
                car.rent();
                System.out.println("✅ Car " + plateNumber + " has been rented.");
                return;
            }
        }
        System.out.println("❌ Car not available.");
    }
}
