import javax.swing.*; //import the input/output displays
import java.io.File;  // Import the File class
import java.io.IOException;
public class GenericsKbArrayApp
{
   public static void main(String[]args) throws IOException
   {
      FactsArray knowledgeBase = new FactsArray();
      String input = JOptionPane.showInputDialog("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice:");
      int choice = Integer.parseInt(input);
      while(choice != 5)
      {
         if (choice == 1)
         {
            input = JOptionPane.showInputDialog("Enter file name: ");
            boolean loaded = knowledgeBase.setArray(input);
            if(loaded)
            {
               JOptionPane.showMessageDialog(null, "Loaded successfully");
            }
            else
            {
               JOptionPane.showMessageDialog(null, "unable to load knowledge base");
            }
         }
         else if (choice == 2)
         {
            String key = JOptionPane.showInputDialog("Enter the term: ");
            String phrase = JOptionPane.showInputDialog("Enter the statement: ");
            double confidence = Double.parseDouble(JOptionPane.showInputDialog("Enter the confidence score: "));
            String added = knowledgeBase.add(key,phrase,confidence);
            JOptionPane.showMessageDialog(null, added);
         }
         else if (choice == 3)
         {
            input = JOptionPane.showInputDialog("Enter the term to search:");
            String statement = knowledgeBase.search(input);
            if (statement.compareTo("") != 0)
            {
               JOptionPane.showMessageDialog(null, statement );
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Term not found");
            }
         }
         else if (choice == 4)
         {
            input = JOptionPane.showInputDialog("Enter the term to search:");
            String sentence = JOptionPane.showInputDialog("Enter the statement to search for:");
            String statement = knowledgeBase.searchBySentence(input, sentence);
            if (statement.compareTo("") != 0)
            {
               JOptionPane.showMessageDialog(null, statement );
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Term not found");
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Invalid input");
         }
         input = JOptionPane.showInputDialog("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledge base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice:");
         choice = Integer.parseInt(input);
      }
   }
}