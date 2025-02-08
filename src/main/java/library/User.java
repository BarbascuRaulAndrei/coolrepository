package library;

/**
 * clasa pentru utilizator
 * 
 */
public abstract class User {
    private String username;
    private String password;
    /**
     * declaram un user
     * @param username numele unui utilizator
     * @param password parola unui utilizator
     * 
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * getter pentru username
     * @return numele unui utilizator
     * 
     */
    public String getUsername() {
        return username;
    }
    /**
     * getter pentru parola
     * @return parola unui utilizator
     * 
     */
    public String getPassword() {
        return password;
    }
    /**
     * verificam daca parola unui utilizator e ok
     * @param password parola unui utilizator
     * @return returneaza true daca parola e corecta, false daca nu e corecta
     * 
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    /**
     * returnam rolul unui utilizator
     * @return rolul unui utilizator (admin sau cititor)
     */
    public abstract String getRole();
}
