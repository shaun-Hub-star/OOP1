package PolyMath;

/**
 * Integer
 */
public class Integer implements Scalar {
    private int number;

    /**
     * @param number
     */
    public Integer(int number) {
        this.number = number;
    }

    /**
     * @param number1
     * @param number2
     */
    public Integer(Integer number1, Integer number2) {
        this.number = number1.getNumber() + number2.getNumber();
    }

    public int getNumber() {
        return number;
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar add(Scalar s) {

        return s.addInteger(this);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);

    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar addRational(Rational s) {
        return s.addInteger(this);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(this, s);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.mulInteger(this);
    }

    /**
     * @param s
     * @return
     */
    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(s.getNumber() * this.number);
    }

    /**
     * @param exponent
     * @return
     */
    @Override
    public Scalar power(int exponent) {

        if (exponent < 0) {
            int base = this.getNumber();
            Rational inverse = new Rational(1, base);
            return inverse.power(-exponent);
        }

        if (this.sign() == 0 & exponent == 0) throw new ArithmeticException("Divide by zero violation");

        Scalar pow = new Integer(1);

        for (int i = 0; i < exponent; i++) {

            pow = this.mulInteger(this);

        }
        return pow;
    }

    /**
     * @return
     */
    @Override
    public Scalar neg() {
        return new Integer(this.number * -1);
    }

    /**
     * @return
     */
    @Override
    public int sign() {
        if (this.number > 0) return 1;
        else if (this.number == 0) return 0;
        else return -1;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return this.number + "";
    }
}
