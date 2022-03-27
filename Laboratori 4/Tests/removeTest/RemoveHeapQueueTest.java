package removeTest;

import heaps.HeapQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveHeapQueueTest implements RemoveTest {
    private HeapQueue<Integer, Integer> heap;

    @BeforeEach
    void setup() {
        heap = new HeapQueue<>();
        heap.add(null, null);
        heap.add(2, 16);
        heap.add(5, 14);
        heap.add(7, 10);
        heap.add(1, 8);
        heap.add(12, 7);
        heap.add(72, 9);
        heap.add(45, 3);
        heap.add(22, 2);
        heap.add(6, 4);
        heap.add(8, 1);
    }

    @Override
    @Test
    public void OneRemove() {
        assertEquals(2, heap.remove());

    }

    @Override
    @Test
    public void twoRemoves() {
        //Two removes in a row to check if the ArrayList is resized correctly
        assertEquals(2, heap.remove());
        assertEquals(5, heap.remove());

    }
}
