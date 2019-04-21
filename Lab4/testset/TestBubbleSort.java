import org.junit.Test;
import static org.junit.Assert.*;

public class TestBubbleSort {

    @Test
    public void testBubbleSort() {
        assertArrayEquals(new int[]{1,2,3,4,5}, BubbleSort.BubbleSort(new int[]{4,3,1,5,2}));
        assertArrayEquals(new int[]{5,12,13,23,34}, BubbleSort.BubbleSort(new int[]{13,12,34,23,5}));
        assertArrayEquals(BubbleSort.BubbleSort(new int[]{4,3,1,5,2}), new int[]{1,2,3,4,5});
    }

}
