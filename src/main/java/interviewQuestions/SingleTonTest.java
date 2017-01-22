package interviewQuestions;

/**
 * Created by Nagendra on 21-01-2017.
 */
public class SingleTonTest {

    private static SingleTonTest singleTonTest = null;
    private static Object mutex= new Object();

    private SingleTonTest(){

    }

    public static SingleTonTest getInstance(){


            if (singleTonTest == null) {
                synchronized (mutex) {
                    if(singleTonTest == null) {
                        singleTonTest =  new SingleTonTest();
                    }
            }

        }
        return singleTonTest;
    }

}
