//Ruth-ann Rudolph RDLRUT001
//25/02/2024
//CSC2001F Assignment 1

import java.io.File;  // Imports
import java.io.IOException;
import java.util.*;

/**
* Class to mannage an array of Facts objects and provide functionality
* 
*/
public class FactsArray
{
   public Facts[] knowledge = new Facts[200000];
   public String fileName;
   public int count = 0;//keeps track of how many statements are in the array
   public Facts current;//holds a fact object
   
/**
* default constructor
* 
*/
   FactsArray()
   {
   
   }
   
/**
* Class takes in a file name and reads the file into the array and returns a boolean to indicate if the file was read in successfully
* 
*/
   public boolean setArray(String name) throws IOException
   {
      File f = new File(name); //import the file
      if (f.exists())//ensures that the file exists
      {
         Scanner scanner = new Scanner(new File(name));
         Scanner lineS;
         String key = "";
         String phrase = "";
         double confidence = 0;
         while (scanner.hasNextLine() && count < 200000) { //loops through the file until the end or until the array is full
         String line = scanner.nextLine();
         lineS = new Scanner(line).useDelimiter("\t");
         key = lineS.next();
         phrase = lineS.next();
         confidence = lineS.nextDouble();
         add(key, phrase, confidence); //adds the fact to the array
         }
         return true;
      }
      else 
      {
         return false;
      }
   }
   
/**
* Searches for a Fact in the array that has the same key as the one given and return it as a string
* 
*/      
      public String search(String k)
      {
         int place = this.exists(k);//checks if the key exists in the array and returns its possition
         if (place > 0)
         {
            return "Statement found: " + k + " " + knowledge[place].getInfo() + ". (Confidence score: " + knowledge[place].getConfidence() + ")";
         }
         return "";   
      }
      
/**
* Searches for a Fact in the array that has the same key and factual statement as the one given and return it as a string
* 
*/       
      public String searchBySentence(String k,String s)
      {
         int place = this.exists(k);//checks if the key exists in the array and returns its possition
         if (place > 0)
         {
            if((knowledge[place].getInfo()).equalsIgnoreCase(s))//checks if the statement in the array is the same as the one recived
            {
               return "The statement was found and has a confidence score of " + knowledge[place].getConfidence() + ".";
            }
         }
         return "";   
      }
      
/**
* Searches for a Fact in the array that has the same key as the one given and returns true or false based on if it is or is not found
* 
*/       
      public int exists(String k)
      {
         boolean found = false;
         int check = 0;
         String key = "";
         Facts result = null;
         while (found == false && check < 200000 && knowledge[check] != null)//searches the array until the boolean is true or the whole array has been checked or the next fact is null
         {
            key = knowledge[check].getKey(); 
            if (key.equalsIgnoreCase(k)) //compares the key to the current one in the array
            {
               found = true;
               return check;
            }
            check++;
         }
            return -1;
      }
      
/**
* Finds a fact that matches the key of the given one, and changes the fact and confidence score if the confidence 
* score is bigger than or equal to the previous one. returns a boolean to indicate if it was sucessfully updated
*/       
      public boolean update(String k, String p, double c)
      {
         int place = this.exists(k);
         if (place > 0)
         {
            if(knowledge[place].getConfidence() <= c)//ensures the new confidence score is bigger than or equal to the origanal
            {
               knowledge[place].update(p,c);//updates the fact
               return true;
            }           
         }
         return false;
      }
      
/**
* checks if the given fact is already in the array, calls the update method if it is already in the array
* or adds it to the array if it is not. Returns a string indicating if the statement was added, updated or neither.
*/ 
      public String add(String k, String p, double c)
      {
         if(exists(k) == -1) //if the key is not yet in the array
         {
            knowledge[count] = new Facts(k,p,c);//adds the fact
            count++;
            return "Statement added successfully";
         }
         else
         {
            if(update(k,p,c))//updates the fact
            {
               return "Statement updated successfully";
            }
            return "Statement could not be added";
         }
      }
}
