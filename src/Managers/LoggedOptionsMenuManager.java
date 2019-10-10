package Managers;

import Classes.OptionsMenu;

import java.util.ArrayList;
import java.util.List;

public class LoggedOptionsMenuManager extends OptionsMenuManager
{


    public LoggedOptionsMenuManager()
    {
        optionsMenu = new OptionsMenu();
    }

    public void StartOptionsMenu()
    {
        List<String> myListOfOptions= new ArrayList<String>();
        myListOfOptions.add("Q - Quit");
        myListOfOptions.add("1 - ListOfBooks");
        myListOfOptions.add("2 - CheckOutBooks");
        myListOfOptions.add("3 - ReturnBooks");
        myListOfOptions.add("4 - ListAllMovies");
        myListOfOptions.add("5 - CheckOutMovies");
        myListOfOptions.add("6 - ReturnMovies");
        myListOfOptions.add("7 - MyInfo");

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
                toReturn = "CheckOutBooks";
                break;
            case "3":
                toReturn = "ReturnBooks";
                break;
            case "4":
                toReturn = "DisplayMovieList";
                break;
            case "5":
                toReturn = "CheckOutMovies";
                break;
            case "6":
                toReturn = "ReturnMovies";
                break;
            case "7":
                toReturn = "MyInfo";
                break;
            default:  toReturn="q";break;
        }
        return toReturn;
        }



}
