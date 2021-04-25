package PolyMath;

import java.util.*;

public class Rational implements Scalar {
    private int numerator;
    private int denominator;


    public Rational(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("try to divide by zero");
        if (numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator < 0) {//controlling the negative sign in the numerator
            this.numerator *= -1;
            this.numerator *= -1;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }


    public int reduceRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return reduceRecursion(b, a % b);
    }

    public Rational reduce() {
        int a = this.numerator;
        int b = this.denominator;
        int biggestDivider = reduceRecursion(a, b);

        return new Rational(numerator / biggestDivider, denominator / biggestDivider);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        return new Rational(this.numerator * s.denominator + s.numerator * this.denominator, s.denominator * this.denominator).reduce();
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Rational(this.numerator + s.getNumber() * this.denominator, denominator).reduce();
    }

    @Override
    public Scalar mulRational(Rational s) {

        return new Rational(this.numerator * s.numerator, this.denominator * s.denominator).reduce();

    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(this.numerator * s.getNumber(), this.denominator).reduce();
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent == 0)
            return new Rational(1, 1);
        int numerator = this.numerator;
        int a = numerator;
        int denominator = this.denominator;
        int b = numerator;
        //in a loop multiplies the values by the base numerator and denominator

        while (exponent > 1) {
            numerator = numerator * a;
            denominator = denominator * b;
            exponent -= 1;
        }
        return new Rational(numerator, denominator).reduce();
    }

    @Override
    public Scalar neg() {
        return new Rational(-this.numerator, this.denominator);
    }

    @Override
    public int sign() {//checking only numerator because we mange the negative sign only at the numerator
        if (numerator > 0) return 1;
        else if (numerator == 0) return 0;
        else return -1;
    }
}