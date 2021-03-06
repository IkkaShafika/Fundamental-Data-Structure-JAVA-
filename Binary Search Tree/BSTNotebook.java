
/**
 * Write a description of class BSTNotebook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSTNotebook
{
    TreeNode root;
    
    public BSTNotebook()
    {
        root = null;
    }
    
    //insert a new node in the binary search tree
    //if the root node is null, create the root node here
    //otherwise, call the insert method of class TreeNode
    public void insertNode(Notebook d)
    {
        if (root==null)
            root = new TreeNode(d);
        
        else 
            root.insert(d);
    }
    
    //inorder traversal
    public void inorderTraversal() 
    {
        inorder(root);
    }
    
    //left-node-right
    private void inorder(TreeNode node) 
    {
        if (node==null)
            return;
        
        inorder(node.left);
        System.out.print(node.data.getPrice() + " ");
        inorder(node.right);
    }
    
    // Preorder Traversal
    public void preorderTraversal()
      { preorder( root ); }
      
    // node-left-right
    private void preorder( TreeNode node )
    {
      if ( node == null )
         return;

      System.out.print( node.data.getPrice() + " " );
      preorder( node.left );
      preorder( node.right );
    } 
    
    // PostOrder Traversal
    public void postorderTraversal()
      { postorder( root ); }
   
    // left-right-node
    private void postorder( TreeNode node )
    {
       if ( node == null )
         return;
         
       postorder(node.left);
       postorder(node.right);
       System.out.print( node.data.getPrice() + " " );
    }
    
    public void displayAll()
    {
       display(root);
    }  
    
    //Ex2
    public void display(TreeNode node)
    {
        if (node == null)
            return;
        
        display (node.left);
        System.out.println(node.data.toString());
        display(node.right);
    }
    
    //Ex3
    public int countN()
    { return countNHP (root); }
    
    //Ex3
    private int countNHP(TreeNode node)
    {
        if (node==null)
            return 0;
        
        if (node.data.getBrand().equalsIgnoreCase("HP") && node.data.getPrice() > 5000)
            return 1 + countNHP(node.left) + countNHP(node.right);
        
        else 
            return 0 + countNHP(node.left) + countNHP(node.right);
    }
    
    //Ex4
    //totalpricetype(string)
    //calculate the total price of notebooks based on the brand of notebooks.               
    public double totalPricetype(String brand)
    { return totalPrice(root, brand); }
    
    //Ex4
    private double totalPrice(TreeNode node, String brand)
    {
        
        if (node==null)
            return 0;
        
        if (node.data.getBrand().equalsIgnoreCase(brand))
            return node.data.getPrice() + totalPrice(node.left, brand) + totalPrice(node.right, brand);
        
        else
            return totalPrice(node.left, brand) + totalPrice(node.right, brand);
    }
    
    //Ex5
    public double maxPrice()
    {  return maxPriceNb(root); }
    
    //Ex5
    private double maxPriceNb (TreeNode node)
    {
        if (node==null)
        return 0;
        
        double n = node.data.getPrice();
        double l = maxPriceNb(node.left);
        double r = maxPriceNb(node.right);
        if (l>n)
            n = l;
        
        if (r>n)
            n=r;
        
        return n;
    }
    
    public String disMaxPrice()
    { return disMaxPriceNb (root); }
    
    public String disMaxPriceNb (TreeNode node)
    {
        if (node==null)
            return " ";
        
        if (node.data.getPrice() == maxPrice())
            return node.data.toString();
        
        else
            return "none";
    }
}
