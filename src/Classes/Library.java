package Classes;

import java.util.ArrayList;
import java.util.List;

public class Library
{
    private List<Book>  booksList;
    private List<Book> checkedOutBooksList;


    public List<Book> GetBookList()
    {
         return  booksList;
    }
    public void SetBookList(List<Book> booksList)
    {
        this.booksList=booksList;
    }


    public List<Book> GetCheckedOutBooks()
    {
        return checkedOutBooksList;
    }
    public void SetCheckedOutBooks(List<Book>checkedOutBooksList)
    {
        this.checkedOutBooksList = checkedOutBooksList;
    }


    public Library()
    {
        booksList = new ArrayList<Book>();
        checkedOutBooksList = new ArrayList<Book>();
    }





}
