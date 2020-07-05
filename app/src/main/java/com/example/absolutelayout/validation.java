package com.example.absolutelayout;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {
    public static boolean emailValidation(String email)
    {
        String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean mobileValidation(String s)
    {

        Pattern p = Pattern.compile("[7-9][0-9]{9}");


        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }


}



