import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.*;
public class FactsArray
{
   public Facts[] knowledge = new Facts[6000];
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
         Scanner scanner = new Scanner(new File("filename"));
         Scanner lineS;
         String key = "";
         String phrase = "";
         double confidence = 0;
         while (scanner.hasNextLine()) {
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
      
      public int exists(String k)
      {
         boolean found = false;
         int check = 0;
         String key = "";
         Facts result = null;
         while (found == false && check < 6000 && knowledge[check] != null)
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
            knowledge[place].setInfo(p);
            knowledge[place].setConfidence(c);            
            return true;
         }
         return false;
      }
      
      public boolean add(String k, String p, double c)
      {
         if(exists(k) == -1)
         {
            knowledge[count] = new Facts(k,p,c);
            count++;
            return true;
         }
         return false;
      }
}
