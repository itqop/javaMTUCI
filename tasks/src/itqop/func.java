package itqop;
import java.util.Arrays;
public class func {
    //1
    public static int remainder(int var_1, int var_2){
        int n;
        n = var_1 % var_2;
        return n;
    }
    public static int triArea(int var_1, int var_2){
        int n;
        n = (var_1 * var_2)/2;
        return n;
    }
    public static int animals(int var_1, int var_2, int var_3){
        int n;
        int chick = 2;
        int cows = 4;
        int pigs = 4;
        n = ((var_1 * chick)+(var_2 * cows)+(var_3 * pigs));
        return n;
    }
    public static double profitableGamble(double prob, double prize, double pay){

        if (prob * prize > pay){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        return(0);
    }
    public static int operation(int N, int a, int b){

        if (a + b == N){
            System.out.println("Added");
        }
        if (a * b == N){
            System.out.println("Miltiply");
        }
        if (a - b == N){
            System.out.println("subtracted");
        }
        if (a / b == N){
            System.out.println("Dev");
        }
        if (a + b != N & a * b !=N & a - b != N & a / b != N){
            System.out.println("None");
        }
        return(0);
    }
    public static double ctoa(char m){
            System.out.println((int)m);
        return(0);
    }
    public static int addUpTo(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++) {
            result = result * i;
        }
        return(result);
    }
    public static int nextEdge(int a,int b){
        int n;
        n = a+b-1;
        return(n);
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
    public static int abcmath(int a,int b,int c){
        int r=0;
        int i=0;
        while(i < b){
            a = a + a;
            i++;
        }
        if(a/c==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        return(a);
    }
    //2
    public static String repeat(String x, int g){
        int k=0;
        String[] h = x.split("");
        String c = "";
        for (String l : h) {
            for (int i = 0; i < g; i++) {
                c += l;

            }
        }
        return(c);
    }
    public static int different(int x[]){
        int max =-100000;
        int j;
        int min = 100000;
        for(int i =0; i < x.length;i++){
            if (x[i] > max) {
                max = x[i];
            }
        }
        for(int i =0; i < x.length;i++){
            if (x[i] < min) {
                min = x[i];
            }
        }
        j = max - min;
        return(j);
    }
    public static boolean isAvgWhole(int x[]){
        int max =-100000;
        int k=0;
        int j=0;
        boolean boo = false;
        int min = 100000;
        for(int i =0; i < x.length;i++){
            j = j + x[i];
            k++;
        }
        j = j / k;
        if(j/2==0){
            boo = true;
        }
        return(boo);
    }
    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
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
    public static int getDecimalPlaces(String a){
        int q;
        q = a.indexOf(".");
        if (q == -1){
            return 0;
        }
        q = (a.substring(q).length());
        return q-1;
    }
    public static int Fibonacci(int q){
        int a = 0;
        int b = 1;
        for (int i = 2; i <= q+1; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
    public static boolean isValid(String q){
        boolean r = false;
        char[] result = q.toCharArray();
        if(result.length == 5){
            for ( int i =0; i < result.length;i++){
                if(result[i]>=0 || result[i] <=9){
                    r = true;
                }
            }
        }
        return r;
    }
    public static boolean isStrangePair(String q, String w){

        boolean r = false;

        char[] result = q.toCharArray();
        char[] result2 = w.toCharArray();

        int g = result2.length;
        int f = result.length;

        if ( g == 0 || f == 0){
            if ( g == f ){
                r = true;
            } return r;
        }

        if(result[0] == result2[g-1] & result[f-1] == result2[0]){
            r = true;
        }

        return r;
    }
    public static boolean isPrefix(String q, String w){
        boolean r = false;
        String we;
        we = w.substring(0,w.length()-2);
        if (q.startsWith(we)){
            r = true;
        }
        return r;
    }
    public static boolean isSuffix(String q, String w){
        boolean r = false;
        String we;
        we = w.substring(1);
        if (q.endsWith(we)){
            r = true;
        }
        return r;
    }
    public static int boxSeq(int a){
        if (a%2==0){
            return a;
        }else {
            return a+2;
        }
    }
    //3
    public static int solutions(int a, int b,int c){
        int n = 0;
        if(a == 0 & b == 0){
            n = 0;
            return n;
        }
        if ( b*b - 4*a*c == 0){
            n = 1;
        }
        if ( b*b - 4*a*c > 0){
            n = 2;
        }
        if ( b*b - 4*a*c < 0){
            n = 0;
        }

        return n;
    }
    public static int findZip(String x){
        int f;
        int g;
        int j =0 ;
        String h;
        char[] result = x.toCharArray();
        f = x.indexOf("zip");
        f = f + 3;
        h = x.substring(f);
        g = h.indexOf("zip");
        if (g == -1){
            return -1;
        }
        j=g+f;
        return j;

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
    public static String flipEndChars(String s) {
        char[] result = s.toCharArray();
        int f = s.length();
        String F = "";
        if (s.length() < 2) {
            return "Incompatible.";
        }
        if (result[0] == result[f - 1]) {
            return "Two's a pair.";
        }
        if (result[0] != result[f - 1]) {
            F = s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
        }
        return (F);
    }
    public static boolean isValidHexCode(String s){
        boolean boo = true;
        char[] result = s.toCharArray();

        if (s.charAt(0) != '#' || s.length() != 7) {
            boo = false;
        }
        if (s.matches("(.)[^a-fA-F_0-9](.)")){
            boo = false;
            }
        return boo;
    }
    public static boolean arrUnic(int[] ar1, int[] ar2){
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
    public static boolean isKaprekar(int n) {

        String nn = String.valueOf(n * n);
        if (nn.length() % 2 != 0) {
            nn = "0" + nn;
        }
        if (Integer.parseInt(nn.substring(0, nn.length() / 2)) + Integer.parseInt(nn.substring(nn.length() / 2, nn.length())) == n) {
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
        for (i=n;i<n + 1000000000;i++)
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
    public static boolean rightTriangle(int a,int b,int c) {
        boolean g = false;
        if (c * c == a * a + b * b || a * a == c * c + b * b || b * b == a * a + c * c) {

        g = true;
    }
        else{
            g = false;
        }

        return g;
    }
    //4
    public static String text(String s) {
        String[] ss = s.split(" ");
        int k = Integer.parseInt(ss[0].substring(ss[0].indexOf(",") + 1));
        String ass = "";
        int count = 0;
        int op = 1;
        for (String q : ss) {
            if (op-- > 0) continue;
            if (count + q.length() <= k) {
                ass += q + " ";
                count += q.length();
            } else {
                count = 0;
                ass += "\n";
                ass += q + " ";
                count += q.length();
            }
        }
        return ass;
    }
    public static StringBuilder split(String d){
        int k = 0 ;
        int g = 0;
        String a="";
        StringBuilder KitTiMamyMav = new StringBuilder();
        char[] result = d.toCharArray();
        for (int i = 0;i < result.length;i++){
            if(result[i] == '('){
                k++;
                a+=result[i];
            }
            if(result[i] == ')'){
                g++;
                a+=result[i];
                if(k == g){
                    a = " " + a + " ";
                    KitTiMamyMav.append(a);
                    k = 0;
                    g = 0;
                    a = "";
                }
            }
        }
        return KitTiMamyMav;
    }
    public static String toCamelCase(String d){
        String f = "";
        String g = "";
        String a = d;
        String v = "";
        int s;
        int k = 1;
        while (k == 1){

            s = a.indexOf("_");
            f = a.substring(0,s-1);
            g = a.substring(s+1);
            v = a.substring(s+1,s+2);
            String Str = new String(v);
            Str = Str.toUpperCase();
            g = a.substring(s+2);
            g = Str + g;
            a = "";
            a = a + f + g;
            s = 0;
            g = "";
            f = "";
            if (a.contains("_") == false){
                k = 0;
            }

        }
        return a;
    }
    public static String toSnakeCase(String d){
        String f = "";
        String g = "";
        String a = d;
        char[] result = a.toCharArray();
        String v = "";
        int s;
        int k = 1;
        for (int i = 0;i < a.length();i++){
            v += result[i];
            if("ZXCVBNMASDFGHJKLQWERTYUIOP".contains(v)){
                   f +="_" + v.toLowerCase();
                   v = "";
                   continue;
            }
            v = "";
            f += result[i];

        }

        return f;
    }
    public static String overTime(double[] arr){
        String p = "";
        double h = 0;
        double ss = 0;
        double k = 0;
        double o = 0;
        double per = 0;
        double z = 0;
        ss = arr[0];
        k = arr[1];
        o = arr[2];
        per = arr[3];
        if (k == 17.0){
            h = (k - ss) * o;
            p += "$" + h;
        }
        if (k > 17.0){
            h = (k-ss-1) * o * per;
            z = (k-ss-1) * o;
            z = z+h;
            p += "$" + z;
        }
        return p;
    }
    public static String BMT(String ves,String rost) {
        String p = "";
        double funt = 0;
        double kg = 0;
        double metr = 0;
        double dd = 0;
        double res = 0;
        String ow = "Overweight";
        String nw = "Normal weight";
        String uw = "Underweight";
        if (ves.contains("pounds") == true) {
            int t = ves.indexOf("pounds");
            p = ves.substring(0, t);
            funt = Double.parseDouble(p);
            funt = funt / 2.205;
        }

        if (rost.contains("inches") == true) {
            int t = rost.indexOf("inches");
            p = rost.substring(0, t);
            dd = Double.parseDouble(p);
            dd = dd / 39.37;
        }

        if (ves.contains("kilos") == true) {
            int t = ves.indexOf("kilos");
            p = ves.substring(0, t);
            kg = Double.parseDouble(p);
        }

        if (rost.contains("meters") == true) {
            int t = rost.indexOf("meters");
            p = rost.substring(0, t);
            metr = Double.parseDouble(p);
        }
        if (ves.contains("pounds") == true & rost.contains("inches") == true) {
            res = funt / (dd * dd);
            p += funt / (dd * dd);
        }
        if (ves.contains("pounds") == true & rost.contains("meters") == true) {
            res = funt / (metr * metr);
            p += funt / (metr * metr);
        }
        if (ves.contains("kilos") == true & rost.contains("meters") == true) {
            res = kg / (metr * metr);
            p += kg / (metr * metr);
        }
        if (ves.contains("kilos") == true & rost.contains("inches") == true) {
            res = kg / (dd * dd);
            p += kg / (dd * dd);
        }
        if (res < 18.5) {
            p = String.format("%.1f", res);
            p = p + " " + uw;
        }
        if (res > 18.5 & res < 24.9) {
            p = String.format("%.1f", res);
            p = p + " " + nw;
        }
        if (res > 25) {
            p = String.format("%.1f", res);
            p = p + " " + ow;
        }
        return p;
    }
    public static int bugger(int s){
        int k = 0;
        int z = 1;
        int f = 1;
        int nat = 0;
        String n = String.valueOf(s);
        char[] ss = n.toCharArray();
        while(z==1){
            for (int i=0;i<ss.length;i++){
                nat = Character.getNumericValue(ss[i]);
                f *= nat;
            }
            ss = Integer.toString(f).toCharArray();
            f = 1;
            k++;
            if (ss.length == 1){
                z = 0;
            }

        }
        if (ss.length == 1 & k == 1){
            k =0;
        }
        return k;
    }
    public static String toStarShorthand(String s){
        String f = "";
        String h = "";
        int k = 1;
        s = s + " ";
        char[] result = s.toCharArray();
        char g = result[0];
        for (int i = 1; i<result.length;i++){
            if( g == result[i]){
                k++;
            }else {
                if (k == 1){
                    f += g;
                }else {
                    h = String.valueOf(k);
                    f += g + "*" + h;
                    k = 1;
                }
                g = result[i];
            }
        }
        return f;
    }
    public static boolean doesRhyme(String s, String q){
        boolean g = false;
        String f = "";
        String j = "";
        char v;
        String lastWord = s.substring(s.lastIndexOf(" ")+1);
        String lastWord2 = q.substring(q.lastIndexOf(" ")+1);
        char[] result1 = lastWord.toCharArray();
        char[] result2 = lastWord2.toCharArray();
        for (int i = 0;i < result1.length;i++){
            v = result1[i];
            v = Character.toLowerCase(v);
            lastWord = "";
            lastWord += v;
            if("aeyuio".contains(lastWord)){
                f = f + lastWord;
            }
        }
        for (int i = 0;i < result2.length;i++){
            v = result2[i];
            v = Character.toLowerCase(v);
            lastWord2 = "";
            lastWord2 += v;
            if("aeyuio".contains(lastWord2)){
                j = j + lastWord2;
            }
        }
        if (j.equals(f)){
            g = true;
        }
        return g;
    }
    public static boolean trouble(long n1, long n2){
        char[] s1 = (String.valueOf(n1)+" ").toCharArray();
        char[] s2 = (String.valueOf(n2)+" ").toCharArray();
        int c1 = 1;
        int c2 = 0;
        char w = s1[0] ;
        char per;
        for (int i = 1; i<s1.length; i++){
            if(w == s1[i]){
                c1++;
            }else{
                if (c1 == 3){
                    break;
                }
                w = s1[i];
            }
        }
        if (c1 != 3){
            return false;
        }
        for (int i = 1; i<s2.length; i++){
            if(w == s2[i]){
                c2++;
            }else{
                if (c2 == 2){
                    return true;
                }
            }
        }
        return false;
    }
    public static int countUniqueBooks(String s, char c){
        String cc ="";
        String q = "";
        cc+=c;
        char[] s1 = (s).toCharArray();
        String vr = "";
        boolean open = false;
        String ww = "";
        for (char w : s1){
            ww +=w;
            if ((ww.equals(cc)) & open){
                open = false;
                if (vr.length()>0){
                    // ass.append(vr);
                    q+=vr;
                }
                vr = "";
                ww = "";
                continue;
            }
            if ((ww.equals(cc))& !open){
                open = true;
                ww = "";
                continue;
            }
            if (open){
                vr += w;
            }
            ww = "";
        }
        return q.replaceAll("(.)(?=.*?\\1)", "").length();
    }
    //5
    public static String encrypt(String s){
        char[] Charlotte = s.toCharArray();
        String hentai = "";
        int z = Integer.valueOf(Charlotte[0]);
        hentai += z;
        int n = 0;
        for (int i = 1;i < Charlotte.length;i++){
            n = Integer.valueOf(Charlotte[i]);
            z = n - z;
            hentai += ","+ z;
            z = n;
        }
        return hentai;
    }
    public static String decrypt(int[] charlotte){
        String hentai="";
        hentai = Character.toString(charlotte[0]);
        String n = "";
        int z = 0;
        z = charlotte[0];
        for (int i = 1;i < charlotte.length;i++){
            z = z + charlotte[i];
            n = Character.toString(z);
            hentai = hentai + n;
        }
        return hentai;
    }
    public static Boolean canMove(String a, String b, String c){
        boolean Charlotte = false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        c = c.toLowerCase();
        char[] n = b.toCharArray();
        char[] k = c.toCharArray();
        int zn = 0;
        int zk = 0;
        switch (a){
            case "pawn":
                if(n[0] == k[0] & (k[1]-n[1]==2 || k[1]-n[1]==-2)){
                    Charlotte = true;
                }
                break;
            case "knight":
                zn = Integer.valueOf(n[0]);
                zk = Integer.valueOf(k[0]);
                if(zk > zn & zk < zn+2 & (k[1]-n[1]==2 || k[1]-n[1]==-2) || zk < zn & zk > zn-2 &
                        (k[1]-n[1]==2 || k[1]-n[1]==-2)){
                    Charlotte = true;
                }
                if((zk - zn == 2 || zk - zn == -2) & (k[1]-n[1]==1 || k[1]-n[1]==-1)){
                    Charlotte = true;
                }
                break;
            case "queen":
                zn = Integer.valueOf(n[0]);
                zk = Integer.valueOf(k[0]);
                if (k[1] == n[1] & zn != zk || k[1] != n[1] & zn == zk){
                    Charlotte = true;
                }
                if (n[1]-k[1] == zn - zk || k[1]-n[1]== zk-zn||n[1]-k[1] == zk - zn || k[1]-n[1]== zn-zk){
                    Charlotte = true;
                }
                break;
            case "bishop":
                zn = Integer.valueOf(n[0]);
                zk = Integer.valueOf(k[0]);
                if (n[1]-k[1] == zn - zk || k[1]-n[1]== zk-zn || n[1]-k[1] == zk - zn || k[1]-n[1]== zn-zk){
                    Charlotte = true;
                }
                break;
            case "rook":
                zn = Integer.valueOf(n[0]);
                zk = Integer.valueOf(k[0]);
                if (k[1] == n[1] & zn != zk || k[1] != n[1] & zn == zk){
                    Charlotte = true;
                }
                break;
            case "king":
                zn = Integer.valueOf(n[0]);
                zk = Integer.valueOf(k[0]);
                if (k[1] == n[1] & (zk == zn -1 || zk == zn + 1)  || ( k[1] == n[1]-1 || k[1] == n[1] +1 ) & zn == zk){
                    Charlotte = true;
                }
                if (n[1]-k[1] == zn - zk & (n[1] - k[1] == 1 || k[1]-n[1]==1)
                        || k[1]-n[1] == zk-zn & (n[1] - k[1] == 1 || k[1]-n[1]==1)
                        || n[1]-k[1] == zk - zn & (n[1] - k[1] == 1 || k[1]-n[1]==1)
                        || k[1]-n[1]== zn-zk & (n[1] - k[1] == 1 || k[1]-n[1]==1) ){
                    Charlotte = true;
                }
                break;
        }
        return Charlotte;

    }
    public static boolean canComplete(String a,String b){
        boolean Charlotte = false;
        char[] n = a.toCharArray();
        char[] k = b.toCharArray();
        int q = 0;
        String f = "";
        for(int i = 0;i<n.length;i++){
            for(int h = q ;h<k.length;h++){
                if(n[i]==k[h]){
                    f += k[h];
                    q = h;
                    break;
                }
            }
        }
        if (f.equals(a)){
            Charlotte = true;
        }
        return Charlotte;
    }
    static public char[] sumDigProd(int ... s){
        int hentai =0;
        for(int i = 0;i<s.length;i++){
            hentai = hentai+ s[i];
        }

        int k = 0;
        int z = 1;
        int f = 1;
        int nat = 0;
        String n = String.valueOf(hentai);
        char[] ss = n.toCharArray();
        while(z==1){
            for (int i=0;i<ss.length;i++){
                nat = Character.getNumericValue(ss[i]);
                f *= nat;
            }
            ss = Integer.toString(f).toCharArray();
            f = 1;
            k++;
            if (ss.length == 1){
                z = 0;
            }

        }
        if (ss.length == 1 & k == 1){
            k =0;
        }
        return ss;
    }
    public static String sameVowelGroup(String[] hentai){
        char[] w;
        String Charlotte = "";
        StringBuilder o = new StringBuilder();
        String[] q = hentai.clone();
        for (int i = 0; i<q.length; i++){
            q[i] = q[i].replaceAll("(.)(?=.*?\1)", "");
            q[i] = q[i].replaceAll("[^aueouiAUEOIY]{1}","");
            w = q[i].toCharArray();
            Arrays.sort(w);
            Charlotte = new String(w);
            q[i] = Charlotte;
        }
        String d = q[0];
        Charlotte = "";
        for (int i = 0; i<q.length;i++){
            if (d.equals(q[i])){
                Charlotte+=hentai[i]+" ";
            }
        }
        return Charlotte;
    }
    public static boolean validateCard(long hentai){
        String Charlotte = "";
        String r = "";
        Charlotte += hentai;
        char[] w = Charlotte.toCharArray();
        char[] w1 = Arrays.copyOf(w,w.length-1);
        r+= w[ w.length-1];
        int check =Integer.parseInt(r); // 1
        int j = 0;
        for (int i = w.length-2;i>=0;i--){
            w1[j++] = w[i];
        } //2
        int sum = 0;
        for (int i = 0; i<w1.length;i++){
            if (i%2 != 0){sum +=Integer.parseInt(String.valueOf(w1[i])); continue;}
            j = Integer.parseInt(String.valueOf(w1[i]))*2;
            j = j%10 + j/10%10;
            w[i] = Character.forDigit(j,10);
            sum +=j;
        }
        sum = 10 - sum%10;
        if (sum == check){
            return true;
        }
        return false;
    }
    public static String correctTitle(String s){
        String[] f = {};
        String g="";
        String o = "";
        String v = "";
        char[] q ={};
        s = s.toLowerCase();
        for (int i=0;i<s.length();i++){
            f = s.split(" ");
        }
        for(int h = 0;h<f.length;h++){
            q = f[h].toCharArray();
            if(!f[h].equals("in") && !f[h].equals("the") && !f[h].equals("on") && !f[h].equals("and")) {
                o += q[0];
                q[0] = Character.toUpperCase(q[0]);
            }
            g += String.valueOf(q) + " ";
        }
        return g;
    }
    public static String hexLattice(int n){
        double t = 0;
        int k = 0;
        while (n>t){
            k++;
            t = 1 + 6*(0.5 * k*(k-1));

        }
        if (n != t){
            return "Invalid";
        }
        int how;
        int prob;
        String hex = "";
        for (int i = 0; i< 2*k-1; i++){
            if(i<k){
                how = k+i;
                prob = k-i;
            }else{
                how = k +2*k-2-i;
                prob= i-k+2;
            }
            for(int ll = 0; ll<prob;ll++){
                hex+=" ";
            }
            for(int ll = 0; ll<2*how-1;ll++){
                if (ll%2==0){
                    hex+="o";
                }else{
                    hex+=" ";
                }
            }
            for(int ll = 0; ll<prob;ll++){
                hex+=" ";
            }
            hex+="\n";
        }
        return hex;
    }
    public static String numToEng(int hentai){
        String g = "";
        int d = 0;
        int h = 0;
        char[] s = {};
        g +=hentai;
        s = g.toCharArray();
        String[] dig = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        String[] dig1 = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] dig2 = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","hundred"};
        if (hentai <=10){
            g = dig[hentai];
            return g;
        }
        if (hentai == 10 || hentai == 20 || hentai == 30|| hentai == 40|| hentai == 50|| hentai == 60|| hentai == 70|| hentai == 80
                || hentai == 90){
            g = dig2[hentai/10-1];
            return g;
        }
        if (hentai >= 11 & hentai < 20){
            g = dig1[hentai%10-1];
            return g;
        }
        if (hentai > 20 & hentai < 100 & hentai != 10 & hentai != 20 & hentai != 30 & hentai != 40 & hentai != 50
                & hentai != 60 & hentai != 70 & hentai != 80 & hentai != 90){
            g = dig2[hentai/10%10-1] +" "+ dig[hentai%10];
            return g;
        }
        if (hentai == 100 || hentai == 200 || hentai == 300 || hentai == 400 || hentai == 500 || hentai == 600
                || hentai == 700 || hentai == 800 || hentai == 900){
            g = dig[hentai/10/10] + " " + dig2[9];
            return g;
        }
        if (hentai/10%10 == 0){
            g = dig[hentai/10/10] + " " + dig2[9] + " " + dig[hentai%10];
            return g;
        }

        if (s.length==3&hentai%10==0){
            g = dig[hentai/10/10] + " " + dig2[9] + " " + dig2[hentai/10%10-1];
            return g;
        }

        if (s.length==3&hentai%100>10& hentai%100<20){
            g = dig[hentai/10/10] + " " + dig2[9] + " " + dig1[hentai%10-1];
            return g;
        }
        if (hentai > 109 & hentai < 1000 & hentai != 100 & hentai != 200 & hentai != 300 & hentai != 400 & hentai != 500
                & hentai != 600 & hentai != 700 & hentai != 800 & hentai != 900){
            g = dig[hentai/10/10] + " " + dig2[9] + " " + dig2[hentai/10%10-1] + " " + dig[hentai%10] ;
        }
        return g;
    }
    public static String numToRus(int hentai){
        String g = "";
        int d = 0;
        int h = 0;
        char[] s = {};
        g +=hentai;
        s = g.toCharArray();
        String[] dig = {"ноль","один","два","три","четыре","пять","шесть","семь","восемь","девять","десять"};
        String[] dig1 = {"одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать",
                "восемнадцать","девятнадцать"};
        String[] dig2 = {"десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят",
                "девяносто","сто"};
        String[] dig3 = {"сто","двести","тристо","четыресто","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"};
        if (hentai <=10){
            g = dig[hentai];
            return g;
        }
        if (hentai == 10 || hentai == 20 || hentai == 30|| hentai == 40|| hentai == 50|| hentai == 60|| hentai == 70|| hentai == 80
                || hentai == 90){
            g = dig2[hentai/10-1];
            return g;
        }
        if (hentai >= 11 & hentai < 20){
            g = dig1[hentai%10-1];
            return g;
        }
        if (hentai > 20 & hentai < 100 & hentai != 10 & hentai != 20 & hentai != 30 & hentai != 40 & hentai != 50
                & hentai != 60 & hentai != 70 & hentai != 80 & hentai != 90){
            g = dig2[hentai/10%10-1] +" "+ dig[hentai%10];
            return g;
        }
        if (hentai == 100 || hentai == 200 || hentai == 300 || hentai == 400 || hentai == 500 || hentai == 600
                || hentai == 700 || hentai == 800 || hentai == 900){
            g = dig[hentai/10/10] + " " + dig2[9];
            return g;
        }
        if (hentai/10%10 == 0){
            g = dig[hentai/10/10] + " " + dig2[9] + " " + dig[hentai%10];
            return g;
        }

        if (s.length==3&hentai%10==0){
            g = dig3[hentai/10/10-1] + " " + dig2[hentai/10%10-1];
            return g;
        }

        if (s.length==3&hentai%100>10& hentai%100<20){
            g =  dig3[hentai/10/10-1] + " " + dig1[hentai%10-1];
            return g;
        }
        if (hentai > 109 & hentai < 1000 & hentai != 100 & hentai != 200 & hentai != 300 & hentai != 400 & hentai != 500
                & hentai != 600 & hentai != 700 & hentai != 800 & hentai != 900){
            g = dig3[hentai/10/10-1] + " " + dig2[hentai/10%10-1] + " " + dig[hentai%10] ;
        }
        return g;
    }
    //6

}

