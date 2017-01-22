package interviewQuestions;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class ReverseString {

    public static void main(String[] args) {
        String word = "Sara ji is Great";

        for (int i = word.length()-1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
    }
}
