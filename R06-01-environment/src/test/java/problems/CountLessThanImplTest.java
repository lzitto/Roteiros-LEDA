package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountLessThanImplTest  {

     @Test
     void testeBrutoBScountLess() {
        Integer entrada = 8;
        Integer esperado = 12;
        Integer[] m = {1,2,2,2,3,3,4,4,5};
        Integer[] t = {2,4,5,7,7,7,7,7,7,7,7,7,8,10,12,14,16,18};
        CountLessThanImpl impl = new CountLessThanImpl();

        assertEquals(esperado,  impl.countLess(t,entrada));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "2, 3",
        "3, 5",
        "4, 6",
        "5, 9",
        "6, 10"
    })
    void testCountLessRepetidos(int entrada, int esperado) {

        Integer[] v = {1,1,1,2,2,3,4,4,4,5};

        CountLessThanImpl impl = new CountLessThanImpl();

        assertEquals(
            esperado,
            impl.countLess(v, entrada)
        );
    }

}
