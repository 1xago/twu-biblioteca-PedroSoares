package Managers;

import Classes.Book;
import Classes.OptionsMenu;
import Classes.User;

import java.util.ArrayList;
import java.util.List;

public class OptionsMenuManager
{

    private AdminOptionsMenuManager adminOptionsMenuManager ;
   private LoggedOptionsMenuManager loggedOptionsMenuManager ;
   private NonLoggedOptionsMenuManager nonLoggedOptionsMenuManager ;

    public OptionsMenu optionsMenu;


    public OptionsMenu GetOptionsMenu()
    {
        return optionsMenu;
    }
   OptionsMenuManager userManager = nonLoggedOptionsMenuManager;


    private String currentMenu;
    UserManager myUserManager;
/*
    public OptionsMenu GetOptionsMenu()
    {
        return new OptionsMenu();
    }
*/
public void SetCurrentMenu(String currentMenu)
{
    this.currentMenu=currentMenu;
}
public String GetCurrentMenu()
{
    return currentMenu;
}
public OptionsMenuManager(AdminOptionsMenuManager adminOptionsMenuManager,
                          LoggedOptionsMenuManager loggedOptionsMenuManager,
                          NonLoggedOptionsMenuManager nonLoggedOptionsMenuManager)
{
    this.adminOptionsMenuManager= new AdminOptionsMenuManager();
    this.loggedOptionsMenuManager= new LoggedOptionsMenuManager();
    this.nonLoggedOptionsMenuManager=new NonLoggedOptionsMenuManager();
    myUserManager = new UserManager();
}


  public OptionsMenuManager()
  {
      currentMenu = "LoginMenu";

      userManager = nonLoggedOptionsMenuManager;


  }


   public String MainMenuValidatorOptions(String userInput)
   {
       return "";
   }
public User StartLoginMenu(LibraryManager myLibraryManager)
{

    System.out.println("Insert user:");
    String user =myUserManager.AskUserID();
    System.out.println("Insert password:");
    String password = myUserManager.AskUserPassword();
    if(user.equals("Q")||user.equals("q")||password.equals("Q")||password.equals("q"))
    {
        userManager = nonLoggedOptionsMenuManager;
        currentMenu = "StartMenu";
        userManager.StartOptionsMenu();
        currentMenu = "StartMenu";
        return new User();
    }
    if(myLibraryManager.IsUserAndPasswordCorrect(user,password))
    {
        
        if(myLibraryManager.IsUserAdmin(user))
        {
            userManager=adminOptionsMenuManager;
            userManager.currentMenu ="StartMenu";
            userManager.StartOptionsMenu();
        }
       else
        {
            userManager=loggedOptionsMenuManager;
            userManager.currentMenu = "StartMenu";
            userManager.StartOptionsMenu();
        }
        return myLibraryManager.GetUser(user);
    }
    else
    {
        System.out.println("Wrong username or Password, press Q to skipp Loggin");

        StartLoginMenu( myLibraryManager);
        return new User();
    }
}

    public void StartOptionsMenu()
    {

    }



    public void DisplayListOfOptions(String ReceivedOption)
    {

        if(ReceivedOption.equals("StartMenu"))
        {
            List<String> myListOfOptions= userManager.GetOptionsMenu().GetListOfOptions();
            // List<String> myListOfOptions= optionsMenu.GetListOfOptions();
            for(String option : myListOfOptions)
            {
                System.out.println(option + ";");
            }
        }
        if(ReceivedOption.equals("BookCheckout"))
        {
            System.out.println("Write the Id of the book you wish to Checkout");
        }
        if(ReceivedOption .equals("BookReturn"))
        {
            System.out.println("Write the Id of the book you wish to Return");
        }
        if(ReceivedOption.equals("MovieCheckout"))
        {
            System.out.println("Write the Id of the Movie you wish to Checkout");
        }


    }

    public void DisplayListOfOptions()
    {

        if(currentMenu.equals( "StartMenu"))
        {
            List<String> myListOfOptions=optionsMenu.GetListOfOptions();
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
        if(currentMenu.equals( "MovieCheckout"))
        {
            System.out.println("Write the Id of the Movie you wish to Checkout");
        }


    }
}
