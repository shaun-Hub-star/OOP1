package PolyMath;
import java.util.*;
public class Rational implements Scalar {
    private int numerator;
    private int denominator;


   public Rational(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }


    public int reduceRecursion(int a,int b) {
        if (b == 0) {
            return a;
        }
        return reduceRecursion(b, a % b);
    }
    public Rational reduce(){
        int a = this.numerator;
        int b = this.denominator;
        int biggestDevider = reduceRecursion(a,b);

        return new Rational(numerator/biggestDevider, denominator/biggestDevider);
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
        return new Rational(this.numerator*s.denominator + s.numerator*this.denominator,s.denominator*this.denominator).reduce();
    }

    @Override
    public Scalar addInteger(Integer s) {
       return new Rational(this.numerator + s.getNumber() * this.denominator, denominator).reduce();
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(this.numerator*s.numerator,this.denominator*s.denominator).reduce();

    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(this.numerator*s.getNumber(),this.denominator).reduce();
    }

    @Override
    public Scalar power(int exponent) {
       if(exponent == 0)
           return new Rational(1,1);
       int numerator = this.numerator;
       int a = numerator;
       int denominator = this.denominator;
       int b = numerator;
       //in a loop multiplys the values by the base numerator and denominator

        while(exponent > 1){
            numerator = numerator*a;
            denominator = denominator*b;
        }
        return new Rational(numerator,denominator).reduce();
    }

    @Override
    public Scalar neg() {
        return new Rational(-this.numerator,this.denominator);
    }

    @Override
    public int sign() {
        return this.numerator/Math.abs(this.numerator);
    }
}