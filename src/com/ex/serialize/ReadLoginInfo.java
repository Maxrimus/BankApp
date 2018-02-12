package com.ex.serialize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadLoginInfo {
    static BufferedReader reader = null;

    public static void loadUpLoginInfo(){
        try {
            reader = new BufferedReader(new FileReader("resources/logininfo"));
            String line;
            int count = 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
