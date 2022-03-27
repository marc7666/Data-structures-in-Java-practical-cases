/**
 * @author1: Diego Martinez De San Juan
 * @author2: Marc Cervera Rosell
 */

package stack;

public interface Stack<E> {
    void push(E elem);

    E top();

    void pop();

    boolean isEmpty();
}
