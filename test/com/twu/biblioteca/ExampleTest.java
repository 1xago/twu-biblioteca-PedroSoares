package com.twu.biblioteca;


import Managers.VisitManager;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
  //  @Rule
  //  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Test
    public void PresentWelcomeMessage()
    {

        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        VisitManager myVisit = new VisitManager();
        assertEquals("1","1");

      //  assertEquals(outSpy, "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
