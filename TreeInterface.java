/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/18/21 
 */

/**
 * An interface of a tree whose entries are stored in nodes that can 
 * have children/parents.
 */
public interface TreeInterface<T> {
    public T getRootData();
    
    public int getHeight();
    
    public int getNumberOfNodes();
    
    public boolean isEmpty();
    
    public void clear();
} // end TreeInterface
