package Managers;

import Classes.Book;
import Classes.OptionsMenu;

import java.util.List;

public class OptionsMenuManager
{
   private OptionsMenu optionsMenu = new OptionsMenu();
    private String currentMenu= "StartMenu";

public void SetCurrentMenu(String currentMenu)
{
    this.currentMenu=currentMenu;
}
public String GetCurrentMenu()
{
    return currentMenu;
}



  public  OptionsMenuManager()
  {
      optionsMenu = new OptionsMenu();
      currentMenu = "StartMenu";
  }

  public void StartOptionsMenu()
  {
      List<String> myListOfOptions= optionsMenu.GetListOfOptions();
      myListOfOptions.add("Q - Quit");
      myListOfOptions.add("1 - ListOfBooks");
      myListOfOptions.add("2 - CheckOutBooks");
      myListOfOptions.add("3 - ReturnBooks");

  }


    public void DisplayListOfOptions()
    {
        if(currentMenu.equals( "StartMenu"))
        {
            List<String> myListOfOptions= optionsMenu.GetListOfOptions();
            for(String option : myListOfOptions)
            {
                System.out.println(option + ";");
            }
        }
        if(currentMenu.equals( "BookCheckout"))
        {
            System.out.println("Write the Id of the book you wish to Checkout");
        }
        if(currentMenu .equals( "BookReturn"))
        {
            System.out.println("Write the Id of the book you wish to Return");
        }
    }
}
