/**
 * Created by Nagendra on 07-01-2017.
 */
public class ReverseStringTest {
    public static void main(String[] args) {
        String str= "This is Java Test";
        StringBuilder stringBuilder = reverseString(str);
        System.out.println(stringBuilder.toString());
    }

    private static StringBuilder reverseString(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }

        return stringBuilder.reverse();
    }
}
