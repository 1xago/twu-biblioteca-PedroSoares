package com.twu.biblioteca;


import Classes.User;
import Managers.AdminOptionsMenuManager;
import Managers.LibraryManager;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryManagerTest {

    @Test
    public void TestFillDefaultUserList()
    {
        LibraryManager libraryManager = new LibraryManager();

        libraryManager.FillDefaultUserList();

        List<User> listOfOptions = libraryManager.GetMyLibrary().GetUserList();

        assertEquals("aaa-aaa",listOfOptions.get(0).LibraryNumber);
        assertEquals("librarian@me",listOfOptions.get(0).Email);
        assertEquals("librarian",listOfOptions.get(0).Name);
        assertEquals("aaa",listOfOptions.get(0).Password);
        assertEquals("123456",listOfOptions.get(0).PhoneNumber);
        assertEquals(true,listOfOptions.get(0).IsAdmin);


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
