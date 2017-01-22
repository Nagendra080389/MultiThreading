package interviewQuestions;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class PrimeNumbers {

    static int primeNumbers[] = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
       primeNumbersAre(primeNumbers);
    }

    private static void primeNumbersAre(int[] primeNumbers) {

        for (int i = 0; i <= primeNumbers.length-1; i++) {
            if((primeNumbers[i]%2) != 0 ){
                System.out.println("Prime Number : "+primeNumbers[i]);
            }
        }
    }

}
