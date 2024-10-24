package com.ttejeda.saucedemo.model;


/**
 * Represents the profile for a user with 5 parameters:
 * username, password, firstName, lastName and postalCode.
 */
public class User {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    /**
     * @param username      the username to login
     * @param password      password to login
     * @param firstName     first name used to do the checkout
     * @param lastName      last name used to do the checkout
     * @param postalCode    postal code to indicate where to send the purchase
     */
    public User(String username, String password, String firstName, String lastName, String postalCode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    /**
     * Retrieves the username used to login
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the profile username to use
     * @param username username
     */
    public void setUsername(String username) {}

    /**
     * Retrieves the password used to login
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password to use
     * @param password password
     */
    public void setPassword(String password) {}

    /**
     * Retrieves the user first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a new first name
     * @param firstName user first name
     */
    public void setFirstName(String firstName) {}

    /**
     * Retrieves the user last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a new last name
     * @param lastName user last name
     */
    public void setLastName(String lastName) {}

    /**
     * Retrieves the user postal code
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets a new postal code
     * @param postalCode user postal code
     */
    public void setPostalCode(Integer postalCode) {}
}
