package PolyMath;

public interface Scalar {

    public Scalar add(Scalar s);
    public Scalar mull(Scalar s);
    public Scalar addRational(Rational s);
    public Scalar addInteger(Integer s);
    public Scalar mulRational(Rational s);
    public Scalar mulInteger(Integer s);
    public Scalar power(int exponent);
    public Scalar neg();
    public int sign();
}