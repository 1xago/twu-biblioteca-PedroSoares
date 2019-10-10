package Classes;

import javax.jws.soap.SOAPBinding;

public class User
{
    public double UserId;
    public boolean IsAdmin;
    public String LibraryNumber;
    public String Password;
    public String Name;
    public String PhoneNumber;
    public String Email;
public  User()
{
    UserId=0;
    this.IsAdmin = false;
    this.LibraryNumber ="";
    this.Password = "";
    this.Name="";
    this.PhoneNumber = "";
    this.Email="";
}
    public User(boolean IsAdmin,String LibraryNumber,String Password, String Name, String PhoneNumber, String Email,Double UserId)
    {
        this.UserId= UserId;
        this.IsAdmin = IsAdmin;
        this.LibraryNumber =LibraryNumber;
        this.Password = Password;
this.Name=Name;
this.PhoneNumber = PhoneNumber;
this.Email=Email;
    }


}
