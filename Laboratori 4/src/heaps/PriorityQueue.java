package heaps;

public interface PriorityQueue<V, P extends Comparable<? super P>> {
    void add(V value, P priority);

    V remove();

    V element();

    int size();
}

/**
 * V => Values in the queue
 * P => Priority
 **/
