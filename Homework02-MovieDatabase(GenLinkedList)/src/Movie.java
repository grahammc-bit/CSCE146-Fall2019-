//Written by Matthew Graham
public class Movie{
   private String name;
   private int year;
   private int rating;
   private String director;
   private double gross;
   public Movie()
   {
       name = "no";
       year = 0;
       rating = 0;
       director = "no";
       gross = 0.0;
   }
   public Movie(String aName, int aYear, int aRating, String aDirector, double aGross)
   {
       name = aName;      
       year = aYear;
      
       if(aRating >= 1 && aRating <= 5)
           rating = aRating;
       else
           rating = 1;
      
       director = aDirector;      
       gross = aGross;
   }
   public boolean equals(Movie other)
   {
       if(name.equals(other.name) && year == other.year && rating == other.rating && director.equals(other.director)
               && gross == other.gross)
       {
           return true;
       }
       else
       {
           return false;
       }
   } 
   public int compareTo(Movie other)
   {
       if(other.name.equals("no") && other.year == 0 && other.rating == 0 && other.director.equals("no") && other.gross == 0)
       {
           return 0;
       }
       else
       {
           return 1;
       }
   } 
   public String toString()
   {
       return "Title: " + name + ", Year: " + year + ", Rating: " + rating + ", Director: " + director + ", Box Office Gross: " + gross;
   } 
   public String getName()
   {
       return name;
   }
   public int getYear()
   {
       return year;
   }
   public int getRating()
   {
       return rating;
   }
   public String getDirector()
   {
       return director;
   }
   public double getGross()
   {
       return gross;
   }

}