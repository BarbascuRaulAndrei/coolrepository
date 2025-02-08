import library.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//junit test pentru user
class UserTest {

    @Test
    void testGetUsername() {
        User user = new TestUser("testUser", "password123");
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testGetPassword() {
        User user = new TestUser("testUser", "password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    void testCheckPassword() {
        User user = new TestUser("testUser", "password123");

        // Test correct password
        assertTrue(user.checkPassword("password123"));

        // Test incorrect password
        assertFalse(user.checkPassword("wrongPassword"));
    }

    @Test
    void testGetRole() {
        User user = new TestUser("testUser", "password123");
        assertEquals("TestRole", user.getRole());
    }
}
