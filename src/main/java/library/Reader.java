package library;
/**
 * clasa pentru cititori
 */
public class Reader extends User {
	/**
	 * cititor
	 * @param username numele cititorului
	 * @param password parola cititorului
	 */
    public Reader(String username, String password) {
        super(username, password);
    }
   
    @Override
    /**
     * rolul de cititor
     * @return returnam rolul de cititor
     * 
     */
    public String getRole() {
        return "Reader";
    }
}