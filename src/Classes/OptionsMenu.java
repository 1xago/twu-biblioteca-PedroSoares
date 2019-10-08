package Classes;

import java.util.ArrayList;
import java.util.List;

public class OptionsMenu
{
   private List<String> listOfOptions;

   public void  SetListOfOptions ( List<String> listOfOptions)
   {
       this.listOfOptions = listOfOptions;
   }
   public List<String> GetListOfOptions ()
   {
       return listOfOptions;
   }

    public OptionsMenu()
    {
        listOfOptions = new ArrayList<String>();
    }


}
