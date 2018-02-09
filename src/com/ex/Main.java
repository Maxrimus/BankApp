package com.ex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
    }

    public Main(){}

    public int[] sort(int[] toSort){
        int[] toReturn = toSort;
        boolean sorted = false;
        int a, b;
        while(!sorted)
        {
            sorted = true;
            for(int i = 0; i < toReturn.length-1; i++)
            {
                if((a=toReturn[i])>(b=toReturn[i+1]))
                {
                    toReturn[i] = b;
                    toReturn[i+1] = a;
                    sorted = false;
                }
            }
        }
        return toReturn;
    }
}
