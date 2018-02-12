package com.ex;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ValidFormatTest {

    @Test
    public void testIsBetweenLengths1(){
        boolean expected = true;
        String input = "1234567";
        int min = 1;
        int max = 8;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsBetweenLengths2(){
        boolean expected = true;
        String input = "12345678";
        int min = 8;
        int max = 8;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsBetweenLengths3(){
        boolean expected = true;
        String input = "";
        int min = 0;
        int max = 0;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsBetweenLengths4(){
        boolean expected = false;
        String input = "123456789";
        int min = 1;
        int max = 8;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsBetweenLengths5(){
        boolean expected = false;
        String input = "1";
        int min = 2;
        int max = 8;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsBetweenLengths6(){
        boolean expected = false;
        String input = "";
        int min = 1;
        int max = 8;
        Assert.assertEquals(expected,ValidFormat.isBetweenLength(input,min,max));
    }

    @Test
    public void testIsAnIntBetween1(){
        boolean expected = true;
        String input = "12";
        int min = 0;
        int max = 20;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween2(){
        boolean expected = true;
        String input = "12";
        int min = 0;
        int max = 12;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween3(){
        boolean expected = true;
        String input = "12";
        int min = 12;
        int max = 12;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween4(){
        boolean expected = true;
        String input = "12";
        int min = 12;
        int max = 20;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween5(){
        boolean expected = false;
        String input = "12";
        int min = 13;
        int max = 20;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween6(){
        boolean expected = false;
        String input = "21";
        int min = 13;
        int max = 20;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAnIntBetween7(){
        boolean expected = false;
        String input = "twelve";
        int min = 13;
        int max = 20;
        Assert.assertEquals(expected,ValidFormat.isAnIntBetween(input,min,max));
    }

    @Test
    public void testIsAllLetters1(){
        boolean expected = true;
        String input = "test";
        Assert.assertEquals(expected,ValidFormat.isAllLetters(input));
    }

    @Test
    public void testIsAllLetters2(){
        boolean expected = false;
        String input = "t3st";
        Assert.assertEquals(expected,ValidFormat.isAllLetters(input));
    }

    @Test
    public void testIsAllLetters3(){
        boolean expected = false;
        String input = "1234";
        Assert.assertEquals(expected,ValidFormat.isAllLetters(input));
    }

    @Test
    public void testIsAllLetters4(){
        boolean expected = false;
        String input = "te st";
        Assert.assertEquals(expected,ValidFormat.isAllLetters(input));
    }

    @Test
    public void testIsAllLetters5(){
        boolean expected = false;
        String input = "";
        Assert.assertEquals(expected,ValidFormat.isAllLetters(input));
    }

    @Test
    public void testIsAlphaNum1(){
        boolean expected = true;
        String input = "test";
        Assert.assertEquals(expected,ValidFormat.isAlphanum(input));
    }

    @Test
    public void testIsAlphaNum2(){
        boolean expected = true;
        String input = "1234";
        Assert.assertEquals(expected,ValidFormat.isAlphanum(input));
    }

    @Test
    public void testIsAlphaNum3(){
        boolean expected = true;
        String input = "test1234";
        Assert.assertEquals(expected,ValidFormat.isAlphanum(input));
    }

    @Test
    public void testIsAlphaNum4(){
        boolean expected = false;
        String input = "test 1234";
        Assert.assertEquals(expected,ValidFormat.isAlphanum(input));
    }

    @Test
    public void testIsAlphaNum5(){
        boolean expected = false;
        String input = "";
        Assert.assertEquals(expected,ValidFormat.isAlphanum(input));
    }

    @Test
    public void testHasNoSpaces1(){
        boolean expected = true;
        String input = "test";
        Assert.assertEquals(expected,ValidFormat.hasNoSpaces(input));
    }

    @Test
    public void testHasNoSpaces2(){
        boolean expected = false;
        String input = "te st";
        Assert.assertEquals(expected,ValidFormat.hasNoSpaces(input));
    }

    @Test
    public void testHasNoSpaces3(){
        boolean expected = false;
        String input = "   ";
        Assert.assertEquals(expected,ValidFormat.hasNoSpaces(input));
    }

    @Test
    public void testHasNoSpaces4(){
        boolean expected = false;
        String input = "";
        Assert.assertEquals(expected,ValidFormat.hasNoSpaces(input));
    }

    @Test
    public void testCheckNameStructure1(){
        String input = "Joe Tursi";
        Assert.assertTrue(ValidFormat.checkNameStructure(input));
    }

    @Test
    public void testCheckNameStructure2(){
        String input = "Joe tursi";
        Assert.assertFalse(ValidFormat.checkNameStructure(input));
    }

    @Test
    public void testCheckNameStructure3(){
        String input = "joe Tursi";
        Assert.assertFalse(ValidFormat.checkNameStructure(input));
    }

    @Test
    public void testCheckNameStructure4(){
        String input = "joe tursi";
        Assert.assertFalse(ValidFormat.checkNameStructure(input));
    }

    @Test
    public void testCheckNameStructure5(){
        String input = "";
        Assert.assertFalse(ValidFormat.checkNameStructure(input));
    }

    @Test
    public void testCheckPassWordStructure1(){
        String input = "Abc!1234";
        Assert.assertTrue(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure2(){
        String input = "abc!1234";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure3(){
        String input = "ABC!1234";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure4(){
        String input = "Abc!defg";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure5(){
        String input = "Abcd1234";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure6(){
        String input = "Abc!123";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testCheckPassWordStructure7(){
        String input = "";
        Assert.assertFalse(ValidFormat.checkPasswordStructure(input));
    }

    @Test
    public void testIsAnSSN1(){
        String input = "123-45-6789";
        Assert.assertTrue(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnSSN2(){
        String input = "12-45-6789";
        Assert.assertFalse(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnSSN3(){
        String input = "123-4-6789";
        Assert.assertFalse(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnSSN4(){
        String input = "123-45-678";
        Assert.assertFalse(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnSSN5(){
        String input = "123-45-67890";
        Assert.assertFalse(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnSSN6(){
        String input = "";
        Assert.assertFalse(ValidFormat.isAnSSN(input));
    }

    @Test
    public void testIsAnEmail1(){
        String input = "email@email.com";
        Assert.assertTrue(ValidFormat.isAnEmail(input));
    }

    @Test
    public void testIsAnEmail2(){
        String input = "@email.com";
        Assert.assertFalse(ValidFormat.isAnEmail(input));
    }

    @Test
    public void testIsAnEmail3(){
        String input = "email@.com";
        Assert.assertTrue(ValidFormat.isAnEmail(input));
    }

    @Test
    public void testIsAnEmail4(){
        String input = "email@email.";
        Assert.assertTrue(ValidFormat.isAnEmail(input));
    }

    @Test
    public void testIsAnEmail5(){
        String input = "email";
        Assert.assertTrue(ValidFormat.isAnEmail(input));
    }

    @Test
    public void testIsAnEmail6(){
        String input = "";
        Assert.assertTrue(ValidFormat.isAnEmail(input));
    }
}
