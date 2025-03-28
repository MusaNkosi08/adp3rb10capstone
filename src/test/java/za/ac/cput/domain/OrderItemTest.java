package za.ac.cput.domain;

//Tyrese Ntate 221817816

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    public void testTotalPrice() {
        // Create an OrderItem instance using the Builder pattern
        OrderItem item = new OrderItem.Builder()
                .itemId(1)
                .quantity(3)
                .price(10.0)
                .build();

        // Calculate the expected total price
        double expectedTotal = 3 * 10.0;

        // Assert that the totalPrice method returns the expected value
        assertEquals(expectedTotal, item.totalPrice(), 0.001);
    }

    @Test
    public void testBuilderPattern() {
        // Create an OrderItem instance using the Builder pattern
        OrderItem item = new OrderItem.Builder()
                .itemId(2)
                .quantity(5)
                .price(15.0)
                .build();

        // Assert that the fields are set correctly
        assertEquals(2, item.getItemId());
        assertEquals(5, item.getQuantity());
        assertEquals(15.0, item.getPrice(), 0.001);
    }

    @Test
    public void testNegativeQuantity() {
        // Attempt to create an OrderItem with a negative quantity
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem.Builder()
                    .itemId(3)
                    .quantity(-1)
                    .price(20.0)
                    .build();
        });

        // Assert that the exception message is as expected
        assertEquals("Quantity cannot be negative", exception.getMessage());
    }

    @Test
    public void testNegativePrice() {
        // Attempt to create an OrderItem with a negative price
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem.Builder()
                    .itemId(4)
                    .quantity(2)
                    .price(-5.0)
                    .build();
        });

        // Assert that the exception message is as expected
        assertEquals("Price cannot be negative", exception.getMessage());
    }
}
