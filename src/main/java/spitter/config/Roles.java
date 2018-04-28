package spitter.config;

public enum Roles {
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
