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
        assertEquals(a.add(b).toString(), "0");

    }

    @Test
    void add2() {
        assertEquals(b.add(c).toString(), "-5");
    }

    @Test
    void mul1() {
        assertEquals(a.mul(b).toString(), "-25");
    }

    @Test
    void mul2() {
        assertEquals(a.mul(c).toString(), "0");
    }

    @Test
    void mul3() {
        assertEquals(b.mul(b).toString(), "25");
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
        assertEquals(a.add(b).toString(), "0");
    }

    @Test
    void mulRational() {
        assertEquals(a.mul(r).toString(), "-5/2");
    }

    @Test
    void mulInteger() {
        assertEquals(a.mul(b).toString(), "-25");
    }

    @Test
    void power1() {
        assertEquals(a.power(-1).toString(), "1/5");
    }

    @Test
    void power2() {
        boolean flag = false;
        try {
            c.power(0);
        } catch (Exception e) {
            flag = true;
        }
        if (!flag) fail();
    }

    @Test
    void power3() {
        assertEquals(b.power(-1).toString(), "-1/5");
    }


}