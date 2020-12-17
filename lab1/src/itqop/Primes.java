package itqop;

import java.math.BigInteger;

public class Primes {
    static int var = 2;
    static boolean boo ;
    public static void main(String[] args) {
        for (int i = 1; i<101; i++){
            var = 2;
            checkIsItANaturalNumber(i);
            if (boo){
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
    private static void checkIsItANaturalNumber(int n) {
        if(n>1){
            if (n % var == 0 && var != n){
                boo = false;
                return;
            }else if (var < n/2){
                var++;
                checkIsItANaturalNumber(n);
            }else boo = true;
        }
    }
}
