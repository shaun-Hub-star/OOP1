package PolyMath;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private ArrayList<Monomial> poly;
    public static  Polynomial build(String input){
        String[] monomialList = input.split("\\s+");
        //iterates on the list of strings
        for(int i = 0; i < monomialList.length;i++){
            int k = 0;
            //evaluates the string's value in a certain possition in the array
            if(monomialList[i].charAt(0) == )
            for(int l = 0; l < monomialList[i].length(); l++){
                k = k* 10 + monomialList[i].charAt(l);
            }
        }
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

    }


}
