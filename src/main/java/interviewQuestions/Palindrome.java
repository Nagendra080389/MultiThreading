package interviewQuestions;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class Palindrome {

    public static void main(String[] args) {
        String word = "madam";

        for (int i = 0; i < word.length(); i++) {
            char start = word.charAt(i);
            char end = word.charAt(word.length() - (i + 1));

            if(start != end){
                System.out.println("Not Palindrome");
                break;
            }

        }

    }
}
