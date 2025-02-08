package library;

/**
 * clasa pentru carti
 * 
 */
public class Book {
    private String title;
    private String author;
    private String year;
    private int stock;
    private int currentstock;
    private String genre;
    /**
     * carte
     * @param title titlul cartii
     * @param author autorul cartii
     * @param year anul lansarii
     * @param stock stocul valabil
     * @param genre genul cartii
     * 
     */
    public Book(String title, String author, String year, int stock, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.stock = stock;
        this.genre = genre;
        this.currentstock= stock;
    }

    /**
     * getter titlu
     * @return titlul cartii
     * 
     */
    public String getTitle() {
        return title;
    }
    /**
     * getter autor
     * @return autorul cartii
     * 
     */
    public String getAuthor() {
        return author;
    }
    /**
     * getter an
     * @return anul cartii
     * 
     */
    public String getYear() {
        return year;
    }
    /**
     * getter stoc
     * @return stocul cartii
     * 
     */
    public int getStock() {
        return stock;
    }
    /**
     * getter stoc curent
     * @return stocul curent (nefolosit in codul final)
     * 
     */
    public int getcurrentStock()
    {
    	return currentstock;
    }
    /**
     * setter pentru stoc
     * @param stock stocul cartilor
     * 
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * setter pentru stoc curent (nefolosit)
     * @param currentstock stocul curent al cartilor
     * 
     */
    public void setCurrentStock(int currentstock) {
        this.currentstock = currentstock;
    }
    /**
     * getter pentru gen
     * @return genul cartii
     * 
     */
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " de " + author + " (" + year + ") - " + genre + " - stoc: " + stock;
    }
}
