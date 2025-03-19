package com.swaglabsm.utils;

import java.util.Random;

public class Helper {
    
    public static String generateRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        
        // Generate a random string of 8 characters
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        
        return sb.toString() + "@testmail.com";
    }
    
    public static String getDefaultPassword() {
        return "Password123";
    }
}
