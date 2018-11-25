import org.junit.Test;

import static org.junit.Assert.*;

public class QuadraticEqTest {

    private static final double DELTA = 0.000001;

    // Первый (самый простой) тест

    @Test
    public void testSimple() {
        // assertEquals( ожидаемое_значение, вычисленное значение )
        //       сообщение_если_значения_не_равны, ..., ...
        // a*x^2 + b*x + c = 0
        assertArrayEquals("x^2 = 0",
                new double[]{0.0},
                QuadraticEq.solveQuadraticEq(1.0, 0.0, 0.0), DELTA);
    }


    // Рассматриваем случай, когда два решения уравнения
    @Test
    public void twoSolutions() {
        assertArrayEquals("x^2 - 1 = 0",
                new double[]{-1.0, 1.0},
                QuadraticEq.solveQuadraticEq(1.0, 0.0, -1.0), DELTA);
        assertArrayEquals("x^2 - 4 = 0",
                new double[]{-2.0, 2.0},
                QuadraticEq.solveQuadraticEq(1.0, 0.0, -4.0), DELTA);
    }

    /**
     * Отдельный тест когда b != 0
     */
    @Test
    public void twoSolutionsBNotNull() {
        // (x-1)(x-2) = x^2 - 3x + 2
        assertArrayEquals("x^2 - 3x + 2 = 0",
                new double[]{1.0, 2.0},
                QuadraticEq.solveQuadraticEq(1.0, -3.0, 2.0), DELTA);
    }
    //<--

    /**
     * Квадратные уравнения с одним решением
     */
    @Test
    public void oneSolution() {
        assertArrayEquals("(x+1)^2 = x^2 + 2*x + 1 = 0",
                new double[]{-1.0},
                QuadraticEq.solveQuadraticEq(1.0, 2.0, 1.0), DELTA);
    }

    /**
     * Уравнения с дискриминантом меньше 0
     * у которых нет решений в действ. числах
     */
    @Test
    public void testNoSolutions() {
        assertArrayEquals("x^2 + 1 = 0",
                new double[]{},
                QuadraticEq.solveQuadraticEq(1.0, 0.0, 1.0), DELTA);

        assertArrayEquals("3x^2 + 10 = 0",
                new double[]{},
                QuadraticEq.solveQuadraticEq(3.0, 0.0, 10.0), DELTA);
    }

    /**
     * Вырожденный случай: a = 0
     * Квадратное уравнение превращается в линейное
     */
    @Test
    public void testZeroA() {
        assertArrayEquals("2x + 1 = 0",
                new double[]{-0.5},
                QuadraticEq.solveQuadraticEq(0.0, 2.0, 1.0), DELTA);

        assertArrayEquals("x - 10 = 0",
                new double[]{10.0},
                QuadraticEq.solveQuadraticEq(0.0, 1.0, -10.0), DELTA);
    }

    /**
     * Тестируем вырожденный случай: a = 0, b = 0
     */

    @Test
    public void testZeroAZeroB() {
        assertArrayEquals("1 = 0",
                new double[]{},
                QuadraticEq.solveQuadraticEq(0.0, 0.0, 1.0), DELTA);
    }


    /**
     * Вырожденный случай: a = 0, b = 0, c = 0
     */

    @Test(expected = RuntimeException.class)
    public void testZeroAZeroBZeroC() {
        assertArrayEquals("0 = 0",
                new double[]{},
                QuadraticEq.solveQuadraticEq(0.0, 0.0, 0.0), DELTA);
    }
    /**
     * Проверка ввода значений выходящих за граничные значения
     */

    @Test(expected = RuntimeException.class)
    public void testIfAParamLessMinus100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(-101.0, 0.0, 0.0), DELTA);
    }
    @Test(expected = RuntimeException.class)
    public void testIfBParamLessMinus100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(0.0, -101.0, 0.0), DELTA);
    }
    @Test(expected = RuntimeException.class)
    public void testIfCParamLessMinus100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(0.0, 0.0, -101.0), DELTA);
    }
    @Test(expected = RuntimeException.class)
    public void testIfAParamMore100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(101.0, 0.0, 0.0), DELTA);
    }
    @Test(expected = RuntimeException.class)
    public void testIfBParamMore100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(0.0, 101.0, 0.0), DELTA);
    }
    @Test(expected = RuntimeException.class)
    public void testIfCParamMore100(){
        assertArrayEquals(" from -100 to 100",
                new double[]{}, QuadraticEq.solveQuadraticEq(0.0, 0.0, 101.0), DELTA);
    }
}