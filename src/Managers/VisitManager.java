package Managers;

import Classes.Library;

import java.util.Scanner;

public class VisitManager
{
    LibraryManager myLibraryManager;
    OptionsMenuManager myOptionsMenuManager;
    public VisitManager()
    {
        Starter();
        Run();
    }

    private void Run()
    {
        myOptionsMenuManager.DisplayListOfOptions();
        Scanner scanner = new Scanner(System.in);
        String userInput =   scanner.next();

        ValidateOption(userInput);

    }

    private void ValidateOption(String userInput)
    {


        if(myOptionsMenuManager.GetCurrentMenu().equals("BookCheckout"))
        {
            BookCheckoutValidatorOptions(userInput);
        }
        if(myOptionsMenuManager.GetCurrentMenu().equals("StartMenu"))
        {

            MainMenuValidatorOptions(userInput);
        }
        if(myOptionsMenuManager.GetCurrentMenu().equals("BookReturn"))
        {
            BookReturnValidatorOptions(userInput);
        }
        else
        {
            System.out.println("no menu selected");
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
        if(myLibraryManager.checkOutBook(doubleUserInput))
        {
            System.out.println("Thank you! Enjoy the book");
            myOptionsMenuManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("Sorry, that book is not available");
            myOptionsMenuManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }
    private void BookReturnValidatorOptions(String userInput)
    {
        if(myLibraryManager.ReturnBook(Double.parseDouble(userInput)))
        {
            System.out.println("Thank you for returning the book");
            myOptionsMenuManager.SetCurrentMenu("StartMenu");
            Run();
        }
        else
        {
            System.out.println("That is not a valid book to return");
            myOptionsMenuManager.SetCurrentMenu("StartMenu");
            Run();
        }
    }

    private void MainMenuValidatorOptions(String userInput)
    {
        if(userInput.equals("q")|| userInput.equals("Q"))
        {
            return;
        }
        if(userInput.equals("1"))
        {
            myLibraryManager.DisplayBookList();
            Run();
            return;
        }
        if(userInput.equals("2"))
        {
            myLibraryManager.DisplayBookList();
            myOptionsMenuManager.SetCurrentMenu("BookCheckout");
            Run();
            return;
        }
        if(userInput.equals("3"))
        {
            myLibraryManager.DisplayBookList();
            myOptionsMenuManager.SetCurrentMenu("BookReturn");
            Run();
            return;
        }
        else
        {
            DisplayNotValidOptionSelection();
        }
    }

    private void DisplayNotValidOptionSelection()
    {
        System.out.println("Please select a valid option!");
        Run();
    }

    private void Starter()
{
    PresentWelcomeMessage();
    //starting library Manager
    myLibraryManager = new LibraryManager();
    myLibraryManager.FillBooksListWithDefaultBooks();
    //starting Options Menu
    myOptionsMenuManager = new OptionsMenuManager();
    myOptionsMenuManager.StartOptionsMenu();
}
    private void PresentWelcomeMessage()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
