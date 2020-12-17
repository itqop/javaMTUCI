package itqop;
public class FirstBlock extends SecondBlock{
    public static int remainder(int a, int b){
        return a%b;
    }
    public static int triArea(int var_1, int var_2){
        return (var_1 * var_2)/2;
    }
    public static int animals(int var_1, int var_2, int var_3){
        int n;
        int chick = 2;
        int cows = 4;
        int pigs = 4;
        n = ((var_1 * chick)+(var_2 * cows)+(var_3 * pigs));
        return n;
    }
    public static boolean profitableGamble(double prob, double prize, double pay){
        if (prob * prize > pay){
            return true;
        }else{
            return false;
        }
    }
    public static String operation(int N, int a, int b){
        if (a + b == N){
            return "Added";
        }
        if (a * b == N){
            return "Miltiply";
        }
        if (a - b == N){
            return "subtracted";
        }
        if (a / b == N){
            return "Dev";
        }
        else{
            return "None";
        }
    }
    public static int ctoa(char m){
        return (int)m;
    }
    public static int addUpTo(int n){
        int result = 0;
        for (int i = 1; i <=n; i ++) {
            result = result + i;
        }
        return(result);
    }
    public static double nextEdge(int a,int b){
        return Math.sqrt(a*a + b*b);
    }
    public static int sumOfCubes(int x[]) {
        int sum=0;
        int v;
        for(int i=0; i<x.length; i++) {
            v = x[i] * x[i] * x[i];
            sum=sum+v;
        }
        return(sum);
    }
    public static boolean abcmath(int a,int b,int c){
        int r=0;
        int i=0;
        while(i < b){
            a = a + a;
            i++;
        }
        if(a%c==0){
            return true;
        }else{
            return false;
        }
    }
}
