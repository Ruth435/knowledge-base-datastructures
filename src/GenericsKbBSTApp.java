//Ruth-ann Rudolph RDLRUT001
//02/03/2024
//CSC2001F Assignment 1

import javax.swing.*; //import the input/output displays
import java.io.File;  // Import the File class
import java.io.IOException;

/**
* Class to implement the UI of the Facts BST
*/
public class GenericsKbBSTApp
{
      public static void main(String[]args) throws IOException
   {
      FactsBST knowledgeBase = new FactsBST();
      String input = JOptionPane.showInputDialog("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice:");
      int choice = Integer.parseInt(input);
      while(choice != 5) //while the user has not enetered 5 (option to exit the program)
      {
         if (choice == 1) //use chooses to load a knowledge base from a file
         {
            input = JOptionPane.showInputDialog("Enter file name: ");
            boolean loaded = knowledgeBase.setBST(input);
            if(loaded)
            {
               JOptionPane.showMessageDialog(null, "Loaded successfully");
            }
            else
            {
               JOptionPane.showMessageDialog(null, "unable to load knowledge base");
            }
         }
         else if (choice == 2) //user chooses to add a new statement to the knowledge base
         {
            String key = JOptionPane.showInputDialog("Enter the term: ");
            String phrase = JOptionPane.showInputDialog("Enter the statement: ");
            double confidence = Double.parseDouble(JOptionPane.showInputDialog("Enter the confidence score: "));
            String added = knowledgeBase.insert(key,phrase,confidence);
            JOptionPane.showMessageDialog(null, added); //output the statent returned from the added method, to indicate the result of adding or updateing the statement
         }
         else if (choice == 3) //user chooses to Search for an item in the knowledge base by term
         {
            input = JOptionPane.showInputDialog("Enter the term to search:");
            String statement = knowledgeBase.search(input);
            if (statement != null) //checks if the statemtnt was found by ensuring the returned string was not blank
            {
               JOptionPane.showMessageDialog(null, statement );//prints out the statement if it is found
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Statement not found");
            }
         }
         else if (choice == 4) //user chooses to Search for an item in the knowledge base by term and sentence
         {
            input = JOptionPane.showInputDialog("Enter the term to search:");
            String sentence = JOptionPane.showInputDialog("Enter the statement to search for:");
            String statement = knowledgeBase.searchBySentence(input, sentence);
            if (statement != null) //checks if the statemtnt was found by ensuring the returned string was not blank
            {
               JOptionPane.showMessageDialog(null, statement );//prints out the confidence score of the statement that was found
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Statement not found");
            }
         }
         else //if the option is not a valid number (1 to 5)
         {
            JOptionPane.showMessageDialog(null, "Invalid input");
         }
         input = JOptionPane.showInputDialog("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice:");
         choice = Integer.parseInt(input);
      }
      JOptionPane.showMessageDialog(null,"Goodbye!");
   }
}