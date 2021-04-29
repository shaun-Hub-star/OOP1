package test;

import PolyMath.Integer;
import PolyMath.Rational;
import PolyMath.Scalar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    Scalar r;
    Scalar r2;
    Scalar r3;
    Scalar r4;


    @BeforeEach
    void setUp() {
        r = new Rational(0, 2);
        r2 = new Rational(0, 1);
        r3 = new Rational(1, -3);
        r4 = new Rational(-2, -6);


    }

    @Test
    void reduceRecursion() {
        assertEquals(-3, Rational.reduceRecursion(-3, 6));
    }

    @Test
    void reduce() {
        Rational s = new Rational(-4, 8);
        assertEquals(s.reduce().toString(), "-1/2");
    }


    @Test
    void add() {
        assertEquals(r3.add(r4).toString(), "0");
    }

    @Test
    void mul() {
        assertEquals(r3.mul(r4).toString(), "-1/9");
    }

    @Test
    void addRational() {
        assertEquals(r3.addRational((Rational) r4).toString(), "0");
    }

    @Test
    void addInteger() {
        assertEquals(r2.addInteger(new Integer(3)).toString(), "3");
    }

    @Test
    void mulRational() {
        assertEquals(r3.mulRational((Rational) r4).toString(), "-1/9");
    }

    @Test
    void mulInteger() {
        assertEquals(r2.mulInteger(new Integer(3)).toString(), "0");
    }

    @Test
    void power1() {
        boolean flag = true;
        try {
            r.power(-3);
        } catch (Exception e) {
            flag = false;
        }

        if (flag) fail();
    }


}