package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    @Test
    void createSupplier_withNameOnly_shouldSucceed() {
        Supplier supplier = SupplierFactory.createSupplier("ABC Distributors");

        assertNotNull(supplier);
        assertEquals("ABC Distributors", supplier.getName());
        assertNull(supplier.getEmail());
        assertNull(supplier.getAddress());
        assertNull(supplier.getPhoneNumber());
        assertNull(supplier.getWebsite());
    }

    @Test
    void createSupplier_withAllFields_shouldSucceed() {
        Supplier supplier = SupplierFactory.createSupplier(
                "XYZ Supplies",
                "456 Industrial Ave",
                "xyz@supplies.com",
                "0821234567",
                "www.xyzsupplies.com"
        );

        assertNotNull(supplier);
        assertEquals("XYZ Supplies", supplier.getName());
        assertEquals("456 Industrial Ave", supplier.getAddress());
        assertEquals("xyz@supplies.com", supplier.getEmail());
        assertEquals("0821234567", supplier.getPhoneNumber());
        assertEquals("www.xyzsupplies.com", supplier.getWebsite());
    }

    @Test
    void createSupplier_withEmailOnly_shouldSucceed() {
        Supplier supplier = SupplierFactory.createSupplierWithEmail("QuickParts", "info@quickparts.co.za");

        assertNotNull(supplier);
        assertEquals("QuickParts", supplier.getName());
        assertEquals("info@quickparts.co.za", supplier.getEmail());
        assertNull(supplier.getAddress());
        assertNull(supplier.getPhoneNumber());
        assertNull(supplier.getWebsite());
    }

    // Optional: Validation test if you later enforce non-null names
    @Test
    void createSupplier_withNullName_shouldThrowException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            SupplierFactory.createSupplier(null);
        });

        assertNotNull(exception.getMessage());
    }
}
