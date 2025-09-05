//package za.ac.cput.domain;
//
///* Role.java
//``Author: Aimee Paulus (222814969)
//  Date: 10 May 2025
// */
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//
//@Entity
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String roleId;
//    private String roleName;
//    private double roleSalary;
//
//    protected Role() {
//
//    }
//
//    private Role(RoleBuilder builder) {
//
//        this.roleId = builder.roleId;
//        this.roleName = builder.roleName;
//        this.roleSalary = builder.roleSalary;
//    }
//
//
//    public String getRoleId() {
//        return roleId;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public double getRoleSalary() {
//        return roleSalary;
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                "roleId='" + roleId + '\'' +
//                ", roleName='" + roleName + '\'' +
//                ", roleSalary=" + roleSalary +
//                '}';
//    }
//
//    public static class RoleBuilder {
//        private String roleId;
//        private String roleName;
//        private double roleSalary;
//
//        public RoleBuilder(String roleId, String roleName, double roleSalary){
//            this.roleId = roleId;
//            this.roleName = roleName;
//            this.roleSalary = roleSalary;
//        }
//
//        public RoleBuilder setRoleId(String roleId) {
//            this.roleId = roleId;
//            return this;
//        }
//
//        public RoleBuilder setRoleName(String roleName) {
//            this.roleName = roleName;
//            return this;
//        }
//
//        public RoleBuilder setRoleSalary(double roleSalary) {
//            this.roleSalary = roleSalary;
//            return this;
//        }
//
//        public Role build() {
//            return new Role(this);
//        }
//    }
//
//}
