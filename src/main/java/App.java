import java.util.Arrays;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        double a, b, c;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value");
        a = scanner.nextDouble();
        System.out.println("Enter b value");
        b = scanner.nextDouble();
        System.out.println("Enter c value");
        c = scanner.nextDouble();

        System.out.println(Arrays.toString(QuadraticEq.solveQuadraticEq(a, b, c)));

    }

}
