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
    private PrintStream console = null;          // ������Ϊnull��������� (�ַ��豸) console
    private ByteArrayOutputStream bytes = null;  // ������Ϊnull����bytes ���ڻ���console �ض���������ַ���

    public TestPrime(int n, String expected) {
        this.n = n;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        printPrimes = new PrintPrimes();
        bytes = new ByteArrayOutputStream();    // ����ռ�
        console = System.out;                   // ��ȡSystem.out ������ľ��
        System.setOut(new PrintStream(bytes));  // ��ԭ�����������̨Console���ַ��� �ض��� �� bytes
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
