package Classes;

import com.sun.istack.internal.Nullable;

public class Movie
{
    public String Name;
    public double YearPublished;
    public String Director;
    public int Rating;
    public Boolean IsRatingAvailable;
    public double MovieId;

    public Movie(String Name, double YearPublished, String Director, int Rating,double MovieId ,@Nullable Boolean IsRatingAvailableId)
    {
        this.Name =Name;
        this.YearPublished = YearPublished;
        this.Director =Director;
        this.Rating =Rating;
        this.IsRatingAvailable = false;
        this.MovieId=MovieId;
        if(IsRatingAvailableId!=null)
        {
            this.IsRatingAvailable=IsRatingAvailableId;
        }
        else
        {
            this.IsRatingAvailable=false;
        }
    }

}
