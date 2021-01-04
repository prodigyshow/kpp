package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("------- App 1 -------");
        String readText1 = readFile("file1.txt");

        Scanner txtScan = new Scanner(readText1);
        List<String> sntc = new LinkedList<>();
        txtScan.useDelimiter("\\. |\\? |! |\\n");

        while(txtScan.hasNext()) {
            sntc.add(txtScan.next());
        }

        for (String str : sntc) {

            if (str.length() <= 180) {
                System.out.println(str);
            } else {
                System.out.println("<Long sentence deleted>");
            }
        }

        System.out.println("\n\nFile path: \n");

        for (String str : sntc) {
            if (findPath(str) != null) {
                System.out.println(findPath(str));
            }
        }


        System.out.println("------- App 2 -------");

        SecondApp app2 = new SecondApp();
        String text2 = app2.readFile("file2.txt");
        List<String> questionSentenceList = app2.findSentences(text2);

        System.out.print("Enter word length\n> ");

        Scanner myInput = new Scanner(System.in);
        int wordLength = myInput.nextInt();

        for (String s : questionSentenceList){
            System.out.println(s);

            List<String> words = app2.findWordWthLength(s, wordLength);

            if (words.size() > 0) {
                for (String w : words){
                    System.out.println("    " + w);
                }
            }
            else{
                System.out.println("<There are no such words>");
            }
        }

    }

    public static String readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScan = new Scanner(file);
        String text = new String();
        fileScan.useDelimiter("\\Z");
        text = fileScan.next();

        return text;
    }

    public static String findPath (String input) {
        int index = -1;
        int start = -1;
        int end = -1;

        String[] pathPattern = new String[]{":\\", "\\", ":/", "/"};
        for (String pattern : pathPattern){
            if(input.contains(pattern)){
                index = input.indexOf(pattern);
            }
        }
        if(index == -1){
            return null;
        }

        if(input.substring(0 , index).contains(" ")){
            start = input.substring(0 , index).lastIndexOf(" ") + 1;
        }
        else{
            start = 0;
        }

        if(input.substring(start , input.length()).contains(" ")){
            end = input.substring(start , input.length()).indexOf(" ") + start;
        }
        else{
            end = input.length();
        }

        return input.substring(start, end);
    }
}


