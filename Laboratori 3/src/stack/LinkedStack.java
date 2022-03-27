/**
 * @author1: Diego Martinez De San Juan
 * @author2: Marc Cervera Rosell
 */

package stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node first; //First node
    private int stackSize; //Stack size
    private int modCount; //Structure modification counter
    private String message; //Message for empty stack

    /**
     * Nested class to create the nodes.
     */
    private static class Node<E> {
        private E item;
        private Node next;
    }

    /**
     * Constructor of the class that initializes the different variables.
     */
    public LinkedStack() {
        this.first = null; //Starting with an empty list
        this.stackSize = 0;
        this.modCount = 0;
        this.message = "Empty stack"; //Exceptions message
    }

    /**
     * Method to add an element into the stack
     */
    @Override
    public void push(E elem) {
        Node<E> oldFirst = first;
        first = new Node();
        first.item = elem;
        first.next = oldFirst;
        stackSize++;
        modCount++;

        /**
         * Graphic view of the stack:
         * Example: Step = push(12), step 2 = push(24)
         *
         * push(12):
         *
         * 12 (TOP)
         *
         * push(24):
         *
         * 24 => 12 (TOP)
         *
         * */

    }

    /**
     * Returns the last introduced element.
     */
    @Override
    public E top() {
        try {
            return (E) first.item;
        } catch (Exception e) { //Empty stack
            throw new NoSuchElementException(getMessage());
        }
    }

    /**
     * Removes the most recently item added to the stack.
     */
    @Override
    public void pop() {
        try {
            first = first.next;
            stackSize--;
            modCount++;


        } catch (Exception e) { //Empty stack
            throw new NoSuchElementException(getMessage());
        }
    }

    /**
     * Empty stack => TRUE. FALSE otherwise
     */
    @Override
    public boolean isEmpty() {
        return getStackSize() == 0 && this.first == null;
    }

    /**
     * Gets the stack size value
     */
    public int getStackSize() {
        return stackSize;
    }

    /**
     * Gets de modCount value
     */
    public int getModCount() {
        return modCount;
    }


    /**
     * Gets the message "Empty stack"
     */
    public String getMessage() {
        return message;
    }

}
