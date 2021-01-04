package com.company;


import org.junit.jupiter.api.Test;
import org.testng.Assert;
import static org.junit.jupiter.api.Assertions.*;


public class TestApp {
    @Test
    public void shouldFindQuestionSentences() throws Exception{
        SecondApp app2 = new SecondApp();
        String text = "Short string with question mark? Short string.";

        Assert.assertTrue(app2.findSentences(text).size() == 1);
        String expected = "Short string with question mark?";
        String real = app2.findSentences(text).get(0);
        Assert.assertEquals(expected,real);
    }

    @Test
    public void shouldFindWordsOfLengthFive() throws Exception{
        SecondApp app2 = new SecondApp();
        String text = "Short string with question mark? Short string.";
        var list = app2.findSentences(text);

        String expected = "Short";
        String real = app2.findWordWthLength(list.get(0), 5).get(0);

        Assert.assertEquals(expected, real);
    }

    @Test
    public void shouldNotFindAnySentence() throws Exception{
        SecondApp app2 = new SecondApp();
        String text = "Short string with question mark. Short string.";
        var list = app2.findSentences(text);

        Assert.assertEquals(list.size(), 0);
    }
}
