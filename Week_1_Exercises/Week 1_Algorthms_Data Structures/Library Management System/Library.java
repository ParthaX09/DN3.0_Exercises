import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted by title)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title (for binary search)
    public void sortBooksByTitle() {
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "Dracula", "Bram Stoker"));
        library.addBook(new Book("B003", "To Kill a Mockingbird", "Harper Lee"));

        // Linear search
        System.out.println("Linear Search:");
        Book foundBookLinear = library.linearSearchByTitle("Dracula");
        System.out.println(foundBookLinear != null ? foundBookLinear : "Book not found");

        // Sort books for binary search
        library.sortBooksByTitle();

        // Binary search
        System.out.println("Binary Search:");
        Book foundBookBinary = library.binarySearchByTitle("The Great Gatsby");
        System.out.println(foundBookBinary != null ? foundBookBinary : "Book not found");
    }
}
