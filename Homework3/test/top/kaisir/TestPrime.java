package top.kaisir;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPrime {
    private int n;
    private String expected;
    private PrintPrimes printPrimes;
    private PrintStream console = null;          // 声明（为null）：输出流 (字符设备) console
    private ByteArrayOutputStream bytes = null;  // 声明（为null）：bytes 用于缓存console 重定向过来的字符流

    public TestPrime(int n, String expected) {
        this.n = n;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        printPrimes = new PrintPrimes();
        bytes = new ByteArrayOutputStream();    // 分配空间
        console = System.out;                   // 获取System.out 输出流的句柄
        System.setOut(new PrintStream(bytes));  // 将原本输出到控制台Console的字符流 重定向 到 bytes
    }

    @After
    public void tearDown(){
        System.setOut(console);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {1, "Prime: 2\r\n"},
                {3, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n"},
                {5, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n"}
        });
    }

    @Test
    public void testPrintPrimes(){
        printPrimes.printPrimes(n);
        assertEquals(expected , bytes.toString());
    }
}
