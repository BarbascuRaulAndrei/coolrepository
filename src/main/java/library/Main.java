package library;

import gui.LoginGUI;

/**
 * clasa main
 */
public class Main {
	/**
     * main
     * @param args pentru main
     */
    public static void main(String[] args) {
        // cream si afisam fereastra de login
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.display();
    }
}