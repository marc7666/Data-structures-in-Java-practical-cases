package sizeTest;

import heaps.HeapQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SizeHeapQueueTest implements SizeTest {
    private HeapQueue<Integer, Integer> heap;

    @BeforeEach
    void setup() {
        heap = new HeapQueue<>();
        heap.add(null, null);
        heap.add(9, 15);
        heap.add(2, 18);
        heap.add(6, 4);
    }

    @Override
    @Test
    public void size() {
        assertEquals(3, heap.size());
    }
}
