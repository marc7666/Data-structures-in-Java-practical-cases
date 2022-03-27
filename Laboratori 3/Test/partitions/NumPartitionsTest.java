/**
 * @author1: Diego Martinez De San Juan
 * @author2: Marc Cervera Rosell
 */

package partitions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumPartitionsTest {

    public static final int MAX = 20;

    /**
     * Checks that the recursive method and the iterative method returns the same value
     */
    @Test
    void golden() {
        for (int sum = 1; sum <= MAX; sum++) {
            var rec = NumPartitions.numPartitionsRec(sum);
            var ite = NumPartitions.numPartitionsIter(sum);
            assertEquals(rec, ite);
        }
    }
}
