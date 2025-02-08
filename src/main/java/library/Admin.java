package library;

/**
 * clasa pentru admin
 * 
 */
public class Admin extends User {
	/**
	 * clasa admin
	 * @param username numele utilizatorului
	 * @param password parola utilizatorului
	 */
    public Admin(String username, String password) {
        super(username, password);
    }

    /**
     * setam rolul la admin
     * @return returnam rolul
     * 
     */
    @Override
    public String getRole() {
        return "Admin";
    }
}