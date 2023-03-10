/*package test_task1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import task1.Cosine;

class CosFunctionTest {



    @ParameterizedTest
    @ValueSource(doubles = {30, 45, 60, 90, 120, 180})
    public void standardCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0})
    public void zeroCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-30, -45, -60, -90, -120, -180})
    public void negativeCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.2, -101.54, 32.44, 29.01, -120.34, 170.45})
    public void doubleCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }


    @ParameterizedTest
    @ValueSource(doubles = {3000, 4000, 5000})
    public void bigNumsCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-3000, -4000, -5000})
    public void negativeBigNumsCheck(double value) {
        double ans = Math.cos(Math.toRadians(value));
        double left_border = ans - 0.005;
        double right_border = ans + 0.005;
        double num = Cosine.Cosine(value);
        Assertions.assertTrue(right_border > num && left_border < num);
    }


}*/


package test_task1;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import task1.Cosine;

class CosFunctionTest {



    @ParameterizedTest
    @ValueSource(doubles = {30, 45, 60, 90, 120, 180})
    public void standardCheck(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0})
    public void nullCheck(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-30, -45, -60, -90, -120, -180})
    public void negativeCheck(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.2, -101.54, 32.44, 29.01, -120.34, 170.45})
    public void doubleCheck(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }


    @ParameterizedTest
    @ValueSource(doubles = {3000, 4000, 5000})
    public void bigNumsCheck(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-3000, -4000, -5000})
    public void negativeBigNumsCheck4(double value) {
        Assertions.assertTrue(Math.cos(Math.toRadians(value)) + 0.005 > Cosine.Cosine(value) && Math.cos(Math.toRadians(value)) - 0.005 < Cosine.Cosine(value));
    }


}
