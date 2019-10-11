package com.twu.biblioteca;


import Managers.AdminOptionsMenuManager;
import Managers.LoggedOptionsMenuManager;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoggedOptionsMenuManagerTest {

    @Test
    public void LoggedOptionsMenuManager()
    {
        LoggedOptionsMenuManager loggedOptionsMenuManager = new LoggedOptionsMenuManager();

        loggedOptionsMenuManager.StartOptionsMenu();

        List<String> listOfOptions = loggedOptionsMenuManager.GetOptionsMenu().GetListOfOptions();
        assertEquals("Q - Quit",listOfOptions.get(0));
        assertEquals("1 - ListOfBooks",listOfOptions.get(1));
        assertEquals("2 - CheckOutBooks",listOfOptions.get(2));
        assertEquals("3 - ReturnBooks",listOfOptions.get(3));
        assertEquals("4 - ListAllMovies",listOfOptions.get(4));
        assertEquals("5 - CheckOutMovies",listOfOptions.get(5));
        assertEquals("6 - ReturnMovies",listOfOptions.get(6));
        assertEquals("7 - MyInfo",listOfOptions.get(7));

      //  assertEquals(outSpy, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void TestMainMenuValidatorOptions()
    {
        LoggedOptionsMenuManager loggedOptionsMenuManager = new LoggedOptionsMenuManager();

        loggedOptionsMenuManager.StartOptionsMenu();
        String resultq = loggedOptionsMenuManager.MainMenuValidatorOptions("q");
        String resultQ = loggedOptionsMenuManager.MainMenuValidatorOptions("Q");
        String result1 = loggedOptionsMenuManager.MainMenuValidatorOptions("1");
        String result2 = loggedOptionsMenuManager.MainMenuValidatorOptions("2");
        String result3 = loggedOptionsMenuManager.MainMenuValidatorOptions("3");
        String result4 = loggedOptionsMenuManager.MainMenuValidatorOptions("4");
        String result5 = loggedOptionsMenuManager.MainMenuValidatorOptions("5");
        String result6 = loggedOptionsMenuManager.MainMenuValidatorOptions("6");
        String result7 = loggedOptionsMenuManager.MainMenuValidatorOptions("7");




        assertEquals("q",resultq);
        assertEquals("Q",resultQ);
        assertEquals("DisplayBookList",result1);
        assertEquals("CheckOutBooks",result2);
        assertEquals("ReturnBooks",result3);
        assertEquals("DisplayMovieList",result4);
        assertEquals("CheckOutMovies",result5);
        assertEquals("ReturnMovies",result6);
        assertEquals("MyInfo",result7);

        //  assertEquals(outSpy, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
