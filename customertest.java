import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testCorrectPassword() {
        Customer customer = new Customer("user1", "pass123");
        assertTrue(customer.checkPassword("pass123"));
    }

    @Test
    public void testIncorrectPassword() {
        Customer customer = new Customer("user1", "pass123");
        assertFalse(customer.checkPassword("wrongPass"));
    }
}
