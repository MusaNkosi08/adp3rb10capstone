# Changelog

## August 2025

### Fixed Reserved SQL Keyword Table Name
- Changed `Order` entity table name from `order` to `orders` using `@Table(name = "orders")` to avoid SQL syntax errors with reserved keywords.

### JPA Primary Key and Foreign Key Mapping
- Updated `OrderItem` entity's `@JoinColumn` to reference `orderId` instead of `order_id` to match the primary key field in `Order`.

### Spring Data JPA Repository Method Naming
- Renamed repository methods to follow Spring Data JPA conventions:
  - `countRolesWithSalaryAbove` → `countByRoleSalaryGreaterThan`
  - `findRolesWithinSalaryRange` → `findByRoleSalaryBetween`

### Type Mismatch in Factory
- Changed `OrderFactory.createOrder` parameter from `int orderId` to `Long orderId` to match the `Order` entity.

### Restored Missing Entity Fields
- Restored `customerId` field in `Order` entity to resolve compile errors.

### Removed Unused Variable Warning
- Removed unused loop over `OrderItem` objects in `OrderFactory`.

### Fixed Database Connection Issues
- Corrected formatting in `application.properties` and advised on using a supported MySQL/MariaDB version.

### Added Missing JPA Entity Annotations
- Added `@Entity` and relationship annotations to entities like `OrderItem`.

---

All major compile, runtime, and mapping errors have been resolved. The project now follows Spring Boot, JPA, and database best practices.
