package itqop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SixthBlock {
    public static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
    public static String translateWord(String a) {
        String ext = "";
        String firststring = "";
        String secondstring = "";
        char[] A = a.toCharArray();
        char[] glassnie = {
                'A',
                'E',
                'I',
                'O',
                'U',
                'Y',
                'a',
                'e',
                'i',
                'o',
                'u',
                'y'
        };
        int pos = -1;
        if (a.length() > 0) {
            if (pos == -1) { // от сюда до 1171 строки поиск первой гласной буквы в слове
                for (int i = 0; i < A.length; i++) {
                    for (int b = 0; b < glassnie.length; b++) {
                        if (A[i] == glassnie[b]) {
                            pos = i;
                        }
                    }
                    if (pos != -1) {
                        break;
                    }
                }

            }
            firststring = a.substring(0, pos); // разбиение слова на 2 от начала до гласной и от гласной до конца
            secondstring = a.substring(pos, a.length()); // 2 часть слова
            pos = -1;
            for (int b = 0; b < glassnie.length; b++) { // соединение слова если первая буква согласная
                if (A[0] != glassnie[b]) {
                    ext = secondstring + firststring + "ay";
                    break;
                }
            }
            for (int n = 0; n < glassnie.length; n++) { // соединение слова если первая буква гласная
                if (A[0] == glassnie[n]) {
                    ext = a + "yay";
                    break;
                }
            }
        } else {
            ext = " ";
        }
        return ext;
    }
    public static String translateSentence(String n){
        String ext = "";
        String[] h = n.split(" "); // разбиение предложения на слова
        for (int i=0;i<h.length;i++){ // применяем функцию перевода слова
            ext += translateWord(h[i]) + " ";
        }
        return ext;
    }
    public static String correctTitle(String s) {
        String[] f = {};
        String g = "";
        String o = "";
        String v = "";
        char[] q = {};
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            f = s.split(" ");
        }
        for (int h = 0; h < f.length; h++) {
            q = f[h].toCharArray();
            if (!f[h].equals("in") && !f[h].equals("the") && !f[h].equals("on") && !f[h].equals("and")) {
                o += q[0];
                q[0] = Character.toUpperCase(q[0]);
            }
            g += String.valueOf(q) + " ";
        }
        return g;
    }
    public static boolean validColor(String a) {
        boolean q = false;
        String format = "";
        String str = "";
        String[] colorIndex = {};
        int r = -3;
        int b = -3;
        int g = -3;
        double A = -3;
        char[] n = a.toCharArray();
        if (a.indexOf('(') == 3) { // определение формата
            for (int i = 0; i <= 2; i++) {
                format = format + n[i];
            }
        } else {
            for (int i = 0; i <= 3; i++) {
                format = format + n[i];
            }
        }
        format = format.toLowerCase(); // нижний регистр названию
        if (format.equals("rgb")) {
            str = a.substring(a.indexOf('(')+1,a.indexOf(')')); // определение только цифр
            str = str.replace(" ","");
            colorIndex = str.split(","); // разбиение цифр
            if(colorIndex[0].equals("") || colorIndex[1].equals("") || colorIndex[2].equals("")){
                q = false;
            }else {
                r = Integer.parseInt(colorIndex[0]);  // распределение цифр
                g = Integer.parseInt(colorIndex[1]);
                b = Integer.parseInt(colorIndex[2]);
            }
            if ((r < 226 && g < 226 && b < 226) && (r > -1 && g > -1 && b > -1)) { // проверка на валидность
                q = true;
            }
        }
        if (format.equals("rgba")){
            str = a.substring(a.indexOf('(')+1,a.indexOf(')')); // определение только цифр
            str = str.replace(" ","");
            colorIndex = str.split(","); // разбиение цифр

            if(colorIndex[0].equals("") || colorIndex[1].equals("") || colorIndex[2].equals("") || colorIndex[3].equals("")){
                q = false;
            }else{
                r = Integer.parseInt(colorIndex[0]); // распределение цифр
                g = Integer.parseInt(colorIndex[1]);
                b = Integer.parseInt(colorIndex[2]);
                A = Double.parseDouble(colorIndex[3]);
            }
            if ((r < 226 && g < 226 && b < 226 && A <= 1.0) && (r > -1 && g > -1 && b > -1 && A >=0.0)) {
                q = true; // проверка на валидность
            }
        }
        return q;
    }
    public static String getHashTags(String a){
        String ext = "";
        a = a.toLowerCase();
        String[] h = a.split(" ");
        String one = "";
        String two = "";
        String three = "";
        int k = -1;
        int j = -1;
        int l = -1;
        for(int i=0;i<h.length;i++){ //нахождение 1го подходящего слова
            if(one.length() < h[i].length()){
                one = h[i];
                k = i;
            }
        }
        for(int i=0;i<h.length;i++){ //нахождение 2го подходящего слова
            if(two.length() < h[i].length() && !h[i].equals(one)){
                two = h[i];
                j = i;
            }
        }
        for(int i=0;i<h.length;i++){ //нахождение 3го подходящего слова
            if(three.length() < h[i].length() && !h[i].equals(one) && !h[i].equals(two)){
                three = h[i];
                l = i;
            }
        }
        if(one.length()>0){
            one = "#" + one;
        }
        if(two.length()>0){
            two = "#" + two ;
        }
        if (three.length()>0){
            three = "#" + three;
        }
        if (three.length() == 0){
            ext = one + ", " + two;
        }else {
            ext = one + ", " + two + ", " + three; // склеивание результата
        }
        return ext;
    }
    public static int ulan(int x){
        List<Integer> Ulans_numbers = new ArrayList<Integer>();
        Ulans_numbers.add(1);
        Ulans_numbers.add(2);
        int len = 2;
        int nextNum = 3;
        int count = 0;
        while (len < x){
            for (int i = 0; i < len; i++){
                for (int j = i + 1; j < len; j++){
                    if ((Ulans_numbers.get(i) + Ulans_numbers.get(j)) == nextNum){
                        count += 1;
                    }
                }
            }
            if (count == 1){
                Ulans_numbers.add(nextNum);
                len += 1;
            }
            count = 0;
            nextNum += 1;
        }
        if (x == 1 || x == 2)
            return x;
        else
            return Ulans_numbers.get(len - 1);

    }
    public static String longestNonrepeatingSubstring(String str){
        String longestStr = "";
        String tempStr = "";
        for(int i = 0; i < str.length(); i++){
            if (tempStr.indexOf(str.charAt(i)) == -1){
                tempStr += str.charAt(i);
            }
            else{
                if (longestStr.length() < tempStr.length()){
                    longestStr = tempStr;
                    tempStr = "";
                }
            }
        }
        if (tempStr.length() > longestStr.length()){
            longestStr = tempStr;
        }
        return longestStr;
    }
    public static String ToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
    public static boolean isOperation(char ch) {
        if (ch == '+') return true;
        if (ch == '-') return true;
        if (ch == '/') return true;
        if (ch == '*') return true;
        if (ch == '=') return true;
        return false;
    }

    public static boolean formula(String str){
        char[] str2 = str.toCharArray();
        if(str2.length==0)return false;
        if(isOperation(str2[0]))return false;
        int flag=0;
        for(int i = 0;i < str2.length-1;i++){
            if(str2[i]=='=')flag++;
            if(isOperation(str2[i])&&isOperation(str2[i+1]))return false;
        }
        if(flag!=1)return false;
        return true;
    }
    public static Boolean isPalindrome(String s) {
        char[] str2 = s.toCharArray();
        for(int i = 0;i< str2.length;i++){
            if(str2[i]!=str2[str2.length-1-i])return false;
        }
        return true;
    }
    public static boolean wert = false;
    public static void palindrom(String str){
        char[] str2= str.toCharArray();
        if(str2.length==1) wert = false;
        boolean fl = isPalindrome(str);
        if(fl){
            wert = true;
        }
        else{
            int newStr = 0;
            int index=0;
            for(int i = 0;i < str2.length/2;i++){
                if(i!=0)
                    newStr*=10;
                char first = str2[index];
                char second = str2[1+index];
                index+=2;
                newStr+=(((int)(first)-48)+((int)(second)-48));

            }
            System.out.println(newStr);
            String newString = Integer.toString(newStr);
            palindrom(newString);
        }
    }
    public static boolean palindromm() {
        return wert;
    }
    
}
