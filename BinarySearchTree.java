
public class BinarySearchTree 
{
	private Node root1;
	   private Node root2;
	   private Node root3;

	   public void setup()
	   {
	      //     50
	      //    /  \
	      //  80    60
	      //  /\    /
	      // 20 35 55

	      // create above tree (not a search tree)
	      Node leaf1 = new Node(20, null, null);
	      Node leaf2 = new Node(35, null, null);
	      Node leaf3 = new Node(55, null, null);

	      Node p1 = new Node(80, leaf1, leaf2);
	      Node p2 = new Node(60, leaf3, null);

	      root1 = new Node(50, p1, p2);
	      
	      //     50
	      //    /  \
	      //  80    60
	      //  /\    /
	      // 20 35 55

	      // identical tree
	      Node leaf01 = new Node(20, null, null);
	      Node leaf02 = new Node(35, null, null);
	      Node leaf03 = new Node(55, null, null);

	      Node p01 = new Node(80, leaf01, leaf02);
	      Node p02 = new Node(60, leaf03, null);

	      root2 = new Node(50, p01, p02);
	      
	      //     50
	      //    /  \
	      //  80    60
	      //  /\    /
	      // 20 35 55

	      // identical tree
	      Node leaf001 = new Node(55, null, null);
	      Node leaf002 = new Node(35, null, null);
	      Node leaf003 = new Node(20, null, null);

	      Node p001 = new Node(60, null, leaf001);
	      Node p002 = new Node(80, leaf002, leaf003);

	      root3 = new Node(50, p001, p002);
	   }

	   public int nodeCount()
	   {
	      return nodeCount(root1);
	   }
	   
	   public boolean isFull()
	   {		
		  return isFull(root1);
	   }	
	   
	   public boolean compareStructure()
	   {
		  return compareStructure(root1, root2);	   
	   }
	   
	   public boolean equals()
	   {
		  return equals(root1, root2);	   
	   }
	   
	   public Node copy()
	   {
		   return copy(root1);
	   }
	   
	   public Node mirror()
	   {
		   return mirror(root1);
	   }
	   
	   public void inOrder()
	   {
	       inOrder(root1);
	   }
	   
	   public boolean isMirror()
	   {
		   return isMirror(root1, root3);
	   }
	   
	   public Node rotateRight()
	   {
		   return rotateRight(root1);
	   }
	   
	   public Node rotateLeft()
	   {
		   return rotateLeft(root1);
	   }

	   private int nodeCount(Node t)
	   {
	      if (t == null)
	         return 0;
	      else
	      {
	         return 1 + nodeCount(t.left) + nodeCount(t.right); 
	      }
	   }   
	 
	   private boolean isFull(Node t)	
	   {
		  if (t == null)
		     return true;
		  else if((t.left != null && t.right != null) || (t.left == null && t.right == null))
		  {
		   	 return true && isFull(t.left) && isFull(t.right);      
		  }
		  return false;		
	   }
	   
	   private boolean compareStructure(Node t1, Node t2) 
	   {       
	       if (t1 == null && t2 == null)
	           return true;                   
	       else if (t1 != null && t2 != null)
	       {
	           return true && compareStructure(t1.left, t2.left) && compareStructure(t1.right, t2.right);
	       }
	       return false;
	   }
	   
	   private boolean equals(Node t1, Node t2) 
	   {       
	       if (t1 == null && t2 == null)
	           return true;                   
	       else if ((t1 != null && t2 != null) && (t1.data == t2.data))
	       {
	           return true && equals(t1.left, t2.left) && equals(t1.right, t2.right);
	       }
	       return false;
	   }
	   
	   private Node copy(Node t)
	   {
	       if (t == null)
	           return t;

	       Node left = copy(t.left);
	       Node right = copy(t.right);

	       t.left = left;
	       t.right = right;

	       return t;
	   } 
	   
	   private Node mirror(Node t)
	   {
	       if (t == null)
	           return t;

	       Node left = mirror(t.left);
	       Node right = mirror(t.right);

	       t.left = right;
	       t.right = left;

	       return t;
	   }   
	   
	   private boolean isMirror(Node t1, Node t2)
	   {
		   if (t1 == null && t2 == null)
	           return true;                   
	       else if (t1.left == t2.right && t1.right == t2.left)
	       {
	           return true && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	       }
	       return false;
	   }
	   
	   private void inOrder(Node t)
	   {
	       if (t == null)
	           return;

	       inOrder(t.left);
	       System.out.print(t.data + " ");
	       inOrder(t.right);
	   }
	   
	   private Node rotateRight(Node t)
	   {
	       if (t == null)
	           return t;
	       
	       Node temp;
	       temp = t.left;
	       t.left = temp.right;
	       temp.right = t;
	       return t;
	   }   
	   
	   private Node rotateLeft(Node t)
	   {
	       if (t == null)
	           return t;
	       
	       Node temp;
	       temp = t.right;
	       t.right = temp.left;
	       temp.left = t;
	       return t;
	   } 
	   
	   public void printLevels()
	   {
	       int h = height(root1);
	       for (int l=1; l<=h; l++)
	       {
	    	   System.out.print("Level ");
	    	   System.out.print(l-1 + ": ");
	    	   printSpecificLevel(root1, l);
	           System.out.println();
	       }
	   }
	   
	   public int height(Node t)
	   {
	       if (t == null)
	          return 0;
	       else
	       {
	           int h_left = height(t.left);
	           int h_right = height(t.right);
	            
	           if (h_left > h_right)
	               return(h_left+1);
	           else 
	        	   return(h_right+1); 
	       }
	   }
	   // used for printLevels
	   void printSpecificLevel (Node t ,int level)
	   {
	       if (t == null)
	           return;
	       if (level == 1)
	           System.out.print(t.data + " ");
	       else if (level > 1)
	       {
	    	   printSpecificLevel(t.left, level-1);
	    	   printSpecificLevel(t.right, level-1);
	       }
	   }

	   private static class Node
	   {
	      int data;
	      Node left;
	      Node right;

	      Node(int d, Node lt, Node rt)
	      {
	         data = d;
	         left = lt;
	         right = rt;
	      }
	   }
 
public static void main(String args[])
	   {
		   BinarySearchTree tree = new BinarySearchTree();

		      tree.setup();
		      
		      System.out.println("nodeCount");
		      System.out.println("-------------------------------------------");
		      int treenodeCount = tree.nodeCount();    
		      System.out.println("The number of nodes is: " + treenodeCount);
		      System.out.println();
		      
		      System.out.println("isFull");
		      System.out.println("-------------------------------------------");
		      if(tree.isFull())
				System.out.println("Tree is full");
			  else
				System.out.println("Tree is not full");
		      System.out.println();
		      
		      System.out.println("compareStructure");
		      System.out.println("-------------------------------------------");
		      if (tree.compareStructure(tree.root1, tree.root2))
		        System.out.println("Both trees have the same structure");
		      else
		        System.out.println("The trees do not have the same structure");
		      System.out.println();
		      
		      System.out.println("equals");
		      System.out.println("-------------------------------------------");
		      if (tree.equals(tree.root1, tree.root2))
		        System.out.println("Both trees are the same");
		      else
		        System.out.println("The trees are not the same"); 
		      System.out.println();
		      
		      System.out.println("printLevels");
		      System.out.println("-------------------------------------------");
		      System.out.println("Level-by-level printing of tree ");
			  tree.printLevels();
			  System.out.println();
			  
			  System.out.println("ORIGINAL TREE");
		      System.out.println("-------------------------------------------");
			  System.out.println("Inorder traversal of original tree is :");
			  tree.inOrder();
			  System.out.println("");
			  System.out.println();
			
			  System.out.println("copy");
		      System.out.println("-------------------------------------------");
			  tree.copy();
			  System.out.println("Inorder traversal of copy of original tree is :");
			  tree.inOrder();
			  System.out.println("");
			  System.out.println();
			
			  System.out.println("mirror");
		      System.out.println("-------------------------------------------");
			  tree.mirror();
			  System.out.println("Inorder traversal of mirror of original tree is : ");
			  tree.inOrder();
			  System.out.println("");
			  System.out.println();
			
			  System.out.println("rotateRight");
		      System.out.println("-------------------------------------------");
			  tree.rotateRight();
			  System.out.println("Inorder traversal of right-rotation of original tree is : ");
			  tree.inOrder();
			  System.out.println("");
			  System.out.println();
				
			  System.out.println("rotateLeft");
		      System.out.println("-------------------------------------------");
			  tree.rotateLeft();
	     	  System.out.println("Inorder traversal of left-rotation of original tree is : ");
			  tree.inOrder();
			  System.out.println("");
			  System.out.println();
				
			  System.out.println("isMirror");
		      System.out.println("-------------------------------------------");
				if (tree.isMirror(tree.root1, tree.root3))
			        System.out.println("Tree 3 is a mirror of Tree 1");
			    else
			        System.out.println("Tree 3 is a mirror of Tree 1");
				System.out.println();
	   }  
}