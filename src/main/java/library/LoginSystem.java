package library;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * clasa pentru sistem de log in
 */
public class LoginSystem {
    private Map<String, String> users;
    private static final String USERS_FILE = "users.txt";//users.txt este fisierul pe care il vom utiliza

    /**
     * constructor pentru loginsystem
     */
    public LoginSystem() {
        users = new HashMap<>();
        loadUsersFromFile();
    }
    /**
     * metoda pentru autentificarea unui utilizator
     * @param username numele utilizatorului
     * @param password parola utilizatorului
     * @return true daca merge, fals daca nu
     */
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    /**
     * metoda de adaugare utilizator in fisier
     * @param username numele utilizatorului
     * @param password parola utilizatorului
     */
    public void addUser(String username, String password) {
        users.put(username, password);
        saveUsersToFile(); // salvează utilizatorul in fișier
    }

    /**
     *  metoda de incarcare utilizatori din fisier
     */
    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("eroare! " + e.getMessage());
        }
    }

    /**
     * metoda de salvare utilizatori in fisier
     */
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}
