package Managers;

import Classes.Book;
import Classes.Library;

import java.util.List;

public class LibraryManager
{
    private Library myLibrary;

   public LibraryManager()
   {
       myLibrary = new Library();
   }
    public void FillBooksListWithDefaultBooks()
    {
        List<Book> bookList = myLibrary.GetBookList();
        bookList.add(new Book(1,"Book1","1990"));
        bookList.add(new Book(2,"Book2","1991"));
        bookList.add(new Book(3,"Book3","1992"));
        myLibrary.SetBookList(bookList);
    }
    public void DisplayBookList()
    {
        List<Book> bookList = myLibrary.GetBookList();
        for(Book book : bookList)
        {
            System.out.println("ID " +book.Id + ", Name " + book.Name + ", Year "+ book.YearPublished );
        }
    }

    public Boolean checkOutBook(double bookId)
    {
        Boolean successfullyCheckedOutABook = false;
        List<Book> bookList = myLibrary.GetBookList();
        List<Book> checkedOutbookList = myLibrary.GetCheckedOutBooks();

        for (Book myBook : bookList)
        {
            if (myBook.Id == bookId)
            {
                bookList.removeIf(s -> s.Id==myBook.Id);
                checkedOutbookList.add(myBook);
                successfullyCheckedOutABook=true;

                break;
            }
        }

        myLibrary.SetBookList(bookList);
        myLibrary.SetCheckedOutBooks(checkedOutbookList);
        return successfullyCheckedOutABook;
    }


    public Boolean ReturnBook(double bookId)
    {
        Boolean successfullyReturnedABook = false;
        List<Book> bookList = myLibrary.GetBookList();
        List<Book> checkedOutbookList = myLibrary.GetCheckedOutBooks();

        for (Book myBook : checkedOutbookList)
        {
            if (myBook.Id == bookId)
            {
                checkedOutbookList.removeIf(s -> s.Id==myBook.Id);
                bookList.add(myBook);
                successfullyReturnedABook=true;
                break;
            }
        }
        myLibrary.SetBookList(bookList);
        myLibrary.SetCheckedOutBooks(checkedOutbookList);
        return successfullyReturnedABook;
    }
}
