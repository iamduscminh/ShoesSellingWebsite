package model;

/**
 *
 * @author win
 */
public class Account {
    private int accId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean role;

    public Account() {
    }

    public Account(int accId, String username, String password, String firstName, String lastName, boolean role) {
        this.accId = accId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Account(int accId, String username, String password, String firstName, String lastName) {
        this.accId = accId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    
    @Override
    public String toString() {
        return "Account{" + "accId=" + accId + ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + '}';
    }

    

    
    
}
