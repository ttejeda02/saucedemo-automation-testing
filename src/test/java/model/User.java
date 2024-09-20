package model;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer postalCode;

    public User(String username, String password, String firstName, String lastName, Integer postalCode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {}

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {}
}
