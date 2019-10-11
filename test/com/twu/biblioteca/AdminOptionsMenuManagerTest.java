package com.twu.biblioteca;


import Managers.AdminOptionsMenuManager;
import Managers.VisitManager;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminOptionsMenuManagerTest {

    @Test
    public void TestStartOptionsMenu()
    {
        AdminOptionsMenuManager adminOptionsMenuManager = new AdminOptionsMenuManager();

        adminOptionsMenuManager.StartOptionsMenu();

        List<String> listOfOptions = adminOptionsMenuManager.GetOptionsMenu().GetListOfOptions();
        assertEquals("Q - Quit",listOfOptions.get(0));
        assertEquals("1 - ListOfBooks",listOfOptions.get(1));
        assertEquals("2 - ListAllMovies",listOfOptions.get(2));
        assertEquals("3 - ListAllCheckedOutBooks",listOfOptions.get(3));
        assertEquals("4 - ListAllCheckedOutMovies",listOfOptions.get(4));

      //  assertEquals(outSpy, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void TestMainMenuValidatorOptions()
    {
        AdminOptionsMenuManager adminOptionsMenuManager = new AdminOptionsMenuManager();

        adminOptionsMenuManager.StartOptionsMenu();
        String resultq = adminOptionsMenuManager.MainMenuValidatorOptions("q");
        String resultQ = adminOptionsMenuManager.MainMenuValidatorOptions("Q");
        String result1 = adminOptionsMenuManager.MainMenuValidatorOptions("1");
        String result2 = adminOptionsMenuManager.MainMenuValidatorOptions("2");
        String result3 = adminOptionsMenuManager.MainMenuValidatorOptions("3");
        String result4 = adminOptionsMenuManager.MainMenuValidatorOptions("4");




        assertEquals("q",resultq);
        assertEquals("Q",resultQ);
        assertEquals("DisplayBookList",result1);
        assertEquals("DisplayMovieList",result2);
        assertEquals("ListAllCheckedOutBooks",result3);
        assertEquals("ListAllCheckedOutMovies",result4);

        //  assertEquals(outSpy, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
