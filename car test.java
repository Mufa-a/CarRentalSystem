import static org.junit.Assert.*;
import org.junit.Test;

public class CarTest {
    @Test
    public void testCarIsAvailableByDefault() {
        Car car = new Car("KAA123A", "Toyota Vitz");
        assertTrue(car.isAvailable());
    }

    @Test
    public void testRentCar() {
        Car car = new Car("KAA123A", "Toyota Vitz");
        car.rent();
        assertFalse(car.isAvailable());
    }

    @Test
    public void testReturnCar() {
        Car car = new Car("KAA123A", "Toyota Vitz");
        car.rent();
        car.returnCar();
        assertTrue(car.isAvailable());
    }
}
