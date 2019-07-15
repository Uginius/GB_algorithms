package Lesson3;

public class ReverseString {
    public static void main(String[] args) {
        String myString = "Test 1";
        System.out.println(myString + " : " + RevString(myString));
    }

    public static String RevString(String str) {
        char[] array = str.toCharArray();
        String tmpStr = "";
        for (int i = array.length - 1; i >= 0; i--) tmpStr += array[i];
        return tmpStr;
    }

}
