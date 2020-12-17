package itqop;
import java.util.Arrays;
public class FifthBlock extends SixthBlock{
    public static int buggerv2(int n){
        String s = String.valueOf(n);
        char[] ss = s.toCharArray();
        int count = 0;
        int w = 1;
        while (true){
            s = String.valueOf(n);
            ss = s.toCharArray();
            if (s.length() == 1){
                break;
            }
            for (char q : ss){
                w*= Character.getNumericValue(q);;
            }
            n = w;
            w = 1;
        }
        return n;
    }
    public static String encrypt(String s){
        char[] s1 = (s).toCharArray();
        int w = Integer.valueOf(s1[0]);
        int re = 1;
        String p = "";
        p +=w+" ";
        for (char q : s1){
            if(re-->0)continue;
            p += (Integer.valueOf(q) - w)+" ";
            w = Integer.valueOf(q);
        }
        return p;
    }
    public static String decrypt(int[] j){
        String s = "";
        int w = j[0];
        int re = 1;
        int rew = 1;
        s += Character.toString(w);
        for (int i : j){
            if(re-->0)continue;
            rew = w+i;
            s += Character.toString(rew);
            w = rew;
        }
        return s;
    }
    public static boolean canMove(String s1, String s2, String s3){
        boolean Charlotte = false;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        s3  = s3.toLowerCase();
        char[] n = s2.toCharArray();
        char[] k = s3.toCharArray();
        int zn = 0;
        int zk = 0;
        switch (s1){
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
    public static boolean canComplete(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        String q = "";
        int w = 0;
        for (char i : c1) {
            for (int j = w; j<c2.length;j++){
                if (i == c2[j]) {
                    q += i;
                    w = ++j;
                    break;
                }
            }
        }
        if (s1.equals(q)){
            return true;
        }
        return false;
    }
    public static int sumDigProd(int ... n){
        int sum = 0;
        for (int i : n){
            sum +=i;
        }
        sum = buggerv2(sum);
        return sum;
    }
    public static String sameVowelGroup(String[] e){
        char[] w;
        String sorted = "";
        StringBuilder o = new StringBuilder();
        String[] q = e.clone();
        for (int i = 0; i<q.length; i++){
            q[i] = q[i].replaceAll("(.)(?=.*?\\1)", "");
            q[i] = q[i].replaceAll("[^aueouiAUEOIY]{1}","");
            w = q[i].toCharArray();
            Arrays.sort(w);
            sorted = new String(w);
            q[i] = sorted;
        }
        String d = q[0];
        sorted = "";
        for (int i = 0; i<q.length;i++){
            if (d.equals(q[i])){
                sorted+=e[i]+" ";
            }
        }
        return sorted;
    }
    public static boolean validateCard(long q){
        String e = "";
        String r = "";
        e += q;
        char[] w = e.toCharArray();
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
    public static String numToEng(int rawr){
        String g = "";
        int d = 0;
        int h = 0;
        char[] s = {};
        g +=rawr;
        s = g.toCharArray();
        String[] dig = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        String[] dig1 = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] dig2 = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety","hundred"};
        if (rawr <=10){
            g = dig[rawr];
            return g;
        }
        if (rawr == 10 || rawr == 20 || rawr == 30|| rawr == 40|| rawr == 50|| rawr == 60|| rawr == 70|| rawr == 80
                || rawr == 90){
            g = dig2[rawr/10-1];
            return g;
        }
        if (rawr >= 11 & rawr < 20){
            g = dig1[rawr%10-1];
            return g;
        }
        if (rawr > 20 & rawr < 100 & rawr != 10 & rawr != 20 & rawr != 30 & rawr != 40 & rawr != 50
                & rawr != 60 & rawr != 70 & rawr != 80 & rawr != 90){
            g = dig2[rawr/10%10-1] +" "+ dig[rawr%10];
            return g;
        }
        if (rawr == 100 || rawr == 200 || rawr == 300 || rawr == 400 || rawr == 500 || rawr == 600
                || rawr == 700 || rawr == 800 || rawr == 900){
            g = dig[rawr/10/10] + " " + dig2[9];
            return g;
        }
        if (rawr/10%10 == 0){
            g = dig[rawr/10/10] + " " + dig2[9] + " " + dig[rawr%10];
            return g;
        }

        if (s.length==3&rawr%10==0){
            g = dig[rawr/10/10] + " " + dig2[9] + " " + dig2[rawr/10%10-1];
            return g;
        }

        if (s.length==3&rawr%100>10& rawr%100<20){
            g = dig[rawr/10/10] + " " + dig2[9] + " " + dig1[rawr%10-1];
            return g;
        }
        if (rawr > 109 & rawr < 1000 & rawr != 100 & rawr != 200 & rawr != 300 & rawr != 400 & rawr != 500
                & rawr != 600 & rawr != 700 & rawr != 800 & rawr != 900){
            g = dig[rawr/10/10] + " " + dig2[9] + " " + dig2[rawr/10%10-1] + " " + dig[rawr%10] ;
        }
        return g;
    }
    public static String numToRus(int rawr){
        String g = "";
        int d = 0;
        int h = 0;
        char[] s = {};
        g +=rawr;
        s = g.toCharArray();
        String[] dig = {"ноль","один","два","три","четыре","пять","шесть","семь","восемь","девять","десять"};
        String[] dig1 = {"одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать",
                "восемнадцать","девятнадцать"};
        String[] dig2 = {"десять","двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят",
                "девяносто","сто"};
        String[] dig3 = {"сто","двести","тристо","четыресто","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"};
        if (rawr <=10){
            g = dig[rawr];
            return g;
        }
        if (rawr == 10 || rawr == 20 || rawr == 30|| rawr == 40|| rawr == 50|| rawr == 60|| rawr == 70|| rawr == 80
                || rawr == 90){
            g = dig2[rawr/10-1];
            return g;
        }
        if (rawr >= 11 & rawr < 20){
            g = dig1[rawr%10-1];
            return g;
        }
        if (rawr > 20 & rawr < 100 & rawr != 10 & rawr != 20 & rawr != 30 & rawr != 40 & rawr != 50
                & rawr != 60 & rawr != 70 & rawr != 80 & rawr != 90){
            g = dig2[rawr/10%10-1] +" "+ dig[rawr%10];
            return g;
        }
        if (rawr == 100 || rawr == 200 || rawr == 300 || rawr == 400 || rawr == 500 || rawr == 600
                || rawr == 700 || rawr == 800 || rawr == 900){
            g = dig[rawr/10/10] + " " + dig2[9];
            return g;
        }
        if (rawr/10%10 == 0){
            g = dig[rawr/10/10] + " " + dig2[9] + " " + dig[rawr%10];
            return g;
        }

        if (s.length==3&rawr%10==0){
            g = dig3[rawr/10/10-1] + " " + dig2[rawr/10%10-1];
            return g;
        }

        if (s.length==3&rawr%100>10& rawr%100<20){
            g =  dig3[rawr/10/10-1] + " " + dig1[rawr%10-1];
            return g;
        }
        if (rawr > 109 & rawr < 1000 & rawr != 100 & rawr != 200 & rawr != 300 & rawr != 400 & rawr != 500
                & rawr != 600 & rawr != 700 & rawr != 800 & rawr != 900){
            g = dig3[rawr/10/10-1] + " " + dig2[rawr/10%10-1] + " " + dig[rawr%10] ;
        }
        return g;
    }
    public static String getSha256Hash(String s){
        return null;
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

}
