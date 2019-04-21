import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBackPack {
    private int m;
    private int n;
    private int w[];
    private int p[];
    private int c[][];

    @Before
    public void setUp(){
        this.m = 10;
        this.n = 3;
        this.w = new int[]{3,4,5};
        this.p = new int[]{4,5,6};
        this.c = BackPack.BackPack_Solution(m, n, w, p);
    }

    @Test
    public void testBackPack(){
        assertEquals(11, this.c[n][m]);
    }

}
