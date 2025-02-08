package library;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * clasa pentru biblioteca
 */
public class Library {
    private ArrayList<Book> books; //aici avem doua liste, una pentru carti, una pentru utilizatori
    private ArrayList<User> users;
    private static final String REVIEWS_FILE = "reviews.txt";
    /**
     * librarie
     * 
     * 
     */
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loadBooksFromFile(); // incarca cartile la pornirea aplicatiei
        loadUsersFromFile();  // incarca utilizatorii la pornirea aplicatiei
        
    }

    /**
     * metoda pentru a adauga o carte in fisiser
     * @param book cartea pe care o adaugam
     * 
     */
    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile(); // salveaza cartile in fisier dupa fiecare adaugare
    }
    /**
     * metoda pentru a adauga un review
     * @param bookTitle titlul cartii
     * @param review review-ul
     * @param username numele persoanei care adauga review-ul
     * 
     */
    public void addReview(String bookTitle, String review, String username) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REVIEWS_FILE, true))) {
        	String lowercaseTitle = bookTitle.toLowerCase();
            writer.write(lowercaseTitle + " | " + review + " | " + username);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    /**
     * metoda pentru a sterge carti din fisiers
     * @param book cartea
     * 
     */
    public void removeBook(Book book) {
        books.remove(book);
        saveBooksToFile(); // salveaza cartile in fisier dupa fiecare stergere
    }

    /**
     * metoda pentru a cauta carti
     * @param keyword keyword-ul se refera la un cuvant cheie din titlul/titlurile cartilor
     * @return rezultatele cautarii (o lista de carti)
     */
    public ArrayList<Book> searchBooks(String keyword) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * metoda de adaugar un utilizator
     * @param user un utilizator (cu nume si parola)
     * 
     */
    public void addUser(User user) {
        users.add(user);
        saveUsersToFile();  // Salveaza utilizatorii in fisier
    }

    /**
     * metoda de autentificare
     * @param username numele unui user
     * @param password parola unui user
     * @return returneaza null daca nu gasim userul
     */
    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * metoda de returnare lista de carti
     * @return returneaza lista de carti
     * 
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * metoda pentru imprumut carte
     * @param title titlul cartii
     * @return returneaza true daca am reusit sa imprumuam si false daca nu
     */
    public boolean borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getStock() > 0) {
                book.setStock(book.getStock() - 1); //tot de explicat cu stocul
                saveBooksToFile(); // salveaza stocul dupa fiecare imprumut
                return true; // imprumut reusit
            }
        }
        return false; // imprumut esuat
    }

    /**
     * metoda de reutrnare carte
     * @param title titlul cartii pe care o returnam
     * @return true daca reusim, false daca nu
     * 
     */
    public boolean returnBook(String title) { //aici voi explica currentstoc/normal stoc
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
            	
            	
            		book.setStock(book.getStock() + 1);
                    saveBooksToFile(); // salveaza stocul dupa fiecare returnare
                    return true; // returnare reusita
            	
            	
            }
        }
        return false; // returnare esuata
    }

    /**
     * metoda de salvare carti in fisiser
     * 
     * 
     */
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Books.txt"))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getStock() + "," + book.getGenre());//aici de explicat posibilitati
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda de incarcare carti in fisier
     * 
     * 
     */
    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0].trim();
                String author = data[1].trim();
                String year = data[2].trim();
                int stock = Integer.parseInt(data[3].trim());
                String genre = data[4].trim();

                Book book = new Book(title, author, year, stock, genre);
                books.add(book);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda de salvare utilizator in fisier
     * 
     * 
     */
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * metoda de incarcare utilizatori din
     * 
     * 
     */
    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    // Adaugam utilizatorul ca Reader pentru simplificare
                    User user = new Reader(username, password);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * metoda incarcare review-uri din fisier
     * @param bookTitle titlul cartii
     * @return returneaza review-urile
     */
    public List<String> getReviews(String bookTitle) {
        List<String> reviews = new ArrayList<>();
        String lowercaseTitle = bookTitle.toLowerCase();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(REVIEWS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length > 0 && parts[0].toLowerCase().equals(lowercaseTitle)) {
                    reviews.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }

}
