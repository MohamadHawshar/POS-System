package algopractice.String_Array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TWO_AllPossiblePalindromicPartitions { 
    
    public static void main(String[] args) {
        String s = "nitiiin";
        allPalindromicPartions(s);
               
    }
    
    public static void allPalindromicPartions(String s){
        int n = s.length();
        
        ArrayList<ArrayList<String>> allPal = new ArrayList<>();
        
        Deque<String> currentPal = new LinkedList<>();
        
        allPalrec(allPal, currentPal, 0, n, s);
        
        for(int i=0; i<allPal.size();i++){
            for(int j=0; j< allPal.get(i).size();j++){
                System.out.print(allPal.get(i).get(j) + ' ');
            }
            System.out.println("");
        }
        
        
        
    }
    public static void allPalrec(ArrayList<ArrayList<String>> allPal, Deque<String> currentPal, int start, int end, String s){
        
        if(start >= end){
            allPal.add(new ArrayList<>(currentPal));
            return;
        }
        
        for(int i= start; i<end; i++){
            if(isPalindrom(start, i, s)){
                currentPal.addLast(s.substring(start,i+1));
                allPalrec(allPal, currentPal, i+1, end, s);
                currentPal.removeLast();
            }
        }
        
    }
    public static boolean isPalindrom(int start, int end, String s){
            while(start < end){
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
                
            }return true;
    }
    
}
