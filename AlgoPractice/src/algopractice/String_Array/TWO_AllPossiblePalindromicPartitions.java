package algopractice.String_Array;

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
    
    public static Boolean isPal(String s){
        char[] table = s.toCharArray();
        int size = table.length;
        int i=0,j=size-1;
        while(i<j){
            if(table[i] != table[j]) {
                System.out.println("false");
                return false;
            }
            i++;
            j--;
        }
        System.out.println("true");
        return true;
        
    }
    
    public static void allPal(String s){
        char[] table = s.toCharArray();
        
    }
    public static void main(String[] args) {
        isPal("n");
    }
}
