import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class BinaryTreeTest {
    public static void main(String[] args)
    {
        System.out.println("Testing class");
    }

    public <T> String callPostOrderTraversal(BinaryTree<T> tree) {

        return "x";
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

    public BinaryTree<String> createTestTree4()
    {
        BinaryTree<String> tree4 = new BinaryTree<>();
        tree4.setTree("A", null, null);

        return tree4;
    }

    @Test
    public void testPostOrderTraversal()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();
        BinaryTree<String> Tree4 = createTestTree4();

        assertEquals(8, Tree1.getNumberOfNodes());
        assertEquals(4, Tree2.getNumberOfNodes());
        assertEquals(4, Tree3.getNumberOfNodes());
        assertEquals(1, Tree4.getNumberOfNodes());

        assertEquals(8, Tree1.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(4, Tree2.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(4, Tree3.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(1, Tree4.getNumberOfNodes_callBinaryNodeMethod());
    }

    @Test
    public void testGetNumberOfNodes()
    {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();
        BinaryTree<String> Tree4 = createTestTree4();

        //assertEquals(0, uninitializedTree.getNumberOfNodes());
        assertEquals(8, Tree1.getNumberOfNodes());
        assertEquals(4, Tree2.getNumberOfNodes());
        assertEquals(4, Tree3.getNumberOfNodes());
        assertEquals(1, Tree4.getNumberOfNodes());

        assertEquals(8, Tree1.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(4, Tree2.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(4, Tree3.getNumberOfNodes_callBinaryNodeMethod());
        assertEquals(1, Tree4.getNumberOfNodes_callBinaryNodeMethod());
    }

    @Test
    public void testGetHeightTest() {
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();
        BinaryTree<String> Tree4 = createTestTree4();
        
        assertEquals(4, Tree1.getHeight());
        assertEquals(4, Tree2.getHeight());
        assertEquals(4, Tree3.getHeight());
        assertEquals(1, Tree4.getHeight());

        assertEquals(4, Tree1.getHeight_callBinaryNodeMethod());
        assertEquals(4, Tree2.getHeight_callBinaryNodeMethod());
        assertEquals(4, Tree3.getHeight_callBinaryNodeMethod());
        assertEquals(1, Tree4.getHeight_callBinaryNodeMethod());
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

}
