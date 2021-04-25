package PolyMath;

public class Integer implements Scalar {
    private int number;

    public Integer(int number){
        this.number=number;
    }
    public Integer(Integer number1,Integer number2){
        this.number = number1.getNumber() + number2.getNumber();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(this,s);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(s.getNumber()*this.number);
    }

    @Override
    public Scalar power(int exponent) {
        Scalar pow = new Integer(1);
        for(int i=0;i<exponent;i++){
            pow=this.mulInteger(this);
        }
        return pow;
    }

    @Override
    public Scalar neg() {
        return new Integer(this.number*-1);
    }

    @Override
    public int sign() {
        if(this.number>0)return 1;
        else if(this.number==0)return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return this.number + "";
    }
}
