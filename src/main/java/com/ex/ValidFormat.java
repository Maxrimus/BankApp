package com.ex;

import static com.ex.Main.accounts;

public class ValidFormat {

    public ValidFormat(){

    }

    public static String loopUntilValid(String input, String command){
        // DO NOT CHANGE THESE COMMAND NAMES, WILL BREAK CODE
        //  Commands:
        // LETTERS
        // ALPHANUM
        // SPACE
        // NAME
        // PASSWORD
        // SSN
        // EMAIL
        // EXIST



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
            case "NAME":{
                boolean invalid = true;
                while (invalid){
                    if (checkNameStructure(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "PASSWORD":{
                boolean invalid = true;
                while (invalid){
                    if (checkPasswordStructure(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "SSN":{
                boolean invalid = true;
                while (invalid){
                    if (isAnSSN(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "EMAIL":{
                boolean invalid = true;
                while (invalid){
                    if (isAnEmail(input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("Input is not matching\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
            case "EXIST":{
                boolean invalid = true;
                while (invalid){
                    if (!accounts.doesUserExist(User.Customer, input)){
                        invalid = false;
                    }
                    else{
                        System.out.println("That username already exists\nPlease try again");
                        input = Main.getUserInput();
                    }
                }
                break;
            }
        }

        return input;
    }

    public static String loopUntilValid(String input, String command, int min, int max){
        // DO NOT CHANGE THESE COMMAND NAMES, CODE WILL BREAK
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
        if (input != null) {
            if (n >= minLength && n <= maxLength) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static boolean isAnIntBetween(String input, int minValue, int maxValue){
        //String specialchar = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

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

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        for (int i = 0; i < input.length(); i++){
            if (!Character.isLetter(input.charAt(i)) && input.charAt(i) != ' '){
                System.out.println("You entered number(s)");
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanum(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        for (int i = 0; i < input.length(); i++){
            if (!Character.isLetterOrDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean hasNoSpaces(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        for (int i = 0; i < input.length(); i++){
            if (Character.isSpaceChar(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean checkNameStructure(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        if (!hasNoSpaces(input)){
            String[] first_last = input.split(" ");

            if (Character.isUpperCase(first_last[0].charAt(0))) {

                if (Character.isUpperCase(first_last[1].charAt(0))){
                    return true;
                }
                System.out.println("Must be of format 'John Smith'");
                System.out.println("Uppercase first letters of first and last name with a space in between");
                return false;
            }
        }
        return false;
    }

    public static boolean checkPasswordStructure(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        //String specialchar = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

        if (input.length() < 6){
            System.out.println("Your password must be at least 6 characters long");
            return false;
        }

        return true;
    }

    public static boolean isAnSSN(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        int countDashes = 0;

        for (int i = 0; i< input.length(); i++){
            if (input.charAt(i) == '-'){
                countDashes++;
            }
        }

        if (countDashes != 2){
            System.out.println("Missing '-'");
            return false;
        }

        String[] line = input.split("-");

        if (line[0].length() != 3 || !isAnIntBetween(line[0], 0,999)){
            System.out.println("Must be of format ###-##-####");
            return false;
        }
        else if (line[1].length() != 2 || !isAnIntBetween(line[1], 0, 99)){
            System.out.println("Must be of format ###-##-####");
            return false;
        }
        else if (line[2].length() != 4 || !isAnIntBetween(line[2], 0, 9999)){
            System.out.println("Must be of format ###-##-####");
            return false;
        }
        else{
            return true;
        }

    }

    public static boolean isAnEmail(String input){

        if (input == null){
            return false;
        }
        if (input.length() < 1){
            System.out.println("You did not enter anything");
            return false;
        }

        boolean atSign = false;
        boolean dot = false;

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '@'){
                atSign = true;
            }

            if (input.charAt(i) == '.'){
                dot = true;
            }
        }

        if (!atSign || !dot){
            System.out.println("Missing '@' or '.'");
            return false;
        }

        String[] line = input.split("\\.");

        if (line.length < 2){
            return false;
        }

        if (!line[line.length-1].equals("com") && !line[line.length-1].equals("edu")){
            System.out.println("Not a '.com' or '.edu'");
            return false;
        }

        line = input.split("\\@");

        if (line.length < 2){
            return false;
        }

        if (!isAlphanum(line[0])){
            return false;
        }

        return true;
    }

    public static boolean isCurrency(String input){
        boolean hasDot = false;
        int countDot = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '.'){
                hasDot = true;
                countDot++;
            }

            if (!Character.isDigit(input.charAt(i))){
                return false;
            }
        }

        if (countDot > 1){
            return false;
        }

        if (hasDot){
            String[] line = input.split("\\.");
            if (line[1].length() > 2){
                return false;
            }
        }

        return true;
    }
}
