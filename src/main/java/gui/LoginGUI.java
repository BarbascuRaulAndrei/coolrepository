package gui;

import javax.swing.*;

import library.LoginSystem;

import java.awt.*;
/**
 * GUI-ul pentru fereastra de login
 */
public class LoginGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private LoginSystem loginSystem;
    /**
     * constructor basic
     */
    public LoginGUI() {
        loginSystem = new LoginSystem();
        initialize();
    }
    /**
     * initializarea gui-ului
     */
    private void initialize() {
        frame = new JFrame("Library Login");
        frame.getContentPane().setBackground(new Color(192, 192, 192));
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Parola:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(e -> handleLogin());

        frame.getContentPane().add(usernameLabel);
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(new JLabel()); // Empty space
        frame.getContentPane().add(loginButton);
    }

    /**
     * functie ce se ocupa cu login-ul 
     */
    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (loginSystem.authenticate(username, password)) {
           // JOptionPane.showMessageDialog(frame, "Login successful!");

            // determinam user role (admin sau reader)
            if ("admin".equals(username)) {
                LibraryGUI libraryGUI = new LibraryGUI();
                libraryGUI.display();
            } else {
                ReaderGUI readerGUI = new ReaderGUI();
                readerGUI.display();
            }

            frame.dispose(); // inchidem login-ul
        } else {
            JOptionPane.showMessageDialog(frame, "Parola sau user invalid.", "Eroare!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * dam display la fereastra de gui
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * mini functie de main de test
     * @param args pentru main
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginGUI window = new LoginGUI();
                window.display();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}