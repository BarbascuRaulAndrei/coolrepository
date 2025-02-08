package gui;

import javax.swing.*;

import library.Book;
import library.Library;

import java.awt.*;
import java.util.List;
/**
 * GUI-ul pentru fereastra cititorului (de unde imprumutam, returnam, cautam si adaugam review-uri la carti
 */
public class ReaderGUI {
    private JFrame frame;
    private Library library;
    /**
     * constructor de baza
     */
    public ReaderGUI() {
        library = new Library();
        initialize();
    }
    /**
     * metoda pentru adaugare review
     * @param bookTitle titlul cartii
     * 
     */
    private void addReview(String bookTitle) {
        if (bookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Introdu cartea la care vrei sa faci review:");
            return;
        }

        String review = JOptionPane.showInputDialog(frame, "Introdu review-ul");
        if (review == null || review.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Trebuie sa contina ceva!");
            return;
        }

        String username = JOptionPane.showInputDialog(frame, "Introdu-ti username-ul");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nu poate fi gol!");
            return;
        }

        library.addReview(bookTitle, review, username);
        JOptionPane.showMessageDialog(frame, "Review success!");
    }
    /**
     * vizualizam review-urile
     * @param textArea zona unde sunt afisate review-urile
     *
     */
    private void viewReviews(JTextArea textArea) {
        String bookTitle = JOptionPane.showInputDialog(frame, "Introdu titlul cartii:");
        if (bookTitle == null || bookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nu poate fi gol!");
            return;
        }

        List<String> reviews = library.getReviews(bookTitle);
        if (reviews.isEmpty()) {
            textArea.append("Nu am gasit review-uri pentru: \"" + bookTitle + "\".\n");
        } else {
            textArea.append("Review-urile pentru cartea: \"" + bookTitle + "\":\n");
            reviews.forEach(review -> textArea.append(review + "\n"));
        }
    }


    /**
     * initializarea GUI-ului
     */
    private void initialize() {
        frame = new JFrame("Meniu cititor");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 2));

        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Cauta");
        searchButton.addActionListener(e -> searchBooks(searchField.getText()));

        topPanel.add(searchField);
        topPanel.add(searchButton);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 2));

        JTextField borrowField = new JTextField();
        JButton borrowButton = new JButton("Imprumuta");
        borrowButton.addActionListener(e -> borrowBook(borrowField.getText(), textArea));

        JTextField returnField = new JTextField();
        JButton returnButton = new JButton("Returneaza");
        returnButton.addActionListener(e -> returnBook(returnField.getText(), textArea));

        // camp si buton pentru recenzii
        JTextField reviewField = new JTextField();
        JButton reviewButton = new JButton("Adauga Review");
        reviewButton.addActionListener(e -> addReview(reviewField.getText()));

        bottomPanel.add(borrowField);
        bottomPanel.add(borrowButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setEnabled(false);
        bottomPanel.add(lblNewLabel);
        bottomPanel.add(returnField);
        bottomPanel.add(returnButton);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setEnabled(false);
        bottomPanel.add(lblNewLabel_1);

        bottomPanel.add(reviewField);
        bottomPanel.add(reviewButton);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        JButton viewReviewsButton = new JButton("Vizioneaza review-uri");
        viewReviewsButton.addActionListener(e -> viewReviews(textArea));

        bottomPanel.add(viewReviewsButton);

    }

    /**
     * functie de cautat carti
     * @param query termen introdus de utilizator
     */
    private void searchBooks(String query) {
        List<Book> books = library.searchBooks(query);
        StringBuilder result = new StringBuilder("Rezultate:\n");
        for (Book book : books) {
            result.append(book).append("\n");
        }
        JOptionPane.showMessageDialog(frame, result.toString(), "Rezultate", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * functie de imprumut carte
     * @param title titlul cartii pe care o imprumutam
     * @param textArea zona unde se afiseaza rezultatul actiunii
     */
    private void borrowBook(String title, JTextArea textArea) {
        boolean success = library.borrowBook(title);
        if (success) {
            textArea.append("Ai imprumutat: " + title + "\n");
        } else {
            textArea.append("Eroare! Aceasta carte nu e valabila!\n");
        }
    }
    /**
     * functie de returnare carte
     * @param title titlul cartii pe care o returnam
     * @param textArea zona unde afisam rezultatul actiunii
     */
    private void returnBook(String title, JTextArea textArea) {
        boolean success = library.returnBook(title);
        if (success) {
            textArea.append("Ne-ai returnat: " + title + "\n");
        } else {
            textArea.append("Eroare! Nu acceptam aceasta carte!\n");
        }
    }
    /**
     * display-ul
     */
    public void display() {
        frame.setVisible(true);
    }
}
