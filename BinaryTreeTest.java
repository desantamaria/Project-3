import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class BinaryTreeTest {
    public static void main(String[] args)
    {
        System.out.println("Testing class");
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

    @Test
    public void testGetNumberOfNodes()
    {
        BinaryTree<String> emptyTree = new BinaryTree<>();
        BinaryTree<String> uninitializedTree;
        BinaryTree<String> Tree1 = createTestTree1();
        BinaryTree<String> Tree2 = createTestTree2();
        BinaryTree<String> Tree3 = createTestTree3();

        assertEquals(0, emptyTree.getNumberOfNodes());
        assertEquals(0, uninitializedTree.getNumberOfNodes());
        assertEquals(8, Tree1.getNumberOfNodes());
        assertEquals(4, Tree2.getNumberOfNodes());
        assertEquals(4, Tree3.getNumberOfNodes());
    }
}
