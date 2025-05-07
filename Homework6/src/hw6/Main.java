package hw6;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
	String title; // Represents the book title
	String author; // Represents the author
	String isbn; // Represents the ISBN number
	boolean isAvailable; // checks if the books is available

	// Constructor to initialize fields
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isAvailable = true;
	}

	// toString() to display book details
	public String toString() {
		return ("Book Title: " + title + " || Author: " + author + " || ISBN#: " + isbn + " || Status: " + (isAvailable ? "Available to check out" : "Checked Out" ));
	}
}

class Library {
	ArrayList<Book> books = new ArrayList<>();
	
	// Function to start and add books to the ArrayList books
	public Library() {
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
		books.add(new Book("1984", "George Orwell", "9780451524935"));
		books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
		books.add(new Book("A Brief History of Time", "Stephen Hawking", "9780553380163"));
		books.add(new Book("The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt", "9780135957059"));
		books.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "9780132350884"));
		books.add(new Book("Educated: A Memoir", "Tara Westover", "9780399590504"));
		books.add(new Book("Thinking, Fast and Slow", "Daniel Kahneman", "9780374533557"));
	}
	
	// function to add a new book 
	public void addBook(Book book) {
		for (Book b : books) {
		if (b.isbn.equals(book.isbn)) {
			System.out.println("ISBN Number: " + book.isbn + " is already in the library!");
			return;
		}
		}
		books.add(book);
		System.out.println("The book, " + book.title + ", by " + book.author + " was added to the library!");
	}
	
	// function to remove a new book 
	public void removeBook(String isbn) {
		for (Book book : books) {
			if (book.isbn.equals(isbn)) {
				books.remove(book); 
				System.out.println("ISBN#: " + isbn + " was removed from the library!");
			}
		}
		
	}
	
	// function to display all the books in ArrayList books
	public void displayAllBooks() {
		System.out.println("All the Books in the library: ");
		for (Book book: books ) {
			System.out.println(book);
		}
	}
	
	// function to search by title
	public void searchByTitle(String title) {
		
		for (Book book: books ) {
			if (book.title.equals(title)) {
				System.out.println(title + " is in our library");
				break;
			}
			else {
				continue;
			}
			
			
			}
		}
	
	// function to search by author
		public void searchByAuthor(String author) {
			for (Book book: books ) {
				if (book.author.equals(author)) {
					System.out.println(author + " is in our library");
				}
				else {
					
				}
			}
			System.out.println("The author, "+ author + ", is not in our library");
		}
		
		// function to mark book as checked out
		public void checkOutBook(String isbn) {
			for (Book book: books) {
				if (book.isbn.equals(isbn)) {
					if (book.isAvailable) {
						book.isAvailable = false;
						System.out.print("Checked out: " + book.title + ", ISBN: " + book.isbn);
					} else {
						System.out.println("That book is already checked out.");
					}
				}
			}
		}

		// function to mark book as available
		public void returnBook(String isbn) {
			for (Book book : books) {
				if (book.isbn.equals(isbn)) {
					if (!book.isAvailable) {
						book.isAvailable = true;
						System.out.println("Returning book with ISBN #: " + isbn);
						System.out.println("Book returned");
					} else {
					System.out.println("Book with ISBN #: " + isbn + " is not checked out");
					}
					break;
				}
				
			}
		}
	}

	// Main class with a menu
	public class Main {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Library library = new Library();
			int choice = -1;

			while (choice != 8) {
				System.out.println("\n=== Welcome to the Library Management System ===");
				System.out.println("1. Add a Book");
				System.out.println("2. Remove a Book");
				System.out.println("3. Display all the Books");
				System.out.println("4. Search By Title");
				System.out.println("5. Search By Author");
				System.out.println("6. Check out a Book");
				System.out.println("7. Return a Book");
				System.out.println("8. Exit");
				System.out.println("Choose an option (1-8): ");

				choice = scanner.nextInt();
				switch (choice) {
				case 1: 
					System.out.println("Let's add a book to the library! ");
					System.out.println("Enter the TITLE of the book: ");
					scanner.nextLine();
					String title = scanner.nextLine();
					System.out.println("Enter the AUTHOR of the book: ");
					String author = scanner.nextLine();
					System.out.println("Enter the ISBN# of the book: ");
					String isbn = scanner.nextLine();
					Book newBook = new Book(title, author, isbn);
					library.addBook(newBook);
					break;

				case 2: 
					System.out.println("Let's remove a book to the library! ");
					System.out.println("Enter the ISBN# of the book: ");
					String removeisbn = scanner.next();
					library.removeBook(removeisbn);
					break;

				case 3: 
					library.displayAllBooks();
					break;

				case 4: 
					System.out.println("Enter the title of the book you are looking for: ");
					scanner.nextLine();
					String titleSearch = scanner.nextLine();
					library.searchByTitle(titleSearch);
					break;

				case 5: 
					System.out.println("Enter the author you are looking for: ");
					scanner.nextLine();
					String authorSearch = scanner.nextLine();
					library.searchByAuthor(authorSearch);
					break;

				case 6: 
					System.out.println("Which book do you want to check out?");
					library.displayAllBooks();
					System.out.println("Enter the ISBN# of the book: ");
					String checkoutisbn = scanner.next();
					library.checkOutBook(checkoutisbn);
					break;

				case 7: 
					System.out.println("Let's return a book you checked out to the library! ");
					System.out.println("Enter the ISBN# of the book: ");
					String returnisbn = scanner.next();
					library.returnBook(returnisbn);
					break;

				case 8: 
					System.out.println("Exiting the system. Thank You!");
					break;

				default:
					// Handle invalid menu option
					System.out.println("Wrong Entry! Please enter a number from 1-8 to select your option");	
				}
			}
			scanner.close(); // Close scanner after use
		}
	}
