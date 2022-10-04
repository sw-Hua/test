package com.asd.backened.utils;

import java.util.Random;

/**
 * The verification code tool class is randomly generated
 */
public class ValidateCodeUtils {
    /**
     * The verification code is randomly generated
     * @param length The length can be 4 or 6 characters
     * @return
     */
    public static Integer generateValidateCode(int length){
        Integer code =null;
        if(length == 4){
            code = new Random().nextInt(9999);//Generate a random number. The maximum value is 9999
            if(code < 1000){
                code = code + 1000;//Make sure the random number is 4 digits
            }
        }else if(length == 6){
            code = new Random().nextInt(999999);//Generate a random number. The maximum value is 999999
            if(code < 100000){
                code = code + 100000;//Make sure the random number is 6 digits
            }
        }else{
            throw new RuntimeException("Only four - or six-digit verification codes can be generated");
        }
        return code;
    }

    /**
     * Randomly generate a verification code with a specified length
     * @param length
     * @return
     */
    public static String generateValidateCode4String(int length){
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        String capstr = hash1.substring(0, length);
        return capstr;
    }
}
