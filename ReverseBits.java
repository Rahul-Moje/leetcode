package main.java.com.leetcode;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverse = new ReverseBits();
        int n = -16;
        int ans = reverse.reverseBits(n);
        System.out.println(ans);
    }

    private int reverseBits(int n) {
        StringBuilder s = new StringBuilder();
        int result = 0;
        System.out.println(s.indexOf("hello"));
        System.out.println(Integer.toBinaryString(n));
        for(int i=1;i<=32;i++){
            int bit = n & 1;
            result = result | bit;
            if(i!=32)
                result = result << 1;
            n = n >>> 1;
        }
        return result;
    }
}