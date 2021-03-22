import java.util.Arrays;
/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/22/21 
 */

/**
 * A class of trees whose entries are stored in binary nodes 
 * in which each node has at most two children. 
 */

public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;
    private T[] traversalArray; // array consisting of values of the postorder travaersal
    private int topIndex = 0;
    
    public BinaryTree() {
        root = null;
    } // end default constructor
    
    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    } // end constructor
    
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        initializeTree(rootData, leftTree, rightTree);
    } // end constructor
    
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree) {
        initializeTree(rootData, (BinaryTree<T>) leftTree,
                (BinaryTree<T>) rightTree);
    } // end setTree
    
    public void setRootData(T rootData) {
        root.setData(rootData);
    } // end setRootData
    
    /**
     * Returns the root node data.
     *
     * @throws EmptyTreeException 
     * @return the data attached to the root node.
     */
    public T getRootData() {
        if (isEmpty())
            throw new EmptyTreeException();
        else
            return root.getData();
    } // end getRootData
    
    /**
     * Checks if the tree is empty by checking if the root node is null.
     *
     * @return whether the root is null or not (T/F).
     */
    public boolean isEmpty() {
        return root == null;
    } // end isEmpty
    
    /**
     * Sets the root node to null.
     */
    public void clear() {
        root = null;
    } // end clear
    
    /**
     * Sets the desired node as the root node.
     *
     * @param rootNode The node that is to be set as the root node.
     */
    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    } // end setRootNode
    
    /**
     * Returns the root node.
     *
     * @return the root node.
     */
    protected BinaryNode<T> getRootNode() {
        return root;
    } // end getRootNode
    
    /**
     * Initializes the trees and creates the node of the new tree.
     *
     * @param rootData The data that is to be set as the root node.
     * @param leftTree A tree that is to be set as the Left tree. 
     * @param rightTree A tree that is to be set as the Right tree.
     */
    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        
        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root);
        
        if ((rightTree != null) && !rightTree.isEmpty()) {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        } // end if
        
        if ((leftTree != null) && (leftTree != this))
            leftTree.clear();
        
        if ((rightTree != null) && (rightTree != this))
            rightTree.clear();
    } // end initializeTree
    
    /**
     * calls postorderTraverse(BinaryNode<T> node) prints (using post-order
     * traversal) all nodes in the "whole" tree
     */
    public void postorderTraverse() {
        if (isEmpty())
            throw new EmptyTreeException();
        @SuppressWarnings("unchecked")
        T[] tempTraversalArray = (T[])new Object[getNumberOfNodes()];
        traversalArray = tempTraversalArray;

        postorderTraverse(root);
    } // end postorderTraverse
    
    /**
     * returns the values of the Postorder Traversal.
     * @return a copy of traversalArray.
     */
    public T[] getTraversalArray() {
        return Arrays.copyOf(traversalArray, traversalArray.length);
    }

    /**
     * A Recursive Method in the BinaryTree Class prints (using post-order
     * traversal) all nodes in the subtree rooted at this node.
     */
    private void postorderTraverse(BinaryNode<T> node) {        
        if(node != null) {
            postorderTraverse(node.getLeftChild());
            postorderTraverse(node.getRightChild());
            traversalArray[topIndex] = node.getData();
            topIndex++; 
            System.out.println(node.getData());
        } // end if
    } // end postorderTraverse
    
    /**
     * The following calls postorderTraverse_binaryNodeMethod(), which is a
     * recursive binaryNode class method prints (using post-order traversal) all
     * nodes in the "whole" tree
     */
    public void postorderTraverse_callBinaryNodeMethod() {
        if (isEmpty())
            throw new EmptyTreeException();
        
        root.createTraversalArray(getNumberOfNodes());
        
        root.postorderTraverse_binaryNodeMethod(root);
    } // end postorderTraverse_callBinaryNodeMethod
    
    /**
     * calls getHeight(BinaryNode<T> node)
     *
     * @return The height of the "whole" tree
     */
    public int getHeight() {
        if (isEmpty())
            throw new EmptyTreeException();
        return getHeight(root);
    } // end getHeight
    
    /**
     * A Recursive Method in the BinaryTree Class Computes the height of the
     * subtree rooted at this node.
     *
     * @return The height of the subtree rooted at this node.
     */
    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()),
                    getHeight(node.getRightChild()));
        return height;
    } // end getHeight
    
    /**
     * The following calls getHeight_binaryNodeMethod() which is a recursive
     * binaryNode class method Computes the height of the "whole" tree.
     *
     * @return The height of the "whole" tree.
     */
    public int getHeight_callBinaryNodeMethod() {
        if (isEmpty())
            throw new EmptyTreeException();
        return root.getHeight_binaryNodeMethod();
    } // end getHeight_callBinaryNodeMethod
    
    /**
     * calls getNumberOfNodes(BinaryNode<T> node)
     *
     * @return The number of nodes in the "whole" tree
     */
    public int getNumberOfNodes() {
        if (isEmpty())
            throw new EmptyTreeException();
        return getNumberOfNodes(root);
    } // end getNumberOfNodes
    
    /**
     * A Recursive Method in the BinaryTree Class Counts the nodes in the
     * subtree rooted at this node.
     *
     * @return The number of nodes in the subtree rooted at this node.
     */
    private int getNumberOfNodes(BinaryNode<T> node) {
        int leftNumber = 0;
        int rightNumber = 0;

        if(node.getLeftChild() != null) {
            leftNumber = getNumberOfNodes(node.getLeftChild());
        } // end if

        if(node.getRightChild() != null) {
            rightNumber = getNumberOfNodes(node.getRightChild());
        } // end if

        return 1 + leftNumber + rightNumber;
        
    } // end getNumberOfNodes
    
    /**
     * The following calls getNumberOfNodes_binaryNodeMethod() which is a
     * recursive binaryNode class method Counts the nodes in the "whole" tree
     *
     * @return The number of nodes in the "whole" tree.
     */
    public int getNumberOfNodes_callBinaryNodeMethod() {
        if (isEmpty())
            throw new EmptyTreeException();
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
        return numberOfNodes;
    } // end getNumberOfNodes_callBinaryNodeMethod
    
} // end BinaryTree
