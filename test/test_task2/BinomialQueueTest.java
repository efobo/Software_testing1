package test_task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import task1.Cosine;
import task2.BinomialQueue;
import task2.UnderflowException;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinomialQueueTest {


    @ParameterizedTest
    @ArgumentsSource(BinomialQueueArgsProvider.class)
    public void mergeCheck(int numItems, int i) {
        BinomialQueue<Integer> h  = new BinomialQueue<>();
        BinomialQueue<Integer> h1 = new BinomialQueue<>();

        for(i = 37; i != 0; i = ( i + 37 ) % numItems) {
            if(i % 2 == 0) {
                h1.insert(i);
            } else {
                h.insert(i);
            }
        }

        h.merge(h1);
        for(i = 1; i < numItems; i++) {
            try {
                Assertions.assertEquals(h.deleteMin(), i);
            } catch (UnderflowException e) {
                e.printStackTrace();
            }

        }

    }

    static class BinomialQueueArgsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    // check array sort
                    Arguments.of(150, 21),
                    Arguments.of(150, 140),
                    Arguments.of(500, 100),
                    Arguments.of(1000, 37),
                    Arguments.of(10000, 500));
        }
    }

}
