package itqop;

public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)){
                System.out.println(s + " - палиндром");
            }else{
                System.out.println(s + " - не палиндром");
            }
        }
    }
    public static String reverseString(String s){
        String q ="";
        for (int i = s.length()-1; i>=0; i--){
            q+= s.charAt(i);
        }
        return q ;
    }
    public static boolean isPalindrome(String s){
        if(s.equals(reverseString(s))){
            return true;
        }else return false;
    }

}
