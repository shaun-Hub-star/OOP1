package PolyMath;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private ArrayList<Monomial> poly;

    public Polynomial(){
        this.poly = new ArrayList<Monomial>();
    }


    public static  Polynomial build(String input){
        String[] monomialList = input.split("\\s+");
        Polynomial poly = new Polynomial();
        //iterates on the list of strings
        int isNeg = 1;
        for(int i = 0; i < monomialList.length;i++){
            if(monomialList[i].contains("/")) {
                poly.add(buildRationalMonomial(monomialList[i].split("/"),i));
            }else{
                poly.add(buildIntegerMonomial(monomialList[i],i));
            }
        }
        return poly;
    }


    public static Monomial buildRationalMonomial(String[] array,int i ){
        int numerator = java.lang.Integer.parseInt(array[0]);
        int denominator = java.lang.Integer.parseInt(array[1]);
        Rational scalar = new Rational(numerator,denominator);
        Monomial mono = new Monomial(i,scalar);
        return mono;
    }

    public static Monomial buildIntegerMonomial(String numAsString,int i ){
        int number = java.lang.Integer.parseInt(numAsString);
        Integer scalar = new Integer(number);
        Monomial mono = new Monomial(i,scalar);
        return mono;
    }


    public Polynomial add(){
        return null;
    }
    public Polynomial mul(){
        return null;
    }
    public Polynomial evaluate(){
        return null;
    }
    public Polynomial derivative(){
        return null;
    }
    public String toString(){
        return null;
    }


}
