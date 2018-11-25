import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEq {

    private static final double DELTA = 000000.1;

    /**
     * Решение квадратного уравнения: ax^2 + bx + c = 0
     *
     * @param a коэффициент уравнения a
     * @param b коэффициент уравнения b
     * @param c коэффициент уравнения c
     * @return массив решений уравнения
     */
    public static double[] solveQuadraticEq (double a, double b, double c){

        // Можно бросать не RuntimeException, а написать свое или сделать обработку значение не удовлетворяющим условиям задачи
        if (a < -100 || a > 100){
            throw new RuntimeException();
        }else if (b < -100 || b > 100 ){
            throw new RuntimeException();
        }else if (c < -100 || c > 100){
            throw new RuntimeException();
        }

        if (abs(a) < DELTA) {
            if (abs(b) < DELTA) {
                if (abs(c) < DELTA)
                    throw new RuntimeException();
                return new double[]{};
            }
            return new double[]{-c / b};
        }

        // Вычислим дискриминант
        double D = pow(b, 2) - 4 * a * c;

        // Если D = 0 => одно решение
        if (abs(D) < DELTA) {
            return new double[]{-b / (2 * a)};
        }

        // Если D > 0 => 2 решения
        if (D > 0) {
            return new double[]{
                    (-b - sqrt(D)) / (2 * a),
                    (-b + sqrt(D)) / (2 * a)
            };
        }
        // Нет решений
        return new double[]{};
    }

}
