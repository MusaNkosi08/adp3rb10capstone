package za.ac.cput.domain;

/* SupplierTest.java
   Test class for Supplier
   Author: 222791829
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierTest {

    @Test
    void testSupplierCreationWithAllFields() {
        Supplier supplier = new Supplier.Builder("Tech Supplies")
                .address("123 Main Street, Cape Town")
                .email("info@techsupplies.com")
                .phoneNumber("021-123-4567")
                .website("www.techsupplies.com")
                .build();

        assertNotNull(supplier);
        assertEquals("Tech Supplies", supplier.getName());
        assertEquals("123 Main Street, Cape Town", supplier.getAddress());
        assertEquals("info@techsupplies.com", supplier.getEmail());
        assertEquals("021-123-4567", supplier.getPhoneNumber());
        assertEquals("www.techsupplies.com", supplier.getWebsite());
    }

    @Test
    void testSupplierCreationWithOnlyName() {
        Supplier supplier = new Supplier.Builder("Basic Supplier").build();

        assertNotNull(supplier);
        assertEquals("Basic Supplier", supplier.getName());
        assertNull(supplier.getAddress());
        assertNull(supplier.getEmail());
        assertNull(supplier.getPhoneNumber());
        assertNull(supplier.getWebsite());
    }

    @Test
    void testToStringContainsValues() {
        Supplier supplier = new Supplier.Builder("Office Depot")
                .email("contact@officedepot.com")
                .build();

        String result = supplier.toString();

        assertTrue(result.contains("Office Depot"));
        assertTrue(result.contains("contact@officedepot.com"));
    }
}
