package test;

import PolyMath.Integer;
import PolyMath.Rational;
import PolyMath.Scalar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    Scalar a;
    Scalar b;
    Scalar c;
    Scalar r;

    @BeforeEach
    void setUp() {
        a = new Integer(5);
        b = new Integer(-5);
        c = new Integer(0);
        r = new Rational(1, -2);

    }

    @Test
    void add1() {
        assertEquals("0",a.add(b).toString());

    }

    @Test
    void add2() {
        assertEquals("-5",b.add(c).toString());
    }

    @Test
    void mul1() {
        assertEquals("-25",a.mul(b).toString());
    }

    @Test
    void mul2() {
        assertEquals("0",a.mul(c).toString());
    }

    @Test
    void mul3() {
        assertEquals("25",b.mul(b).toString());
    }

    @Test
    void addRational1() {
        assertEquals("-11/2", b.addRational((Rational) r).toString());
    }

    @Test
    void addRational2() {
        assertEquals("-1/2", c.addRational((Rational) r).toString());
    }

    @Test
    void addInteger() {
        assertEquals("0",a.add(b).toString());
    }

    @Test
    void mulRational() {
        assertEquals("-5/2",a.mul(r).toString());
    }

    @Test
    void mulInteger() {
        assertEquals("-25",a.mul(b).toString());
    }

    @Test
    void power1() {
        assertEquals("1/5",a.power(-1).toString());
    }



    void power2() {
        assertEquals("-1/5",b.power(-1).toString());

    }


}