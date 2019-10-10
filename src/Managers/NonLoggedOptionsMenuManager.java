package Managers;

import Classes.OptionsMenu;

import java.util.ArrayList;
import java.util.List;

public class NonLoggedOptionsMenuManager extends OptionsMenuManager
{
    public NonLoggedOptionsMenuManager()
    {
        optionsMenu = new OptionsMenu();
    }
    public void StartOptionsMenu()
    {
        List<String> myListOfOptions= new ArrayList<String>();
        myListOfOptions.add("Q - Quit");
        myListOfOptions.add("1 - ListOfBooks");
        myListOfOptions.add("2 - ListAllMovies");
        myListOfOptions.add("3 - Log");
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
                toReturn = "Log";
                break;

            default:  toReturn="q";break;
        }
        return toReturn;


    }

}
