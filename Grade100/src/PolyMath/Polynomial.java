package PolyMath;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private ArrayList<Monomial> poly;

    public Polynomial() {
        poly = new ArrayList<>();
    }


    public static Polynomial build(String input) {
        String[] monomialList = input.split("\\s+");
        ArrayList<Monomial> list = new ArrayList<Monomial>();
        //iterates on the list of strings
        int isNeg = 1;
        for (int i = 0; i < monomialList.length; i++) {
            if (monomialList[i].contains("/")) {
                list.add(buildRationalMonomial(monomialList[i].split("/"), i));
            } else {
                list.add(buildIntegerMonomial(monomialList[i], i));
            }
        }
        Polynomial p = new Polynomial();
        p.addList(list);
        return p;

    }

    private void addList(ArrayList<Monomial> list) {
        poly = list;
    }


    public static Monomial buildRationalMonomial(String[] array, int i) {
        int numerator = java.lang.Integer.parseInt(array[0]);
        int denominator = java.lang.Integer.parseInt(array[1]);
        Rational scalar = new Rational(numerator, denominator);
        Monomial mono = new Monomial(i, scalar);
        return mono;
    }

    public static Monomial buildIntegerMonomial(String numAsString, int i) {
        int number = java.lang.Integer.parseInt(numAsString);
        Integer scalar = new Integer(number);
        Monomial mono = new Monomial(i, scalar);
        return mono;
    }

    public Polynomial add(Polynomial p) {
        Polynomial addition = new Polynomial();
        for (int i = 0; i < Math.max(p.poly.size(), poly.size()); i++) {
            Monomial p1 = null, p2 = null;

            if (poly.size() > i) p1 = poly.get(i);//if there is a bug its probably in the indexes
            if (p.poly.size() > i) p2 = p.poly.get(i);

            if (p1 != null && p2 != null) addition.poly.add(p1.add(p2).getExponent(), p1.add(p2));
            else if (p1 != null) {
                addition.poly.add(p1.getExponent(), p1);
            } else {
                addition.poly.add(p2.getExponent(), p2);
            }
        }
        return addition;
    }

    public Polynomial mul(Polynomial p) {//there is a bug
        Polynomial multiply = new Polynomial();
        for (int i = 0; i < this.poly.size(); i++) {//first polynomial
            for (int j = 0; j < p.poly.size(); j++) {//second polynomial
                Monomial multiplication = this.poly.get(i).mult(p.poly.get(j));

                Monomial mono = null;
                try {
                    mono = multiply.poly.get(multiplication.getExponent());
                    multiply.poly.remove(mono.getExponent());
                    multiply.poly.add(multiplication.getExponent(), mono.add(multiplication));
                } catch (Exception e) {
                    multiply.poly.add(multiplication.getExponent(), multiplication);
                }
            }
        }
        return multiply;
    }

    public Scalar evaluate(Scalar s) {
        Scalar sum = new Rational(0, 1);
        for (Monomial p : poly) {
            sum = sum.add(p.evaluate(s));
        }
        return sum;
    }

    public Polynomial derivative() {
        Polynomial derivative = new Polynomial();
        for (Monomial p : this.poly) {
            derivative.poly.add(p.derivative());
        }
        return derivative;
    }

    public String toString() {
        String s = "";
        for (Monomial p : poly) {
            if (p.sign() == 1 && s.length() == 0) s += p.toString();
            else if (p.sign() == 1) s += "+" + p.toString();
            else if (p.sign() == -1) s += p.toString();
        }
        if (s.length() == 0) s = "0";
        return s;
    }


}
