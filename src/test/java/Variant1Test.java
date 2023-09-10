import org.example.Variant1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;


public class Variant1Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test(dataProvider = "meterData")
    public void meterTest(int L, int expected) {
        int actual = new Variant1().inMeter(L);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] meterData() {
        return new Object[][]{
                {100, 1},
                {350, 3},
                {1000, 10},
                {1550, 15},
                {100000, 1000}
        };
    }

    @Test(dataProvider = "positiveNumberData")
    public void testIsPositiveNumber(int number, boolean expected) {
        boolean actual = new Variant1().isPositiveNumber(number);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] positiveNumberData() {
        return new Object[][]{
                {5, true},
                {0, false},
                {-5, false},
                {100, true},
                {-100, false}
        };
    }

    @Test(dataProvider = "modifyNumberData")
    public void testModifyNumber(int input, int expected) {
        int actual = new Variant1().modifyNumber(input);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] modifyNumberData() {
        return new Object[][]{
                {5, 6},
                {-5, -5},
                {0, 0},
                {100, 101},
                {-100, -100}
        };
    }

    @Test(dataProvider = "dayOfWeekData")
    public void testGetDayOfWeek(int dayNumber, String expected) {
        String actual = new Variant1().getDayOfWeek(dayNumber);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dayOfWeekData() {
        return new Object[][]{
                {1, "понеділок"},
                {2, "вівторок"},
                {3, "середа"},
                {4, "четвер"},
                {5, "п'ятниця"},
                {6, "субота"},
                {7, "неділя"},
                {0, "невідомий день"},
                {8, "невідомий день"}
        };
    }

    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
    }

    @Test(dataProvider = "numberData")
    public void testPrintNumberNTimes(int K, int N, String expectedOutput) {
        new Variant1().printNumberNTimes(K, N);
        assertEquals(expectedOutput, outContent.toString());
    }

    @DataProvider
    public Object[][] numberData() {
        return new Object[][]{
                {5, 3, "555"},
                {7, 5, "77777"},
                {10, 1, "10"},
                {8, -2, "N має бути більше нуля"},
        };
    }

    @Test(dataProvider = "remainingLengthData")
    public void testFindRemainingLength(int A, int B, int expected) {
        int actual = new Variant1().findRemainingLength(A, B);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] remainingLengthData() {
        return new Object[][]{
                {15, 4, 3},
                {10, 3, 1},
                {7, 2, 1},
                {8, 5, 3},
                {20, 7, 6},
                {100, 25, 0},
                {1, 1, 0},
        };
    }

    @Test(dataProvider = "oddNumbersData")
    public void testGenerateOddNumbers(int N, int[] expected) {
        int[] actual = new Variant1().generateOddNumbers(N);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] oddNumbersData() {
        return new Object[][]{
                {7, new int[]{1, 3, 5, 7, 9, 11, 13}},
                {5, new int[]{1, 3, 5, 7, 9}},
                {3, new int[]{1, 3, 5}},
                {1, new int[]{1}},
        };
    }

    @Test(dataProvider = "matrixData")
    public void testCreateMatrix(int M, int N, int[][] expectedMatrix) {
        int[][] actualMatrix = new Variant1().createMatrix(M, N);

        assertEquals(expectedMatrix.length, actualMatrix.length);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertEquals(expectedMatrix[i].length, actualMatrix[i].length);
        }

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[i].length; j++) {
                assertEquals(expectedMatrix[i][j], actualMatrix[i][j]);
            }
        }
    }

    @DataProvider
    public Object[][] matrixData() {
        return new Object[][]{
                {3, 3, new int[][]{{10, 10, 10}, {20, 20, 20}, {30, 30, 30}}},
                {2, 4, new int[][]{{10, 10, 10, 10}, {20, 20, 20, 20}}},
                {4, 2, new int[][]{{10, 10}, {20, 20}, {30, 30}, {40, 40}}},
        };
    }

    @Test(dataProvider = "minMaxData")
    public void testFindMinMax(int[] numbers, int[] expected) {
        int[] actual = new Variant1().findMinMax(numbers);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] minMaxData() {
        return new Object[][]{
                {new int[]{1, 3, 5, 7, 9, 11, 13}, new int[]{1, 13}},
                {new int[]{1, 3, 5, 7, 9}, new int[]{1, 9}},
                {new int[]{5, 8, 2, 12, 6}, new int[]{2, 12}},
                {new int[]{42}, new int[]{42, 42}},
        };
    }
}
