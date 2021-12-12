package lesson14;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        System.out.println("initialization");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test finished");
    }

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(10, calculator.sum(3, 7), "sum should be equal 10");
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testMultiplication() throws InterruptedException {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void testDivisionWithException() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(10, 0));
    }

    @CsvSource({
            "1,2,3",
            "3,2,5",
            "13,2,15"
    })
    @ParameterizedTest
    void testAdditionMultiple(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.sum(a, b));
    }


    @MethodSource("dataForAddition")
    @ParameterizedTest
    void testAdditionMiltipleWithMethod(int a, int b, int result) {
    Assertions.assertEquals(result, calculator.sum(a,b));
    }




//        List<Arguments> arguments = new ArrayList<>();
//        Random random = new Random();
//        for (int i=0; i<1000; i++){
//            int a = random.nextInt(1000);
//            int b =  random.nextInt(1000);
//            arguments.
//        }
//    }
}
