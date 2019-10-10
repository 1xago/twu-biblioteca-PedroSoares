package Managers;

import Classes.Library;
import Classes.User;
import sun.rmi.runtime.Log;

import java.util.Scanner;

public class VisitManager
{
    LibraryManager myLibraryManager;
    OptionsMenuManager myOptionsMenuManager;
    User myUser;


    public VisitManager()
    {
        Starter();
        Run();
    }

    private void Run()
    {


        myOptionsMenuManager.userManager.DisplayListOfOptions();
        myOptionsMenuManager.GetCurrentMenu();
        Scanner scanner = new Scanner(System.in);
        String userInput =   scanner.next();

        ValidateOption(userInput);

    }

    private void    ValidateOption(String userInput)
    {
switch (myOptionsMenuManager.userManager.GetCurrentMenu())
{
    case "BookCheckout":
        BookCheckoutValidatorOptions(userInput);
        break;
    case "StartMenu":
        MainMenuValidatorOptions(userInput);
        break;
    case "BookReturn":
        BookReturnValidatorOptions(userInput);
        break;
    case "MovieCheckout":
        MovieCheckoutValidatorOptions(userInput);
        break;
    case "MovieReturn":
        MovieReturnValidatorOptions(userInput);
        break;
    default:
        System.out.println("no menu selected");
        break;
}
    }


    private void MovieCheckoutValidatorOptions(String userInput)
    {
        double doubleUserInput=0;
        try {doubleUserInput=Double.parseDouble(userInput);
        } catch (Exception e) {
            System.out.println("user input was "+ userInput + " but i failed to convert to double");
            e.printStackTrace();
        }
        if(myLibraryManager.checkOutMovie(doubleUserInput,myUser.LibraryNumber))
        {
            System.out.println("Thank you! Enjoy the movie");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("Sorry, that movie is not available");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }


    private void BookCheckoutValidatorOptions(String userInput)
    {
        double doubleUserInput=0;
        try {doubleUserInput=Double.parseDouble(userInput);
        } catch (Exception e) {
            System.out.println("user input was "+ userInput + " but i failed to convert to double");
            e.printStackTrace();
        }
        if(myLibraryManager.checkOutBook(doubleUserInput,myUser.LibraryNumber))
        {
            System.out.println("Thank you! Enjoy the book");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("Sorry, that book is not available");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }
    private void BookReturnValidatorOptions(String userInput)
    {
        if(myLibraryManager.ReturnBook(Double.parseDouble(userInput),myUser.LibraryNumber))
        {
            System.out.println("Thank you for returning the book");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("That is not a valid book to return");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }

    private void MovieReturnValidatorOptions(String userInput)
    {
        if(myLibraryManager.ReturnMovie(Double.parseDouble(userInput),myUser.LibraryNumber))
        {
            System.out.println("Thank you for returning the Movie");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("That is not a valid movie to return");
            myOptionsMenuManager.userManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }

    private void MainMenuValidatorOptions(String userInput)
    {
        String value =myOptionsMenuManager.userManager.MainMenuValidatorOptions(userInput);
    switch (value)
    {
        case "q":  break;
        case "Q":  break;
        case "DisplayBookList":
            myLibraryManager.DisplayBookList();
            Run();
            break;
        case "DisplayMovieList":
            myLibraryManager.DisplayMovieList();
            Run();
            break;
        case "ListAllCheckedOutBooks":
            myLibraryManager.DisplayListOfAllCheckoutBooks();
            Run();
            break;
        case "ListAllCheckedOutMovies":
            myLibraryManager.DisplayListOfAllCheckoutMovies();
            Run();
            break;
        case "CheckOutBooks":
            myLibraryManager.DisplayBookList();
            myOptionsMenuManager.userManager.SetCurrentMenu("BookCheckout");
            Run();
            break;
        case "ReturnBooks":
            myOptionsMenuManager.userManager.SetCurrentMenu("BookReturn");
            Run();
            break;
        case "CheckOutMovies":
            myLibraryManager.DisplayMovieList();
            myOptionsMenuManager.userManager.SetCurrentMenu("MovieCheckout");
            Run();
            break;
        case "ReturnMovies":
            myOptionsMenuManager.userManager.SetCurrentMenu("MovieReturn");
            Run();
            break;

        case "log":
            Starter();
            break;
        case "MyInfo":
            DisplayUserInfo();
            Run();
            break;

        default: DisplayNotValidOptionSelection();break;
    }
    }
private void DisplayUserInfo()
{
    System.out.println("User Name: " + myUser.Name + "User Email "+ myUser.Email
    + "Phone Number "+ myUser.PhoneNumber);
}
    private void DisplayNotValidOptionSelection()
    {
        System.out.println("Please select a valid option!");
        Run();
    }

    private User Starter()
{
    PresentWelcomeMessage();
    //starting library Manager
    myLibraryManager = new LibraryManager();
    myLibraryManager.FillBooksListWithDefaultBooks();
    myLibraryManager.FillMoviesWithDefaultMovies();
    myLibraryManager.FillDefaultUserList();
    //starting Options Menu
    myOptionsMenuManager = new OptionsMenuManager(new AdminOptionsMenuManager(),new LoggedOptionsMenuManager(),new NonLoggedOptionsMenuManager());
    myUser= myOptionsMenuManager.StartLoginMenu(myLibraryManager);
    return myUser;

}
    private void PresentWelcomeMessage()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
