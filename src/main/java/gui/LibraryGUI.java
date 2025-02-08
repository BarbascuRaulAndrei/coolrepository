package gui;

import javax.swing.*;

import library.Book;
import library.Library;
import library.LoginSystem;

import java.awt.*;
/**
 * GUI-ul ferestrei pentru admin (de unde adaugam si stergem carti in fisier)
 */
public class LibraryGUI {
    private JFrame frame;
    private JList<String> bookList;
    private DefaultListModel<String> bookListModel;
    private Library library;
    private LoginSystem loginSystem;
    /**
     * constructor la gui-ul de admin
     */
    public LibraryGUI() {
        library = new Library();
        loginSystem = new LoginSystem();
        initialize();
    }
    /**
     * init pentru gui
     */
    private void initialize() {
        frame = new JFrame("Sistem Biblioteca");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        bookListModel = new DefaultListModel<>();
        library.getBooks().forEach(book -> bookListModel.addElement(book.toString()));

        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        JButton addBookButton = new JButton("Adauga carte");
        addBookButton.addActionListener(e -> addBook());
        panel.add(addBookButton);

        JButton removeBookButton = new JButton("Sterge carte");
        removeBookButton.addActionListener(e -> removeBook());
        panel.add(removeBookButton);
    }

    /**
     * metoda pentru addbook
     */
    private void addBook() {
        String title = JOptionPane.showInputDialog("Titlu:");
        String author = JOptionPane.showInputDialog("Autor:");
        String year = JOptionPane.showInputDialog("Anul lansarii:");
        String genre = JOptionPane.showInputDialog("Genul:");
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stocul valabil:"));

        Book book = new Book(title, author, year, stock, genre);
        library.addBook(book);
        bookListModel.addElement(book.toString());
    }
    /**
     * metoda pentru removebook
     */
    private void removeBook() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex != -1) {
            Book book = library.getBooks().get(selectedIndex);
            library.removeBook(book);
            bookListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Da click pe cartea pe care doresti sa o stergi");
        }
    }

    /**
     * display
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * functie de main pentru testare, de ignorat
     * @param args pentru main
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LibraryGUI window = new LibraryGUI();
                window.display();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}