import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.Assert;

public class BinaryTreeTest {
    public static void main(String[] args)
    {
        System.out.println("Test Trees:");
        System.out.println();
    }

    public BinaryTree<String> createTestTree1()
    {
        //Tree1
        BinaryTree<String> tree1 = new BinaryTree<>();
        //Leaves:
        BinaryTree<String> bTree1 = new BinaryTree<>("B");
        BinaryTree<String> fTree1 = new BinaryTree<>("F");
        BinaryTree<String> gTree1 = new BinaryTree<>("G");
        BinaryTree<String> hTree1 = new BinaryTree<>("H");
        //Subtrees:
        BinaryTree<String> dTree1 = new BinaryTree<>("D", fTree1, null);
        BinaryTree<String> eTree1 = new BinaryTree<>("E", gTree1, hTree1);
        BinaryTree<String> cTree1 = new BinaryTree<>("C", dTree1, eTree1);

        tree1.setTree("A", bTree1, cTree1);

        return tree1;
    }

    public BinaryTree<String> createTestTree2()
    {
        //Tree1
        BinaryTree<String> tree2 = new BinaryTree<>();
        //Leaves:
        BinaryTree<String> dTree2 = new BinaryTree<>("D");
        //Subtrees:
        BinaryTree<String> cTree2 = new BinaryTree<>("C", dTree2, null);
        BinaryTree<String> bTree2 = new BinaryTree<>("B", cTree2, null);

        tree2.setTree("A", bTree2, null);

        return tree2;
    }

    public BinaryTree<String> createTestTree3()
    {
        //Tree1
        BinaryTree<String> tree3 = new BinaryTree<>();
        //Leaves:
        BinaryTree<String> dTree3 = new BinaryTree<>("D");
        //Subtrees:
        BinaryTree<String> cTree3 = new BinaryTree<>("C", null, dTree3);
        BinaryTree<String> bTree3 = new BinaryTree<>("B", null, cTree3);

        tree3.setTree("A", null, bTree3);

        return tree3;
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
        testTreeEmpty.getRootNode().getNumberOfNodes_binaryNodeMethod();
    }

    @Test
    public void testGetHeightTest() {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        assertEquals(4, Tree1.getHeight());
        assertEquals(4, Tree2.getHeight());
        assertEquals(4, Tree3.getHeight());
    }
    
    @Test
    public void testGetHeight_callBinaryNodeMethodTest() {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        assertEquals(4, Tree1.getHeight_callBinaryNodeMethod());
        assertEquals(4, Tree2.getHeight_callBinaryNodeMethod());
        assertEquals(4, Tree3.getHeight_callBinaryNodeMethod());
    }

    @Test
    public void testGetNumberHeight_BinaryNodeMethod()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        //Tests the Height in Node A of tree1
        assertEquals(4, Tree1.getRootNode().getHeight_binaryNodeMethod());
                
        //Tests the Height in Node C of tree2

        //Returns NodeC from Tree2
        BinaryNode<String> nodeC = Tree2.getRootNode().getLeftChild().getLeftChild(); 
        assertEquals(2, nodeC.getHeight_binaryNodeMethod());

        //Tests the height in Node B of tree3

        //Returns nodeB from Tree3
        BinaryNode<String> nodeB = Tree3.getRootNode().getRightChild();
        assertEquals(3, nodeB.getHeight_binaryNodeMethod());
    }
    
    @Test
    public void testGetNumberOfNodes()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        //Tests the number of nodes in tree1
        assertEquals(8, Tree1.getNumberOfNodes());
        //Tests the number of nodes in tree2
        assertEquals(4, Tree2.getNumberOfNodes());
        //Tests the number of nodes in tree3
        assertEquals(4, Tree3.getNumberOfNodes());
    }

    @Test
    public void testGetNumberOfNodes_callBinaryNodeMethod()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        //Tests the number of nodes in tree1
        assertEquals(8, Tree1.getNumberOfNodes_callBinaryNodeMethod());
        //Tests the number of nodes in tree2
        assertEquals(4, Tree2.getNumberOfNodes_callBinaryNodeMethod());
        //Tests the number of nodes in tree3
        assertEquals(4, Tree3.getNumberOfNodes_callBinaryNodeMethod());
    }

    @Test
    public void testGetNumberOfNodes_BinaryNodeMethod()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        //Tests the number of nodes in Node A of tree1
        assertEquals(8, Tree1.getRootNode().getNumberOfNodes_binaryNodeMethod());
                
        //Tests the number of nodes in Node C of tree2

        //Returns NodeC from Tree2
        BinaryNode<String> nodeC = Tree2.getRootNode().getLeftChild().getLeftChild(); 
        assertEquals(2, nodeC.getNumberOfNodes_binaryNodeMethod());

        //Tests the number of nodes in Node B of tree3

        //Returns nodeB from Tree3
        BinaryNode<String> nodeB = Tree3.getRootNode().getRightChild();
        assertEquals(3, nodeB.getNumberOfNodes_binaryNodeMethod());
    }

    @Test
    public void testPostorderTraverse()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        Object[] expectedTraversalArray1 = {"B", "F", "D", "G", "H", "E", "C", "A"};
        Tree1.postorderTraverse();
        Object[] traversalArray1 = Tree1.getTraversalArray();
        Assert.assertArrayEquals(expectedTraversalArray1, traversalArray1);
        System.out.println();

        Object[] expectedTraversalArray2 = {"D", "C", "B", "A"};
        Tree2.postorderTraverse();
        Object[] traversalArray2 = Tree2.getTraversalArray();
        Assert.assertArrayEquals(expectedTraversalArray2, traversalArray2);
        System.out.println();

        Object[] expectedTraversalArray3 = {"D", "C", "B", "A"};
        Tree3.postorderTraverse();
        Object[] traversalArray3 = Tree3.getTraversalArray();
        Assert.assertArrayEquals(expectedTraversalArray3, traversalArray3);
        System.out.println();
    }

    @Test
    public void testPostorderTraverseCallBinaryNodeMehtod()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        Object[] expectedTraversalArray1 = {"B", "F", "D", "G", "H", "E", "C", "A"};
        Tree1.postorderTraverse_callBinaryNodeMethod();
        Object[] traversalArray1 = Tree1.getRootNode().getTraversalArrayBinaryMethod();
        Assert.assertArrayEquals(expectedTraversalArray1, traversalArray1);
        System.out.println();

        Object[] expectedTraversalArray2 = {"D", "C", "B", "A"};
        Tree2.postorderTraverse_callBinaryNodeMethod();
        Object[] traversalArray2 = Tree2.getRootNode().getTraversalArrayBinaryMethod();
        Assert.assertArrayEquals(expectedTraversalArray2, traversalArray2);
        System.out.println();

        Object[] expectedTraversalArray3 = {"D", "C", "B", "A"};
        Tree3.postorderTraverse_callBinaryNodeMethod();
        Object[] traversalArray3 = Tree3.getRootNode().getTraversalArrayBinaryMethod();
        Assert.assertArrayEquals(expectedTraversalArray3, traversalArray3);
        System.out.println();
    }
    public static <T> Object[] returnPostorderTraverse_callBinaryNodeMethodResult(BinaryTree<T> tree){
        Object[] expectedTraversalArray1 = {"B", "F", "D", "G", "H", "E", "C", "A"};
        return expectedTraversalArray1;
    }

}
