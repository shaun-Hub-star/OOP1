package PolyMath;
import java.util.*;
public class Rational implements Scalar {
    private int numerator;
    private int denominator;


   public Rational(int numerator,int denominator,boolean toReduce){
        this.numerator = numerator;
        this.denominator = denominator;
        if(toReduce){
            Rational reduced = reduce();
            this.numerator = reduced.getNumerator();
            this.denominator = reduced.getDenominator();
        }

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

        return new Rational(numerator/biggestDevider, denominator/biggestDevider,false);
    }

    @Override
    public Scalar add(Scalar s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.addRational(this);
    }
    
    @Override
    public Scalar addRational(Rational s) {
        return new Rational(this.numerator*s.denominator + s.numerator*this.denominator,s.denominator*this.denominator,true);
    }

    @Override
    public Scalar addInteger(Integer s) {
       return new Rational(this.numerator + s.getNumber() * this.denominator, denominator,true);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(this.numerator*s.numerator,this.denominator*s.denominator,true);

    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Rational(this.numerator*s.getNumber(),this.denominator,true);
    }

    @Override
    public Scalar power(int exponent) {
       if(exponent == 0)
           return new Rational(1,1,false);
       int numerator = this.numerator;
       int a = numerator;
       int denominator = this.denominator;
       int b = numerator;
       //in a loop multiplys the values by the base numerator and denominator

        while(exponent > 1){
            numerator = numerator*a;
            denominator = denominator*b;
        }
        return new Rational(numerator,denominator,true);
    }

    @Override
    public Scalar neg() {
        return new Rational(-this.numerator,this.denominator,false);
    }

    @Override
    public int sign() {
        return this.numerator/Math.abs(this.numerator);
    }
}