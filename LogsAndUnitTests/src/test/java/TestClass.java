import com.example.logAndTest.testingSource.TestingSource;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    int[] forShift = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] forBalance = {1, 5, 9, 3, 2, 11, 6, 3};
    int[] minMaxArray = {10, 58, 32, 52, 11, 40, 15, 12, 31, 22, 82, 1, 17, 23};
    int[] giftedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

    @Test
    public void testGetBalance() {
        boolean actual = TestingSource.getBalance(forBalance);
        Assert.assertTrue(actual);
    }

    @Test
    public void testGetBalance1() {
        Assert.assertTrue(TestingSource.getBalance(minMaxArray));
    }

    @Test
    public void testGetBalance2() {
        Assert.assertFalse(TestingSource.getBalance(giftedArray));
    }

    @Test
    public void testShift() {
        int[] expected = {6, 3, 1, 5, 9, 3, 2, 11};
        int[] actual = TestingSource.shift(forBalance,2);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testShift1() {
        int[] expected = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
        int[] actual = TestingSource.shift(forShift,4);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testShift2() {
        int[] expected = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] actual = TestingSource.shift(forShift,-3);
        Assert.assertArrayEquals(expected,actual);
    }
}
