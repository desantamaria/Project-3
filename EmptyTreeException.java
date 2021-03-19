/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/18/21 
 */

/**
 * A class that throws an exception when the tree is empty.
 */
public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        this(null);
    } // end default constructor
    
    public EmptyTreeException(String message) {
        super(message);
    } // end constructor
} // end EmptyTreeException
