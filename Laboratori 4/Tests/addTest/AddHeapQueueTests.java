package addTest;

import heaps.HeapQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddHeapQueueTests implements AddTest {
    private HeapQueue<Integer, Integer> heap;
    private HeapQueue<Integer, Integer> heap2;

    @BeforeEach
    void setup() {
        heap = new HeapQueue<>();
        heap2 = new HeapQueue<>();
    }

    @Override
    @Test
    public void addGreaterPriority() {
        //Priority1 > Priority2 => With ordered priorities
        heap.add(null, null);
        heap.add(67, 5);
        heap.add(87, 2);
        heap.add(3, 1);
        assertEquals(67, heap.element());

        //Priority1 > Priority2 => With disordered priorities to check that add() reorders correctly the heap
        heap2.add(null, null);
        heap2.add(9, 2);
        heap2.add(67, 5);
        heap2.add(3, 2);
        heap2.add(3, 3);
        heap2.add(3, 4);
        assertEquals(67, heap2.element());

    }

    @Override
    @Test
    public void addEqualPriority() {
        //Priority1 == Priority2 => Returns the one that have less timeStamp
        heap.add(null, null);
        heap.add(45, 5);
        heap.add(32, 5);
        assertEquals(45, heap.element());

    }

    @Override
    @Test
    public void addNullCase() {
        //Priority null with greater priority
        heap.add(null, null);
        heap.add(55, null);
        heap.add(7, 4);
        assertEquals(7, heap.element());

        //Priority null with priority null
        heap2.add(null, null);
        heap2.add(12, null);
        heap2.add(24, null);
        assertEquals(12, heap2.element());
    }

}
