package itqop;

import java.util.Arrays;

public class SecondBlock extends ThirdBlock {
    public static String repeat(String s, int n){
        String[] ass =  s.split("");
        String q = "";
        for (String i : ass){
           for (int j = 0; j<n;j++){
               q += i;
           }
        }
        return q;
    }
    public static int differenceMaxMin(int[] a){
        int max = a[0];
        int min = a[0];
        for (int i : a){
            if (i>max){
                max = i;
            }
            if (i<min){
                min = i;
            }
        }
        return max-min;
    }
    public static boolean isAvgWhole(int[] a){
        boolean boo = false;
        int sum = 0;
        for (int i : a){
            sum += i;
        }
        if (sum % a.length ==0){
            boo = true;
        }
        return boo;
    }
    public static int[] cumulativeSum(int[] a){
        int sum = 0;
        int[] qw = {};

        for (int i : a){
            sum += i;
            qw = addElement(qw,sum);
        }
        return qw;
    }
    public static int getDecimalPlaces(String s){
        int q;
        q = s.indexOf(".");
        if (q==-1){return 0;}
        q = (s.substring(q)).length();
        return q-1;
    }
    public static int Fibonacci(int f){
        int a = 0;
        int b = 1;
        for (int i = 2; i <= f+1; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
    public static boolean isValid(String s){
        boolean boo = true;
        if (s.length() > 5 || s.length() <5 || s.matches("(.*)[^0-9](.*)")){
            boo = false;
        }
        return boo;
    }
    public static boolean isStrangePair(String s1, String s2){
        boolean boo = false;
        int sl1 = s1.length();
        int sl2 = s2.length();
        if (sl1 == 0 || sl2 == 0){
            if (sl1 == sl2){boo = true;}
            return boo;
        }
        if (s1.codePointAt(0) == s2.codePointAt(sl2-1) & s2.codePointAt(0) == s1.codePointAt(sl1-1)){
            boo = true;
        }
        return boo;
    }
    public static boolean isPrefix(String s1, String s2){
        boolean boo = false;
        if (s1.startsWith(s2.substring(0,s2.length()-2))){
            boo = true;
        }
        return boo;
    }
    public static boolean isSuffix(String s1, String s2){
        boolean boo = false;
        if (s1.endsWith(s2.substring(1))){
            boo = true;
        }
        return boo;
    }
    public static int boxSeq(int q){
        if (q%2 == 0){
            return q;
        }else{
           return q+2;
        }

    }
}
