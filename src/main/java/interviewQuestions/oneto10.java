package interviewQuestions;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class oneto10 {
    public static void main(String[] args) {
        int n = 0;
        printNumber(n);

    }

    private static void printNumber(int n) {
        if(n==10){
            return;
        }
        System.out.println(n);
        n++;
        printNumber(n);
    }
}
