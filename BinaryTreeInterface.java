/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/22/21 
 */

/**
 * An interface of a tree whose entries are stored in nodes that can 
 * have at max two children.
 */

public interface BinaryTreeInterface<T> extends TreeInterface<T> {
    /**
     * Sets the data in the root of this binary tree.
     *
     * @param rootData The object that is the data for the tree's root.
     */
    public void setRootData(T rootData);
    
    /**
     * Sets this binary tree to a new binary tree.
     *
     * @param rootData  The object that is the data for the new tree's root.
     * @param leftTree  The left subtree of the new tree.
     * @param rightTree The right subtree of the new tree.
     */
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree);
} // end BinaryTreeInterface
