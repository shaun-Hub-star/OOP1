package test;

import PolyMath.Integer;
import PolyMath.Polynomial;
import PolyMath.Rational;
import PolyMath.Scalar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    private Polynomial p1 = Polynomial.build("1/2 1");
    private Polynomial p2 = Polynomial.build("1 0 -1 0 1/4");
    private Polynomial p3 = Polynomial.build("5 0 -2");
    private Polynomial p4 = Polynomial.build("5");
    private Polynomial p5 = Polynomial.build("2/-1");
    private Polynomial p6 = Polynomial.build("1/2 1 0 8");
    private Polynomial p7 = Polynomial.build("0 0 100");
    private Polynomial p8 = Polynomial.build("0 -1");
    private Polynomial p9 = Polynomial.build("0 -1/-2");

    @Test
    void build() {
        String[] stringArray = {"1/2+x","1-x^2+1/4x^4","5-2x^2","5","-2","1/2+x+8x^3","100x^2","-x","1/2x"};
        String[] acualArray = {p1.toString(),p2.toString(),p3.toString(),p4.toString(),p5.toString(),p6.toString(),p7.toString(),p8.toString(),p9.toString()};
        assertArrayEquals(stringArray,acualArray);
    }

    @Test
    void buildRationalMonomial() {
    }

    @Test
    void buildIntegerMonomial() {
    }

    @Test
    void add() {
        String[] test = {p1.add(p1).toString(), p1.add(p2).toString(), p2.add(p3).toString(), p3.add(p1).toString(), p4.add(p4).toString(), p5.add(p5).toString(), p5.add(p6).toString(), p6.add(p7).toString(), p7.add(p5).toString(), p8.add(p8).toString(), p9.add(p9).toString(), p8.add(p9).toString()};
        String expected[] = {"1+2x", "3/2+x-x^2+1/4x^4", "6-3x^2+1/4x^4", "11/2+x-2x^2", "10", "-4", "-3/2+x+8x^3", "1/2+x+100x^2+8x^3", "-2+100x^2", "-2x", "x", "-1/2x"};
        assertArrayEquals(expected,test);
    }

    @Test
    void mul() {
        String test[] = {p1.mul(p1).toString(), p1.mul(p2).toString(), p2.mul(p3).toString(), p3.mul(p1).toString(), p4.mul(p4).toString(), p5.mul(p5).toString(), p5.mul(p6).toString(), p6.mul(p7).toString(), p7.mul(p5).toString(), p8.mul(p8).toString(), p9.mul(p9).toString(), p8.mul(p9).toString()};
        String expected[] = {"1/4+x+x^2", "1/2+x-1/2x^2-x^3+1/8x^4+1/4x^5", "5-7x^2+13/4x^4-1/2x^6", "5/2+5x-x^2-2x^3", "25", "4", "-1-2x-16x^3", "50x^2+100x^3+800x^5", "-200x^2", "x^2", "1/4x^2", "-1/2x^2"};
        assertArrayEquals(expected,test);
    }

    @Test
    void evaluate() {
        Scalar p = new Integer(1);
        Scalar r = new Integer(0);
        Scalar q = new Rational(0, 1);
        Scalar s = new Rational(1, 2);
        String test[] = {p1.evaluate(r).toString(), p2.evaluate(r).toString(), p3.evaluate(r).toString(), p4.evaluate(r).toString(), p1.evaluate(p).toString(), p2.evaluate(p).toString(), p3.evaluate(p).toString(), p4.evaluate(p).toString(), p5.evaluate(q).toString(), p6.evaluate(q).toString(), p7.evaluate(q).toString(), p8.evaluate(q).toString(), p9.evaluate(q).toString(), p5.evaluate(s).toString(), p6.evaluate(s).toString(), p7.evaluate(s).toString(), p8.evaluate(s).toString(), p9.evaluate(s).toString()};
        String[] expected = {"1/2", "1", "5", "5", "3/2", "1/4", "3", "5", "-2", "1/2", "0", "0", "0", "-2", "2", "25", "-1/2", "1/4"};
        assertArrayEquals(expected,test);
    }

    @Test
    void derivative() {
        String test[] = {p1.derivative().toString(), p2.derivative().toString(), p3.derivative().toString(), p4.derivative().toString(), p5.derivative().toString(), p6.derivative().toString(), p7.derivative().toString(), p8.derivative().toString(), p9.derivative().toString(),};
        String expected[] = {"1", "-2x+x^3", "-4x", "0", "0", "1+24x^2", "200x", "-1", "1/2"};
        assertArrayEquals(expected,test);
    }


}