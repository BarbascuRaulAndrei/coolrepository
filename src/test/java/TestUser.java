import library.User;
/**
 * clasa de test pentru utilizator
 */
public class TestUser extends User {
	/**
     * utilizator pentru test
     * @param username test pentru nume
     * @param password test pentru parola
     */
    public TestUser(String username, String password) {
        super(username, password);
    }

    /**
     * returnarea rolului de test
     */
    @Override
    public String getRole() {
        return "TestRole";
    }
}
