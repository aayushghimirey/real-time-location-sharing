package io.aygh7.location_system.location_system.shared;

public enum UserRole {

    CLIENT("ROLE_CLIENT"),
    DRIVER("ROLE_DRIVER");

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
