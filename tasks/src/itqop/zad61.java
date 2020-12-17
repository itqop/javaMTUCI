package itqop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class zad61 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число: ");
        int n = Integer.parseInt(reader.readLine());
        possiblePartitions(n);
    }
    public static void possiblePartitions(int n){
        int sum = 1;
        for (int i = 2; i <= n; i++){
            sum += factF(n, i);
        }
        System.out.print("Число Белла: " + sum);
    }
    public static int factF(int n, int k){
        return (fact(n))/(fact(k) * fact(n - k));
    }
    public static int fact(int n){
        int mult = 1;
        if (n == 0 || n == 1)
            return mult;
        else{
            for (int i = 1; i <= n; i++)
                mult *= i;
        }
        return mult;
    }
}
