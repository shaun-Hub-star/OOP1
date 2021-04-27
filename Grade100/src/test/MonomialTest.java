package test;

import PolyMath.Integer;
import PolyMath.Monomial;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class MonomialTest {

    @BeforeAll
    void setUP() {
        Monomial m1 = new Monomial(3, new Integer(5));
        Monomial m2 = new Monomial(0, new Integer(5));
        Monomial m3 = new Monomial(1, new Integer(5));
        Monomial m4 = new Monomial(3, new Integer(5));
        Monomial m5 = new Monomial(3, new Integer(5));
        Monomial m6 = new Monomial(3, new Integer(5));
    }
}
