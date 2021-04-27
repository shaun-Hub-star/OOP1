package test;
import PolyMath.Polynomial;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
public class PolynomialTest {
    @BeforeEach
    void setUp() {
        Polynomial p1 = Polynomial.build("1/2 1");
        Polynomial p2 = Polynomial.build("1 0 -1 0 1/4");
        Polynomial p3 = Polynomial.build("5 0 -2");
        Polynomial p4 = Polynomial.build("5");
        Polynomial p5 = Polynomial.build("2/-1");
        Polynomial p6 = Polynomial.build("1/2 1 0 8");
        Polynomial p7 = Polynomial.build("0 0 100");
        Polynomial p8 = Polynomial.build("0 -1");
        Polynomial p9 = Polynomial.build("0 -1/-2");
    }
}
