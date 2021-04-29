package PolyMath;

import java.util.*;

/**
 * Rational class:
 */
public class Rational implements Scalar {
    private int numerator;
    private int denominator;


    /**
     * @param numerator
     * @param denominator
     */
    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("try to divide by zero");

        if (numerator < 0 && denominator < 0 || denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

    }

    /**
     * @return
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * @return
     */
    public int getNumerator() {
        return numerator;
    }


    /**
     * @param a
     * @param b
     * @return
     */
    public static int reduceRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return reduceRecursion(b, a % b);
    }

    /**
     * @return
     */
    public Rational reduce() {
        int a = this.numerator;
        int b = this.denominator;
        int biggestDivider = reduceRecursion(a, b);

        return new Rational(numerator / biggestDivider, denominator / biggestDivider);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar addRational(Rational s) {
        return new Rational(this.numerator * s.denominator + s.numerator * this.denominator, s.denominator * this.denominator).reduce();
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar addInteger(Integer s) {
        return new Rational(this.numerator + s.getNumber() * this.denominator, denominator).reduce();
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar mulRational(Rational s) {

        return new Rational(this.numerator * s.numerator, this.denominator * s.denominator).reduce();

    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(this.numerator * s.getNumber(), this.denominator).reduce();
    }

    /**
     * @param exponent
     * @return
     */
    @Override
    public Scalar power(int exponent) {
        if (exponent == 0)
            return new Rational(1, 1);


        int numerator = this.numerator;
        int a = numerator;
        int denominator = this.denominator;
        int b = denominator;

        //in a loop multiplies the values by the base numerator and denominator
        if (exponent < 0) {
            if (this.sign() == 0) throw new ArithmeticException("divide by zero violation ");
            exponent *= -1;
            numerator = this.denominator;
            denominator = this.numerator;
            a = numerator;
            b = denominator;
        }

        while (exponent > 1) {
            numerator = numerator * a;
            denominator = denominator * b;
            exponent -= 1;
        }
        return new Rational(numerator, denominator).reduce();
    }

    /**
     * @return
     */
    @Override
    public Scalar neg() {
        return new Rational(-this.numerator, this.denominator);
    }

    /**
     * @return
     */
    @Override
    public int sign() {//checking only numerator because we mange the negative sign only at the numerator
        if (numerator > 0) return 1;
        else if (numerator == 0) return 0;
        else return -1;
    }

    /**
     * @return
     */
    public String toString() {
        if (this.denominator == 1) return this.numerator + "";
        else
            return this.numerator + "/" + this.denominator;
    }
}