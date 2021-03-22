/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/22/21 
 */

/**
 * A class that throws an exception when the tree is empty.
 */

public class EmptyTreeException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmptyTreeException() {
        this(null);
    } // end default constructor
    
    public EmptyTreeException(String message) {
        super(message);
    } // end constructor
} // end EmptyTreeException
