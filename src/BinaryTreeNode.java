//Ruth-ann Rudolph RDLRUT001
//02/03/2024
//CSC2001F Assignment 1

/** Code adapted from Hussein's Binary Tree node
* simple node implementation for facts objects*/
public class BinaryTreeNode<Facts>
{
   Facts data;
   BinaryTreeNode<Facts> left;
   BinaryTreeNode<Facts> right;
 
   public BinaryTreeNode ( Facts d, BinaryTreeNode<Facts> l, 
   BinaryTreeNode<Facts> r )
   {
      data = d;
      left = l;
      right = r;
   }
 
   BinaryTreeNode<Facts> getLeft () { return left; }
   BinaryTreeNode<Facts> getRight () { return right; }
 
}
