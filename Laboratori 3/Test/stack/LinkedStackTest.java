/**
 * @author1: Diego Martinez De San Juan
 * @author2: Marc Cervera Rosell
 */

package stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    LinkedStack<Integer> theStack = new LinkedStack<>();

    /**
     * Returning the top of the stack. If the stack is empty, the method has to throw NoSuchElementExcpetion
     */
    @Test
    void topTest() {
        assertThrows(NoSuchElementException.class, () -> {
            theStack.top();
        });
        theStack.push(12);
        assertEquals(12, theStack.top());
        theStack.push(123456789);
        assertEquals(123456789, theStack.top());

    }

    /**
     * Adding an element in the stack, so now, the stack is not going to be empty
     */
    @Test
    void pushTest() {
        assertTrue(theStack.isEmpty());
        assertEquals(0, theStack.getStackSize());
        assertEquals(0, theStack.getModCount());
        theStack.push(12);
        assertEquals(1, theStack.getStackSize());
        assertEquals(1, theStack.getModCount());
        theStack.push(11);
        assertEquals(2, theStack.getStackSize());
        assertEquals(2, theStack.getModCount());
        assertFalse(theStack.isEmpty());
    }


    /**
     * The stack has been created recently, so It doesn't have any element
     **/
    @Test
    void isEmptyTest() {
        assertTrue(theStack.isEmpty());
        theStack.push(12);
        assertFalse(theStack.isEmpty());
    }

    /**
     * Checking if the pop() method removes the top of the stack. If the stack is empty, the method has to throw NoSuchElementExcpetion
     **/
    @Test
    void popTest() {
        assertTrue(theStack.isEmpty());
        theStack.push(12);
        theStack.push(124);
        theStack.pop();
        assertFalse(theStack.isEmpty());
        assertEquals(12, theStack.top());
        assertEquals(1, theStack.getStackSize());
        assertEquals(3, theStack.getModCount());
        theStack.pop();
        assertEquals(0, theStack.getStackSize());
        assertEquals(4, theStack.getModCount());
        assertTrue(theStack.isEmpty());

    }
}
