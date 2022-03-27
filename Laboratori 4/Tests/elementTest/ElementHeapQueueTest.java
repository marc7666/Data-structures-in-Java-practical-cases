package elementTest;

import heaps.HeapQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementHeapQueueTest implements ElementTest {
    private HeapQueue<Integer, Integer> heap;

    @BeforeEach
    void setup() {
        heap = new HeapQueue<>();
        heap.add(null, null);
        heap.add(37, 16);
        heap.add(6, 1);
        heap.add(3, 2);
        heap.add(8, 4);
    }

    @Override
    @Test
    public void element() {
        assertEquals(37, heap.element());
    }
}
