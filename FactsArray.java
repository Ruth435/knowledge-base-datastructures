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

}