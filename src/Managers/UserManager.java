package Managers;

import Classes.Library;

import java.util.Scanner;

public class UserManager
{
    public String AskUserID()
    {
        System.out.println("Please Write your user id with -");
        return WaitForUserRepply();
    }

    private String WaitForUserRepply()
    {
        Scanner scanner = new Scanner(System.in);
        String userInput =   scanner.next();
        return userInput;
    }

    public String AskUserPassword()
    {
     System.out.println("Please Write your password");
        return WaitForUserRepply();
    }
}
