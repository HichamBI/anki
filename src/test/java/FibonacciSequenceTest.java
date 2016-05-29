import knowledge.FibonacciSequence;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciSequenceTest{

    @Test
    public void it_should_return_fibonacci_of_passed_index() throws Exception {
        assertThat(FibonacciSequence.getFibonacciOf(0)).isEqualTo(0);
        assertThat(FibonacciSequence.getFibonacciOf(1)).isEqualTo(1);
        assertThat(FibonacciSequence.getFibonacciOf(2)).isEqualTo(1);
        assertThat(FibonacciSequence.getFibonacciOf(3)).isEqualTo(2);
        assertThat(FibonacciSequence.getFibonacciOf(4)).isEqualTo(3);
        assertThat(FibonacciSequence.getFibonacciOf(5)).isEqualTo(5);
        assertThat(FibonacciSequence.getFibonacciOf(6)).isEqualTo(8);
        assertThat(FibonacciSequence.getFibonacciOf(7)).isEqualTo(13);
        assertThat(FibonacciSequence.getFibonacciOf(8)).isEqualTo(21);
        assertThat(FibonacciSequence.getFibonacciOf(9)).isEqualTo(34);
        assertThat(FibonacciSequence.getFibonacciOf(10)).isEqualTo(55);
    }
}