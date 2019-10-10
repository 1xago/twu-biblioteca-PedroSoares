package Managers;

import Classes.OptionsMenu;

import java.util.ArrayList;
import java.util.List;

public class AdminOptionsMenuManager extends OptionsMenuManager
{



public AdminOptionsMenuManager()
{
    optionsMenu = new OptionsMenu();
}
    public void StartOptionsMenu()
    {
        List<String> myListOfOptions= new ArrayList<String>();
        myListOfOptions.add("Q - Quit");
        myListOfOptions.add("1 - ListOfBooks");
        myListOfOptions.add("2 - ListAllMovies");
        myListOfOptions.add("3 - ListAllCheckedOutBooks");
        myListOfOptions.add("4 - ListAllCheckedOutMovies");

        optionsMenu.SetListOfOptions(myListOfOptions);
    }
    public  String MainMenuValidatorOptions(String userInput)
    {
        String toReturn;
        switch(userInput)
        {
            case "q":  toReturn="q"; break;
            case "Q":  toReturn="Q";break;
            case "1":
                toReturn="DisplayBookList";
                break;
            case "2":
                toReturn = "DisplayMovieList";
                break;
            case "3":
                toReturn = "ListAllCheckedOutBooks";
                break;
            case "4":
                toReturn = "ListAllCheckedOutMovies";
                break;
            default:  toReturn="q";break;
        }
        return toReturn;


    }
}
