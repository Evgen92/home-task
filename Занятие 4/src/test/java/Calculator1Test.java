import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

class Calculator1Test {

    private Calculator calculator;

    @BeforeEach
    void initCalc() {
        calculator = new Calculator();
    }

    @AfterEach
    void afterCalc() {
        calculator = null;
    }

    @Test
    void calcSum() {
        int expectedResult = 5;
        int actualResult = calculator.calcSum(2, 3);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calcPow() {
        double expectedResult = 8;
        double actualResult = calculator.calcPow(2.0, 3.0);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calcMult() {
        int expectedResult = 6;
        int actualResult = calculator.calcMult(2, 3);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calcMin() {
        int expectedResult = 2;
        int actualResult = calculator.calcMin(2, 3);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calcMax() {
        Calculator calculator = new Calculator();
        int expectedResult = 3;
        int actualResult = calculator.calcMax(2, 3);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @RunWith(value = Parameterized.class)
    public class tstCalcSum {

        private int passValue1;
        private int passValue2;
        private int expectedResult;
        private Calculator calc;

        @Parameterized.Parameters
        public Collection set_of_parameters() {
            return Arrays.asList(new Object[][]{
                            {6, 4, 2},
                            {7, 6, 1},
                            {9, 5, 4}
                    }
            );
        }


        public tstCalcSum(int expectedResult, int passValue1, int passValue2) {
            this.expectedResult = expectedResult;
            this.passValue1 = passValue1;
            this.passValue2 = passValue2;
        }

        @Before
        public void setUp(){
            calc = new Calculator();
        }

        @Test
        public void tstCalcSum(){
            Assertions.assertEquals(expectedResult, calc.calcSum(passValue1, passValue2));
        }
    }
}
