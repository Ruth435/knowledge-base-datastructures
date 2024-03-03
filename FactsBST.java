//Ruth-ann Rudolph RDLRUT001
//02/03/2024
//CSC2001F Assignment 1

import java.io.File;  // Imports
import java.io.IOException;
import java.util.*;

/** Code adapted from Hussein's Binary Tree
* Binary tree implementation for Facts objects*/
public class FactsBST
{
   BinaryTreeNode<Facts> root;
   Facts constant = new Facts();
 
 /**no element constructor sets the root node to null*/
   public FactsBST ()
   {
      root = null;
   }

/**takes in the text file and adds each element to the binary tree, returns a boolean to indicate success or failure*/   
   public boolean setBST(String name) throws IOException
   {
      File f = new File(name); //import the file
      if (f.exists())//ensures that the file exists
      {
         Scanner scanner = new Scanner(new File(name));
         Scanner lineS;
         String key = "";
         String phrase = "";
         double confidence = 0;
         while (scanner.hasNextLine()) { //loops through the file until the end of the file
         String line = scanner.nextLine();
         lineS = new Scanner(line).useDelimiter("\t");
         key = lineS.next();
         phrase = lineS.next();
         confidence = lineS.nextDouble();
         insert (key, phrase, confidence);
         }
         return true;
      }
      else 
      {
         return false;
      }
   }
   
/**returns the height of the tree, from the root*/   
   public int getHeight ()
   {
      return getHeight (root);
   } 

/**returns the height of the tree, from the given node*/   
   public int getHeight ( BinaryTreeNode<Facts> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }

/**rerurns the size of the tree from the root*/   
   public int getSize ()
   {
      return getSize (root);
   } 
   
/**Returns the size of the tree from the given node*/   
   public int getSize ( BinaryTreeNode<Facts> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
/**prints out the data of the current node*/   
   public void visit ( BinaryTreeNode<Facts> node )
   {
      System.out.println (node.data);
   }

/**finds the given fact in the tree and returns the data associated, from the root*/   
   public BinaryTreeNode<Facts> find ( Facts d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
    }
    
/**finds the given fact in the tree and returns the data associated, from the given node*/      
   public BinaryTreeNode<Facts> find ( Facts d, BinaryTreeNode<Facts> node )
   {
      int cmp = d.compareTo(node.data); 
      if (cmp == 0) 
         return node;
      else if (cmp < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
 
/**inserts a new fact given the key, phrase and confidence score, returns a string indicating success or failure, or updating the fact if the key already exists in the tree*/   
   public String insert (String k, String p, double c )
   {
      Facts current = new Facts(k,p,c);
      BinaryTreeNode<Facts> existing = find(current);
      if(existing == null)
      {
         if (root == null)
         {
            root = new BinaryTreeNode<Facts> (current, null, null);
            return "Statement added successfully";
         }  
         else
         {
            insert (current, root);
            return "Statement added successfully";
         }   
      }
      else
      {
         if (c >= existing.data.getConfidence())
         {
            update(existing.data, p, c);
            return "Statement updated successfully";
         }
        return "Statement could not be updated or added"; 
      }      
   }

/**updates the node d witht the new details phrase and confidence*/     
   public void update(Facts d, String p, double c)
   {
      find(d).data.update(p,c);
   }

/**searches for a node with a matching key, from the root*/
   public String search(String k)
   {
      if (root == null)
      {
         return null;
      }   
      else
      {
         return search (k, root);
      }   
    }

/**searches for a node with a matching key, from the node given*/    
   public String search (String k, BinaryTreeNode<Facts> node )
   {
      int cmp = (node.data.getKey()).compareTo(k);
      System.out.println(node.data.getKey() + cmp + k );
      if (cmp == 0) 
      {
         return "Statement found: " + k + " " + node.data.getInfo() + ". (Confidence score: " + node.data.getConfidence() + ")";
      }   
      else if (cmp < 0)
         return (node.left == null) ? null : search(k, node.left);
      else
         return (node.right == null) ? null : search(k, node.right);             
   }
   
/**searches for a node with a matching key, and phrase from the key*/   
   public String searchBySentence(String k, String p)
   {
      if (root == null)
         return null;
      else
         return searchBySentence (k, p, root);
   }
  
/**searches for a node with a matching key,and phrase from the given node*/   
   public String searchBySentence(String k, String p, BinaryTreeNode<Facts> node )
   {
      int cmp = (node.data.getKey()).compareTo(k); 
      if (cmp == 0)
      {
         if(p.equalsIgnoreCase(node.data.getInfo()))
         {
            return "Statement found: " + k + " " + node.data.getInfo() + ". (Confidence score: " + node.data.getConfidence() + ")";
         }
         return null;
      }
      else if (cmp < 0)
         return (node.left == null) ? null : searchBySentence(k,p, node.left);
      else
         return (node.right == null) ? null : searchBySentence(k,p, node.right);          
   }

}