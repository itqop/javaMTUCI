package itqop;

public class FourthBlock extends FifthBlock{
    public static String bala(String s){
        String[] ss = s.split(" ");
        int k = Integer.parseInt(ss[0].substring(ss[0].indexOf(",")+1));
        String ass = "";
        int count = 0;
        int op = 1;
        for (String q : ss){
            if (op-->0)continue;
            if (count + q.length() <= k){
                ass += q+" ";
                count += q.length();
            }else{
                count = 0;
                ass+="\n";
                ass += q+" ";
                count += q.length();
            }
        }
        return ass;
    }
    public static StringBuilder split(String s){
        StringBuilder ass = new StringBuilder();
        char[] ss = s.toCharArray();
        int counto = 0;
        int countc = 0;
        String sd = "";
        for (char q : ss){
            if (q == '('){
                counto++;
                sd+=q;
            }
            if (q == ')'){
                countc++;
                sd+=q;
                if (countc == counto){
                    sd = " " + sd + " ";
                    ass.append(sd);
                    countc = 0;
                    counto = 0;
                    sd ="";
                }
            }
        }
        return ass;
    }
    public static String toCamelCase(String s){
        String ass = "";
        String a = "";
        char[] ss = s.toCharArray();
        boolean boo = false;
        for (char q : ss){
            if(q >= 'a' & q <= 'z'){
                if (boo){
                    a +=q;
                    ass += a.toUpperCase();
                    boo = false;
                    a = "";
                    continue;
                }
                ass+=q;
            }else{
                boo = true;
            }
        }
        return ass;
    }
    public static String toSnakeCase(String s){
        String ass = "";
        String a = "";
        char[] ss = s.toCharArray();
        boolean boo = false;
        for (char q : ss){
            if(q >= 'a' & q <= 'z'){
                ass+=q;
            }
            if (q>='A' & q<='Z'){
                a+=q;
                ass += "_"+ a.toLowerCase();
                a = "";
            }
        }
        return ass;
    }
    public static int bugger(int n){
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
            count++;
        }
        return count;
    }
    public static String overTime(double[] d){
        if (d[1]<=17 & d[0]>=9){
            return "$"+ String.format("%.2f",((d[1]-d[0]) * d[2]));
        }
        if (d[1]<=17 & d[0]<9){
            return "$"+ String.format("%.2f",((d[1]-9) * d[2] + (9-d[0])*d[2]*d[3]));
        }
        if (d[1]>17 & d[0]>=9){
            return "$"+ String.format("%.2f",((17-d[0]) * d[2] + (d[1]-17)*d[2]*d[3]));
        }
        if (d[1]>17 & d[0]<9){
            return "$"+ String.format("%.2f",((17-9) * d[2] + (d[1]-17 + 9-d[0] )*d[2]*d[3]));
        }
        return "";
    }
    public static String BMI(String s1, String s2){
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        double kg = 0;
        double m = 0;
        if (s1.contains("pounds")){
            kg = Double.parseDouble(ss1[0]) / 2.205;
        }else{
            kg = Double.parseDouble(ss1[0]);
        }
        if (s2.contains("inches")){
            m = Double.parseDouble(ss2[0]) /  39.37;
        }else{
            m = Double.parseDouble(ss2[0]);
        }
        String.format("%.1f", kg / (m*m));
        kg = kg / (m*m);
        if (kg<18.5){
            s1 = String.format("%.1f",kg) + " Underweight";
        }
        if (kg>=18.5 & kg <25){
            s1 = String.format("%.1f",kg)+" Normal weight";
        }
        if (kg>=25){
            s1 = String.format("%.1f",kg)+" Overweight";
        }
        return s1;
    }
    public static String toStarShorthand(String s){
        s += " ";
        char[] ss = s.toCharArray();
        int count = 1;
        String ass = "";
        char w = ss[0];
        int er = 1;
        for (char q : ss){
            if (er-->0){ continue; }
            if (q == w){
                count++;
            }else{
                if(count == 1){
                    ass += w;
                }else{
                    ass += w +"*"+ String.valueOf(count);
                }
                count = 1;
                w = q;
            }
        }
        return ass;
    }
    public static boolean doesRhyme(String s1, String s2){
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        s1 = ss1[ss1.length-1];
        s2 = ss2[ss2.length-1];
        String al = "AUEOYI";
        int[] b1 = {0,0,0,0,0,0};
        int[] b2 = {0,0,0,0,0,0};
        s1 = s1.replaceAll("[^aueouiAUEOIY]{1}","").toLowerCase();
        s2 = s2.replaceAll("[^aueouiAUEOIY]{1}","").toLowerCase();
        if (s1.equals(s2)){
            return true;
        }
        return false;
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
       // StringBuilder ass = new StringBuilder();
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
}
