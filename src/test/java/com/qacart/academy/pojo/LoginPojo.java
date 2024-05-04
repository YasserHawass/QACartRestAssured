package com.qacart.academy.pojo;

/**
 * The type Login pojo.
 */
public class LoginPojo {
    private String email;
    private String password;

    /**
     * Instantiates a new Login pojo.
     *
     * @param email    the email
     * @param password the password
     */
    public LoginPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
