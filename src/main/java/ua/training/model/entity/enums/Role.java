package ua.training.model.entity;

public enum Role {
    UNKNOWN("unknown"),
    ADMIN("admin"),
    CASHIER("cashier"),
    SENIOR_CASHIER("senior cashier"),
    MERCHANT("merchant");

    Role(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
