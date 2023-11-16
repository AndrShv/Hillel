import java.util.Locale;

public class lesson {
    public static void main(String[] args){
        /*
        System.out.println("Hello".codePointAt(0));
        System.out.println("hello".codePointAt(0));
        int i =2454;
        char name = (char) i;
        System.out.println(name);
        System.out.println(s.toUpperCase());
        if(s.equals("Hi the world1")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        System.out.println(s.contains("w"));
        System.out.println(s.substring(0,4));
         */

        String s = "Hello the world";
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }
}