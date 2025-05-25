package za.ac.cput.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierTest {

    @Test
    void builderCreatesSupplierWithAllFields() {
        Supplier supplier = new Supplier.Builder("Supplier King")
                .address("456 King Street")
                .email("info@supplierking.com")
                .phoneNumber("0723456789")
                .website("www.supplierking.com")
                .build();

        assertNotNull(supplier);
        assertEquals("Supplier King", supplier.getName());
        assertEquals("456 King Street", supplier.getAddress());
        assertEquals("info@supplierking.com", supplier.getEmail());
        assertEquals("0723456789", supplier.getPhoneNumber());
        assertEquals("www.supplierking.com", supplier.getWebsite());
    }

    @Test
    void builderCreatesSupplierWithNameOnly() {
        Supplier supplier = new Supplier.Builder("Minimal Supplier").build();

        assertNotNull(supplier);
        assertEquals("Minimal Supplier", supplier.getName());
        assertNull(supplier.getAddress());
        assertNull(supplier.getEmail());
        assertNull(supplier.getPhoneNumber());
        assertNull(supplier.getWebsite());
    }

    @Test
    void toStringContainsSupplierName() {
        Supplier supplier = new Supplier.Builder("ToString Supplier").build();
        String output = supplier.toString();

        assertTrue(output.contains("ToString Supplier"));
        assertTrue(output.contains("name='ToString Supplier'"));
    }

    @Test
    void supplierBuilderAllowsPartialFields() {
        Supplier supplier = new Supplier.Builder("Partial Supplier")
                .email("partial@supplier.com")
                .build();

        assertEquals("Partial Supplier", supplier.getName());
        assertEquals("partial@supplier.com", supplier.getEmail());
        assertNull(supplier.getAddress());
        assertNull(supplier.getPhoneNumber());
    }
}
