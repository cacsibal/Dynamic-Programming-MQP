package org.dp.topDown.oneSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximalIndependentSetPathTest {

    /** https://canvas.wpi.edu/courses/79353/files/7995069?module_item_id=1394420 */
    @Test
    void test_1() {


        int[] path = new int[]{12,11,13,15};
        MaximalIndependentSetPath testMISP = new MaximalIndependentSetPath(path);
        assertEquals(27, testMISP.solution());
    }

    /** https://canvas.wpi.edu/courses/79353/files/7995069?module_item_id=1394420 */
    @Test
    void test_2() {


        int[] path = new int[]{2,1000,3,1};
        MaximalIndependentSetPath testMISP = new MaximalIndependentSetPath(path);
        assertEquals(1001, testMISP.solution());
    }
}