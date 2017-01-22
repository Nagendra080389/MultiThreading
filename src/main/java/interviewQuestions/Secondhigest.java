package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * Created by Nagendra on 20-01-2017.
 */
public class Secondhigest {
    static int arrayofNumbers[] = {8,2,4,6,9,2,3,0};

    public static void main(String[] args) {
        sort(arrayofNumbers);

        System.out.println(Arrays.toString(arrayofNumbers));

        System.out.println("second higest Number in the array Numbers is : "+arrayofNumbers[arrayofNumbers.length-2]);


    }
}
