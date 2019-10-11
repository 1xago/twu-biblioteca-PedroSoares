package com.twu.biblioteca;


import Managers.AdminOptionsMenuManager;
import Managers.NonLoggedOptionsMenuManager;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NonLoggedOptionsMenuManagerTest {

    @Test
    public void TestStartOptionsMenu()
    {
        NonLoggedOptionsMenuManager nonLoggedOptionsMenuManager = new NonLoggedOptionsMenuManager();

        nonLoggedOptionsMenuManager.StartOptionsMenu();

        List<String> listOfOptions = nonLoggedOptionsMenuManager.GetOptionsMenu().GetListOfOptions();
        assertEquals("Q - Quit",listOfOptions.get(0));
        assertEquals("1 - ListOfBooks",listOfOptions.get(1));
        assertEquals("2 - ListAllMovies",listOfOptions.get(2));
        assertEquals("3 - Log",listOfOptions.get(3));
    }

    @Test
    public void TestMainMenuValidatorOptions()
    {
        NonLoggedOptionsMenuManager nonLoggedOptionsMenuManager = new NonLoggedOptionsMenuManager();

        nonLoggedOptionsMenuManager.StartOptionsMenu();
        String resultq = nonLoggedOptionsMenuManager.MainMenuValidatorOptions("q");
        String resultQ = nonLoggedOptionsMenuManager.MainMenuValidatorOptions("Q");
        String result1 = nonLoggedOptionsMenuManager.MainMenuValidatorOptions("1");
        String result2 = nonLoggedOptionsMenuManager.MainMenuValidatorOptions("2");
        String result3 = nonLoggedOptionsMenuManager.MainMenuValidatorOptions("3");





        assertEquals("q",resultq);
        assertEquals("Q",resultQ);
        assertEquals("DisplayBookList",result1);
        assertEquals("DisplayMovieList",result2);
        assertEquals("Log",result3);

    }
}
