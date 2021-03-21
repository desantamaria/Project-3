/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/18/21 
 */

/**
 * A class that tests the functionality of the Binary Tree methods.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class DriverBT {
    public static void main(String[] args) {
        System.out.println("1st Testing Example:");
        BinaryTree<String> aTree = new BinaryTree<>();
        createTree1(aTree);
        
        System.out.println("(binaryTree) post-order: ");
        aTree.postorderTraverse();
        
        System.out.println("(binaryNode) post-order: ");
        aTree.postorderTraverse_callBinaryNodeMethod();
        
        System.out.println();
        
        System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
        System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());
        
        System.out.println();
        
        System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
        System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());
        
        System.out.println("==========================================");
        System.out.println();
        
        System.out.println("2nd Testing Example:");
        BinaryTree<String> aTree2 = new BinaryTree<>();
        createTree2(aTree2);
        
        System.out.println("(binaryTree) post-order: ");
        aTree2.postorderTraverse();
        
        System.out.println("(binaryNode) post-order: ");
        aTree2.postorderTraverse_callBinaryNodeMethod();
        
        System.out.println();
        
        System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
        System.out.println("(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());
        
        System.out.println();
        
        System.out.println("(BinaryTree) # nodes of tree is " + aTree2.getNumberOfNodes());
        System.out.println("(BinaryNode) # nodes of tree is " + aTree2.getNumberOfNodes_callBinaryNodeMethod());
        
        System.out.println("Done.");
    }  // end main
    
    public static void createTree1(BinaryTree<String> tree) {
        // Leaves
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        
        // Subtrees:
        BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);
        
        tree.setTree("A", bTree, cTree);
        
        System.out.println("\nGiven Tree 1:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\  ");
        System.out.println("  B     C  ");
        System.out.println(" / \\   /  ");
        System.out.println("D   E  F   ");
        System.out.println("        \\ ");
        System.out.println("         G ");
        System.out.println();
    } // end createTree
    
    /**-------------------------------------------------------------------- */
    /**
     * Task 4: Create a tree case as shown in assignment 3
     */
    public static void createTree2(BinaryTree<String> tree) {
        //Leaves 
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> hTree = new BinaryTree<>("H");

        //Subtrees:
        BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
        BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
        BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree); 
        
        tree.setTree("A", bTree, cTree);

        System.out.println("\nGiven Tree 2:\n");
        System.out.println("     A           ");
        System.out.println("   /   \\        ");
        System.out.println("  B     C        ");
        System.out.println("       /  \\     ");
        System.out.println("      D     E    ");
        System.out.println("     /     /  \\ ");
        System.out.println("    F     G     H");
    } // end createTree2
    
    public static void testTreeA(BinaryTree<String> tree) {
        //Leaves 
        BinaryTree<String> bTree = new BinaryTree<>("B");
        BinaryTree<String> cTree = new BinaryTree<>("C");
        
        tree.setTree("A", bTree, cTree);

        System.out.println("\nTest Tree A:\n");
        System.out.println("     A           ");
        System.out.println("   /   \\        ");
        System.out.println("  B     C        ");
    } // end testTreeA

    @Test
    public void testGetHeightTest() {
        BinaryTree<String> exampleOne = new BinaryTree<>();
        createTree1(exampleOne);
        
        BinaryTree<String> exampleTwo = new BinaryTree<>();
        createTree2(exampleTwo);

        BinaryTree<String> testTreeA = new BinaryTree<>();
        testTreeA(testTreeA);

        assertEquals(4, exampleOne.getHeight());
        assertEquals(4, exampleTwo.getHeight());
        assertEquals(2, testTreeA.getHeight());
    }

    @Test(expected = EmptyTreeException.class)
    public void testEmptyTreeException() {
        BinaryTree<String> testTreeEmpty = new BinaryTree<>();
        System.out.println("created empty tree ...");
        
        testTreeEmpty.postorderTraverse();
        testTreeEmpty.postorderTraverse_callBinaryNodeMethod();

        testTreeEmpty.getHeight();
        testTreeEmpty.getHeight_callBinaryNodeMethod();

        testTreeEmpty.getNumberOfNodes();
        testTreeEmpty.getNumberOfNodes_callBinaryNodeMethod();
    }

}  // end DriverBT
