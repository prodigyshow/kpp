package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondApp {
    public String readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner fileScanner = new Scanner(file);
        fileScanner.useDelimiter("\\Z");

        return fileScanner.next();
    }

    public List<String> findSentences(String text){
        List<String> questionSentenceList = new LinkedList<>();

        Pattern questionMarkPattern = Pattern.compile("([^.?!]*)\\?");
        Matcher questionMarkMatcher = questionMarkPattern.matcher(text);
        while (questionMarkMatcher.find()){
            questionSentenceList.add(questionMarkMatcher.group());
        }

        return questionSentenceList;
    }

    public List<String> findWordWthLength(String text, int length){
        Pattern wordPattern = Pattern.compile("\\b\\w{" + length + "}\\b");
        Matcher wordMatcher = wordPattern.matcher(text);
        List<String> words = new LinkedList<>();

        while(wordMatcher.find()){
            words.add(wordMatcher.group());
        }
        return words;
    }
}
