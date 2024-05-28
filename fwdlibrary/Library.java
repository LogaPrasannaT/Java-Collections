import java.util.*;

public class Library {
    Map<String, Book> books = new HashMap<>();
    Map<String, Member> members = new HashMap<>();
    List<Transaction> transactions = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public void borrow(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && book.isAvailable() && member != null) {
            book.setAvailable(false);
            book.incrementBorrowCount();
            member.incrementBorrowCount();
            transactions.add(new Transaction(bookId, memberId, new Date(), true));
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);
        if (book != null && !book.isAvailable() && member != null) {
            book.setAvailable(true);
            transactions.add(new Transaction(bookId, memberId, new Date(), false));
        } else {
            System.out.println("Book is not returned");
        }
    }

    public void listAllBooks() {
        System.out.println("ID\tTitle\tAuthor\tStatus");
        System.out.println("------------------------------------------");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void listBorrowBooks() {
        System.out.println("Borrowed books:");
        for (Transaction transaction : transactions) {
            if (transaction.isBorrow()) {
                Book book = books.get(transaction.getBookId());
                Member member = members.get(transaction.getMemId());
                System.out.println(book.getTitle() + "\tBorrowed by\t" + member.getName());
            }
        }
    }

    public void findMemberMostBook() {
        Member maxMember = null;
        System.out.println("The member who borrowed the most books:");
        for (Member member : members.values()) {
            if (maxMember == null || member.getBorrowCount() > maxMember.getBorrowCount()) {
                maxMember = member;
            }
        }
        if (maxMember != null) {
            System.out.println(maxMember.getName());
        }
    }

    public void findMostBorrowBook() {
        Book maxBook = null;
        System.out.println("The book that is most borrowed:");
        for (Book book : books.values()) {
            if (maxBook == null || book.getBorrowCount() > maxBook.getBorrowCount()) {
                maxBook = book;
            }
        }
        if (maxBook != null) {
            System.out.println(maxBook.getTitle());
        }
    }

    public static void main(String[] args) {
        Library lib = new Library();
        String bookId, memberId;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n---------Menu----------");
            System.out.println("1.\tAdd Books");
            System.out.println("2.\tAdd Member");
            System.out.println("3.\tList of Available books");
            System.out.println("4.\tBorrow Book");
            System.out.println("5.\tReturn Book");
            System.out.println("6.\tList of Borrow books");
            System.out.println("7.\tMember who borrowed book most");
            System.out.println("8.\tThe book that is most Borrowed");
            System.out.println("9.\tExit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    lib.addBook(new Book("10210", "Life is Full Of Surprises & Miracles", "Loki"));
                    lib.addBook(new Book("22010", "Age After 20", "LP"));
                    lib.addBook(new Book("32382", "Responsibility of a younger son", "Prasanna"));
                    lib.addBook(new Book("42132", "Reality vs Reelity", "Lokesh"));
                    break;
                case 2:
                    lib.addMember(new Member("1", "Tony Stark"));
                    lib.addMember(new Member("2", "Steve Rogers"));
                    break;
                case 3:
                    lib.listAllBooks();
                    break;
                case 4:
                    System.out.println("Enter the book id");
                    bookId = sc.next();
                    System.out.println("Enter the member id");
                    memberId = sc.next();
                    lib.borrow(bookId, memberId);
                    break;
                case 5:
                    System.out.println("Enter the book id");
                    bookId = sc.next();
                    System.out.println("Enter the member id");
                    memberId = sc.next();
                    lib.returnBook(bookId, memberId);
                    break;
                case 6:
                    lib.listBorrowBooks();
                    break;
                case 7:
                    lib.findMemberMostBook();
                    break;
                case 8:
                    lib.findMostBorrowBook();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}

