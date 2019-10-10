package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library
{
    private List<Book>  booksList;
    private Map<Book,String> checkedOutBooksList;
    private List<Movie> movieList;
    private Map<Movie,String> checkedOutMovieList;
    private List<User> userList;


    public List<User> GetUserList()
    {
        return  userList;
    }
    public void SetUserList(List<User> userList)
    {
        this.userList=userList;
    }


    public List<Movie> GetMovieList()
    {
        return  movieList;
    }
    public void SetMovieList(List<Movie> movieList)
    {
        this.movieList=movieList;
    }

    public Map<Movie,String> GetCheckedOutMovies()
    {
        return checkedOutMovieList;
    }
    public void SetCheckedOutMovies(Map<Movie,String>checkedOutMovieList)
    {
        this.checkedOutMovieList = checkedOutMovieList;
    }


    public List<Book> GetBookList()
    {
         return  booksList;
    }
    public void SetBookList(List<Book> booksList)
    {
        this.booksList=booksList;
    }


    public Map<Book,String> GetCheckedOutBooks()
    {
        return checkedOutBooksList;
    }
    public void SetCheckedOutBooks(Map<Book,String>checkedOutBooksList)
    {
        this.checkedOutBooksList = checkedOutBooksList;
    }


    public Library()
    {
        booksList = new ArrayList<Book>();
        checkedOutBooksList = new HashMap<Book,String>();
        movieList = new ArrayList<Movie>();
        checkedOutMovieList = new HashMap<Movie,String>();
        userList = new ArrayList<User>();


    }





}
