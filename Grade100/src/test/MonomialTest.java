package test;

import PolyMath.Integer;
import PolyMath.Monomial;
import PolyMath.Rational;
import PolyMath.Scalar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonomialTest {
    private Monomial m1 = new Monomial(0, new Integer(0));
    private Monomial m2 = new Monomial(2, new Integer(1));
    private Monomial m3 = new Monomial(2, new Integer(2));
    private Monomial m4 = new Monomial(7, new Integer(10));
    private Monomial m5 = new Monomial(9, new Integer(-1));
    private Monomial m6 = new Monomial(9, new Integer(1));
    private Monomial m7 = new Monomial(0, new Integer(7));

    @Test
    void testAdd() {
        Monomial add1 = m1.add(m1);
        Monomial add2 = m2.add(m2);
        Monomial add3 = m3.add(m2);
        Monomial add4 = m5.add(m6);


        String test[] = {add1.toString(), add2.toString(), add3.toString(), add4.toString()};
        String expected[] = {"0", "2x^2", "3x^2", "0"};
        assertArrayEquals(test, expected);


    }
    @Test
    void testMul() {
        Monomial mul1 = m1.mult(m1);
        Monomial mul2 = m2.mult(m2);
        Monomial mul3 = m3.mult(m2);
        Monomial mul4 = m5.mult(m6);
        String test[] = {mul1.toString(), mul2.toString(), mul3.toString(), mul4.toString()};
        String expected[] = {"0", "x^4", "2x^4", "-x^18"};
        assertArrayEquals(test, expected);
    }
    @Test
    void testDerv() {
        Monomial der1 = m1.derivative();
        Monomial der2 = m2.derivative();
        Monomial der3 = m3.derivative();
        Monomial der4 = m4.derivative();
        Monomial der5 = m5.derivative();
        Monomial der6 = m6.derivative();
        Monomial der7 = m7.derivative();
        String test[] = {der1.toString(), der2.toString(), der3.toString(), der4.toString(), der5.toString(), der6.toString(), der7.toString()};
        String expected[] = {"0", "2x", "4x", "70x^6", "-9x^8", "9x^8", "0"};
        assertArrayEquals(test, expected);

    }
    @Test
    void testEval() {
        Scalar c1 = m1.evaluate(new Rational(0, 2));
        Scalar c2 = m2.evaluate(new Rational(1, 2));
        Scalar c3 = m4.evaluate(new Rational(-1, 2));
        Scalar c4 = m5.evaluate(new Rational(1, 1));
        Scalar c5 = m6.evaluate(new Rational(1, -1));
        Scalar c6 = m7.evaluate(new Rational(8, 16));
        String test[] = {c1.toString(), c2.toString(), c3.toString(), c4.toString(), c5.toString(), c6.toString()};
        String expected[] = {"0", "1/4", "-5/64", "-1", "-1", "7"};
    }
}
