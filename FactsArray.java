import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.*;
public class FactsArray
{
   public Facts[] knowledge = new Facts[200000];
   public String fileName;
   public int count = 0;
   public Facts current;
   FactsArray()
   {
   
   }
   
   public boolean setArray(String name) throws IOException
   {
      File f = new File(name); //import the file
      if (f.exists())
      {
         Scanner scanner = new Scanner(new File(name));
         Scanner lineS;
         String key = "";
         String phrase = "";
         double confidence = 0;
         while (scanner.hasNextLine() && count < 200000) {
         String line = scanner.nextLine();
         lineS = new Scanner(line).useDelimiter("\t");
         key = lineS.next();
         phrase = lineS.next();
         confidence = lineS.nextDouble();
         current = new Facts(key, phrase, confidence);
         knowledge[count] = current;
         count++;
         }
         return true;
      }
      else 
      {
         return false;
      }
   }
      
      public String search(String k)
      {
         int place = this.exists(k);
         if (place > 0)
         {
            return "Statement found: " + k + " " + knowledge[place].getInfo() + ". (Confidence score: " + knowledge[place].getConfidence() + ")";
         }
         return "";   
      }
      
      public String searchBySentence(String k,String s)
      {
         int place = this.exists(k);
         if (place > 0)
         {
            if((knowledge[place].getInfo()).compareTo(s) == 0)
            {
               return "The statement was found and has a confidence score of " + knowledge[place].getConfidence() + ".";
            }
         }
         return "";   
      }
      
      public int exists(String k)
      {
         boolean found = false;
         int check = 0;
         String key = "";
         Facts result = null;
         while (found == false && check < 200000 && knowledge[check] != null)
         {
            key = knowledge[check].getKey();
            if (key.equalsIgnoreCase(k))
            {
               found = true;
               return check;
            }
            check++;
         }
            return -1;
      }
      
      public boolean update(String k, String p, double c)
      {
         int place = this.exists(k);
         if (place > 0)
         {
            if(knowledge[place].getConfidence() < c)
            {
               knowledge[place].update(p,c);
               return true;
            }           
         }
         return false;
      }
      
      public String add(String k, String p, double c)
      {
         if(exists(k) == -1)
         {
            knowledge[count] = new Facts(k,p,c);
            count++;
            return "Statement added successfully";
         }
         else
         {
            if(update(k,p,c))
            {
               return "Statement updated successfully";
            }
            return "Statement could not be added";
         }
      }
}
