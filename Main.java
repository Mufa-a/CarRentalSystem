import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a sample customer
        Customer customer = new Customer("user1", "pass123");

        // Create rental agency and add cars
        RentalAgency agency = new RentalAgency();
        agency.addCar(new Car("KAA123A", "Toyota Vitz"));
        agency.addCar(new Car("KBB456B", "Honda Civic"));
        agency.addCar(new Car("KCC789C", "Nissan Note"));

        // LOGIN SYSTEM
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = maskPassword(sc);

            if (customer.getUsername().equals(username) && customer.checkPassword(password)) {
                System.out.println("✅ Login successful!");
                loggedIn = true;
            } else {
                attempts++;
                System.out.println("❌ Wrong username or password. Attempts left: " + (3 - attempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting...");
            return;
        }

        // Car rental menu
        int choice;
        do {
            System.out.println("\n--- Car Rental Menu ---");
            System.out.println("1. View available cars");
            System.out.println("2. Rent a car");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    agency.showAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter plate number of car: ");
                    String plate = sc.nextLine();
                    agency.rentCar(plate);
                    break;
                case 3:
                    System.out.println("Thank you for using Car Rental System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Simple password masking (for assignment)
    private static String maskPassword(Scanner sc) {
        String password = sc.nextLine();
        System.out.println("*".repeat(password.length())); // fake masking
        return password;
    }
}

// Car class
class Car {
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

// Customer class
class Customer {
    private String username;
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}

// RentalAgency class
class RentalAgency {
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
