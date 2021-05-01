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
        assertEquals("-1/2",s.reduce().toString());
    }


    @Test
    void add() {
        assertEquals("0",r3.add(r4).toString());
    }

    @Test
    void mul() {
        assertEquals("-1/9",r3.mul(r4).toString());
    }

    @Test
    void addRational() {
        assertEquals("0",r3.addRational((Rational) r4).toString());
    }

    @Test
    void addInteger() {
        assertEquals("3",r2.addInteger(new Integer(3)).toString());
    }

    @Test
    void mulRational() {
        assertEquals("-1/9",r3.mulRational((Rational) r4).toString());
    }

    @Test
    void mulInteger() {
        assertEquals("0",r2.mulInteger(new Integer(3)).toString());
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