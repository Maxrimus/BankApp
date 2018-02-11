package com.ex;

public class ValidFormat {

    public ValidFormat(){

    }

    public static String loopUntilValid(String input, String command){
        //  Commands:
        // LETTERS
        // ALPHANUM
        // SPACE

        switch (command){
            case "LETTERS":{
                boolean invalid = true;
                while (invalid){
                    if (isAllLetters(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }

                break;
            }
            case "ALPHANUM":{
                boolean invalid = true;
                while (invalid){
                    if (isAlphanum(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "SPACE":{
                boolean invalid = true;
                while (invalid){
                    if (hasNoSpaces(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
        }

        return input;
    }

    public static String loopUntilValid(String input, String command, int min, int max){
        // Commands:
        // LENGTH
        // VALUE

        switch (command){
            case "LENGTH":{
                boolean invalid = true;
                while (invalid){
                    if (isBetweenLength(input,min,max)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "VALUE":{
                boolean invalid = true;
                while (invalid){
                    if (isAnIntBetween(input,min,max)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
        }
        return input;
    }

    public static boolean isBetweenLength(String input, int minLength, int maxLength){
        int n = input.length();
        if (n >= minLength && n <= maxLength){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isAnIntBetween(String input, int minValue, int maxValue){
        String specialchar = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                System.out.println("You did not enter a number");
                return false;
            }
        }
        Integer n = Integer.parseInt(input);
        if (n >= minValue && n <= maxValue){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isAllLetters(String input){
        for (int i = 0; i < input.length(); i++){
            if (!Character.isLetter(input.charAt(i))){
                System.out.println("You entered number(s)");
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanum(String input){
        for (int i = 0; i < input.length(); i++){
            if (!Character.isLetterOrDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean hasNoSpaces(String input){
        for (int i = 0; i < input.length(); i++){
            if (Character.isSpaceChar(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
