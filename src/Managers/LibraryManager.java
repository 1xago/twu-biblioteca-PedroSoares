package Managers;

import Classes.Book;
import Classes.Library;
import Classes.Movie;
import Classes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibraryManager
{
    private Library myLibrary;

   public LibraryManager()
   {
       myLibrary = new Library();
   }

    public void FillDefaultUserList()

    {
        List<User> userlist = new ArrayList<User>();
        userlist.add(new User(true,"aaa-aaa","aaa","librarian","123456","librarian@me",1.0));
        userlist.add(new User(false,"111-111","aaa","user1","123456","user1@me",2.0));
        userlist.add(new User(false,"222-222","aaa","user2","123456","user2@me",3.0));
        myLibrary.SetUserList(userlist);
    }

    public void FillBooksListWithDefaultBooks()
    {
        List<Book> bookList = myLibrary.GetBookList();
        bookList.add(new Book(1,"Book1","1990"));
        bookList.add(new Book(2,"Book2","1991"));
        bookList.add(new Book(3,"Book3","1992"));
        myLibrary.SetBookList(bookList);
    }
    public void FillMoviesWithDefaultMovies()
    {
        List<Movie> movieList = myLibrary.GetMovieList();
        movieList.add(new Movie("Name1",1992,"Director1",2, 1,true));
        movieList.add(new Movie("Name2",1993,"Director2",3,2,true));
        movieList.add(new Movie("Name3",1994,"Director1",0,3,false));

        myLibrary.SetMovieList(movieList);
    }


    public void DisplayListOfAllCheckoutBooks()
    {
        Map<Book,String> bookList = myLibrary.GetCheckedOutBooks();

        for (Map.Entry<Book, String> entry : bookList.entrySet())
        {
            Book checkingBook = entry.getKey();
            String checkingUser = entry.getValue();
            System.out.println("Book Name: " +checkingBook.Name + ", BookId: " + checkingBook.Id + ", Person That Requested: "+ checkingUser );
        }
    }
    public void DisplayListOfAllCheckoutMovies()
    {
        Map<Movie,String> movieList = myLibrary.GetCheckedOutMovies();

        for (Map.Entry<Movie, String> entry : movieList.entrySet())
        {
            Movie checkingMovie = entry.getKey();
            String checkingUser = entry.getValue();
            System.out.println("Movie Name: " +checkingMovie.Name + ", MovieId: " + checkingMovie.MovieId + ", Person That Requested: "+ checkingUser );
        }
    }

    public void DisplayBookList()
    {
        List<Book> bookList = myLibrary.GetBookList();
        for(Book book : bookList)
        {
            System.out.println("ID " +book.Id + ", Name " + book.Name + ", Year "+ book.YearPublished );
        }
    }
    public void DisplayMovieList()
    {
        List<Movie> movieList = myLibrary.GetMovieList();
        for(Movie movie : movieList)
        {
            System.out.print("Movie ID: "+movie.MovieId +" Movie Name: " +movie.Name + ", Year Published: " + movie.YearPublished + ", Director "+ movie.Director);
                   if (movie.IsRatingAvailable)
                   {
                       System.out.println(", Rating: "+ movie.Rating);
                   }
                   else
                   {
                       System.out.println(", Rating: N/A");
                   }
        }
    }

    public Boolean checkOutMovie(double movieId,String userId)
    {
        Boolean successfullyCheckedOutAMovie = false;
        List<Movie> movieList = myLibrary.GetMovieList();
        Map<Movie,String> checkedOutmovieList = myLibrary.GetCheckedOutMovies();

        for (Movie myMovie : movieList)
        {
            if (myMovie.MovieId == movieId)
            {
                movieList.removeIf(s -> s.MovieId==myMovie.MovieId);
                checkedOutmovieList.put(myMovie,userId);
                successfullyCheckedOutAMovie=true;

                break;
            }
        }

        myLibrary.SetMovieList(movieList);
        myLibrary.SetCheckedOutMovies(checkedOutmovieList);
        return successfullyCheckedOutAMovie;
    }



    public Boolean checkOutBook(double bookId,String userId)
    {
        Boolean successfullyCheckedOutABook = false;
        List<Book> bookList = myLibrary.GetBookList();
        Map<Book,String> checkedOutbookList = myLibrary.GetCheckedOutBooks();

        for (Book myBook : bookList)
        {
            if (myBook.Id == bookId)
            {
                bookList.removeIf(s -> s.Id==myBook.Id);
                checkedOutbookList.put(myBook,userId);
                successfullyCheckedOutABook=true;

                break;
            }
        }

        myLibrary.SetBookList(bookList);
        myLibrary.SetCheckedOutBooks(checkedOutbookList);
        return successfullyCheckedOutABook;
    }



    public Boolean ReturnMovie(double movieId,String userId)
    {
        Boolean successfullyReturnedAMovie = false;
        List<Movie> MovieList = myLibrary.GetMovieList();
        Map<Movie,String> checkedOutMovieList = myLibrary.GetCheckedOutMovies();
        //this checks if the book exists in the checkedout list and if i am the user that checked it out

        for (Map.Entry<Movie, String> entry : checkedOutMovieList.entrySet())
        {
            Movie checkingMovie = entry.getKey();
            String checkingUser = entry.getValue();
            if(userId.equals(checkingUser)&& checkingMovie.MovieId==movieId)
            {
                checkedOutMovieList.remove(checkingMovie);
                MovieList.add(checkingMovie);
                successfullyReturnedAMovie=true;
                break;
            }
        }

        myLibrary.SetMovieList(MovieList);
        myLibrary.SetCheckedOutMovies(checkedOutMovieList);
        return successfullyReturnedAMovie;
    }



    public Boolean ReturnBook(double bookId,String userId)
    {
        Boolean successfullyReturnedABook = false;
        List<Book> bookList = myLibrary.GetBookList();
        Map<Book,String> checkedOutbookList = myLibrary.GetCheckedOutBooks();
        //this checks if the book exists in the checkedout list and if i am the user that checked it out

        for (Map.Entry<Book, String> entry : checkedOutbookList.entrySet())
        {
            Book checkingBook = entry.getKey();
            String checkingUser = entry.getValue();
            if(userId.equals(checkingUser)&& checkingBook.Id==bookId)
            {
                checkedOutbookList.remove(checkingBook);
                bookList.add(checkingBook);
                successfullyReturnedABook=true;
                break;
            }
        }

        myLibrary.SetBookList(bookList);
        myLibrary.SetCheckedOutBooks(checkedOutbookList);
        return successfullyReturnedABook;
    }

    public boolean IsUserAndPasswordCorrect(String user, String password)
    {
       for(User selectedUser:myLibrary.GetUserList())
       {
        if(selectedUser.LibraryNumber.equals(user)&& selectedUser.Password.equals(password))
        {
            return true;
        }
       }
       return false;
    }
    public boolean IsUserAdmin(String user)
    {
     for(User selectedUser:myLibrary.GetUserList())
     {
            if(selectedUser.LibraryNumber.equals(user)&& selectedUser.IsAdmin)
            {
                return true;
            }
        }
    return false;
    }

    public User GetUser(String LibraryNumber)
    {
        List<User> userList = myLibrary.GetUserList();
        for(User user:userList)
        {
            if(user.LibraryNumber.equals(LibraryNumber))
            {
                return user;
            }
        }
return new User();
    }

}
