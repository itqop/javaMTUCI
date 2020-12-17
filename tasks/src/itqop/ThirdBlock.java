package itqop;

public class ThirdBlock extends FourthBlock{
    public static int solutions(int a, int b, int c){
        int n = 0;
        if ( b*b - 4*a*c == 0){
            n = 1;
        }
        if ( b*b - 4*a*c > 0){
            n = 2;
        }
        if ( b*b - 4*a*c < 0 || (a == 0 & b == 0)){
            n = 0;
        }
        return n;
    }
    public static int findZip(String s){
        int q = s.indexOf("zip");
        if (q == -1){return (-1);}
        else{
            s = s.replaceFirst("zip","qop");
            return s.indexOf("zip");
        }
    }
    public static boolean checkPerfect(int n){
        boolean boo = false;
        int o = 0;
        for (int i = 1; i < n; i++){
            if (n%i == 0){
                o+=i;
            }
        }
        if (o == n){boo = true;}
        return boo;
    }
    public static String flipEndChars(String s){
        if (s.length()<2){return "Incompatible.";}
        if (s.substring(0,1).codePointAt(0) == s.substring(s.length()-1).codePointAt(0)){return "Two's a pair.";}
        return s.substring(s.length()-1)+s.substring(1,s.length()-1) + s.substring(0,1);
    }
    public static boolean isValidHexCode(String s){
        boolean boo = true;
        if (s.length() != 7){return false;}
        if (s.charAt(0)!='#'){return false;}
        if (s.substring(1).matches("(.*)[^a-fA-F_0-9](.*)")){boo = false;}
        return boo;
    }
    public static boolean same(int[] ar1, int[] ar2){
        boolean boo =false;
        String s1 = " ";
        for (int n : ar1){
            if (!s1.contains((" "+String.valueOf(n)+" "))){
                s1 +=String.valueOf(n)+" ";
            }
        }
        String s2 = " ";
        for (int n : ar2){
            if (!s2.contains((" "+String.valueOf(n)+" "))){
                s2 +=String.valueOf(n)+" ";
            }
        }
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int q1 = 0;
        int q2 = 0;
        for (char q : ss1){
            if (q == ' '){
                q1++;
            }
        }
        for (char q : ss2){
            if (q == ' '){
                q2++;
            }
        }
        if (q1 == q2){boo = true;}
        return boo;
    }
    public static boolean isKaprekar(int n){
        String nn = String.valueOf(n*n);
        if(nn.length() % 2 != 0){nn = "0" + nn;}
        if (Integer.parseInt(nn.substring(0,nn.length()/2)) + Integer.parseInt(nn.substring(nn.length()/2,nn.length())) == n){
            return true;
        }
        return false;

    }
    public static String longestZero(String s){
        s = s + "1";
        char[] ss = s.toCharArray();
        int count = 0;
        int countt = 0;
        boolean boo = false;
        for (char i : ss){
            if (i == '0'){ boo = true; }
            else{boo = false;}
            if(boo){
                count++;
            }else{
                if (count>countt){countt=count; count = 0;}
            }
        }
        String ans = "";
        for (int i = 0; i<countt; i++){
            ans+="0";
        }
        return ans;
    }
    public static int nextPrime(int n){
        int i,j;
        for (i=n;i<n+1000000000;i++)
        {int k=0;
            for (j=2;j<=i;j++)
            {
                if ((i%j) == 0)
                    k++;
            }
            if (k<2){
                return i;
            }
        }
        return 0;
    }
    public static boolean rightTriangle(int a, int b, int c){
        if (a*a == b*b +c*c || b*b == a*a + c*c || c*c == b*b + a*a){return true;}
        return false;
    }


}
