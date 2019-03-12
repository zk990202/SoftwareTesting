package top.kaisir;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import top.kaisir.ProblemYuan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestProblemYuan {

	private int input;
	private boolean expected;
	private ProblemYuan pro = null;
	
	public TestProblemYuan(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void setUp() {
		pro = new ProblemYuan();
	}

	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][] {
			{1,true},
			{2,true},
			{33,true},
			{34,false},
			{-1, false}
		});
	}
	
	
	@Test
	public void testCaculateYuan() {
		assertEquals(this.expected, pro.caculateYuan(this.input));
	}

}
