package PolyMath;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    /**
     * @param exponent
     * @param coefficient
     */
    public Monomial(int exponent, Scalar coefficient) {
        if (exponent < 0) throw new IllegalArgumentException("exponent cannot be negative");
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    /**
     * @return
     */
    public Scalar getCoefficient() {
        return coefficient;
    }

    /**
     * @return
     */
    public int getExponent() {
        return exponent;
    }

    /**
     * @param m
     * @return
     */
    public Monomial add(Monomial m) {
        if (this.exponent != m.exponent) return null;

        return new Monomial(this.exponent, this.coefficient.add(m.getCoefficient()));
    }

    /**
     * @param m
     * @return
     */
    public Monomial mult(Monomial m) {
        return new Monomial(this.exponent + m.getExponent(), this.coefficient.mul(m.getCoefficient()));
    }

    /**
     * @param s
     * @return
     */
    public Scalar evaluate(Scalar s) {

        return this.coefficient.mul(s.power(this.exponent));
    }

    /**
     * @return
     */
    public Monomial derivative() {
        if (this.exponent == 0) return new Monomial(0, new Integer(0));

        return new Monomial(this.exponent - 1, this.coefficient.mul(new Integer(this.exponent)));
    }

    /**
     * @return
     */
    public int sign() {
        return this.coefficient.sign();
    }

    /**
     * @return
     */
    public String toString() {

        String coeff="";
        String exp="";
        if(this.exponent==1)
            exp="x";
        else if( this.exponent!=0){
            exp="x^"+this.exponent;
        }
        String real=this.coefficient.toString();
        if(real.equals("0"))
            return "0";
        else if((!real.equals("1"))&&(!real.equals("-1"))){
            coeff=real;
        }
        else if(real.equals("-1")){
            if(this.exponent==0)
                exp="1";
            coeff="-";
        }
        else if(real.equals("1")&exp.equals("")){
            coeff=real;
        }

        return coeff+exp;

    }
}
