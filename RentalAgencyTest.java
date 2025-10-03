import static org.junit.Assert.*;
import org.junit.Test;

public class RentalAgencyTest {
    @Test
    public void testAddCarAndRent() {
        RentalAgency agency = new RentalAgency();
        Car car = new Car("KAA123A", "Toyota Vitz");
        agency.addCar(car);

        // Initially available
        assertTrue(car.isAvailable());

        // Rent the car
        agency.rentCar("KAA123A");
        assertFalse(car.isAvailable());
    }
}
