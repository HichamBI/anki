package knowledge;

/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 24/05/16
 * Time: 21:20
 */

public class FibonacciSequence {

    public static Integer getFibonacciOf(Integer fibonacciIndex) {
        int currentIndex = 1;
        int fib__1 = 0;
        int fib__2 = 1;
        int fib_n = 0;

        while (currentIndex <= fibonacciIndex) {
            fib_n = fib__1 + fib__2;

            fib__2 = fib__1;
            fib__1 = fib_n;

            currentIndex++;
        }

        return fib_n;
    }
}
