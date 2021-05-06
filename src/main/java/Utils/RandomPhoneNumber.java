package Utils;

import java.util.Random;

public class RandomPhoneNumber {
    public static String randomPhoneNumber;
    Random random = new Random();
    public void randomPhoneNumber(){
        randomPhoneNumber = "849" + random.nextInt(9);
    }

}
