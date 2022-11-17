import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static int n = 90;
    public static int previousResult = generatePreviousResult(n);


    public static void main(String[] args) {
        int result = guessNumber(n);
        System.out.println(result);
    }

    private static int guessNumber(int n) {
        int value = 1;
        int min = 1;
        int max = n;

        // La gran formula acá es [min + ((max - min) / 2)]
        while(min <= max){
            value = min + ((max - min) / 2);
            
            int res = guess(value);

            if (res == 0) {
                return value;
            } else if(res < 0) {
                max = value - 1;
            } else {
                min = value + 1;
            }
        }

        return value;
    }

    private static int guess(int value) {
        if(value > previousResult){
            return -1;
        } else if (value < previousResult){
            return 1;
        } else {
            return 0;
        }
    }

    private static int generatePreviousResult(int n) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(n-1+1)+1;
    }
}

