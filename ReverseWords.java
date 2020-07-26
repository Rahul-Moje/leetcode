package main.java.com.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ReverseWords reverseWords = new ReverseWords();
        s = reverseWords.reverse(s);
        System.out.println(s);
    }

    private String reverse(String s) {
        char arr[] = s.toCharArray();
        int startIndex = 0;
        int endIndex = arr.length-1;
        while (arr[startIndex] == ' ')
            startIndex++;
        while (arr[endIndex] == ' ')
            endIndex--;
        StringBuilder builder = new StringBuilder();
        for(int i=startIndex;i<endIndex;i++)
            if((arr[i] != ' ') || (arr[i] == ' ' && arr[i+1] != ' '))
                builder.append(arr[i]);
        builder.append(arr[endIndex]);
        String words[] = builder.toString().split(" ");
        s = "";
        for(int i=words.length-1;i>=0;i--)
            s += (words[i] + " ");
        return s.substring(0,s.length());


    }
}
